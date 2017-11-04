To provide configuration propeties as service:
==============================================

    http://localhost:4502/system/console/configMgr

Dynamically get the values from the user specified locale and currency.


    @Component(immediate = true, label = "TEST Component", description = "TEST service", metatype = true)
    @Service(value = TESTService.class){


    public String country;

      public String locale;


      //default values.
      @Property(label = "COUNTRY", value = "US", description = "Country of the user")
      public static final String COUNTRY = "COUNTRY";

      @Property(label = "LOCALE", value = "en", description = "locale of the user")
      public static final String LOCALE = "LOCALE";


      @Activate
      protected void activate(Map<String, Object> properties) {
        connect(properties);
      }

      private void connect(Map<String, Object> properties) {
        this.country = (String) properties.get(COUNTRY);
        this.locale = (String) properties.get(LOCALE);
      }



     * @return the country
       */
      public String getCountry() {
        return country;
      }


      /**
       * @param country the country to set
       */
      public void setCountry(String country) {
        this.country = country;
      }

      /**
       * @return the locale
       */
      public String getCurrency() {
        return currency;
      }

      /**
       * @param locale  to set
       */
      public void setLocale(String locale) {
        this.locale = locale;
      }


    }





Config in AEM:
===============

go to http://localhost:4502/system/console/bundles

    Mapper service
    COUNTRY	
    US

    Country of the user (COUNTRY)
    LOCALE	
    EN

    currency of the user (CURRENCY)
    Configuration Information
    Persistent Identity (PID)	com.test.TESTService
    Configuration Binding	
    Unbound or new configuration 



