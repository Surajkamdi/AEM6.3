
To install dispatcher:
=======================
      dispatcher-apache2.4-linux-x86-64-4.2.2.tar.gz
      cd /apps/apache/aem63
      mkdir dispatcher
      cd dispatcher
      cp /tmp/dispatcher* .
      ls
      /* You will see dispatcher-apache2.4-linux-x86-64-4.2.2.tar.gz */


      tar -xvzf * 
      ls /apps/apache/aem63/apache/aem/modules
      /*You will see a lot of .so files. Also you will see a mod_ dispatcher.so in that directory. 
      In the next step, we will replace it with a new one*/
      cp  dispatcher-apache2.4-4.2.2.so   /apps/apache/aem63/apache/aem/modules/mod_dispatcher.so
      cd /apps/apache/aem63/apache/aem/conf
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

      On author instances, change the publish_dipatcher.any to author_dispatcher.any
      On publish instances, leave this line as is. */

      cd /apps/apache/aem63/dispatcher/conf


      cp author_dispatcher.any /apps/apache/aem63/apache/aem/conf

      cd   /apps/apache/aem63/apache/aem/conf
      /* Edit author_dispatcher.any and change /hostname to correct author or publish hostname
      */
      ps -ef | grep httpd  /* You will see a few httpd processes */
      cd /apps/apache/aem/bin
      ps -ef | grep httpd /* There should be no httpd processes */

      cd /apps/apache/aem63/apache/aem/bin
      ./apachectl start










