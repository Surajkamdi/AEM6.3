If you use Replication Agent for author to publish environment promotion , if in case file size is big it causes
to queue to stale and get stuck.


How to kill Replication Agent:
==============================
https://helpx.adobe.com/experience-manager/kb/replication-stuck.html


The CQ5 content replication appears to be blocked.
Editors can create content, but the activated pages are not updated on the CQ5 publish instance.
Make sure that each replication agent is enabled and configured correctly.

 Go to the list of replication agents (/etc/replication/agents.author.html)
 For each replication agent, do the following:
Make sure that the agent is enabled.
Verify the connectivity with the publish instance by clicking Test Connection. If it fails, make sure that on TCP network level, the server hosting the CQ author instance can connect to the port of the publish instance.
Open the replication log via the "View Log" link and check when the last replication attempt was successful.
Note the first payload path in the replication queue. Then try to clear the first element of the replication queue. Then, verify whether the replication resumes (starting with CQ5.4). Once it resumes, activate the first payload noted in the queue again.
Check with the CRX Content Explorer, and make sure that there is no /bin/receive node on the publish instance. Otherwise, delete it.
Check with the CRX Content Explorer, and make sure that there is no /bin/replicate node on the author instance. Otherwise, delete it.
Restart replication agents and related bundles

At that point, we can consider the replications agents are configured correctly. If the logs show no replication attempt for a few minutes, then try the following corrective actions to unblock the queues, in this order, checking between each step if the replication resumes.

Disable the replication agent, then re-enable it.
Restart the replication bundle in the Felix console (http://host:port/system/console/bundles/com.day.cq.cq-replication).
Restart the Apache Sling Event Support bundle (http://host:port/system/console/bundles/org.apache.sling.event).
Restart the Apache Felix EventAdmin (http://host:port/system/console/bundles/org.apache.felix.eventadmin).

Force the queue clearance by deleting corresponding Sling Jobs
===============================================================
If the above fails, then clearing manually the queue might be the last option.

One can achieve this by getting rid directly of the Sling Jobs with topic =replication agent name.

Quickest way to do this is to use CRXDE Lite (http://host:port/crx/de/index.jsp), and delete the node:

/var/eventing/jobs/assigned/%INSTANCE-SLING-ID%/%REPLICATION-AGENT-FULL-ID%

So for example with the default publish agent:

/var/eventing/jobs/assigned/e23dd09d-83f1-4735-a77c-394df479214c/com.day.cq.replication.job.publish

Note:
=====

this is considered as an exceptional workaround action, contact AEM Support anyway if such a case occurs. 

Use the Replication Queue Cleaning assistant (ONLY WITH CQ <= 5.4)

In versions of AEM 5.4 and earlier, replication queues can sometimes be polluted by entries that cannot be removed through the OOTB Clear Queue link.

In this case, you can use the Replication Queue Cleaning tool attached here. It brings enhanced functionalities to clear queue entries.

Install the attached package using package manager.
====================================================

Go to http://<host>:<port>/apps/tools/components/cleanReplication/run.html. Or, go to http://<host>:<port>/etc/replication/agents.author.html. Click your agent and you see various options.
First do dry run and see if entries are getting deleted.
Then select all checkboxes and click Run Clean Replication.
There is also a failed replication Listener configuration. You can configure it to send an email if replication fails.
