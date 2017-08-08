
To confirm all aem content copied sucessfully from source to destination:
==========================================================================

IN AEM content is based on files inside /crx-quickstart/repository/segmentstore. if total tar files or otherfiles
is same then it is correct.

    $ pwd
    /apps/aem6.3/crx-quickstart/repository/segmentstore

    [segmentstore]$ ls -l | wc -l
    1261

If size is huge connection may disconnect often while copying through sftp or scp. if it happens you can use
cp -r -u to copy only missing folders.

Syntax:
========

    syntax 
        cp [OPTION]... [-T] SOURCE DEST
        cp [OPTION]... SOURCE... DIRECTORY
        cp [OPTION]... -t DIRECTORY SOURCE..

  usage:
  ======
      cp -r -v -u  crx-quickstart/repository /system1/arun/crx-quickstart
      -u, --update
      copy only when the SOURCE file is newer than the destination file or when the destination file is missing
      -r - recursive
      -v - verbose shows which files copied from source to destination.

