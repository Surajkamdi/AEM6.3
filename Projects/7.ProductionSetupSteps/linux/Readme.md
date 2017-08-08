TO count no of files in dir:
============================
In AEM the content is based on segmentstore dir and size of segment store .
to compare whether all contents are copied from source to destination can use no.of folders inside
/apps/aem/crx-quickstart/repository/segmentstore and size if in case partially copied to confirm whether all are copied successfully.

    
    admin>ls -l | wc -l
     
    output: 2366

To calculate the folder size:
=============================

$ du -sh segmentstore

output:413G    

copy only missing files:
=========================

copy only missed repository files from localhost to remote mounted system /system1/arun/crx-quickstart/repository

    cp -r -v -u  crx-quickstart/repository /system1/arun/crx-quickstart
