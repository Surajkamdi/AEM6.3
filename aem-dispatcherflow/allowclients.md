
To allow dispatcher to publish to publish instance
====================================================

dispatcher to allow publish, it should be in allowed clients entry.
3 things to note:

step 1:
========

publish server to get pull content from.


        /renders
              {
              /publish01
                {
                # Hostname or IP of the render
                /hostname "10.0.0.70"
                # Port of the render
                /port "4503"
                # Connect timeout in milliseconds, 0 to wait indefinitely
                # /timeout "0"
                }
        }

step 2:
=======
 
 #The allowedClients section restricts the client IP addresses that are
 # allowed to issue activation requests.
//allow publish server to push content to.
        
        allowedClients
        {
                # Uncomment the following to restrict activation requests to originate
                # from "localhost" only.
                #
                /0000
                  {
                  /glob "*"
                  /type "deny"
                  }
                /0001
                  {
                  /glob "10.0.0.70"
                  /type "allow"
                  }
        }
        
        
        
step 3:
======
To enable xls , ppt to display render in web browser need to invalidate the cache.

/apps/apache/aem63/apache/conf

The /invalidate property defines the documents that are automatically invalidated when content is updated.

If you offer automatically generated PDF and ZIP files for download, you might have to automatically invalidate these as well. A configuration example this looks as follows:

With automatic invalidation, Dispatcher does not delete cached files after a content update, but checks their validity when they are next requested. Documents in the cache that are not auto-invalidated will remain in the cache until a content update explicitly deletes them.

        /invalidate
          {


         /0004 { /glob "*.xlsx" /type "allow" }
           /0005 { /glob "*.pptx" /type "allow" }
                }

          }
below does invalidate the files and it wont look for the html file in cache every it gets invalidated and gets fresh attachment xls,ppt or any file format from server than from cache.
