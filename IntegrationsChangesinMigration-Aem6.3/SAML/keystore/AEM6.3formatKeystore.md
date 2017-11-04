
STEPS To generate PKCS8
=========================


STEP 1:
=======

Go to: http://localhost:4502/libs/granite/security/content/useradmin.html

STEP 2:
=======
Edit the authentication-service user.

Create a KeyStore by clicking Create KeyStore under Account Settings.

NOTE
=====

Important:
==========

keystore should be in " PKCS#8 format with DER encoding"

The below steps are required only if handler should be able to sign or decrypt messages.

Upload the Private key file by clicking Select Private Key File. The key meeds to be in " PKCS#8 format with DER encoding".  

Upload the certificate file by clicking Select Certificate Chain Files.



STEP 3:
=======


Generate JKS file using keytool:
================================


    C:\IDP>keytool -genkey -validity 365 -keyalg RSA -keysize 2048 -storetype jks -keystore devstore.jks -alias dev 
  -dname "EMAILADDRESS=test@test.com, CN=home.test.com, O=Home, L=Chennai, S=TN, C=IN, OU=MyHome"
  
  
    C:\idp> keytool -export -keystore devstore.jks -alias dev  -rfc -file dev_public.pem
