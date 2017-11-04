Publickey:
==========

    C:\IDP>keytool -genkey -validity 365 -keyalg RSA -keysize 2048 -storetype jks -keystore devstore.jks -alias dev 
      -dname "EMAILADDRESS=test@test.com, CN=home.test.com, O=Home, L=Chennai, S=TN, C=IN, OU=MyHome"
  
  
  it  generate devstor.jks file
  
  
  
TO list the public key X.509 cert:
===================================

     C:\idp> keytool -list -v -keystore devstore.jks
     
Enter keystore password:

Export public certificate:
==========================

    C:\idp> keytool -export -keystore devstore.jks -alias dev  -rfc -file dev_public.pem



NOTE:
=====
you have now 2 files.

1)public cert- dev_public.pem

2)devstore.jks- contain the key value pair.


Public key should start with "--BEGIN Certificate " and "--END Certificate".

