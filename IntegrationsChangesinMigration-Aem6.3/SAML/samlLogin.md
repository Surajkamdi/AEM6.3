STEP 1:Adobe Granite SAML 2.0 Authentication Handler
=====================================================

    goto  http://localhost:4502/system/console/configMgr

    goto > Adobe Granite SAML 2.0 Authentication Handler

    IDP URL : localhost:8080/Auth/sso/idp/SAML2

    serviceprovider : localhost:4502/content/webapi.jsp

    UserID: userid or if salesforce symFederationId.

    synchrozied attributes: 

    FirstName=profile/firstName
    LastName=profile/lastName
    Email=profile/email
    isPartner=profile/isPartner
    SymFederationId=profile/uid

    #key should be http://localhost:4502/crx/de/index.jsp#/etc/key/metadata(binary)
    key-/Certificate Node /etc/key/metadata  

    persistent id : com.adobe.granite.auth.saml.SAMLAuthenticationHandler.c9090325032
    Factory persistent id : com.adobe.granite.auth.saml.SAMLAuthenticationHandler

STEP 2:
=======

Apache Sling Referer Filter:
============================

    Allow hosts: http://localhost:8080/login

    Persistent Idenitty(PID): org.apache.sling.security.impl.ReferrerFilter.

STEP 3:
=======


Apache sling Authentication Service:
====================================

    Impersonation Cookie : sudo
    Authentication Requirements : /bin/signin
    Authentication URI: /j_security_check
    Persistent Identity : org.apache.sling.engine.impl.auth.SlingAuthenticator.



STEP 4:
=======

Install ACS AEM common bundle for AEM 6.3 
    AEM 6.3 use 3.9 form below 
    
    (https://github.com/Adobe-Consulting-Services/acs-aem-commons/releases/tag/acs-aem-commons-3.9.0)



