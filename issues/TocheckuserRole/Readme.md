
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
      
