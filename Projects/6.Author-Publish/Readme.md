Usually content in author is made to publish by below setting.

Step 1:
=======

go to siteadmin> click Tools icon on top


STEP 2:
=======
it redirect to below url.

http://localhost:4502/miscadmin

STEP 3:
=======

on left panel click Replication.



Replication > Takes to below url.
http://localhost:4502/miscadmin#/etc/replication



Replication > Agents on Author > Default Agent >takes to below url.

 
http://localhost:4502/etc/replication/agents.author/publish.html


Agent is disabled. Replicating to http://localhost:4503/bin/receive?sling:authRequestLogin=1
by default it point to localhost:4503 if in case you want to have publish different host like dev to qa
you can change to http://Testqa:4503/test.com/




Default Agent (publish)
=======================
url:  http://localhost:4502/etc/replication/agents.author/publish.html

    Agent that replicates to the default publish instance.
    Agent is disabled. Replicating to http://localhost:4503/bin/receive?sling:authRequestLogin=1
    Queue is not active
    View log
    Test Connection
