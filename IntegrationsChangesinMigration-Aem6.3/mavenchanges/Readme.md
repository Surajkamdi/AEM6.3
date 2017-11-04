    
 Add aem 6.3 jars
 =================
 https://helpx.adobe.com/experience-manager/kt/platform-repository/using/aem-6-3-article-develop.html
 
 
     <dependency>
        <groupId>com.adobe.aem</groupId>
        <artifactId>uber-jar</artifactId>
        <version>6.3.0</version>
        <classifier>apis</classifier>
        <scope>provided</scope>
    </dependency>

    <dependency>
        <groupId>org.osgi</groupId>
        <artifactId>osgi.cmpn</artifactId>
        <version>6.0.0</version>
    </dependency>
    
    NOTE:
    ======
    use obfuscated-apis if the bundle shows error com.adobe.cq.sightly.internal ---- CANNOT be resolved.

    
       <dependency>
        <groupId>com.adobe.aem</groupId>
        <artifactId>uber-jar</artifactId>
        <version>6.3.0</version>
        <classifier>obfuscated-apis</classifier>
        <scope>provided</scope>
    </dependency>
    

    To process the OSGi R6 annotations, version 3.3.0+ of the maven-bundle-plugin is required.
    =========================================================================================

    <plugin>
        <groupId>org.apache.felix</groupId>
        <artifactId>maven-bundle-plugin</artifactId>
        <version>3.3.0</version>
    </plugin>
    
   ui.apps
   ========
   
       <plugin>
        <groupId>org.apache.sling</groupId>
        <artifactId>htl-maven-plugin</artifactId>
        <version>1.0.6</version>
        <configuration>
            <sourceDirectory>${basedir}/src/main/content/jcr_root</sourceDirectory>
            <failOnWarnings>false</failOnWarnings>
        </configuration>
        <executions>
            <execution>
                <id>validate-scripts</id>
                <goals>
                    <goal>validate</goal>
                </goals>
                <phase>compile</phase>
            </execution>
        </executions>
    </plugin>
    
    Dispatcher
    ===========
    
    Apache httpd 2.2.4 dispatcher.tar need to installed - advised.
    
    
