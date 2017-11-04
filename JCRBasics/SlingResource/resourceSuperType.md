ResourceSuperType:
==================

Two ways to define resouce super type:


1)by the sling:resourceSuperType property of resource.

2)by the sling:resourceSuperType property of sling:resourceType points.

   e.g: 
   
      1) /

      2)a

      3)b
         -sling:resourceSuperType=a

      4)c
         -sling:resourceSupertype=b

      5)x
         -sling:resourceType=c

      6)y
          -sling:resourceType=c
          -sling:resourceSuperType=a

