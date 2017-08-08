if the content size is big avoid using Replication Agent process, as it causes the queue to use more memory and causes
to application to clog.


Best practices:
===============
create a install folder inside /crx-quickstart

i.e
Hierarchy:
==========

  AEM 6.3
  =========
         -- crx-quickstart
            -- install
                --prod-content.zip
         --cq5-author-4502.jar
         --license.properties

NOTE:
=====
if the content is small go to packmngr in http://localhost:4502/crx/packmgr/index.jsp  and then do create package
give package name , then give version then give the group name . it creates a temporary zip in group mentioned.

click 

1) package Name : 

2)Version :

3) group :


click on the  package and then click > Edit package > add Filter

Enter Root path > /content

Rules >  select include or exclude > /content/dam
include>/apps/dam


E.g
===
if you want to download all content enter below:

Edit package

Add Filter > 
Root path : /content that's it.

if you want to download users

Root path: /home/users

filter > exclude > rep:policy

you can use include like below.
include>/apps/app1
 
