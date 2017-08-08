

To check dipatcher configured properly
=======================================

STEP 1:
========

check httpd.conf

go to conf directory check httpd.conf has dispatcherconfig entry it points to /conf/publish_dispatcher.any

cd /apps/apache/aem/conf


      /* Edit httpd.conf*/
      /*
      Find the following lines
      <IfModule disp_apache2.c>
        DispatcherConfig conf/publish_dispatcher.any
        DispatcherLog    logs/dispatcher.log  DispatcherLogLevel 0
        DispatcherDeclineRoot 0
        DispatcherUseProcessedURL 1
        DispatcherPassError 0
      </IfModule>

STEP 2:
======
check publish_dispatcher.any
apache>conf]$ nano publish_dispatcher.any

ctrl+W  - search and check /host in file and check whether it points to aem host intended so that

flow request > dispatcher > publisher instance of AEM.
Author instance connected to publish in Replication Agent and push the changes from author to publish.
publish only shows the content published by author in author environment.



    /publish01
        {
        # Hostname or IP of the render
        /hostname "10.0.5.1"  //can be name also like qa.com
        # Port of the render
        /port "4503"
        # Connect timeout in milliseconds, 0 to wait indefinitely
        # /timeout "0"
        }

search /filter in log file if dispatcher request is blocked i.e if apache log path /apache/logs/dispatcher.log shows below Filter rejects:GET /index.html like error.

check issue by hitting publish aem instance url i.e  http://10.0.5.1:4503/ from above if it works correclty, but when you go 
through dispatcher to access publish instance 10.0.5.1:4503 and if it does not work then it is issue with dispatcher.

e.g let say in 10.0.5.0 we have dispachter and in the dispatcher we have above /apache/conf/publish_dispatcher.any conf to redirect to http://10.0.5.1:4503 . 


in my case index.html is blocked by dispatcher filter  as i could see when i tail the /apache/logs/dispatcher.log. so i just add an entry in /filter with type as /allow url as /index.htm to allow request to flow to publish aem server.

      [Wed Jul 26 00:25:08 2017] [D] [43534(140383193360128)] Filter rejects: GET /index.html

Added below line  /0014{ /type "allow" /url "/inde.html" }  # all to allow index.html

          /filter
            {
                  # Deny everything first and then allow specific entries
                  /0001 { /type "deny" /glob "*" }
                  # Open consoles
                  /0011 { /type "allow" /url "/admin/*"  }  # allow servlet engine admin
                  /0012 { /type "allow" /url "/crx/*"    }  # allow content repository
                  /0013 { /type "allow" /url "/system/*" }  # allow OSGi console
                  /0014{ /type "allow" /url "/inde.html" }  # allow OSGi console
                   # Allow non-public conten
             }
             
             
STEP 3:
======
replication agent check author point to publish

i.e localhost:4502 author enviornment has default agent url of localhost:4503 (publish environment)

go to miscadmin http://localhost:4502/miscadmin directly or go to http://localhost:4502/siteadmin 

> click Tools> replicationAgent  click > Agents on Author > default Agent > click then click  setting tab if you want
any user privileges to run set in Agent User id

go to Transport tab set the publish url > http://localhost:4503/bin/receive?sling:authRequestLogin=1

