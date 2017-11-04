
To create widget
=================


in /libs/foundation/components/page/tab_advanced/items/advanced/items create node > cq:widget named errorpages


add propeties:
===============

path :cqinclude
path: /apps/acs-commons/components/utilities/errorpagehandler/dialog/errorpages.infinity.json

label: errorpage 

<errorpages
    jcr:primaryType="cq:Widget"
    path="/apps/acs-commons/components/utilities/errorpagehandler/dialog/errorpages.infinity.json"
    xtype="cqinclude"/>
    
    
Once created go to siteadmin
============================
http://10.44.54.15:4502/siteadmin#/content/Test (APP)

right click properties errorpages  advanced tab > errorpages should show.

label: errorpage  used  in properties added at /libs/foundation/components/page/tab_advanced/items/advanced/items/errorpages will shown
in the widget page of siteadmin
