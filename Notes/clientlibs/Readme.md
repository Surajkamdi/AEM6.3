clientlibs can be done by 

hierarchy:
==========
      --etc
        --designs
           --webapi
             --clientlib
                 --js
                    --jquery.js
                 --css
                 --js.txt
                 --css.txt
                 --.content.xml
                 
          --webpageheadlibs
          --webpagelibs

Root:
=====
    <?xml version="1.0" encoding="UTF-8"?>
    <jcr:root xmlns:cq="http://www.day.com/jcr/cq/1.0" xmlns:jcr="http://www.jcp.org/jcr/1.0"
        cq:lastReplicationAction="Activate"
        jcr:mixinTypes="[cq:ReplicationStatus]"
        jcr:primaryType="cq:ClientLibraryFolder"
        categories="[webapi]"/>

    
 you can create js and css outside clientlib
 
  -- etc
      --designs
        --webpageheadlibs
           --js
              --jquery.js
              --css.txt
              --js.txt
              --.content.xml
              
 -- etc
      --designs
        --webpagelib
           --js
              --jquery.js
              --css.txt
              --js.txt
              --.content.xml

create dependencies by:
==========================
  
/etc/designs/webpageheadlibs/.content.xml
==========================================

        <?xml version="1.0" encoding="UTF-8"?>
        <jcr:root xmlns:cq="http://www.day.com/jcr/cq/1.0" xmlns:jcr="http://www.jcp.org/jcr/1.0"
            jcr:primaryType="cq:ClientLibraryFolder"
            categories="[webapi.headlibs]"
            dependencies="[webpageheadlibs]"/>

  

/etc/designs/webpagelib/.content.xml
=====================================
   
      <?xml version="1.0" encoding="UTF-8"?>
      <jcr:root xmlns:cq="http://www.day.com/jcr/cq/1.0" xmlns:jcr="http://www.jcp.org/jcr/1.0"
          jcr:primaryType="cq:ClientLibraryFolder"
          categories="[webapi.pagelibs]"
          dependencies="[cq.jquery]"/>

     
    
