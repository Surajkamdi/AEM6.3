To configure dispatcher in AEM:
===============================

http://localhost:4503/etc/replication/agents.publish/flush.html?cq_ck=1506566921792

or

steps:
======

STEP 1:
=======

http://localhost:4503/siteadmin

STEP 2:
=======


http://localhost:4503/miscadmin


STEP 3:
=======

click on Replication > Agent on Publish or Agent on Author

after choosing Agen on publish or Author > choose Dispatcher flush.

it will be like on above http://localhost:4503/etc/replication/agents.publish/flush.html?cq_ck=1506566921792

sample config
==============

choose test connection it should pass  > enable the dispatch flush.

      Dispatcher Flush (flush)
      Example agent that is triggered on modification and sends flush requests to the dispatcher.

      Agent is enabled. Replicating to http://localhost:8850/dispatcher/invalidate.cache
      Queue is idle
      Agent is ignored on normal replication
      Agent is triggered when receiving replication events
      View log
      Test Connection
      
      
Important:
==========

localhost:4503/miscadmin#/etc/replication/agents.publish  > click activate it should be activated to make dispatcher flush working.

Also clear cache in dispatcher side in /apps/apache/aem/cache folder.



      [admin@ADMIN cache]$ rm -rf content/
      [admin@ADMIN cache]$ ls
      etc
      [admin@ADMIN cache]$ rm -rf etc
      [admin@ADMIN cache]$ pwd
      /apps/apache/aem/cache
      [admin@ADMIN cache]$


