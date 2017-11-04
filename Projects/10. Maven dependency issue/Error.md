Error:
======

http://localhost:4502/crx/packmgr/index.jsp#/etc/packages/adobe/consulting/acs-aem-commons-content-2.6.11.zip


[ERROR] Failed to execute goal on project aem-cloud.ui.apps: Could not reso
lve dependencies for project com.webapi:aem.cloud.ui.apps:content-package
:0.0.1-SNAPSHOT: Failure to find com.adobe.acs:acs-aem-commons-bundle:jar:3.9.0
 in https://repo.adobe.com/nexus/content/groups/public/ was cached in the local
repository, resolution will not be reattempted until the update interval of adob
e has elapsed or updates are forced -> [Help 1]
[ERROR]



Reason for Error:
==================

i already installed 2.6.11 and i try  to install 3.9 it shows above. since we given scope as provided
it checks in crx repository it pickups 2.6.11 and it is not there in local. since we given scope as provided it looks
in the bundle of the aem.

Reason 1:
==========
  1)no bundle with version 3.10 in maven repsitory.
  or already old version in repository delete it and try it should work.
  


debug:
======
try 

> mvn clean install and let download the jars check the path.


Downloaded: https://repo.adobe.com/nexus/content/groups/public/com/adobe/acs/acs
-aem-commons-content/3.9.0/acs-aem-commons-content-3.9.0-min.zip (10788 KB at 57
6.3 KB/sec)
[INFO]



core:
=====

<dependency>
                <groupId>com.adobe.acs</groupId>
                <artifactId>acs-aem-commons-content</artifactId>
                <version>3.9.0</version>
                <type>content-package</type>
                <scope>provided</scope>
                <classifier>min</classifier>
 </dependency>
 
 	<dependency>
			    <groupId>com.adobe.acs</groupId>
			    <artifactId>acs-aem-commons-bundle</artifactId>
			</dependency>
      
      
 
 ui.apps
 =======
 <dependency>
            <groupId>com.adobe.acs</groupId>
            <artifactId>acs-aem-commons-content</artifactId>
            <type>content-package</type>
            <classifier>min</classifier>
        </dependency>
        
 core
 ====
 <dependency>
            <groupId>com.adobe.acs</groupId>
            <artifactId>acs-aem-commons-bundle</artifactId>
        </dependency>
