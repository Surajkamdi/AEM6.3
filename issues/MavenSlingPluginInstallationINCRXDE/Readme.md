
ERROR:
======


  [ERROR] Failed to execute goal org.apache.sling:maven-sling-plugin:2.1.0:install
   (default) on project symantec.core: Installation on http://localhost:4502/crx/repository/crx.default failed, 
   cause: Installation failed, cause: Method Not Allowed -> [Help 1]

Solutions:
===========

STEPS to solve the issue:
===========================


STEP 1:
========
check in sling servlet resolver 

http://localhost:4502/system/console/servletresolver?url=%2Fcrx%2Frepository%2Fcrx.default&method=GET

OUTPUT:
=======

if crx.default is working then output is 

if crx.default works!!!
========================

Candidate servlets and scripts in order of preference for method GET:
  1.com.day.cq.commons.servlets.NonExistingDispatcherServlet (OptingServlet)
  2.org.apache.sling.servlets.get.impl.DefaultGetServlet
  3.org.apache.sling.jcr.webdav.impl.servlets.SlingWebDavServlet

if  not crx.default works!!!
==============================
 
if /crx/repository/crx.default is not working then output

Candidate servlets and scripts in order of preference for method GET:
  1. com.day.cq.commons.servlets.NonExistingDispatcherServlet (OptingServlet)
  2. org.apache.sling.servlets.get.impl.DefaultGetServlet
  
  STEP 2:
  =======
  go to osgi http://localhost:4502/system/console/services search webdav it lists all osgi sling services with name
  webdav. from services refer components and then install.
  
  STEP 3:
  =======
  basically bundles which is responsible for webdav display is 
  Apache Sling Simple WebDAV Access to repositoriesorg.apache.sling.jcr.webdav -
  Actual class - org.apache.sling.jcr.webdav.impl.servlets.SlingWebDavServlet


  http://localhost:4502/system/console/components/
  
  STEP 4:
  =======
  
  Above is difficult easy way is go to http:/localhost:4502/system/console/bundles in search filter
  search "WebDAV". it should show below if webdav is not active as below make it active. it should works.
  
        437  Adobe DAM WebDAV Supportcom.day.cq.dam.dam-webdav-support	1.2.16	cq5	Active	
    
        486	 Apache Sling Simple WebDAV Access to repositories
                 org.apache.sling.jcr.webdav	2.3.8	sling,jcr	Active	
    
        455	 Jackrabbit WebDAV 
               Libraryorg.apache.jackrabbit.jackrabbit-webdav	2.14.0	jcr,jackrabbit	Resolved
        
  STEP 5:
  =======
  
  
  go to crxde path it should show all folders as below:
  http://localhost:4502/crx/repository/crx.default
  
  
  OUTPUT:
  =======
  
  
           /crx.default
           ..
            tmp
            home
            oak:index
            conf
            etc
            system
            content
            bin
            libs
            tmp1508570706225
            var
            apps
            
  STEP 6:
  =======
  run the maven script,  sling plugin should allow bundle to be installed using maven -sling plugins. it works!!!
  
  STEP 7:
  ======
  maven should shows sucessfull when installing.
  
      [INFO] Installing Bundle com.symantec.core(C:\ARUN\workspace\webapi\core\target\webapi.core-0.0.1-SNAPSHOT.jar) 
       to  http://localhost:4503/crx/repository/crx.default/apps/webapi/install/ via PUT
       [INFO] Bundle installed
       [INFO]


