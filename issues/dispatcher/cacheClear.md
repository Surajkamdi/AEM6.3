To clear cache:
===============
/apache/cache it contains all temp created requested jsp files which can be cleared.


NOTE:
=====
check /apps/apache/conf/publish_dispatcher.any 


it shows

/filter - allowable url by dispatcher

it shows where it cache the pages.
    
    /cache
          {
          # The docroot must be equal to the document root of the webserver. The
          # dispatcher will store files relative to this directory and subsequent
          # requests may be "declined" by the dispatcher, allowing the webserver
          # to deliver them just like static files.
          /docroot "/apps/apache/cache"

          # Sets the level upto which files named ".stat" will be created in the
          # document root of the webserver. When an activation request for some
          # page is received, only files within the same subtree are affected
          # by the invalidation.
          #/statfileslevel "0"
    }
