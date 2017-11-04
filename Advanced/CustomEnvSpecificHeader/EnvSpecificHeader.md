To enable custom header
========================

To show the environment like QA, prod, or company which done the site .


/apps/system/config/com.adobe.acs.commons.wcm.impl.AemEnvironmentIndicatorFilter.config

code available in 
==================

https://github.com/Adobe-Consulting-Services/acs-aem-commons/blob/master/bundle/src/main/java/com/adobe/acs/commons/wcm/impl/AemEnvironmentIndicatorFilter.java


E.g:
====


      browser-title-prefix="QA"
      excluded-wcm-modes=["qa"]
      css-color="orange"
      css-override=.body{back-groundcolor:red}"
      inner-html="QA Environment\ \r\n
      <script>
        \r\ndocument.getElementById('div').innerHtml='<marquee direction=up>This text will </marquee>'
      </script>"
      "

