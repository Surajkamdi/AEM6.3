
Sling service not present in AEM 6.3
======================================

mvtstatis is nothing but multivariable statistics for 

MVT statistics:
===============
Little utility for MVT-Statistics. Allows to configure the URL to be called for tracking page-views and banner clicks. Contains convenience for the running of the click through rate statistics.

com.day.cq.wcm.core.mvt.MVTStatisticsImpl 
==========================================

Configures Collection of data and runs report of click-through-rates


below js are default present in aem 6.0 but not present in aem 6.3

/libs/wcm/foundation/components/page/stats.js
/libs/wcm/foundation/components/page/initwcm.js


stats.js
========

global.Packages.com.day.cq.wcm.core.mvt.MVTStatistics package is deprected uber-jar-6.3.0-obfuscated-apis.jar

in uber-jar-6.3.0 - actual class is \com\day\cq\wcm\core\stats\PageViewStatistics



AEM 6.0 - get statistics
===========================

\aem-api-6.0.0.1.jar\com\day\cq\wcm\core\mvt\MVTStatistics

\aem-api-6.0.0.1.jar\com\day\cq\wcm\core\mvt\PageView.class

\aem-api-6.0.0.1.jar\com\day\cq\wcm\core\stats\PageViewStatistics.class


      /* if (global.sling && global.Packages) {
            mvtService = global.sling.getService(global.Packages.com.day.cq.wcm.core.mvt.MVTStatistics);
        }

        if (mvtService
                && mvtService.getTrackingURI
                && mvtService.getTrackingURI()) {
            mvtStatisticsUrl = mvtService.getTrackingURI().toString();
        }*/
        
        
AEM 6.3 -get statistics
========================

 uber-jar-6.3.0-obfuscated-apis.jar\com\day\cq\wcm\core\stats\PageViewStatistics

        var _getMVTUrl = function () {
        var mvtStatisticsUrl = "";
        var mvtService = undefined;
        if (global.sling && global.Packages) {
            mvtService = global.sling.getService(global.Packages.com.day.cq.wcm.core.stats.PageViewStatistics);
        }

        if (mvtService
                && mvtService.getTrackingURI
                && mvtService.getTrackingURI()) {
            mvtStatisticsUrl = mvtService.getTrackingURI().toString();
        }

        return mvtStatisticsUrl;
    };
