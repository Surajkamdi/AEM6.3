Maven compiler plugins:
========================
For example, if you want to use the Java 8 language features (-source 1.8)
and also want the compiled classes to be compatible with JVM 1.8 (-target 1.8).

2 ways to set compiler:
========================

you can either add the two following properties, which are the default property names for the plugin parameters (procedure 1)
or configure plugin directly.




PROCEDURE 1:
============

        <project>
        :
        :
        :
        <properties>
            <maven.compiler.source>1.8</maven.compiler.source>
            <maven.compiler.target>1.8</maven.compiler.target>
          </properties>

          :
          :
          :
        </project>
   
   
PROCEDURE 2:
=============

or configure the plugin directly:



        <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                    <encoding>UTF-8</encoding>
                </configuration>
            </plugin>
