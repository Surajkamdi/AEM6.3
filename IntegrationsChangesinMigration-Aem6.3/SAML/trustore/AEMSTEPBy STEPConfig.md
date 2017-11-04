STEP 1:
======


Go to: http://localhost:4502/libs/granite/security/content/useradmin.html

Click on any of the users in the list.

Go under Account Settings, and press the Create TrustStore link.

Enter the password for the TrustStore and press Save.

Click on Manage TrustStore.

Upload the IdP certificate.

STEP 2:
=======

Generate certificates using below command.


    C:\IDP>keytool -genkey -validity 365 -keyalg RSA -keysize 2048 -storetype jks -keystore devstore.jks -alias dev 
    -dname "EMAILADDRESS=test@test.com, CN=home.test.com, O=Home, L=Chennai, S=TN, C=IN, OU=MyHome"

    C:\idp> keytool -export -keystore devstore.jks -alias dev  -rfc -file dev_public.pem
    
  NOTE:
  =====
  you need to remember 3 threethings.
  
  1) keystore password - when run command 1 above it prompt "Enter keystore password:"
  
  2)Need to know the Alias "dev"
  
  3)public key - dev_public.pem  which is inside "--BEGIN Certificate" and "--END Certificates" notes.
  


STEP 3:
=======

/libs/granite/security/content/useradmin.html

search the user you want to add certificate

    screenshot:
    ===========


    click on below Manage Trustore link in Account settings.
          Account settings

          Status
          active
          Change Password |Manage TrustStore|Create KeyStore
          Photo


STEP 4:
========

upload the certifcate using 

screenshot:
============

    Add Certificate from KeyStore file:
    ===================================
    
        Select KeyStore File Choose File :devstore.jks
        Enter KeyStore Password : keystore password when running keytool command prompt

        Enter Private Key Password:

        Enter Private Key Alias: dev
        Submit


STEP 5:
=======


  TrustStore Management

  Alias|	Certificate	|  Subject	Issuer	|Not Before|	Not After|


  admin#1509155300538	EMAILADDRESS=test@test.com, CN=home@test.com, O=Home, L=Chennai, ST=TN, C=IN, OU=home	EMAILADDRESS=test@test.com, CN=www1-qa1.symc.Symantec.com, O=Symantec, L=MountainView, ST=CA, C=US, OU=Symantec	Fri Oct 27 18:56:17 MDT 2017	Sat Oct 27 18:56:17 MDT 2018	

  Add Certificate from CER file


STEP 6:
-------

go to OSGI Configuration > /system/console/configMgr

go to Adobe Granite SAML 2.0 Authentication Handler.

screenshot 
===========


Enter the idp alias in the below text box:
        
IDP Certificate Alias	- 
admin#1509155300538

The alias of the IdP's certificate in the global truststore. If this property is empty the authentication handler is disabled. (idpCertAlias)
