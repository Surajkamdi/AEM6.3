OSGI configuration:
====================

in crxde for your application click > create node with name com.webapi.core.impl.SAMLPostProcessResponse and type  sling:OsgiConfig
/apps/webAPI/config/com.webapi.core.impl.SAMLPostProcessResponse



NOTE :
======

the above osgi gets created as folder inside
the /apps/aem/crx-quickstart/launchpad/config/com/webapi/core/impl/SAMLPostProcessResponse.config

=====================================================

Name            |Type  | value

=====================================================

jcr:primaryType | Name |  sling:OsgiConfig

login.url |String | https://localhost:8080/sso/login


get the above properties using 


code:
=====
      @Component(immediate = true, metatype = false)
      @Service
      public class SAMLResponsePostProcessor implements AuthenticationInfoPostProcessor {
      {


        @Activate
        protected void activate(Map<String, Object> properties) {
          if (properties.get("login.url") != null)
            loginUrl = properties.get("login.url").toString();
          log.info("LoginUrl from SAMLPostProcessor is " + loginUrl);
        }

        }




