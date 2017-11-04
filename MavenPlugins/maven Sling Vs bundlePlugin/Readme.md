

Maven Bundle vs Sling Plugin:
==============================

  Bundle plugin - used to create bundle.
  
  SlingPlugin - usd to install in the crxde bundles.


    -- maven-bundle-plugin:2.5.3:install (default-install) @ webapi.core ---
    [INFO] Installing com/webapi/core/0.0.1-SNAPSHOT/WebAPI.core-0.0.1-SNAPSHOT.jar
    [INFO] Writing OBR metadata
    [INFO] 
    [INFO] --- maven-sling-plugin:2.1.0:install (default) @ webapi.core ---
    [INFO] Installing Bundle com.webapi.core(C:\ARUN\workspace\WebAPI\core\target\WebAPI.core-0.0.1-SNAPSHOT.jar)
          to http://localhost:4503/crx/repository/crx.default/apps/WebAPI/install/ via PUT
    [INFO] Bundle installed
    [INFO]                  
  
  
  slingUrlSuffix- represent the url suffix after crx/repository/crx.default to upload jar.
  
   http://localhost:4503/crx/repository/crx.default/apps/WebAPI/install/WebAPI.core-0.0.1-SNAPSHOT.jar
 
   will contain actual jar in crxde 
  
  Maven Bundle Plugin
  ====================
    <plugin>
      <groupId>org.apache.felix</groupId>
      <artifactId>maven-bundle-plugin</artifactId>
      <extensions>true</extensions>
      <configuration>
        <instructions></instructions>
      </configuration>
      </plugin>  
      
      
 Maven Bundle Plugin with configuration to ignore packages:
 ===========================================================
  maven bundle plugin to ignore some packages while bundle the package .
  
  
       <plugin>
          <groupId>org.apache.felix</groupId>
          <artifactId>maven-bundle-plugin</artifactId>
          <extensions>true</extensions>
           <configuration>  
                          <instructions>  
                              <Import-Package>  
                                  org.spring.*;resolution:=optional,
                                  org.apache.http.*;resolution:=optional,
                                  org.apache.*;resolution:=optional,
                                  org.jaxen.*;resolution:=optional,  
                                  javassist;resolution:=optional,  
                                  com.sun.jdi.*;resolution:=optional,  
                                  sun.misc;resolution:=optional,  
                                  org.codehaus.plexus.util;resolution:=optional,  
                                  *  
                              </Import-Package>  
                              <Sling-Model-Packages>  
                                  com.webapi.core  
                              </Sling-Model-Packages>  
                          </instructions>  
                      </configuration>  
          </plugin>  

 maven Sling Plugin:
 ===================
        <profile>
        <id>autoInstallBundle</id>
        <activation></activation>
        <build>
          <plugins>
            <plugin>
              <groupId>org.apache.sling</groupId>
              <artifactId>maven-sling-plugin</artifactId>
              <configuration>
                <!-- Note that this requires /apps/WebAPI/install to exist!! -->
                <!-- This is typically the case when ui.apps is deployed first -->
                <!-- Otherwise, create /apps/WebAPI/install manually (CRXDE|Lite) -->
                <slingUrlSuffix>/apps/WebAPI/install/</slingUrlSuffix>
                <failOnError>true</failOnError>
              </configuration>
            </plugin>
          </plugins>
        </build>
      </profile>
      
NOTE:
======

 http://localhost:4503/crx/repository/crx.default/apps/WebAPI/install/WebAPI.core-0.0.1-SNAPSHOT.jar
 
 screenshot of the actual page
 ==============================
 
 /crx.default/apps/WebAPI/install

..
.WebAPI.core-0.0.1-SNAPSHOT.jar

--------------------------------

Powered by Apache Jackrabbit Oak version 1.6.1
      
