scripts:
=======
JSP script or servlet to render components

according to requesting processing rules of sling , the default script is  <componentname >.jsp
  
1.global.jsp
============

global.jsp provide quick access to specific objects (i.e to access content) to any jsp script file used to render
component.
  
  
Functions provided by global.jsp ,used API & Taglib:
====================================================
  
  1)<cq: defineObjects>
  ======================
      1) slingRequest- wrapped Request object(SlingHtttpServletRequest)
  
      2)singResponse- wrapped respone object(SlingHttpServletRespone)
  
      3)resource - sing resource Object(slingRequest.getResource())
      
      4)resourceResolver- sling resource resolver object(slingRequest.getResourceResolver())
  
      5)currentNode- resolved JCR node for the request.
       
      6)currentDesign - design of addressed resource.
  
      7)properties - properties of address resource (resource.adapto(ValueMap.class))
                 e.g properties.getTitle()
  
  2)Accessing Content:
  ====================
     1)pageTitle = currentPage.getTitle();
  
  3)Taglibraries:
  ===============
  
    1)
        <%taglib prefix ="cq" url = "http://www.day.com/taglibs/cq/1.0"%>

    when /lib/wcm/global.jsp is included in script , cq taglib is automatically declared.
  
    during cq component development, it is  recommended to include at the top of script
  
        <%include file ="/libs/wcm/global.jsp"%>
  
   2)<cq:setContentBundle>
   =======================
    
       <%include file ="/libs/wcm/global.jsp"%>
       <%page import ="com.day.cq.wcm.foundation.forms.formsHelper%>
       <%cq:setContentBundle/>

     
  
   3)<cq:include>
   ==============
     
        <%taglib prefix ="cq" url = "http://www.day.com/taglibs/cq/1.0"%>
        <cq:include path="trail" resourceType="foundation/components/breadcrumb"/>
        <cq:include path="tile" resourceType="foundation/components/title"/>
        <cq:include script="redirect.jsp"/>
        <cq:include path="par" resourceType="foundation/components/parsys"/>

  
  To include sript
         <%@include file="myscript.jsp"%>- directive informs jsp compiler to include compile file into current file
              or 
         <cq:include script="myscript.jsp" /> files include at runtime
        
    recommendation - to use <cq:include> - it allows you directly include script files by their name when using script
     attribute.This takes component and resource type inheritance into account and is often simpler than strict
  adherence to sling's script resolutions using selector and extension . i.e <sling:include>
  
  
  4)<cq:defineObjects>
  ====================
     used to expose scripting objects used by developer.
  
   1) componentcontext - current component context object of request.
          (com.day.cq.wcm.api.components.ComponentContext Interface).
  
  2)component -CQ5 component object of current instance. 
  
  3)currentpage- cq wcm page object(com.day.cq.wcm.api.Page Interface)
  
  4)currentStyle- current style object of current cell.(com.day.cq.wcm.api.designer.Style interface)
  
  5)designer - designer object used to access Design information(.)
  
  
  6)pageproperties - page properties object of current page ( org.apache.sling.api.resource.ValueMap)
  
  7)properties-   ${properties.jcr:title}
  
  8)logname - inherited form sling.
  
  
  
  5)<cq:requestedURL>
  ===================
  
  tag writes current request URL to jspwriter.
  
  
  
