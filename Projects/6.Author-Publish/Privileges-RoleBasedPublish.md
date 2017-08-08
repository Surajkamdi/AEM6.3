STEPS to set the replication 
============================

STEPS 1:
=========
http://localhost:4502/useradmin

STEPS 2:
========
if you 2 replicator i.e one for internal user let say you created a one user internal_replicator and set the 
default replication agent on http://localhost:4502/miscadmin#/etc/replication/agents.author 
with the internal_replicator permission.

Real time usecase of Replicator using privilege is :
====================================================
1)created a user internal_replicator in http://localhost:4502/useradmin and then in right set the permission to only /content/dam/internal
folder



2)created a user external_replicator in http://localhost:4502/useradmin and then in right set the permission to all folder other than /content/dam/internal folder.


Use of role based replication is  if you publish assets using internal_replicator user role in replication agent it allows
only assets underneath internal folder to publish to publish server. if you publish using external_replicator all folders assets gets published to publisher except assets unders internal folder . 


NOTE: set the user in Replication agent . go to  http://localhost:4502/miscadmin#/etc/replication/agents.author create a 
new agent by copying default agent or in publish settings of default agent http://localhost:4502/etc/replication/agents.author/publish.html
just click on the default agent link > click Edit> in agent settings popup > settings tab just set the "Agent User Id" value to be external_replicator and run the replicator it works as external replicator so all assets in internal wont publish to publisher. since in external we restrict internal assets i.e specific to company i.e only internal employees can view the assets.

Do the same for internal user by copying the default agent and then just changing the "Agent User Id" by just click on the newly created agent link > > click Edit> in agent settings popup > settings tab just set the "Agent User Id" to "internal_replicator" and if you 
run the job it works as internal replicator it publish only assets underneath the /content/dam/internal folder
