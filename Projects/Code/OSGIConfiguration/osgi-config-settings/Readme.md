
To make osgi configurations to show up in osgi configurations:
==============================================================

below is the service which will use sso saml metadata to authorize and allow user to login.
To make this service show up in http://localhost:4503/system/console/configMgr

Need to add a file under /system

i.e http://localhost:4503/crx/de/index.jsp#/apps/system/config

Two ways To register osgi services:
===================================

Below SAMLProcessor service will shown up in http://localhost:4503/system/console/configMgr  you can do it in 2 ways:




      @Component(immediate = true, metatype = false)
      @Service
      public class SAMLProcessor implements AuthenticationInfoPostProcessor {

      public string loginUri="localhost:8080/Auth/sso/login"

      }



PROCEDURE 1:
============


go to http://localhost:4503/crx/de/index.jsp#/apps/system/config

you can create #/apps/system/config.qa , #/apps/system/config.uat for difference environment , it takes based on run.mode set in 
C:\Aem 6.3\crx-quickstart\conf\sling.properties   . in this file properties name    sling.run.mode.install.options    
 #sling.run.mode.install.options=author,publish|crx3|crx3tar,crx3mongo,crx3rdb,crx3mpxtar
 
Important:
===========
above not working it works only when i change in /apps/crx-quickstart/start.sh

/apps/crx-quickstart/bin/start
==============================

      if [ -z "$CQ_RUNMODE" ]; then
              CQ_RUNMODE='author,qa'
      fi

      
     
      
appropriate env config will be picked up. you can also check once you change this file whether it is booted up by crxde in 
      
      http://localhost:4503/system/console/status-slingsettings

PROCEDURE 2:
=============

under webapi project /apps/webapi/  create config folder and then create sling:osgi
http://localhost:4503/crx/de/index.jsp#/apps/webapi/config/com.test.core.impl.SAMLProcessor.config

config folder 
============

      jcr:primary type : nt:folder

/config/com.test.core.impl.SAMLProcessor.config
================================================

      jcr:primary Type : sling:OsgiConfig
      loginUri :localhost:8080/Auth/sso/saml

create a nt:file /apps/webapi/config/com.test.core.impl.SAMLProcessor.config , it will shown up in 


either way you can see SAMLProcessor show up in http://localhost:4503/system/console/configMgr
