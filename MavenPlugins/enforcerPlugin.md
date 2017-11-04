Enforcer Plugin:
=================

goals to control certain environmental constraints such as Maven version, 
JDK version and OS family along with many more built-in rules and user created rules

Below tells that core multimodal project should be compiled jdk 1.6.0 or higher. you can enforce some
constraints like minimum version required to build the project. to Avoid being compiled with lower version of java
and get in to trouble in target environment.


    enforcer:enforce - executes rules for each project in a multi-project build.
    enforcer:display-info - display the current information as detected by the built-in rules.
    
    Required Parameters
    ====================
    
    Name   |	Type       |	 	Description
    rules 	EnforcerRule[] 	- 	Array of objects that implement the EnforcerRule interface to execute.
    
E.g:
====

    <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-enforcer-plugin</artifactId>
            <executions>
              <execution>
                <id>enforce-maven</id>
                <goals>
                  <goal>enforce</goal>
                </goals>
                <configuration>
                  <rules>
                    <requireMavenVersion>
                      <version>[3.3+,)</version>
                    </requireMavenVersion>
                    <requireJavaVersion>
                      <message>compile with Java 6 or higher</message>
                      <version>1.6.0</version>
                    </requireJavaVersion>
                  </rules>
                </configuration>
              </execution>
            </executions>
          </plugin>
          
  Error Test case:
  ===============
  if i give the maven requireversion to non-existent one 3.3.999+ not exist it shows below error.   
  if i give 3.3+ it works fine.
  
  Error:
  ======
          [INFO] --- maven-enforcer-plugin:1.4:enforce (enforce-maven) @ webapi ---
        [WARNING] Rule 0: org.apache.maven.plugins.enforcer.RequireMavenVersion failed w
        ith message:
        Detected Maven Version: 3.3.9 is not in the allowed range [3.3.999+,).
     
     
             <plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-enforcer-plugin</artifactId>
				<executions>
					<execution>
						<id>enforce-maven</id>
						<goals>
							<goal>enforce</goal>
						</goals>
						<configuration>
							<rules>
								<requireMavenVersion>
									<version>[3.3.999+,)</version>
								</requireMavenVersion>
								<requireJavaVersion>
									<message>Project must be compiled with Java 6 or higher</message>
									<version>1.8.0</version>
								</requireJavaVersion>
							</rules>
						</configuration>
					</execution>
				</executions>
			</plugin>
