We need Apache to cache the request and get from server:
========================================================

download apache.tar for linux.


sudo su - weblogic 
cd /apps/apache/aem/bin


ps -ef| grep httpd 
./apachectl -k stop 

./apachectl -k start

mkdir /apps/apache/aem63/aem
cd /apps/apache/aem63/

cp /tmp/apache.tar  /apps/apache/aem63/


tar -xvf apa* 

rm -rf apache.tar

cd /apps/apache/aem63/apache/aem/bin
