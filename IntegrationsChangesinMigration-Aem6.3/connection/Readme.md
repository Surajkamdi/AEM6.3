Connection details:
====================
all connection information like connection to salesforce can be wrapped as osgi config.


	@Component(immediate = true, label = "SALESFORCE Connection",
	description = "SalesForce connectio Details", metatype = true)
	@Service(value = SalesForceService.class)
	public class SalesForceService {


	@Property(label = "USERNAME", value = "arunsadhasivam@test.com", description = "Please Provide Valid UserName")
		public static final String USERNAME = "USERNAME";

		@Property(label = "PASSWORD", value = "welcome123", description = "Please Provide Valid PassWord")
		public static final String PASSWORD = "PASSWORD";

		@Property(label = "AUTHENDPOINT", value = "https://test.salesforce.com/services/Soap/u/39.0", 
		description = "Please Provide Valid AuthEndPoint")
		public static final String AUTHENDPOINT = "AUTHENDPOINT";

		@Property(label = "REDIRECT", value = "https://localhost:4502/login/landing_page", 
		description = "Please Provide Valid Redirect URL")
		public static final String REDIRECT = "REDIRECT";


	  }
  
  config in osgi :
  =================
  
  localhost:4502/system/console/configMgr
  
	  USERNAME	
	arunsadhasivam@test.com

	Please Provide Valid UserName (USERNAME)
	PASSWORD	
	••••••••••

	Please Provide Valid PassWord (PASSWORD)
	AUTHENDPOINT	
	https://test.salesforce.com/services/Soap/u/39.0

	Please Provide Valid AuthEndPoint (AUTHENDPOINT)
	REDIRECT	
	https://https://localhost:4502/login/landing_page

	Please  Redirect URL (REDIRECT)
	Configuration Information
	Persistent Identity (PID)	com.test.SalesForceService
