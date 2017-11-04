To Allow the binary files like ppt,pptx,xlsx and xls to render properly in ie 11. need to
added the below lines in dispatcher.any of dispatcher.


ISSUE :
========
when try to download ppt,xls document it gets download as binary file instead of attachment.

if you open xlsx , pptx file in ie 11 it renders in webpage rather than open as separate ppt, xlsx file.
i.e  as like setting "content-disposition: attachment" in normal jsp servlet applicaiton.

it occurs only in ie , chrome by default able to understand without any setting
in dispatcher and renders as attachment but ie11 renders as junk binary 
content in jsp.


/apps/apache/aem63/apache/conf
==============================

The /invalidate property defines the documents that are automatically invalidated when content is updated.

If you offer automatically generated PDF and ZIP files for download, you might have to automatically invalidate these as well. A configuration example this looks as follows:


With automatic invalidation, Dispatcher does not delete cached files after a content update, 
but checks their validity when they are next requested. Documents in the cache that are
not auto-invalidated will remain in the cache until a content update explicitly deletes them.


    /invalidate
      {


     /0004 { /glob "*.xlsx" /type "allow" }
       /0005 { /glob "*.pptx" /type "allow" }
            }

      }
  
  below does invalidate the files and it wont look for the html file in cache every it gets invalidated and gets fresh
  attachment xls,ppt or any file format from server than from cache.
