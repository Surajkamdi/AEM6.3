if clientlibs is not loading.

Check the Rewrite Rule:
========================

Latest  AEM 6.3 interpretates clientlibs as etc.clientlibs 

for e.g http://localhost:4503/etc.clientlibs/clientlibs/granite/jquery.js

in dispatcher you need add rewrite entry to make it work.

http://localhost:8850/etc.clientlibs/clientlibs/granite/jquery.js

/apps/apache/aem/conf/httpd.conf

to make it work added etc.clientlibs in the RewriteRule place.

RewriteRule ^/(apps|bin|content/dam|etc|etc.clientlibs|libs|services|sy$
