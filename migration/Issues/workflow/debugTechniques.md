STEP 1:
========

goto http://localhost:4502/system/console/bundles/311/

in the bundles there is a service section:


    Declarative Service Components	
    Component # com.web.core.impl.servlets.getMetadata, state disabled
    Component #7377 Translation Service Request Scheduler Job, state active
    Component #7368 Translation Service Response Scheduler Job, state active
    Component #7366 com.web.service.GetTranslatedContent, state active
    Component #7369 com.web.service.TranslationContentService, state active
    Component #7372 com.web.translation.service.TranslationRequestService, state active
    Component #7370 com.web.translation.util.GMSTranslatePropertyConfig, state active
    Component #7374 com.web.foundation.core.config.EmailSender, state active
    Component #7376 com.web.core.config.GMSTranslationConfig, state active
    Component #7367 com.veritas.cq.foundation.foundation.core.impl.servlets.CancelRequest, state active
    Component #7375 com.webapi.core.workflow.TranslationWorkflow, state satisfied
    Component #7373 com.webapi.core.workflow.GmsTranslationWorkflow, state satisfied

NOTE:
=====
those which are disabled click on the component check it.

click on the  component named above Component # com.web.core.impl.servlets.getMetadata, state disabled

goto http://localhost:4502/system/console/components

further click the components - getMetadata takes to below

http://localhost:4502/system/console/components/7383

getMetadata:
============
                  7383	 com.web.core.impl.servlets.getMetadata
                  Bundle	com.web.foundation.core (531)
                  Implementation Class	com.web.core.impl.servlets.getMetadata
                  Default State	enabled
                  Activation	delayed
                  Configuration Policy	optional
                  Service Type	singleton
                  Services	javax.servlet.Servlet
                  PID	com.webn.core.impl.servlets.getMetadata
                  Reference resolverFactory	Satisfied
                  Service Name: org.apache.sling.api.resource.ResourceResolverFactory
                  Cardinality: 1..1
                  Policy: static
                  Policy Option: reluctant
                  Bound Service ID 2418 (Apache Sling Resource Resolver Factory)
                  Reference workflowService	Satisfied
                  Service Name: com.day.cq.workflow.WorkflowService
                  Cardinality: 1..1
                  Policy: static
                  Policy Option: reluctant
                  Bound Service ID 35197 (com.day.cq.workflow.impl.CQWorkflowService)
                  Reference builder	Satisfied
                  Service Name: com.day.cq.search.QueryBuilder
                  Cardinality: 1..1
                  Policy: static
                  Policy Option: reluctant
                  Bound Service ID 3542 (com.day.cq.search.impl.builder.QueryBuilderImpl)
                  Reference resourceProvider	Satisfied
                  Service Name: org.apache.sling.api.resource.ResourceProvider
                  Cardinality: 1..1
                  Policy: static
                  Policy Option: reluctant
                  Bound Service ID 3497 (com.adobe.cq.dam.s7imaging.impl.ps.IsImageResourceProvider)
                  Reference messageGatewayService	Satisfied
                  Service Name: com.day.cq.mailer.MessageGatewayService
                  Cardinality: 1..1
                  Policy: static
                  Policy Option: reluctant
                  Bound Service ID 3148 (com.day.cq.mailer.impl.CqMailingService)
                  Properties	component.id = 7383

 
 Java:
 =====
 
 
    @SuppressWarnings("serial")
    @SlingServlet(paths = "/bin/getMetadata", methods = "GET", metatype = true)
    public class getMetadata extends SlingAllMethodsServlet {

      private static final Logger logger = LoggerFactory.getLogger(getMetadata.class);	 

      @Reference
      private ResourceResolverFactory resolverFactory;

        @Reference
      private WorkflowService workflowService;

        @Reference
      private QueryBuilder builder;

        @Reference
        ResourceProvider resourceProvider;

        @Reference 
        MessageGatewayService messageGatewayService;
      }
      
SOLUTION:
==========

Check all the referencing components,service is Active not disabled or satisfied then it works!!!!
