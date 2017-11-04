Persistent ID:
=============

if by if you set Annonymous login user name and password in Sling Authentication service of localhost:4502/system/console/configMgr
or go to localhost:4502/system/bundles  > click osgi configuration> check Apache Sling Authentication Service.

Apache Sling Authentication Service:
======================================

        Anonymous User Name : java ( if wrong user name & password set)

        Annonymous User Password: 

        Authentication User Suffices:/j_security_check

        Configuration Information:
      
        Persistent Identity (PID)	:  org.apache.sling.engine.impl.auth.SlingAuthenticator
        Configuration Binding	
        Unbound or new configuration 
        
Each osgi services has persistent id: it is name by which i created a  configuration file inside launchpad of aem server.
e.g above persistent id configuration will gets stored in aem server in path:

 /apps/aem/crx-quickstart/launchpad/config/org/apache/sling/engine/impl/auth/SlingAuthenticator.config

ISSUE:
======

below error if annonymous user name is set with wrong username & password, and can't login in to even via
localhost:4502/crx/de/index.jsp .so only way to change it is below.


jsp error page:
================
        Problem accessing /libs/granite/core/content/login.html. Reason:

           Forbidden
    
error in /apps/aem/crx-quickstart/logs
======================================

            [ADMIN@localhost logs]$ tail -f error.log
            29.09.2017 19:53:45.378 *INFO* [oak-repository-executor-1] com.adobe.granite.repository Service [9710, [org.apache.jackrabbit.oak.api.jmx.SessionMBean]] ServiceEvent REGISTERED
            29.09.2017 19:54:28.735 *INFO* [Apache Sling Resource Resolver Finalizer Thread] com.adobe.granite.repository Service [9710, [org.apache.jackrabbit.oak.api.jmx.SessionMBean]] ServiceEvent UNREGISTERING
            29.09.2017 19:54:28.749 *INFO* [Apache Sling Resource Resolver Finalizer Thread] com.adobe.granite.repository Service [9709, [org.apache.jackrabbit.oak.api.jmx.SessionMBean]] ServiceEvent UNREGISTERING
            29.09.2017 19:54:28.750 *INFO* [Apache Sling Resource Resolver Finalizer Thread] com.adobe.granite.repository Service [9137, [org.apache.jackrabbit.oak.api.jmx.SessionMBean]] ServiceEvent UNREGISTERING
            29.09.2017 20:00:30.001 *INFO* [sling-default-48-Registered Service.2887] com.adobe.granite.taskmanagement.impl.jcr.TaskArchiveService archiving tasks at: 'Fri Sep 29 20:00:30 MDT 2017'
            29.09.2017 20:01:00.004 *INFO* [oak-repository-executor-1] com.adobe.granite.repository Service [9711, [org.apache.jackrabbit.oak.api.jmx.SessionMBean]] ServiceEvent REGISTERED
            29.09.2017 20:01:18.135 *INFO* [Apache Sling Resource Resolver Finalizer Thread] com.adobe.granite.repository Service [9711, [org.apache.jackrabbit.oak.api.jmx.SessionMBean]] ServiceEvent UNREGISTERING
            29.09.2017 20:06:26.936 *INFO* [qtp138560482-3230] org.apache.sling.auth.core.impl.SlingAuthenticator getAnonymousResolver: Anonymous access not allowed by configuration - requesting credentials
            29.09.2017 20:06:26.986 *INFO* [qtp138560482-3277] org.apache.sling.auth.core.impl.SlingAuthenticator handleLoginFailure: Unable to authenticate anonymous user: Login Failure: all modules ignored
            29.09.2017 20:07:23.002 *INFO* [sling-default-54-Registered Service.2691] com.adobe.granite.oauth.server.impl.AccessTokenCleanupTask AccessTokenCleanupTask: Removed 0 token(s) in 1ms (0 token(s) still active)




        [ADMIN@localhost auth]$ pwd
        /apps/aem/crx-quickstart/launchpad/config/org/apache/sling/engine/impl/auth
        [ADMIN@localhost auth]$ ls
        SlingAuthenticator.config
        [ADMIN@localhost auth]$nano SlingAuthenticator.config


        auth.annonymous=B"false"
        auth.http="preemptive"
        auth.http.realm="Sling\ (Development)"
        auth.sudo.cookie="sling.sudo"
        auth.sudo.parameter="sudo"
        auth.uri.suffix=[ \
          "/j_security_check", \
          ]
        osgi.http.whiteboard.context.select="(osgi.http.whiteboard.context.name\=*)"
        osgi.http.whiteboard.listener="true"
        service.pid="org.apache.sling.engine.impl.auth.SlingAuthenticator"
        sling.auth.anonymous.user="java"
        sling.auth.requirements=[ \
          "+/", \
          "/content/webapi/english/en/auth", \
          "-/libs/granite/core/content/login", \
          "-/etc/clientlibs/granite", \
          ]

Solution:
=========
just  change sling.auth.anonymous.user="" ie make it as default anonymous user instead of any specific user. it will fix the issue.

