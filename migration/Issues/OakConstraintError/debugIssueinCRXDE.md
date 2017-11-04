To Debug issue:
===============

Could not save changes. Received 409 (Conflict) for saving changes in workspace crx.default. 
OakConstraint0001: /apps/foundation/components/test[[nt:folder]]: 
No matching definition found for child node dialog with effective type [cq:Dialog]


Solution:
=========
try to create a dialog in crxde same error occurs. when try to create dialog inside /apps/foundation/components/
error " Received 409 (Conflict) for saving changes in workspace crx.default. 
OakConstraint0001: /apps/foundation/components/test[[nt:folder]]: 
No matching definition found for child node dialog with effective type [cq:Dialog]" same error when run in maven.

