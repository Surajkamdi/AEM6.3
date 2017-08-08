http://www.aemcq5tutorials.com/tutorials/migrate-users-and-groups-with-acl-permissions-in-aem/

Create Package using ACL Packager:-
===================================
•Login to AEM author instance.
•From the Touch UI, Navigate to Tools -> Operations ->Configuration,  From Classic UI open Tools Console(http://localhost:4502/miscadmin#/etc/acs-commons/packagers)

•Under the acs-commmons folder, create a folder named packagers (NOTE: As of 1.6.0, this folder is created automatically)

•Under the content packagers folder, create a new Page using “ACL Packager” Template.

•There are 3 template available under this folder.◾Query Packager – Utility for creating package using queries.

◾Authorizable Packager – Used to Migrate only User and Groups (only authorizable nodes).

◾ACL Packager – Used to Migrate User/Groups with acl permissions from any where under root node.(authorizable nodes + acl nodes).

•Click on Create.



Steps to Migrate User and groups with ACL Permissions using crx package manager:- 
==================================================================================

For migrating or copying users and groups definition from one AEM instance to another,  we follow the approach of creating a package of users/groups definition , then install the package to the destination AEM instance. Note :- Take a back of existing User/group definitions . By adding /home in filter. Go to crx package manager. Create a new package and enter below details in Filters tab.

    Root path:  /home. 
    
    Rules:   /home/users/.*/.tokens

Read more at AEMCQ5Tutorials: Migrate Users and Groups With ACL Permissions in AEM http://www.aemcq5tutorials.com/tutorials/migrate-users-and-groups-with-acl-permissions-in-aem/
