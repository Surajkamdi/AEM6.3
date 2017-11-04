
@Component(name = "com.OWASPServlet", label = "Security Filter Servlet", description = "OWASP Filter Servlet", 
metatype = true, immediate = true)
@Service //it makes it available as service to all other bundles or other component.
@Properties({

		@Property(name = "sling.servlet.paths", value = "/bin/OWASPRedirect/"),
		@Property(name = "sling.servlet.methods", value = "GET,POST") })
public class OWASPAuthServlet extends SlingAllMethodsServlet {


//can call core java bundles installed in AEM through @Reference like spring injection
@Reference
	OWASPRedirectionConfig OWASPRedirectConfig;
  
  
  
  @Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
		Session session = request.getResourceResolver().adaptTo(Session.class);
    Map<String,String> map = 	request.getParameterMap();
    	Set<String> keys = map.keySet();
    	
    	Iterator it  = keys.iterator();
    	
    	while(it.hasNext()){
    	 String value = (String)	it.next();
    	  String parmValue = map.get(value);
    	  if(parmValue.contains("<script>")){
    		      String redirectToUrl = OWASPRedirectConfig
							.getPropertyValue("errorPage");
              
              response.sendRedirect(redirectToUrl);
    	  }
        
    
    }
  
  
}
