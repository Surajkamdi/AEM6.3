
STEP 1:
=======
check the linux version then download accordingly apr-util. if ext.sh error or apr-xml could not be found like that 
then download and install. with lowest version of apr-util.

installation instruction - http://httpd.apache.org/docs/current/install.html

1)httpd-2.4.27.tar.gz - apache site

2)apr-util-1.5.4.tar.gz - since apr-util-1.6.0.tar.gz showing aprxml error

3)apr-1.6.2.tar.gz from apache site

4)pcre-8.41.tar.gz

5) dispatcher  https://www.adobeaemcloud.com/content/companies/public/adobe/dispatcher/dispatcher.html

STEP 2:
========

 

    [aem6]$ pwd
    /apps/apache/aem63
    [aem6]$
    [aem63]$ tar -xvf httpd-2.4.27.tar.gz
    [ADMIN aem63]$ ls
    dispatcher  httpd-2.4.27  httpd-2.4.27.tar.gz
    [ADMIN aem63]$
    [ADMIN aem63]$ mv httpd-2.4.27 apache
    [ADMIN aem63]$ ls
    apache  dispatcher  httpd-2.4.27.tar.gz
    [ADMIN aem63]$ cd apache
    [ADMIN apache]$ cd srclib
    [ADMIN srclib]$
    [ADMIN srclib]$ cp /tmp/pcre-8.41.tar.gz .
    [ADMIN srclib]$ cp /tmp/apr-
    apr-1.6.2.tar.gz       apr-util-1.5.4.tar.gz  apr-util-1.6.0.tar.gz
    [ADMIN srclib]$ cp /tmp/apr-util-1.5.4.tar.gz .
    [ADMIN srclib]$ cp /tmp/apr-1.6.2.tar.gz .
    [ADMIN srclib]$ ls
    apr-1.6.2.tar.gz  apr-util-1.5.4.tar.gz  Makefile.in  pcre-8.41.tar.gz
    [ADMIN srclib]$ tar -xvf apr-1.6.2.tar.gz 
    [ADMIN srclib]$ tar -xvf pcre-8.41.tar.gz
    [ADMIN srclib]$ tar -xvf apr-util-1.5.4.tar.gz
    [ADMIN srclib]$ ls
    apr-1.6.2  apr-1.6.2.tar.gz  apr-util-1.5.4  apr-util-1.5.4.tar.gz  Makefile.in  pcre-8.41  pcre-8.41.tar.gz
    [ADMIN srclib]$ mv apr-1.6.2 apr
    [ADMIN srclib]$ mv apr-util-1.5.4 apr-util
    [ADMIN srclib]$ mv pcre-8.41 pcre
    [ADMIN srclib]$ ls
    apr  apr-1.6.2.tar.gz  apr-util  apr-util-1.5.4.tar.gz  Makefile.in  pcre  pcre-8.41.tar.gz
    [ADMIN srclib]$
    [ADMIN srclib]$ rm -r *.gz
    [ADMIN srclib]$ ls
    apr  apr-util  Makefile.in  pcre
   

    [ADMIN srclib]$
    [ADMIN srclib]$ cd pcre
    [ADMIN pcre]$ pwd
    /apps/apache/aem63/apache/srclib/pcre
    [ADMIN pcre]$ ./configure  --prefix=/apps/apache/aem63/apache/srclib/pcre


    pcre-8.41 configuration summary:

    Install prefix .................. : /apps/apache/aem63/apache/srclib/pcre
    C preprocessor .................. : gcc -E
    C compiler ...................... : gcc
    C++ preprocessor ................ : g++ -E
    C++ compiler .................... : g++
    Linker .......................... : /usr/bin/ld -m elf_x86_64
    C preprocessor fl
    
    
 STEP 3:
 =======
 compile pcre to generate unix native files.
 
    [ADMIN pcre]$ make
    
     after given commands 
    make[1]: Entering directory `/apps/apache/aem63/apache/srclib/pcre'
      CC       libpcre_la-pcre_compile.lo
      CC       libpcre_la-pcre_config.lo
      CC       libpcre_la-pcre_dfa_exec.lo
      CC       libpcre_la-pcre_exec.lo

      CC       libpcre_la-pcre_fullinfo.lo
      CC       libpcre_la-pcre_get.lo
      CC       libpcre_la-pcre_globals.lo
      CC       libpcre_l
      make[1]: Entering directory `/apps/apache/aem63/apache/srclib/pcre'
      make[1]: Leaving directory `/apps/apache/aem63/apache/srclib/pcre'
      


STEP 4:
=======
 install native unix pcre files.
 
 
 
   [ADMIN pcre]$ make install
   make[3]: Leaving directory `/apps/apache/aem63/apache/srclib/pcre'
   make[2]: Leaving directory `/apps/apache/aem63/apache/srclib/pcre'
   make[1]: Leaving directory `/apps/apache/aem63/apache/srclib/pcre'

