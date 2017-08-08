For Migration AEM 6.0 to AEM 6.3 or anyother version , dam content of 1Tb size use VLT(Vault) for
speeder transfer  because replication occurs through queue and if size of content is in tb queue will overflow and
stop aem.

For Better result use 

  >vlt rcp -b 1500 -r -u -n http://arun:arun123!@10.0.5.22:4502/crx/-/jcr:root/content/dam/Test http://admin:admin@10.0.21.30:4503/crx/-/jcr:root/content/dam/Test


1)VLT Remoting:
==============


follow below steps:

if uploading large files using VLT 
it shows "Commons Upload multipart file - No memory left on disk".


Solution:
=========
go to > aem6.3/crx-quickstart/bin/start.bat
change the line so that it wont point to /tmp dir in linux which has low
virutal space.

if change to large directory space like map drive which has high memory. 
so copying time this memory issue wont come.

You can change your startup parameters and move the location of your tmp location. 
Set this jvm parameter in your CQ start script in the CQ_JVM_OPTS variable
(change /path/to/new/temp to your desired temp directory location):-Djava.io.tmpdir=/path/to/new/temp


CODE:
=====
Actual code:
===========

crx-quickstart/bin/start.sh

# default JVM options
if [ -z "$CQ_JVM_OPTS" ]; then
	CQ_JVM_OPTS='-server -Xmx1024m -XX:MaxPermSize=256M -Djava.awt.headless=true' 
fi

CHANGE TO
=========
added new io.tmp.dir to avoid "no space on disk" 
IMPORTANT:
=========

"No space on disk"  even if you large space in system but if /tmp is full this error 
occurs. Because /aem/crx-quickstart/bin/start.sh uses /tmp has temporary dir.
Need to change to some other dir using below additonal -D switch.

# default JVM options
if [ -z "$CQ_JVM_OPTS" ]; then
	CQ_JVM_OPTS='-server -Xmx1024m -XX:MaxPermSize=256M -Djava.awt.headless=true -Djava.io.tmpdir=/mnt/logs'  
fi
