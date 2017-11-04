Error:
======
when accessing the dispatcher it shows popup "localhost:8850 Your request could not be completed because you have been signed out."
It then redirect to 

localhost:8850/libs/granite/core/content/login.html?resource=%2Fcontent%webapi%2Fenglish%2Fen.html
&$$login$$=%24%24login%24%24&j_reason=unknown&j_reason_code=unknown


Solution:
=========

Step 1:
=======
go to localhost:4502/System/console/configmngr

Step 2:
=======

select osgi configuration

select -> Apache Sling Authentication Service
===============================================

Allow Anonymous Access	" checkthe box" it works now dispatcher popup error is showing.
