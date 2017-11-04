
1)Log Request:


http://localhost:4502/system/console/requests - shows all log of last 10 request.

to list additional features enabled in aem version.

Features:
==========
http://10.44.54.72:4502/system/console/features

E.g - com.adobe.dam.asset.lightbox.feature.flag	This Feature Flag would govern the AEM Assets LightBox Feature.	true


Sling Settings:
================
to see run mode settings once started.

http://localhost:4502/system/console/status-slingsettings

Sling Home URL = file:/apps/aem/crx-quickstart/
Run Modes = [crx3, author, samplecontent, crx3tar]


