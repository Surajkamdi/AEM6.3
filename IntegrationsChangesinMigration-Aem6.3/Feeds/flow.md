
when request is http://localhost:4502/content/webapi/feed/rssFeed.html



STEP 1:
=======

/content/webapi/feed/rssFeed/.content.xml

it refers first checks above .content.xml . it looks  cq:template="/apps/webapi/templates/rssfeed" and
 sling:resourceType="webapi/components/page/rssDetails" attributes.
 
 and customstackingcolumn_2 is the nodes which is created inside /content/webapi/feed/rssFeed/jcr:content
 node will be formed like  /content/webapi/feed/rssFeed/jcr:content/bodyparsys/customstackingcolumn_1


template is the page which refer the component. it refers based on allowpaths  of /apps/webapi/templates/rssfeed/.content.xml
e.g it has allowedpaths as     allowedPaths="[/content(/.*)?]" . it refers all components under /content/




hierarchy
=========

    apps--> webapi
              |
              components
                       |
                       content
                       | 
                        page
    apps -->templates

 

 APPS
 ======
   
   apps-->webapi-->components
   
   apps-->webapi-->components-->content
   
   apps-->webapi-->components-->page

   apps-->webapi-->templates

content
========

   content-->webapi



   
      

PAGE component:
===============

apps/webapi/components/page/rssdetails - contains the html, clientlib js, and then any servlet to help munge content like BlobServlet to 
inject image in page as binary.

apps/webapi/components/page/page - extension of root wcm page.

content component:
==================

apps/webapi/components/content - contains mapping to java component i.e bind to java components.
e.g below apps/webapi/components/content/feed/cardLayout.html contains sling : reference

<div data-sly-use.feeditems="com.core.webapi.Feed" data-sly-unwrap>

Feeds/content/webapi/feed/rssFeed/.content.xml
===============================================

    
    <jcr:content
         cq:tags="[taxonomy:rssfeeds/video,taxonomy:resource/feeds,
         analytics:site-section/rssfeeds,
         analytics:rssfeeds/feed1]"
         cq:template="/apps/webapi/templates/rssfeed"
         jcr:description="Rss Feeds sample"

         jcr:mixinTypes="[mix:versionable]"
         jcr:primaryType="cq:PageContent"
         jcr:title="Encryption"

         sling:resourceType="webapi/components/page/rssDetails"
         buyOverrideStyles="button-drop"
         overvviewcardImage="/content/dam/web api/images/rss-feeds-sample.png"
         pageTitle="Rss Feeds."

         tryOverrideStyles="button try">   
