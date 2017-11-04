Advantages of Bundle:
=====================

Ordinary web Application:
=========================
In ordinary web app, you can just download that java file and then create same folder structure and then do class level override, since
files in class level gets high precedence than in jar , so you can do in ordinary web application.

In AEM bundles:
==================
it is not possible , if you have import by default it adds to manifest (import-package) , if you declare public it adds
to export-packages. so it shows conflict error saying 
it gives below error , when i create a common class named com.adobe.cq.sightly.WCMUse in package same as jar
of aem 6.0 -(org.apache.sling.event-3.1.2.jar) and override class to avoid changing all classes of aem 6.0 code and to 
simply migrate to aem 6.3 without changing all the classes (i.e all classes which extends WCMUse in aem 6.0 code ) 

package com.adobe.cq.sightly;


Core -Test bundle:
==================

/**
*migrate to aem 6.3 without changing all classes which implement WCMUse (aem 6.0 java ) since in aem 6.3 the
*class name is WCMUsePojo
*/

public class WCMUse extends WCMUSEPOJO{

}

ERROR:
======

Even though bundle start without any error but  it is not active i.e bundle wont start shows " ConstraintViolation Error" like below if 
WCMUSE java is created which extends WCMPOJO like above.

	
	07.09.2017 23:15:03.339 *ERROR* [qtp1256474302-3606] org.apache.felix.http.jetty %bundles.pluginTitle: Cannot start 		         (org.osgi.framework.BundleException: Uses constraint violation. Unable to resolve resource com.webapi.core [com.webapi.core           [526](R 526.24)] because it exports package 'com.adobe.cq.sightly' and is also exposed to it from resource      	
	com.adobe.cq.sightly.cq-wcm-sightly-extension [com.adobe.cq.sightly.cq-wcm-sightly-extension [425](R 425.0)] via the following   	 dependency chain:


	07.09.2017 23:14:56.271 *ERROR* [FelixDispatchQueue] org.apache.sling.models.impl FrameworkEvent ERROR			 		(java.lang.NoClassDefFoundError: com/adobe/cq/sightly/WCMUse)
	java.lang.NoClassDefFoundError: com/adobe/cq/sightly/WCMUse


	30.08.2017 11:52:01.353 *ERROR* [qtp626598447-25359] org.apache.felix.http.jetty %bundles.pluginTitle: 
	 Cannot start (org.osgi.framework.BundleException: 
	Uses constraint violation. Unable to resolve resource com.Test.core [com.Test.core [530](R 530.2)] because
	it exports package 'com.adobe.cq.sightly' and is also exposed to it from resource 
	com.adobe.cq.sightly.cq-wcm-sightly-extension [com.adobe.cq.sightly.cq-wcm-sightly-extension [425](R 425.0)] 
	via the following dependency chain:

	  com.Test.core [com.Test.core [530](R 530.2)]
	    import: (&(osgi.wiring.package=com.day.cq.wcm.foundation)(version>=5.21.0)(!(version>=6.0.0)))
	     |
	    export: osgi.wiring.package=com.day.cq.wcm.foundation; uses:=com.adobe.cq.sightly
	  com.day.cq.wcm.cq-wcm-foundation [com.day.cq.wcm.cq-wcm-foundation [416](R 416.0)]
	    import: (&(osgi.wiring.package=com.adobe.cq.sightly)(version>=3.0.0)(!(version>=4.0.0)))
	     |
	    export: osgi.wiring.package: com.adobe.cq.sightly
	  com.adobe.cq.sightly.cq-wcm-sightly-extension [com.adobe.cq.sightly.cq-wcm-sightly-extension [425](R 425.0)]
	  Unresolved requirements: [[com.Test.core [530](R 530.2)] 
	  osgi.wiring.package; (&(osgi.wiring.package=com.day.cq.wcm.foundation)(version>=5.21.0)(!(version>=6.0.0)))])
	org.osgi.framework.BundleException: Uses constraint violation. Unable to resolve resource com.Test.core 
	[com.Test.core [530](R 530.2)] because it exports package 
	'com.adobe.cq.sightly' and is also exposed to it from resource com.adobe.cq.sightly.cq-wcm-sightly-extension 
	[com.adobe.cq.sightly.cq-wcm-sightly-extension
	 [425](R 425.0)] via the following dependency chain:

	  com.Test.core [com.Test.core [530](R 530.2)]
	    import: (&(osgi.wiring.package=com.day.cq.wcm.foundation)(version>=5.21.0)(!(version>=6.0.0)))
	     |
	    export: osgi.wiring.package=com.day.cq.wcm.foundation; uses:=com.adobe.cq.sightly
	  com.day.cq.wcm.cq-wcm-foundation [com.day.cq.wcm.cq-wcm-foundation [416](R 416.0)]
	    import: (&(osgi.wiring.package=com.adobe.cq.sightly)(version>=3.0.0)(!(version>=4.0.0)))
	     |
	    export: osgi.wiring.package: com.adobe.cq.sightly
	  com.adobe.cq.sightly.cq-wcm-sightly-extension [com.adobe.cq.sightly.cq-wcm-sightly-extension [425](R 425.0)] 
	  Unresolved requirements: [[com.Test.core [530](R 530.2)]
	  osgi.wiring.package; (&(osgi.wiring.package=com.day.cq.wcm.foundation)(version>=5.21.0)(!(version>=6.0.0)))]
		at org.apache.felix.framework.Felix.resolveBundleRevision(Felix.java:4112)
		at org.apache.felix.framework.Felix.startBundle(Felix.java:2118)
		at org.apache.felix.framework.BundleImpl.start(BundleImpl.java:998)
		at org.apache.felix.framework.BundleImpl.start(BundleImpl.java:984)
		 