STEP 5:
=======
INSTALL APACHE:

goto apache root directory from above installed pcre dir
 
     [ADMIN pcre]$ cd ..
     [ADMIN srclib]$ cd ..
     [ADMIN apache]$ pwd
      /apps/apache/aem63/apache
     [ADMIN apache]$
     [ADMIN apache]$ 
     
    ./configure --with-included-apr --prefix=/apps/apache/aem63/apache --with-pcre=/apps/apache/aem63/apache/srclib/pcre/bin/pcre-config


    configure: summary of build options:

    Server Version: 2.4.27
    Install prefix: /apps/apache/aem63/apache
    C compiler:     gcc -std=gnu99
    CFLAGS:          -g -O2 -pthread
    LDFLAGS:
    LIBS:
    CPPFLAGS:        -DLINUX -D_REENTRANT -D_GNU_SOURCE
    C preprocessor: gcc -E


STEP 6:
=======
compile apache
internally it uses apr-util to compile.

    [ADMIN apache]$ make
    make[4]: Leaving directory `/apps/apache/aem63/apache/modules/mappers'
    make[3]: Leaving directory `/apps/apache/aem63/apache/modules/mappers'
    make[2]: Leaving directory `/apps/apache/aem63/apache/modules'
    make[2]: Entering directory `/apps/apache/aem63/apache/support'
    make[2]: Leaving directory `/apps/apache/aem63/apache/support'



STEP 7:
======
install apache

make[1]: Leaving directory `/apps/apache/aem63/apache'
  
    [ADMIN apache]$ make install
    /apps/apache/aem63/apache/srclib/apr/libtool --silent --mode=install install mod_reqtimeout.la /apps/apache/aem63/apache/modules/
    /apps/apache/aem63/apache/srclib/apr/libtool --silent --mode=install install mod_ext_filter.la /apps/apache/aem63/apache/modules/
    /apps/apache/aem63/apache/srclib/apr/libtool --silent --mode=install install mod_request.la /apps/apache/aem63/apache/modules/
    /apps/apache/aem63/apache/srclib/apr/libtool --silent --mode=install install mod_include.la /apps/apache/aem63/apache/modules/
    /apps/apache/aem63/apache/srclib/apr/libtool --silent --mode=install install mod_filter.la /apps/apache/aem63/apache/modules/
    /apps/apache/aem63/apache/srclib/apr/libtool --silent --mode=install install mod_substitute.la /apps/apache/aem63/apache/modules/
    /apps/apache/aem63/apache/srclib/apr/libtool --silent --mode=install install mod_sed.la /apps/apache/aem63/apache/modules/
    make[3]: Leaving directory `/apps/apache/aem63/apache/modules/filters'
    make[2]: Leaving directory `/apps/apache/aem63/apache/modules/filters'
    Making install in http
    make[3]: Entering directory `/apps/apache/aem63/apache/modules/filters'
    Building shared: mod_buffer.la mod_ratelimit.la mod_reqtimeout.la mod_ext_filter.la mod_request.la mod_include.la mod_filter.la         mod_substitute.la mod_sed.la
    make[4]: Entering directory `/apps/apache/aem63/apache/modules/filters'

