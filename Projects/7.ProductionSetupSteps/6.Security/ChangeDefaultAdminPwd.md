when you create new instance in any server (DEV,QA,prod) and publish ui.apps,ui.content, it gets 
deployed with default password of admin as admin. since default AEM untar file has user repository site with
admin/admin as default user/password.

after deploy to qa if left as much somebody can easily login and do something without anyonce notice , also since
admin default has all permission. it is must to change password to avoid security vulnerability issues and avoid
someone to login in to crxde with default admin.


TO change it.
=============
STEP 1:
======
go to http://localhost:4502/

STEP 2:
=======
click on hammer tool icon on left.

STEP 3:
=======
click on "security" on left panel.

STEP 4:
=======
on right panel select Users.

link will be something like this http://localhost:4502/libs/granite/security/content/useradmin.html

STEP 5:
======
select Administrator

STEP 6:
=======
click on change password hyperlink.
