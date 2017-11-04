AEM 6.0 vs AEM 6.3
===================

aem 6.0
=========
      <dependency>
            <groupId>com.adobe.aem</groupId>
            <artifactId>aem-api</artifactId>
          </dependency>
    
change to below:
================

      <dependency>
                  <groupId>com.adobe.aem</groupId>
                  <artifactId>uber-jar</artifactId>
                  <classifier>apis</classifier>
                    <version>6.3.0</version>
      </dependency>


NOTE:
=====
Make sure uber-jar is in ui.apps,ui.content,main pom.xml . make sure 6.0 com.adobe.aem is commented and replaced by
uber-jar . it is where  aaem sightly - com.adobe.cq.sightly.WCMMode loaded.




