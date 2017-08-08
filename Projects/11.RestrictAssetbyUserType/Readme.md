Restrict Asset Publish based on user Type
==========================================
Aem can publish Asset from Author to publish and can also restrict asset to be in publish based on usertype.
for e.g asset publish by internal_user i.e asset which can be shared with in company can be restricted not to be published to
external public site by having a user Type level asset validation.

for e.g Asset published by internal users from folders /content/dam/internalDocuments/ will only be available to only internal users.
other content published by external usertype wont be seen by internal users.

If you have internal and external server i.e internal server can gets assets published from author by internal users
and external servers gets assets published from author by user who is external user type.

user type -> internal and  author published by internal user --> in internal environment publish servers only gets assets published.
e.g confidential document of companies.

usertype --> external user tye author  --> in all external users the content published by external user gets published in all
external environment server.e.g all other product and troubleshooting document needed by external users will be published.

TO make it .


go to user Admin  link below

STEP 1:
=======
http:/localhost:4502/useradmin - create 2 users one for internal user and other for external user.

e.g internaluser -> internal
e.g externaluser -> external.

internal user --> restrict folder permission in crxde to publish only for internal folder i.e /content/dam/internal
create user by click Edit > create > create user > give  USER ID ,firstname , lastname , password,confirm password.


external user --> restrict folder permission in crxde to publish only for external folder i.e /content/dam/external
FLow:
=====
internal user mapped --> folder --> that internal user is configured in Replication Agent (Agent User id) so whatever permission
set for user i.e whatever folder access give to user will only gets published to replication server set in default agent settings.

STEP 2:
========
search the internalUser> click on it it open as user details in right > 
Properties show LoginID, firstname ,password, confirmation password.
group : everyone
Permission : 

internal users:
only internal 

Path :         Read |  Modify |create |delete |ReadACL| editACL |Replicate
===========================================================================
    apps     | tick    -      -     -      -       -       -
    
    content  |  -      -       -       -    -       -       -
    
    etc      | -       -       -       -     -      -      -
    
    internal  | x       x      x        x  x        x
     
  
  External user
  

Path :         Read |  Modify |create |delete |ReadACL| editACL |Replicate
===========================================================================
    apps     |  x       x      x        x     x        x        x
    
    content  |  x       x      x        x     x        x        x
    
    etc      |  x       x      x        x     x        x        x
   internal   | -       -       -        -     -       -        -
   
   Note:
   =====
   As you can for internal folder only internal users environment are allowed
   for external user all folder assets can be published to publish environment from author in external environment.
   except internal folder .
   
so when asset drop in http://localhost/assets.html/content/dam/internal folder it only publishes to internal user evironment. and
when content drop in other folder than internal folder it will not be available to  external not internal environment.


STEP 3:
======
drop a assets in internal folder http://localhost:4502/assets.html/content/dam then click > publish then only that assets should be available in internal envrionment servers i.e internal server which is available in company network.

if assets is drop in other folder then it is made available to all external environment server .


STEP 4:
========
go to replication http://localhost:4502/siteadmin > click tools > Replication > Agents on Author >

double click on default Agent> Edit

dialog showing multiple tabs.
click on settings tab >  on Agent User Id text box set value "internal" or any name which LoginID created in create user of http://10.44.102.52:4502/useradmin page. i.e  - name of the LoginID created in step 1.


similarly copy the default Agent just change Agent UserID  value set to "external" -Login ID of external user created earlier.

when dropping the assets in "/content/dam/internal" folder which is mapped to internal usertype then assets will be published by internal  should be published to internal servers only no external server has the assets available , similary when assets
dropped in folder mapped to externaluser then assets will be published to all external server and not to internal servers.
since we uncheck the internal folder in the user permission settings.


Agent Settings Menu:
====================
Agent User Id :internal/external 

Note:
====
no need to change other menu tabs like transport,proxy,extended,triggers,batch.

