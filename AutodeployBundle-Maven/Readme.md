packages can be autodeployed by either 1 of 2 ways.

1)put jar inside /crx-install/install/ folder and restart the AEM

or

2)do by pom.xml using maven sling plugin in core module pom.xml, it first install in the path mentioned /apps/Test/install/web-core-1.0.0-SNAPSHOT.jar of crxde(http://localhost:4502/crx/de)


    <profile>
          <id>autoInstallBundle</id>
          <activation></activation>
          <build>
            <plugins>
              <plugin>
                <groupId>org.apache.sling</groupId>
                <artifactId>maven-sling-plugin</artifactId>
                <configuration>
                  <!-- Note that this requires /apps/Test/install to exist!! -->
                  <!-- This is typically the case when ui.apps is deployed first -->
                  <!-- Otherwise, create /apps/Test/install manually (CRXDE|Lite) -->
                  <slingUrlSuffix>/apps/Test/install/</slingUrlSuffix>
                  <failOnError>true</failOnError>
                </configuration>
              </plugin>
            </plugins>
          </build>
        </profile>
    
    
    
then it install in bundles 

E.g
===


    Test - Corecom.test.core
    Symbolic Name	Test WEB
    Version	1.0.0.SNAPSHOT
    Bundle Location	jcrinstall:/apps/Test/install/web-core-1.0.0-SNAPSHOT.jar
