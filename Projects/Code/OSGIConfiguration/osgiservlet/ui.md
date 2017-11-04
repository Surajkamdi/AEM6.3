UI in osgi config
==================

below java property redirect values set in the ui localhost:4502/system/console/configMgr


#@Property(label = "Error", description = "error Page.", 
#value = "https://localhost:8080/OWASP/autherror.jsp")
#	public static final String ErrorPAGE = "errorPage";
	

  Redirection Config
  #can override default values set in java i.e https://localhost:8080/OWASP/autherror.jsp
  errorPage  localhost:8080/OWASP/errorRedirect.html

