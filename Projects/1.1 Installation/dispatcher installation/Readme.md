
sudo su - weblogic 

cd /apps/apache 

ps -ef| grep httpd 

./apachectl -k stop 

mkdir /apps/apache/aem63 


tar -xvf apa* 


./apachectl -k start 

ps -ef| grep httpd 


