STEP 1:
=======

For e.g i have created a application name WebAPI which i want to make available in publish

http://localhost:4502/crx/de/index.jsp#/content/WebAPI

i.e i dont want to deploy manually when i publish from http://localhost:4502 it should be available in
http://localhost:4503.


for this first go to Siteadmin.


STEP 2:
=======
go to http://localhost:4502/siteadmin#/content/WebAPI

select the WebAPI folder in siteadmin in left panel it should show below details:

     Title     | Name |Published | modified|Status | impressions.
     ===========================================================
     WebAPI    | Api  |Published |
     Test      | test |  -       |
     Geometric | geom |  -       |  
    ===========================================================
  
  
  Note
  =====
  by default it is not in Published  like above Test project is not published . if published it is 
  automatically available in localhost:4503.
