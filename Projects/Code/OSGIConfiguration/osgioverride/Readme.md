System configuration:
=====================
by default osgi configuration looks under /libs/system/config.


/apps/webapi

/libs/system/config/sso.config

/libs/system/config.author

/libs/system/config.standby.crx3tar/sso.config

http://localhost:4502/crx/de/index.jsp#/libs/system/install.crx3/com.adobe.granite.repository-0.6.174.jar


override by giving under
=========================

    /apps/webapi/config.qa/sso.config
    /apps/webapi/config.dev/sso.config
    /apps/webapi/config.uat/sso.config


sso.config
===========
    defaultRedirectUrl="/"
    userIDAttribute="uid"
    defaultGroups=["webapi"]
    idpUrl="\ http://localhost:880/idp


this configuration will pickuped up by entering in runmode.
============================================================

/apps/crx-quickstart/bin/start

  if [ -z "$CQ_RUNMODE" ]; then
          CQ_RUNMODE='author,qa'
  fi
