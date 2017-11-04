
Sling installation 
===================
it looks for config and install folder and install the service using this jar.

crx-quickstart\launchpad\startup\1\org.apache.sling.launchpad.installer-1.2.2.jar

org.apache.sling.launchpad.installer.impl.LaunchpadListener.java

org.apache.sling.launchpad.installer.impl.LaunchpadConfigInstaller - read config,install dir and install bundles;
