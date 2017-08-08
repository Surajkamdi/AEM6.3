
To include components either use cq:include as below or parsys.
<cq:include path="footer" resourceType="/apps/common/components/content/footer" />

cq:include will include statically content.

but to give author some flexibility to add dynamically content use parsys. like assetshare, assetviewer , asseteditor.

    Assetshare
      --AssetViewer
      --AssetEditor

NOTE:
======
give assetviewer,asseteditor insider assetshare.

in siteadmin it will be like http://localhost/siteadmin#/content/dam/test/assetshare  i.e Assets will be internally mapped to /content/dam
to add parsys dynamic asset editor or viewer just prefix with cf  http://localhost:4502/cf#content/dam/test/assetshare.html
it open in edit mode just click edit then add assetviewer or assetedit page to pull images.

in sideclick you can click design and then check on component group if 2 times if it is showing.i.e if you override default super type
it shows 2 times. just change the component group to avoid it.

use cf# to dynamically add the assetedit page in the assetshare page

cf - classic ui editor.
  
when click classic ui editor .http://localhost/cf#/content/dam/test/assetshare it shows edit "Path of Asset Editor" in that give the path of asset
edit page because of parsys .


