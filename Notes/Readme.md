
Hierarchy
=========


      /apps
          - webapi
             -components
                 -page
                   
                 -content


          -system
            -config
            -config.qa
      /etc
           -designs
              -
              
           -clentlibs
           
           -clientcontent
                -webapi
                    -jcr:content
                        -contextstores(sling:folder)
                             -empData
                                -loader(node) -resourceType:cq/personalization/components/profileloader/command/load
                              
                              
                      
  
 /libs/cq/personalization/components/profileloader/command/load
 ==============================================================
   -load.init.jsp
   -load.init.json
   
   
       JSONWriter w = new JSONWriter(response.getWriter());
          w.object();
         
            userProperties = upm.getUserProperties(authorizableId, "profile");
           w.key("avatar").value(avatar);
            w.key("authorizableId").value(userProperties.getAuthorizableID());
            w.key("path").value(userProperties.getNode().getPath());
            w.key("formattedName").value(userProperties.getDisplayName());
           w.endObject();
           
           
   /apps/webapi/components/content/accordion
   ===========================================
   
            all content will be parsed by design.

            /etc/designs/default/jcr:content/empDetail/sIparsys

            /etc/designs/default/jcr:content/productDetail/headerIparsys

            sling:resourceType:wcm/foundation/components/iparsys

            jcr:primaryType:nt:unstructured
            components:
         /apps/webapi/components/content/accordion
         /apps/webapi/components/content/alertbanner
         /apps/webapi/components/content/licensingcta
         /apps/webapi/components/content/productcta
         /apps/webapi/components/content/button
         /apps/webapi/components/content/livechat_button
         /apps/webapi/components/content/livechat_Moxie
         
   
   
   /apps/webpai/components/page/webapi-home
   =========================================
   
   refered by content.
   
            jcr:primaryType:
   
   /apps/webapi/templates
   ========================
   
             allowedPaths :/content(/.*)?
             
  /etc/designs/webapi/clientlib
  ==============================
  
           jcr:primaryType :cq:ClientLibraryFolder
           css
           js
           css.txt
           js.txt
     
   
   /content/webapi/en/home
   =======================
   
    it refers page component
         jcr:primaryType : cq:page

         sling:resourceType:/apps/webpai/components/page/webapi-home
         
                /content/webapi/en/home/jr:content
                ===================================

                 jcr:primaryType : cq:pageContent
                  cq:template:
                   cq:tags:

   
         /apps/webpai/components/page             :cq:Component
        /apps/webapi/components/content/accordion  :cq:Component
        /apps/webapi/template                       :cq:template.
       /content/webapi/english/en/home               : cq:page
      /content/symantec/english/en/home/jcr:content  :cq:pageContent.   

