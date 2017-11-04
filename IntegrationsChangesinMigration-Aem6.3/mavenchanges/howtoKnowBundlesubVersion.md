How to know bundle version of AEM 6.0 refering jar equivalent in AEM 6.3
=============================================================================

web-api.jar  depends on commerce.api it shows 1.2,2 cannot be resolved. 

when i install the aem web-api.jar which is available in aem 6.0 directly to aem 6.3
It shows below error when deploy in AEM 6.3 server

    Imported Packages	com.adobe.cq.commerce.api,version=[1.2,2) -- Cannot be resolved
    com.adobe.cq.commerce.api.promotion,version=[1.2,2) -- Cannot be resolved
    com.adobe.cq.commerce.common,version=[1.2,2) -- Cannot be resolved


since import packages reference is not shown since 1.2,2 not exists in AEM 6.3 it exists only in AEM 6.0.
Only way to find the bundle is below:


To debug go to AEM 6.0 server > check whether other bundle it refers in this case
it refers 408 bundle  which is ( Adobe Communique 5 Commerce Core). 

get the refering bundle version detail from AEM 6.3 by searching "Adode Commique 5 commerce Core" in AEM 6.3 localhost:4502/system/console/bundles.

Imported Packages	com.adobe.cq.commerce.api,version=1.2.0 from com.adobe.cq.commerce.cq-commerce-core (408)


STEP 1:
========

Detail steps to get the bundle version from ui(localhost:4502/system/console/bundles)
and full version version + subversion from actual jar inside crx-quickstart\launchpad\felix\#bundleid#.

To check the bundle version to change :
=======================================

AEM 6.0 :localhost:4502/system/console/bundles:
=================================================

    Imported Packages	com.adobe.cq.commerce.api,version=1.2.0 from com.adobe.cq.commerce.cq-commerce-core (408)
    com.adobe.cq.commerce.api.promotion,version=1.2.0 from com.adobe.cq.commerce.cq-commerce-core (408)
    com.adobe.cq.commerce.common,version=1.2.0 from com.adobe.cq.commerce.cq-commerce-core (408)

check the 408 AEM 6.0 bundle get the bundle name.

       Id	Name
      ============================================================================
      408	| Adobe Communique 5 Commerce Corecom.adobe.cq.commerce.cq-commerce-core
      Symbolic Name	com.adobe.cq.commerce.cq-commerce-core
      ============================================================================
      

bundle 408:
============
    Exported Packages	com.adobe.cq.commerce.api,version=4.0.0
    com.adobe.cq.commerce.api.asset,version=1.0.0
    com.adobe.cq.commerce.api.classification,version=1.0.0
    com.adobe.cq.commerce.api.collection,version=1.1.0
    com.adobe.cq.commerce.api.promotion,version=1.2.1
    com.adobe.cq.commerce.api.smartlist,version=2.0.0
    com.adobe.cq.commerce.common,version=3.7.0
    com.adobe.cq.commerce.common.promotion,version=1.2.0





STEP 2:
=======

go to AEM 6.3 search the bundle Name Adobe Communique 5 Commerce Core and get the bundle version.

bundle 271:
============
    Exported Packages	com.adobe.cq.commerce.api,version=4.0.0
    com.adobe.cq.commerce.api.asset,version=1.0.0
    com.adobe.cq.commerce.api.classification,version=1.0.0
    com.adobe.cq.commerce.api.collection,version=1.1.0
    com.adobe.cq.commerce.api.promotion,version=1.2.1
    com.adobe.cq.commerce.api.smartlist,version=2.0.0
    com.adobe.cq.commerce.common,version=3.7.0
    com.adobe.cq.commerce.common.promotion,version=1.2.0
    

STEP 3:
=======
Above bundle version is not full version, subversion is missing to get actual subversion go to the 
go to AEM 6.3 server and \crx-quickstart\launchpad\felix\bundle271\version0.0
 
 
AEM 6.0
=======

    com.adobe.cq.commerce.api;version="[1.2,2)",
    com.adobe.cq.commerce.api.promotion;version="[1.2,2)",
    com.adobe.cq.commerce.common;version="[1.2,2)"

AEM 6.3
========
    com.adobe.cq.commerce.api;version="[4.0,4.1)",
    com.adobe.cq.commerce.api.asset;version="[1.0,1.1)",
    com.adobe.cq.commerce.api.classification;version="[1.0,1.1)",
    com.adobe.cq.commerce.api.collection;version="[1.1,1.2)",
    com.adobe.cq.commerce.api.promotion;version="[1.2,1.3)",
    com.adobe.cq.commerce.api.smartlist;version="[2.0,2.1)",
    com.adobe.cq.commerce.common.promotion;version="[1.2,2)"   
    
STEP 4:
=======
change the bundle by manually open jar file and open in winzip edit it save and run or 
extract the jar if some thing to change in manifest and java .
do binding using bnd.jar and .bnd file.create bundle and install in aem 6.3.

https://github.com/arunsadhasivam/AEMProjects/tree/master/notes/stepstoConvertJarsToBundle



   
Important:
==========
to know which bundle it refers check  "import packages" 
webapi-util.jar(bundle 300) refers bundle 408 -Adobe Communique 5 Commerce Core
 
webapi-util.jar bundle desc:
=============================

      Imported Packages	com.adobe.cq.commerce.api,version=1.2.0 from com.adobe.cq.commerce.cq-commerce-core (408)

To know which bundle version no to put in the aem 6.3 equivalent check the export package of refering bundle(408)

i.e bundle 408 in aem 6.3 refer the  Adobe Communique 5 Commerce Core(


