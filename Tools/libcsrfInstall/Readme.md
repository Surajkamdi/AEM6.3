if you accidently deleted csrf you can download from other env and can install.
but if you install as much it wont get installed to make it install by override
you need install in packmanager by selecting override option.

STEP1:
======

go to http://localhost:4503/crx/packmgr/index.jsp

STEP 2:
=======
upload package select Force Upload:

 
Check to overwrite existing packages.


STEP 3:
=======
install the bundle by choosing below Advance options.
choose   Access Control Handling "Ignore" and Dependencies Handling "ignore"


          Do you really want to install this package?

          my_packages:token

           Advanced Settings
          Save Threshold:

          1024

          Number of transient nodes until automatic saving is triggered. Increase if you encounter 
          concurrent modification exceptions.
          Extract Subpackages:


          Mark this checkbox to enable automatic extraction of sub packages.
          Access Control Handling:

          Ignore


          Specify how access control information is handled during import.
          Dependencies Handling:

          Ignore


          Specify how dependencies are handled during import.
