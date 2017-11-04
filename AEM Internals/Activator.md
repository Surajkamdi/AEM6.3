
Activator:
==========

1.Granitor Activator:
====================


\crx-quickstart\launchpad\startup\1\com.adobe.granite.startup-0.6.2.jar\com.adobe.granite.startup.impl.Activator


2.Sling Runmode Activator:
==========================

\crx-quickstart\launchpad\startup\1\org.apache.sling.settings-1.3.8.jar\org.apache.sling.settings.impl.Activator

run mode is configured from org.apache.sling.settings.impl.SlingSettingsServiceImpl
env variables  read for sling settings to boot.

               public static final String SLING_HOME = "sling.home";
                public static final String SLING_HOME_URL = "sling.home.url";
                public static final String RUN_MODES_PROPERTY = "sling.run.modes";
                public static final String RUN_MODE_OPTIONS = "sling.run.mode.options";
                public static final String RUN_MODE_INSTALL_OPTIONS = "sling.run.mode.install.options";
