6.3 does not WCM USE

AEM 6.0
=========

    <dependency>
      <groupId>com.adobe.aem</groupId>
      <artifactId>aem-api</artifactId>
    </dependency>

aem-api.jar
============
    public abstract class WCMUse
      implements Use
    {
      private Bindings bindings;
    }


AEM 6.3
========

    <dependency>
            <groupId>com.adobe.aem</groupId>
            <artifactId>uber-jar</artifactId>
            <version>6.3.0</version>
            <scope>provided</scope>
        </dependency>  

uber-6.3.0.jar
==============

    @ConsumerType
    public abstract class WCMUsePojo
      implements Use
    {
      private Bindings bindings;
      private SightlyWCMMode wcmMode;
      private PageManager pageManager;
      private Page currentPage;
      private Page resourcePage;
      private ValueMap pageProperties;
      private ValueMap properties;
      private Designer designer;
      private Design currentDesign;
      private Style currentStyle;
      private Component component;
      private ValueMap inheritedPageProperties;
      private Resource resource;
      private ResourceResolver resourceResolver;
      private SlingHttpServletRequest slingHttpServletRequest;
      private SlingHttpServletResponse slingHttpServletResponse;
      private SlingScriptHelper slingScriptHelper;
      private ComponentContext componentContext;
      private EditContext editContext;
      private Design resourceDesign;
      private XSSAPI xssapi;

    }
    
    
 
