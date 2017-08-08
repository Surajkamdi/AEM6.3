Dispatcher Flush
================
if anything changed in publish , dispatcher should know that it is updated by author for that dispatcher should be intimated that content
is changed get latest from publish than from cache. basically refresh cache like when first time assets request it loads from publish
instead from cache.'


dispatcher| aem
=======================

10.1.9.1 | 10.1.10.1|	publish

10.0.9.2 |10.0.10.2	|author -main author

10.1.9.3 |10.1.10.3	|publish - main publish

10.0.9.4 |10.0.10.4	|author -Dr server - failover server (load balance server)

10.1.9.5 |10.1.10.5	|publish - Dr publish.

10.1.9.6 |10.1.10.6	|publish - internal server only for internal company employees


need to set allowed clients in publish environment.


STEP 1:
========
set up the dispatcher with allowed clients  so that when author try to access dispatcher endpoint through dispatcher flush settings, permission will be available.

10.1.9.1
========
from dispatcher 10.1.9.1  request can come from publish (10.1.10.1),author1 (10.0.10.2) or failover server 10.0.10.4(author2)
need to mention from dispatcher all reachable server like publisher called from dispatcher, author1 called from dispatcher
and load balance -fail over server author2 and if in case if you have separate internal server for publisher like
external publisher and internal publisher we need to mention that.



/apache/conf/dispatcher.any
============================

           /allowedClients
           {   
              /001
                {
                 /glob "10.1.10.1"
                 /type "allow"
                }

                /002
                {
                 /glob "10.0.10.2"
                 /type "allow"
                 }

                /003
                 {
                  /glob "10.0.10.4"
                  /type "allow"
                  }

                  /004
                  {
                    glob "10.1.9.6"
                    /type "allow"
                  }
               }

STEP 2:
=======

configuration of Replication dispatcher flush.
===============================================

http://localhost:4502/etc/replication/agents.author/flush.html

edit change url to point to dispatcher from author.

Dispatcher Flush (flush)

Agent that sends flush requests to the dispatcher.

Agent is enabled. Replicating to http://localhost:8850/dispatcher/invalidate.cache

you can set user based publish using edit> Agent settings>Agent settings popup > settings tab > "Agent userID" set value of user you 

want to set.so based on user  you set user based asset publish will be allowed to flush cache.
      
            
Testing:
========

author --> publish --> dispatcher

if any asset say in main author 10.0.9.2 is created then it is published it should be available in main publish 10.1.9.3
by default .  when try to access the asset page which is in publisher by dispatcher(10.1.9.1 )  you will get the page wihtout any issues for the first time. since new assets created accessed for the first time you will get it without any issues from main publish.


Let say dispatcher access for the second time that time , but that time author changed something and published the changes to
publisher(10.1.10.3). when user from  dispatcher 10.1.9.3  try to access the page it wont hit the main publisher(10.1.10.3)
since it already available in cache it just gets from cache but there is change in page. so you get the old page.


in this situation in order  for the dispatcher let know that some changes made by author some agent need to initimate to dispatcher
to get latest from publisher rather than from cache. this is what we set in "Dispatcher flush".

we configure like below in dispatcher.

dispatcher| aem

====================

10.1.9.1  | 10.1.10.1 |main publish

10.0.9.2  |10.0.10.2	|author -main author

10.1.9.3  |10.1.10.3	|publish - DR-failover publish 2

10.0.9.4  |10.0.10.4	|author -Dr server - failover server (load balance server)

10.1.9.5  |10.1.10.5	|publish - internal server only for internal company employees.

DR - disaster recovery.

usually dispatcher of publish will be accessed.

1)when main dispatcher 10.1.9.1 request page let say 10.1.9.1:8850/content/Test/assetshare.html is changed by main author (10.0.10.2) change some thing from original content and  published it to main publish(10.1.10.1) and internal publish (10.1.10.5) for some 
specific secure assets.

if in case of main author is down  run with DR server i.e load balance   author let say 10.0.9.4 and asset will be published in 
DR publisher ( 10.1.10.3)

2)if  is accesssed by user from main dispatcher (10.1.9.1)  10.1.9.1:8850/content/Test/assetshare.html and if any changes done by main author(10.0.10.2)and let say it is published to publisher(10.1.10.1). then dispatcher should not read from cache even if page already in cache or requested for second time.

dispatcher of publish---> access publish instance <-- gets content from author.

IMPORTANT:
==========

order of intimation :
=====================

           1)10.1.9.1 main dispatcher  should be intimated by main publish(10.1.10.1) since it from
             dispatches gets content to display.
           2)main author (10.0.10.2) -should be initimated
              (OR) if in case it run from DR author it get intimate from 10.0.10.4 since main publish gets content when 
              replication agent publishes the content in author.
           3)also get intimation from internal publish 10.1.10.5 since only place  where internal assets -company specific
              secure assets resides.



/apache/conf/dispatcher.any
============================

10.0.9.1- dispatcher config
=============================
flow of intimation since request usually accessed from main publish instance dispatcher --> main publish dispatcher tied to main
publisher and some content for internal publisher for company specific secure information --> main publisher gets data from either main Author or some case in case of failure from DR AUTHOR. also


           /allowedClients
           {   
           
              #main publish.  
              /001
                {
                 /glob "10.1.10.1"
                 /type "allow"
                }

                #main author           
                /002
                {
                 /glob "10.0.10.2"
                 /type "allow"
                 }

                #DR Author    
                /003
                 {
                  /glob "10.0.10.4"
                  /type "allow"
                  }

                  #INTERNAL               
                  /004
                  {
                    glob "10.1.9.5" 
                     /type "allow"
                  }
               }

