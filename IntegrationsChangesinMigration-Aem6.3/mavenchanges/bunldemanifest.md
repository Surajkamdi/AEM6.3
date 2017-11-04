To make aem 6.0 bundle work in aem 6.3:
========================================


in AEM 6.0  sightly version is 2.2,3

Import-Package: com.adobe.cq.sightly;version="[2.2,3)"


to make it work in AEM 6.3 change the bundle manifest in api-util.jar\META-INF\MANIFEST.MF

Import-Package: com.adobe.cq.sightly;version="[3.1,4)"

it works!!!!

you can change the manifest by opening jar in winzip and edit it and save it. or extract jar
run bnd tool 
https://github.com/arunsadhasivam/AEMProjects/tree/master/notes/stepstoConvertJarsToBundle
