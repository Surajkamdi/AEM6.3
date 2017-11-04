

To Dispaly multi value textbox showing (+ / - sign):
====================================================

	@Component(immediate = true, label = "TEST Component", description = "Mapper service", metatype = true)
	@Service(value = TESTService.class)
	public class TESTService {

	 @Property(unbounded = PropertyUnbounded.ARRAY, cardinality = 10, label = "Currency")
	 private static final String CURRENCY_MULTI_PROPERTY = "config.currency";

	 @Property(unbounded = PropertyUnbounded.ARRAY, cardinality = 10, label = "Country")
	 private static final String COUNTRY_MULTI_PROPERTY = "config.country";

	 private Map<String, String> countryMapping = new HashMap<String, String>();

	 private Map<String, String> localeMapping = new HashMap<String, String>();

	 @Activate
	 protected void activate(ComponentContext context) {
		connect(context);
	 }



	  private void connect(ComponentContext context) {
	    try {

		this.countryMapping.put("Australia", "AU");
		this.countryMapping.put("Austria", "AT");
		this.countryMapping.put("Belgium", "BE");
		this.countryMapping.put("Brazil", "BR");
		this.countryMapping.put("Canada", "CA");
		this.countryMapping.put("Denmark", "DK");
		this.countryMapping.put("Finland", "FI");
		this.countryMapping.put("France", "FR");
		this.countryMapping.put("India", "IN");
		this.countryMapping.put("Malaysia", "MY");
		this.countryMapping.put("Mexico", "MX");
		this.countryMapping.put("Netherlands", "NL");
		this.countryMapping.put("Norway", "NO");
		this.countryMapping.put("Singapore", "SG");
		this.countryMapping.put("Sweden", "SE");
		this.countryMapping.put("UnitedStates", "US");


		this.currencyMapping.put("Australia", "au");
		this.currencyMapping.put("Austria", "at");
		this.currencyMapping.put("Belgium", "be");
		this.currencyMapping.put("Brazil", "bz");
		this.currencyMapping.put("Canada", "ca");
		this.currencyMapping.put("Denmark", "en");



	      }







	  }
