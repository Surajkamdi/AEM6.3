


osgi configuration in bundles:
==============================

http://localhost:4503/system/console/configMgr

Akamai CCU REST API Manager	-	
   
Akamai Event Handler	-	
   
Akamai Flush Job


1)Akamai CCU REST API Manager	
==============================


  Manage calls to the Akamai CCU REST API
  Akamai CCU API URL -https://api.ccu.akamai.com

  Description for rootCcuUrl (rootCcuUrl)
  Username	

  Description for userName (userName)
  Password	  

  Description for password (password)
  Default purge action	-  remove

  Can be invalidate, remove (default) (defaultPurgeAction)
  Default purge domain	-  production,dev, qa

  Can be staging, production (default) (defaultPurgeDomain)
  Configuration Information-
  Persistent Identity (PID)	com.test.akamai.ccu.impl.CcuManagerImpl(Actual class)
  Configuration Binding	-  Unbound or new configuration 


2)Akamai Event Handler:
========================


    Listen to repository replication notification to invalidate Akamai cache when it is needed
    Event topic	-    com/day/cq/replication

    Description for event.topics (event.topics)
    Handled paths	-    /content/TestWeb

    Description for pathsHandled (pathsHandled)
    Configuration Information
    Persistent Identity (PID)  -	com.test.akamai.ccu.impl.AkamaiEventHandler(Actual class)
    Configuration Binding	
    Unbound or new configuration 
    
3)Akamai Flush Job
==================

    Job that execute Akamai flush using Akamai CCU manager
    Property job.topics	- com/test/akamai/ccu/impl/FlushAkamaiItemsJob

    Description for job.topics (job.topics)
    Root site url	

    Scheme and domain to append at the beginning of the paths like https://www.test.com (rootSiteUrl)
    Configuration Information
    Persistent Identity (PID)	- com.test.akamai.ccu.impl.FlushAkamaiItemsJob
    Configuration Binding	
    Unbound or new configuration 




