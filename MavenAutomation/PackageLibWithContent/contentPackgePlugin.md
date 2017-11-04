 To package the jars files along with content:
 =============================================
 it will be displayed in crxde as
 
     apps
         ---webapi
               --install
                      -- templates
                               --page
                      --component
                               --page
                               --content
                       --install
                               --web.core.jar
                               --acs-aem-commons-content-3.9.jar
                               --test-webapi-ui.apps.jar
 
 <plugin>
                <groupId>com.day.jcr.vault</groupId>
                <artifactId>content-package-maven-plugin</artifactId>
                <extensions>true</extensions>
                
                <configuration>
                    <group>web-api</group>
                    <verbose>true</verbose>
                	<failOnError>true</failOnError>

                    <filterSource>src/main/content/META-INF/vault/filter.xml</filterSource>
                    <embeddedTarget>/apps/smb/webapi</embeddedTarget>
                    <embeddeds>
                        <embedded>
                            <groupId>com.webapi</groupId>
                            <artifactId>web.core</artifactId>
                        </embedded>
                        <embedded>
                            <groupId>com.adobe.acs</groupId>
                            <artifactId>acs-aem-commons-content</artifactId>
                        </embedded>
                        <embedded>
                            <groupId>com.webapi</groupId>
                            <artifactId>test-webapi.ui.apps</artifactId>
                        </embedded>
                    </embeddeds>
                </configuration>
            </plugin>

