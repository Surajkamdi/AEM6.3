Get the Public certificate from vendor like SSO , OKTA , verizine,symantec.

STEP 1:
=======

go to crxde/etc/ create /etc/key/ under key create sling:folder named "saml" as your wish
create a property "private" enter type as "Binary" and update the public certicate (.jks) file.

so the cert path is http://localhost:4503/crx/de/index.jsp#/etc/key/saml

STEP 2:
=======

in AEM 6.0 to use the public certificate.


AEM 6.0 config the above uploaded certificate:
==============================================

step 1:
========

go to  osgi configuration http://localhost:4503/system/console/configMgr 

  

step 2:
=======

open SAML 2.0 Authentication Handler.
=====================================

1)configure sp, idp url ,logout url

2)in that property named "Key-/Certificate Node" just give the path of cert in crx in our case "/etc/key/saml".




AEM 6.3 config the above uploaded certificate:
==============================================



STEP 1:
========

go to  osgi configuration http://localhost:4503/system/console/configMgr 

open SAML 2.0 Authentication Handler.
=====================================

1)configure sp, idp url ,logout url

2) go to http://localhost:4503/libs/granite/security/content/useradmin.html

   1. Click on any of the users in the list.

   2. Go under Account Settings, and press the Create TrustStore link.

   3. Enter the password for the TrustStore and press Save.

   4. Click on Manage TrustStore.

   5. Upload the IdP certificate.

link:
=====
      https://docs.adobe.com/docs/en/aem/6-3
      /administer/security/saml-2-0-authenticationhandler.html
      #Add%20the%20IdP%20certificate%20to%20the%20AEM%20TrustStore







