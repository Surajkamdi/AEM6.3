To debug once installed bundle
================================

go inside bundles eventhough active check

1)services - all are active 


Service #9,363 of type(s) [com.webapi.core.config.FeedConfigService]
=====================================================================
    

      @Component(policy = ConfigurationPolicy.REQUIRE, immediate = true, label = "webapi Feed Configuration",
      description = "Feed webapi config", metatype = true)
      @Properties({
              @Property(name = Constants.SERVICE_DESCRIPTION, value = "Feed"),
              @Property(name = Constants.SERVICE_VENDOR, value = "webapi") })
      @Service(value = SSOConfigService.class)
      public class FeedConfigService {

      }


2)Declarative service Components  - check all are active if unsatisfied then might be issue.

 Component #3186 com.webapi.core.impl.servlets.DisplayServlet, state active
Component #3188 com.webapi.core.impl.servlets.AuthServlet, state active


Component #3189 com.webapi.core.services.FeedService, state active
===================================================================
  
      @SlingServlet(paths = { "/bin/webapi/FeedService" },
                methods={"GET"},
                metatype=true)
        public class FeedService extends SlingAllMethodsServlet {


          }

