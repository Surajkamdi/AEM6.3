

STEPS to generate trustore in AEM 6.3
=======================================

STEP 1:
========

Go to: http://localhost:4502/libs/granite/security/content/useradmin.html


STEP 2:
========

Click on any of the users in the list.

STEP 3:
=======

Go under Account Settings, and press the Create TrustStore link.

STEP 4:
=======

Enter the password for the TrustStore and press Save.

STEP 5:
=======

Click on Manage TrustStore.

STEP 6:
=======

Upload the IdP certificate.

STEP 7:
=======

Take note of the certificate Alias. This alias should be enterd in AEM 



LOGS:
=====

    127.0.0.1 - admin 27/Oct/2017:18:18:34 -0700 "GET /bin/receive?sling:authRequestLogin=1 HTTP/1.1" 200 32 "-" "Jakarta Commons-HttpClient/3.1"
    0:0:0:0:0:0:0:1 - admin 27/Oct/2017:18:18:48 -0700 "POST /libs/granite/security/post/truststore HTTP/1.1" 200 - "http://localhost:4503/libs/granite/security/content/userEditor.html/home/users/4/4_n3GzBQQV1kebVt_GSI" "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.75 Safari/537.36"
    0:0:0:0:0:0:0:1 - admin 27/Oct/2017:18:18:48 -0700 "GET /home/users/4/4_n3GzBQQV1kebVt_GSI.ks.json?ck=1509153528908 HTTP/1.1" 200 16 "http://localhost:4503/libs/granite/security/content/userEditor.html/home/users/4/4_n3GzBQQV1kebVt_GSI" "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.75 Safari/537.36"
    0:0:0:0:0:0:0:1 - admin 27/Oct/2017:18:18:48 -0700 "GET /libs/granite/security/truststore.json?ck=1509153528909 HTTP/1.1" 200 14 "http://localhost:4503/libs/granite/security/content/userEditor.html/home/users/4/4_n3GzBQQV1kebVt_GSI" "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.75 Safari/537.36"

it should create some json files in the crxde security folder
================================================================

http://localhost:4503/libs/granite/security/truststore.json

OUTPUT:
=======

{"aliases":[]}

