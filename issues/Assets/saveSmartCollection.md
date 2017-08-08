
ISSUE:
=======
"Smart Collection cannot be saved" when seeing log saving root access is needed.
4.07.2017 15:58:51.470 *ERROR* POST /content/dam/collections.collection.html HTTP/1.1]
com.day.cq.dam.core.impl.collection.DamCollectionManager Error while creating collection
javax.jcr.AccessDeniedException: Root node is not accessible.

STEPS to simulate:
===================

STEP 1:
======
go to http://localhost:4502/assets.html and then click on the top corner adobe icon then > click collectoins> create collections
it should save collections  or
http://localhost:4502/libs/dam/gui/content/collections.html/content/dam/collections

as well as go to http://localhost:4502/assets.html  search click on top filter icon in " search filter " give some search filter
to search and then click "smart Smart collection" then give in text box named "enter name of collection"  value to save then click
save it should sucessfully as well as . It should says " smart collection created" alert message.

Solution:
=========

go to url http://localhost:4502/useradmin check the user login for e.g login as admin search admin check the permission on right
under /home/users , /home/groups make sure it is checked 

NOTE:
=====

https://docs.adobe.com/docs/en/aem/6-2/author/assets/managing-assets-touch-ui/managing-collections-touch-ui.html

To enable the members to share collections with other users, provide the dam-users group read permissions at the path home/users.

first to check login user best option is to go to 

http://localhost:4502/useradmin search user in left and in right for e.g search admin in left panel click search icon and
then click admin it shows in right click > properties check the - path text box "/home/users/A/Arun"

then copy the user path and check the same by append in crxde http://localhost:4502/crx/de/index.jsp#/home/users/A/Arun
it shows following hierarchy


    --Arun
        --tokens
        --preference
        --profile
        --rep:policy
           --deny
           --allow
               properties

allow:Properties:
------------------

      ===========================================================
      Name                  |Type                   | value
      ===========================================================
      jcr:primaryType       | Name                  |rep:grantACE
      rep:principalName     | replication-receiver  |rep:grantACE
      rep:privileges        | Name[]                |jcr:all
      ==========================================================
   
   
NOTE:
====
rep:principalName   - replication-receiver is the actual role of the user who login .
      
