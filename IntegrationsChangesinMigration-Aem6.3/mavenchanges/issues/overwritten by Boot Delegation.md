

Overwritten by Boot Delegation:
=================================

AEM 6.0
========

	com.adobe.cq.commerce.api,version=1.2.0 from com.adobe.cq.commerce.cq-commerce-core (408)
	com.adobe.cq.commerce.api.promotion,version=1.2.0 from com.adobe.cq.commerce.cq-commerce-core (408)
	com.adobe.cq.commerce.common,version=1.2.0 from com.adobe.cq.commerce.cq-commerce-core (408)
	javax.activation,version=1.1.1 from org.apache.sling.javax.activation (6)
	javax.crypto,version=0.0.0.1_007_JavaSE from org.apache.felix.framework (0)
	javax.crypto.spec,version=0.0.0.1_007_JavaSE from org.apache.felix.framework (0)
	javax.imageio,version=0.0.0.1_007_JavaSE from org.apache.felix.framework (0)
	javax.imageio.spi,version=0.0.0.1_007_JavaSE from org.apache.felix.framework (0)
	javax.imageio.stream,version=0.0.0.1_007_JavaSE from org.apache.felix.framework (0)
	javax.net.ssl,version=0.0.0.1_007_JavaSE from org.apache.felix.framework (0)
	javax.servlet,version=2.6.0 from org.apache.felix.http.servlet-api (29)
	javax.servlet,version=3.0.0 from org.apache.felix.http.servlet-api (29)
	javax.servlet.http,version=2.6.0 from org.apache.felix.http.servlet-api (29)
	javax.servlet.http,version=3.0.0 from org.apache.felix.http.servlet-api (29)


AEM 6.3
========

 	javax.accessibility,version=0.0.0.1_008_JavaSE
	javax.activity,version=0.0.0.1_008_JavaSE
	javax.annotation,version=0.0.0.1_008_JavaSE
	javax.annotation.processing,version=0.0.0.1_008_JavaSE
	javax.crypto,version=0.0.0.1_008_JavaSE
	javax.crypto.interfaces,version=0.0.0.1_008_JavaSE
	javax.crypto.spec,version=0.0.0.1_008_JavaSE
	javax.imageio,version=0.0.0.1_008_JavaSE


see javax.crypto,version is taken from JAVA 1.7 SDK in AEM 6.0 but in AEM 6.3 it is taken from  JDK 1.8 so boot delegation is
basically core java jdk which causes boot delegation problems.so difference in export package which is exposed causing
problems.
 
