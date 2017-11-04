@Component(immediate = true, label = "OWASP ERROR Redirection Config", metatype = true)
@Properties({
		@Property(name = Constants.ERROR, value = "OWASP ERROR"),
		@Property(name = Constants.SERVICE_VENDOR, value = "OWASP") })
@Service(value = OWASPRedirectConfig.class)
public class OWASPRedirectConfig {

@Property(label = "Error", description = "Communities Questionnaire Page URL.", 
value = "https://localhost:8080/OWASP/autherror.jsp")
	public static final String ErrorPAGE = "errorPage";
	

 
 
 protected void activate(ComponentContext context) {
		try {
			 
			props = context.getProperties();
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	protected void update(ComponentContext context) {
		props = context.getProperties();
	}
	
}
