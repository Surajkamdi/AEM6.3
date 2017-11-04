if clientlibs is not loading.

issue:
======
webpage is showing up fine but menu is not loading ,because it uses jquery and other js to load menu. 

Solution:
==========
Added a entry for modrewriteRule in dispatcher httpd.conf file.

Check the Rewrite Rule:
=======================

/apps/apache/aem/conf/httpd.conf

to make it work added etc.clientlibs in the RewriteRule place.

RewriteRule ^/(apps|bin|content/dam|etc|etc.clientlibs|libs|services|sy$
        
        
