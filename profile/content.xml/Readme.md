\ui.apps\src\main\content\jcr_root\conf\global\settings\dam\adminui-extension


you have   profiles and schema   folder let say:

1)metadataprofile

2)metadataschema

metadataprofile:
==================

3 profiles profile1,employeeprofile,testprofile is created.

\ui.apps\src\main\content\jcr_root\conf\global\settings\dam\adminui-extension\metadataprofile

\ui.apps\src\main\content\jcr_root\conf\global\settings\dam\adminui-extension\metadataprofile\profile1

\ui.apps\src\main\content\jcr_root\conf\global\settings\dam\adminui-extension\metadataprofile\employeeprofile

\ui.apps\src\main\content\jcr_root\conf\global\settings\dam\adminui-extension\metadataprofile\testprofile

metadataschema:
================

\ui.apps\src\main\content\jcr_root\conf\global\settings\dam\adminui-extension\metadataschema

\ui.apps\src\main\content\jcr_root\conf\global\settings\dam\adminui-extension\metadataschema\employeemetadata

\ui.apps\src\main\content\jcr_root\conf\global\settings\dam\adminui-extension\.content.xml

content.xml should contain below content saying it is a folder.

content.xml
============

  <?xml version="1.0" encoding="UTF-8"?>
  <jcr:root xmlns:sling="http://sling.apache.org/jcr/sling/1.0" xmlns:jcr="http://www.jcp.org/jcr/1.0"
      jcr:primaryType="sling:Folder"/>

ISSUE:
=====
profile is not shown up.i.e profile1,employeeprofiel,testprofile is not shown. showing blank screen. profile is 
where default value for employee is setup. like empid prefix with P(permante), cs(contractor)

Solutions:
==========
Add content.xml in adminui-extension folder to state that metadataprofile,metadataschema is a folder.
Important:
==========
if \ui.apps\src\main\content\jcr_root\conf\global\settings\dam\adminui-extension folder which contains metadataprofile,
metadataschema if it does not have content.xml it wonts show up in Metadata Profiles in below link.


http://localhost:4502/aem/start.html  > assets > profiles> Metadata Profiles



