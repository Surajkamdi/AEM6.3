Installation steps :
======================

http://httpd.apache.org/docs/current/install.html

Prerequisite:
=============

1)download - pcre

2)donwload APR

3)download APR-Util
  
STEPS:
======


    $ gzip -d httpd-2.4.27.tar.gz
    $ tar xvf httpd-2.4.27.tar
    $ cd httpd-NN

    Configure	$ ./configure --prefix=PREFIX
    Compile	$ make
    Install	$ make install
    Customize	$ vi PREFIX/conf/httpd.conf
    Test	$ PREFIX/bin/apachectl -k start

    [weblogic@Admin httpd-2.4.27]$ ./configure --prefix =/apps/apache/aem6
      checking for chosen layout... Apache
      checking for working mkdir -p... yes
      checking for grep that handles long lines and -e... /bin/grep
      checking for egrep... /bin/grep -E
      checking build system type... x86_64-pc-linux-gnu
      checking host system type... x86_64-pc-linux-gnu
      checking target system type... x86_64-pc-linux-gnu
      configure:
      configure: Configuring Apache Portable Runtime library...
      configure:
      checking for APR... no
      configure: error: APR not found.  Please read the documentation.      
      
      
APR & APR UTIL Installation:
============================
install apr,aprutil,pcre inside srclib like apr/all apr related files, apr-util/aprutil related files,pcre/pcre related files
i.e no apr/apr-1.6.2/like that to make sure apr as root give --strip


    [weblogic@Admin aem63]$ cd httpd-2.4.27
    [weblogic@Admin httpd-2.4.27]$ cd srclib/

    [weblogic@Admin srclib]$ mkdir apr
    [weblogic@Admin srclib]$ cd mkdir apr-util
    -bash: cd: mkdir: No such file or directory
    [weblogic@Admin srclib]$ mkdir apr-util
    [weblogic@Admin apr-1.6.2]$ cp -r . ../


    #since it needs only files insider extract apr-1.6.2.tar no apr-1.6.2
    e.g /apps/apache/httpd-2.4.27/srclib/apr/apr-1.6.2
    #strip-components=1 commands ignore root folder apr-1.6.2
    [weblogic@Admin apr]$ tar -xvf apr-1.6.2.tar.gz --strip-components=1  

    [weblogic@Admin apr-1.6.2]$ cp -r . ../

  GCC compile:
  ============

        #since it needs only files insider extract apr-1.6.2.tar no apr-1.6.2 e.g
       /apps/apache/httpd-2.4.27/srclib/apr/apr-1.6.2

        #strip-components=1 commands ignore root folder apr-1.6.2
        [weblogic@Admin apr]$ tar -xvf apr-1.6.2.tar.gz --strip-components=1  

        #install gcc https://ftp.gnu.org/gnu/gcc/ or http://gcc.gnu.org/mirrors.html 
        download binary zip (tar.bz2)
        /apps/gcc/gcc-7.1.0

        #added newly for gcc.
        GCC_PATH='/apps/gcc/gcc-7.1.0'
        export GCC_PATH
        export PATH=$PATH:/apps/gcc/gcc-7.1.0


FINAL INSTALLATION STEP:
=======================
  
     $ ./configure --with-included-apr --prefix=/apps/apache/aem63/apache --with-pcre=/apps/apache/aem63/apache/srclib/pcre/bin/pcre-config



