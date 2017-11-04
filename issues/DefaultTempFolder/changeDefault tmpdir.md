
TO CHANGE default /tmp dir
===========================

go to /apps/crx-quickstart/bin/start.sh


CQ_JVM_OPTS="-server -Xmx4096m -XX:MaxPermSize=1024M -Djava.awt.headless=true -Djava.io.tmpdir=/mnt/tmp"
