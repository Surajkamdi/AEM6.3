Once author -AEM 

listening port of dispatcher is 8850

http://localhost:8850/content/Test/assetsshare.html

to publish tags 

To edit the assetshare, assetedit, assetview page edit by adding cf# class ui.

http://localhost:4502/cf#/content/Test/assetshare.html


link to publish to make it is available in publish and dispatcher.
==================================================================

STEP 1:
========
go to author

publish tags,content by below


http://localhost:4502/tagging

http://localhost:4502/siteadmin#/content/Test/assetsshare.html


to check the replication server details for author - publish.

http://localhost:4502/miscadmin#/etc/replication/agents.author  

other way go to miscadmin and then click on Replication > Agents on Author > default Agent > clik on default on right.

http://localhost:4502/useradmin - to check the role assigned to each folder in crxde.

like you can configure a permission for a particular folder can create user and assign that user as agent user id in replication
configuration. so that content with that permission will alone published to publish.
in case i case internal_replicator as a user and then assign a folder named /content/internal then only if i run
the replication with Agent_user_id as internal_replicator then only content inside internal folder will gets transferred and
published to publish server.


STEP 2:
=======
can publish also in crxde 

http://localhost:4502/crx/de/index.jsp#/etc/tags/test-tags

click on test-tags on right click on replication tab > click replicate

STEP 3:
======
to check in dispatcher side

check logs whether any thing is blocked.

/apache/logs/dispatcher.log
