
USe of Dependency project is to add external jars to the bundle like json , jaxp,jaxr, commonslang3.jar and other.

To add some dependend project to webapi like some java project needed to retrieve some values.

e.g webapi requires core java project webservice-utils as java project add to the webapi-core to make some 

webservice calls in webapi to retrieve some values from webservice.


autoInstallBundle is used to install the webservice-utils.core as bunlde along with webapi-core.jar




    <parent>
      <artifactId>webapi</artifactId>
      <groupId>com.webapi</groupId>
      <version>0.0.1-SNAPSHOT</version>
      <relativePath>../pom.xml</relativePath>
    </parent>

  
    <artifactId>webappi-core</artifactId>
    <packaging>bundle</packaging>
    
    
    <dependencies>
        <dependency>
          <groupId>com.google.code.gson</groupId>
          <artifactId>gson</artifactId>
        </dependency>
        <dependency>
          <groupId>de.twentyeleven.skysail</groupId>
          <artifactId>org.json-osgi</artifactId>
        </dependency>
        <dependency>
          <groupId>org.apache.commons</groupId>
          <artifactId>commons-lang3</artifactId>
        </dependency>



         <dependency>
          <groupId>webapi</groupId>
          <artifactId>webapi</artifactId>
          <version>1.0.0</version>
          <scope>system</scope>
          <systemPath>${project.basedir}/src/com/WebAPI/core/dependencies/WebService-utils.core-1.0.0.jar</systemPath>
        </dependency>

        <dependency>
          <groupId>org.apache.httpcomponents</groupId>
          <artifactId>httpclient</artifactId>
        </dependency>
        <dependency>
          <groupId>org.apache.httpcomponents</groupId>
          <artifactId>httpclient-osgi</artifactId>
        </dependency>
        <dependency>
          <groupId>org.apache.httpcomponents</groupId>
          <artifactId>httpcore</artifactId>
        </dependency>
        <dependency>
          <groupId>org.apache.httpcomponents</groupId>
          <artifactId>httpcore-osgi</artifactId>
        </dependency>
        <dependency>
          <groupId>org.jsoup</groupId>
          <artifactId>jsoup</artifactId>
        </dependency>
    </dependencies>

      <profiles>
        <!-- Development profile: install only the bundle -->
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
