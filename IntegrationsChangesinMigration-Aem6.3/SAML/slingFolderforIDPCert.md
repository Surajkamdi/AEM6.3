Sling:folder allows to override and use some components

Eg:

/apps/foundation if under foundation /test folder created and then if try to create dialog it shows
error "Could not save changes. Received 409 (Conflict) for saving changes in workspace crx.default.
OakConstraint0001: /apps/foundation/components/report[[nt:folder]]: No matching definition found for child 
node dialog with effective type [cq:Dialog]"

but if you make /test folder as sling:folder type and then create dialog it works fine.


Sling VS Sling:Folder:
=======================
sling - order folder of type nt:folder

Sling:folder - a node  of type Sling:folder
you can add extra properties 

like e.g you can add /etc/keys/saml
you can create a sing:folder named saml with property private type as "binary" which is not possible in ordinary folder.