make[4]: Nothing to be done for `local-shared-build'.


STEP 8:
=======

    [ADMIN conf]$ pwd
    /apps/apache/aem63/apache/conf
    [ADMIN conf]$ nano httpd.conf
    if need to change port of dispatcher port
    # change below line.
    Listen 80

STEP 9:
=======
start the apache server.


     [ADMIN bin]$ pwd
     /apps/apache/aem63/apache/bin
     [ADMIN bin]$ ./apachectl -k start

STEP 10:
=======
install dispatcher module. first download to install dispatcher module .dispatcher-apache2.4-linux-x86-64-4.2.2.m.gz  

     [ADMIN aem63]mkdir dispatcher
     [ADMIN dispatcher]$ pwd
     /apps/apache/aem63/dispatcher
     [ADMIN dispatcher]$ ls
     [ADMIN dispatcher]$ no files.

     [ADMIN dispatcher]$ cd ..
     [ADMIN aem63]$ cd dispatcher
     [ADMIN dispatcher]$


     [ADMIN dispatcher]$ ls
     dispatcher-apache2.4-linux-x86-64-4.2.2.tar.gz

     [ADMIN dispatcher]$ pwd
     /apps/apache/aem63/dispatcher

     [ADMIN dispatcher]$ tar -xvf dispatcher-apache2.4-linux-x86-64-4.2.2.tar.gz
        dispatcher-apache2.4-4.2.2.so
        conf/
        conf/httpd.conf.disp2
        conf/author_dispatcher.any
        conf/dispatcher.any
        conf/README.dispatcher.apache2
        README
        CHANGES

     [ADMIN dispatcher]$ ls
     CHANGES  dispatcher-apache2.4-4.2.2.so                   README
     conf     dispatcher-apache2.4-linux-x86-64-4.2.2.tar.gz
     cp /tmp/dispatcher* .
     [ADMIN conf]cp  dispatcher-apache2.4-4.2.2.so   /apps/apache/aem63/apache/modules/mod_dispatcher.so
     [ADMIN]$ cp  dispatcher-apache2.4-4.2.2.so   /apps/apache/aem63/apache/modules/mod_dispatcher.so
     
     
     
     
IMPORTANT:
==========

/apps/apache/aem63/dispatcher/dispatcher-apache2.4-4.1.9.so is copied to /apps/apache/aem63/apache/modules/ without renaming
then need the below line else it already has mod_dispatcher.so if it is renamed.

CHECKED:
=======
LoadModule dispatcher_module modules/dispatcher-apache2.4-4.2.2.so
does not matter if you overwrite by copying downloaded version from apache i.e /apps/apache/aem63/dispatcher/dispatcher-apache2.4-4.1.9.so to  mod_dispatcher.so . ie either rename the file or just add dispatcher (dispatcher-apache2.4-4.2.2.so)
from dispatcher-apache2.4-linux-x86-64-4.2.2 .tar.gz


BOTH ways works fine - either rename dispatcher-apache2.4-4.1.9.so  -mod_dispatcher  or add dispatcher-apache2.4-4.1.9.so  along with mod_dispatcher.so 


 PROCEDURES - both are testing and working fine.
 ===============================================
   
     1)tomcat initial mod_dispatcher.so --> override with downloaded dispatcher-apache2.4-4.1.9.so 
     2)just keep mod_dispatcher.so in  apps/apache/aem63/apache/modules/ and also added to apps/apache/aem63/apache/modules/dispatcher-apache2.4-4.1.9.so
     difference is just  in apps/apache/aem63/apache/conf/http.conf just refere that file like

     if renamed the dispatcher-apache2.4-4.1.9.so to mod_dispatcher.so
     just call 
     LoadModule dispatcher_module modules/mod_dispatcher.so

     if not renmaed and added dispatcher-apache2.4-4.2.2.so just load that instead of mod_dispatcher.so

     LoadModule dispatcher_module modules/dispatcher-apache2.4-4.2.2.so


NOTE:
======
we need mod_dispatcher.so because /apps/apache/aem63/dispatcher/conf/http.conf.disp2 has line 
below LoadModule dispatcher_module  modules/mod_dispatcher.so     
     
     -rwxr-xr-x. 1 admin admin  36432 Jul 27 15:58 mod_dir.so
     -rwxr-x---. 1 admin admin 692153 Jul 27 18:00 mod_dispatcher.so
     -rwxr-xr-x. 1 admin admin 177918 Jul 27 15:58 mod_rewrite.so
     -rwxr-xr-x. 1 admin admin 123232 Jul 27 15:58 mod_sed.so
     -rwxr-xr-x. 1 admin admin  31680 Jul 27 15:58 mod_session_cookie.so
     
     Check the  mod_dispatcher.so has updated date.
     
STEP 11:
=======
Update the conf file
/apps/apache/aem63/dispatcher/dispatcher-apache2.4-4.1.9.so is copied to /apps/apache/aem63/apache/aem/modules/ without renaming
then need the below line else it already has mod_dispatcher.so if it is renamed.



     [ADMIN conf]$ pwd
     /apps/apache/aem63/apache/conf
     [ADMIN conf]$nano httpd.conf
     
     #LoadModule rewrite_module modules/mod_rewrite.so
     LoadModule dispatcher_module modules/dispatcher-apache2.4-4.1.9.so
     <IfModule disp_apache2.c>
        DispatcherConfig conf/author_dispatcher.any
        DispatcherLog    logs/dispatcher.log
        DispatcherLogLevel 3
        DispatcherNoServerHeader 0
        DispatcherDeclineRoot 0
        DispatcherUseProcessedURL 1
        DispatcherPassError 0
     </IfModule>


IMPORTANT:
==========
make sure that we have author_dispatcher.any( if author ) or dispathcer.any ( if publish) in the below path
/apps/apache/aem/conf  and also make sure httpd.conf is also loading the modules from /apps/apache/aem63/dispatcher/ newly
created path.


      [ADMIN conf]$ ls -l
      total 112
      -rw-r-----. 1 admin admin  7418 Jul 27 18:48 author_dispatcher.any
      drwxr-xr-x. 2 admin admin  4096 Jul 27 15:58 extra
      -rw-r--r--. 1 admin admin 18628 Jul 27 18:42 httpd.conf
      -rw-r--r--. 1 admin admin 13077 Jul 27 15:58 magic
      -rw-r--r--. 1 admin admin 60855 Jul 27 15:58 mime.types
      drwxr-xr-x. 3 admin admin  4096 Jul 27 15:58 original
      [ADMIN conf]$

NOTE:
======
note only author_dispatcher.any and httpd.conf is changed




STEP 12:
=========
change the redirect

[ADMIN conf]$ pwd
/apps/apache/aem63/apache/conf

[ADMIN conf]$ nano author_dispatcher.any

 # The load will be balanced among these render instances
    /renders
      {
      /rend01
        {
        # Hostname or IP of the render
        /hostname "10.0.5.23"
        # Port of the render
        /port "4502"
        # Connect timeout in milliseconds, 0 to wait indefinitely
        # /timeout "0"
        }
      }


set the cache directory
========================
    # The cache section regulates what responses will be cached and where.
    /cache
      {
      # The docroot must be equal to the document root of the webserver. The
      # dispatcher will store files relative to this directory and subsequent
      # requests may be "declined" by the dispatcher, allowing the webserver
      # to deliver them just like static files.
      /docroot /apps/apache/aem63/apache/cache"
      
      }

set the cache directory and clear the cache after the first time installation to get latest files and to let cache feature request pages.

STEP 13:
=======
you can start the server and check whether it is up  and running.

[ADMIN bin]$ ps -ef | grep java
weblogic 15619     1  3 Jul11 ?        14:10:01 java -server -Xmx1024m -XX:MaxPermSize=256M -Djava.awt.headless=true -Dsling.run.modes=author,crx3,crx3tar -jar crx-quickstart/app/cq-quickstart-6.3.0-standalone-quickstart.jar start -c crx-quickstart -i launchpad -p 4502 -Dsling.properties=conf/sling.properties
admin 35832 40630  0 19:12 pts/0    00:00:00 grep java


[ADMIN bin]$ ps -ef | grep httpd
admin 35746     1  0 19:12 ?        00:00:00 /apps/apache/aem63/apache/bin/httpd -k start
admin 35747 35746  0 19:12 ?        00:00:00 /apps/apache/aem63/apache/bin/httpd -k start
admin 35748 35746  0 19:12 ?        00:00:00 /apps/apache/aem63/apache/bin/httpd -k start
admin 35750 35746  0 19:12 ?        00:00:00 /apps/apache/aem63/apache/bin/httpd -k start
admin 35851 40630  0 19:12 pts/0    00:00:00 grep httpd
[ADMIN bin]$

NOTE:
=====
check both java and httpd is running as above and 
hit in browser http://10.0.5.23:8850  8850 is listening server in httpd as below and redirect aem server instance is given
in  /apps/apache/aem63/apache/conf/author_dispatcher.any in line /renders  with /host 10.0.5.23  and port 4502 aem port. 

/apps/apache/aem63/apache/conf
    [ADMIN conf]$ nano httpd.conf
    if need to change port of dispatcher port
    # change below line.
    Listen 80
    
DEGBUG steps
=============
if not working debug below ways




   [ADMIN bin]$ pwd
   /apps/aem63/crx-quickstart/bin
   [ADMIN bin]$ nano start

   # TCP port used for stop and status scripts
   if [ -z "$CQ_PORT" ]; then
           CQ_PORT=4502
   fi

   # hostname of the interface that this server should listen to
   #if [ -z "$CQ_HOST" ]; then
   #       CQ_HOST=
   #fi

   # runmode(s)
   # will not be used if repository is already present
   if [ -z "$CQ_RUNMODE" ]; then
           CQ_RUNMODE='author'
   fi


   # default JVM options
   if [ -z "$CQ_JVM_OPTS" ]; then
           CQ_JVM_OPTS='-server -Xmx1024m -XX:MaxPermSize=1024M -Djava.awt.headless=true'
   fi
check the above 3 things port should 4502, runmode to be author for author and  jvm should be 1024 min and max

Stop aem and start aem
========================

   [ADMIN crx-quickstart]cd /apps/aem63/crx-quickstart/bin
   [ADMIN crx-quickstart]pwd
   /apps/aem63/crx-quickstart/bin
   [ADMIN bin]$ ./start
   
   [ADMIN crx-quickstart]cd /apps/aem63/crx-quickstart/bin
   [ADMIN bin]$ ./start
   
   [ADMIN apache]cd /apps/apache/aem63/apache/bin
   [ADMIN bin]$ pwd
   /apps/apache/aem63/apache/bin
   [weblogic@TUS3AEMWEBAUT02 bin]$ ./apachectl -k start
  

Check the flows is correctly done:
====================================

   Navigate to <APACHE_ROOT>/conf.
   Open httpd.conf for editing.
   The following configuration entries must be added, in the order listed:
   1)LoadModule to load the module on start up.
   2) Dispatcher-specific configuration entries, including DispatcherConfig, DispatcherLog and DispatcherLogLevel.
   3)SetHandler to activate the Dispatcher. LoadModule.
      
       
  STEP 1:Dispatcher specific configuration entries
  =================================================
  The Dispatcher-specific configuration entries are placed after the "LoadModule entry"

    <IfModule disp_apache2.c>
       DispatcherConfig conf/author_dispatcher.any
       DispatcherLog    logs/dispatcher.log
       DispatcherLogLevel 3
       #DispatcherNoServerHeader 0  # deprecreated for latest versoin.
       DispatcherDeclineRoot 0
       DispatcherUseProcessedURL 0
       DispatcherPassError 0
       DispatcherKeepAliveTimeout 60
     </IfModule>

STEP 2:set Handler
==================

set Handler - After these entries you must add a SetHandler statement to the context of your configuration (< Directory>, < Location>) for the Dispatcher to handle the incoming requests. 

The following example configures the Dispatcher to handle requests for the complete website:

Windows and Unix
==================

<Directory />
  <IfModule disp_apache2.c>
    SetHandler dispatcher-handler
  </IfModule>

  Options FollowSymLinks
  AllowOverride None
</Directory>

TEST:
=====
if request is hit from dispatcher i.e for e.g if ip is 10.0.5.10:8850 then when dispatcher is hit like  http://http://10.0.5.10:8850/ it should redirect to redirect aem instance http://10.0:8850/aem/start.html otherwise ordinary direct will show  "It works!" since it is
just http apache server . by default it uses 80 port. you can change by change in /apache/conf/http.conf "listen" property.
apache http server  through /apache/conf/http.conf property  Line: "listen 8850 "   maps to aem file  /apache/conf/dispatcher.py
through below line.
    /renders
    { 
      /hostname-10.0.5.10
      /port:4502
     }
   
   


   
   
