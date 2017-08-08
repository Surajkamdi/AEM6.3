if the content is in TB it is not good way to do replication agent to push from author to publish. 

Good procedure is to use VLT.

http://www.sravan.co/blog/aem-copying-large-volume-of-content

Command to Copy from author to publish:
=======================================

below command copy all content of /content/dam/Test from 10.0.5.22:4502 to 10.0.21.30 
i.e /content/dam/Test get added in to  10.0.21.30 from 10.0.5.22:4502


important:
=========
before running below vlt disable dam content because has rendition turned on , if it is turned on, every time it saves the document
it do rendition. something like indexing in db. if it turned on it do indexing on each time insert /update of table.
so disalbe as like we turn on index while we update bulk content. because index serves good for search operation not insert.

STEPS:
======

Step 1 (Vault Installation): Navigate to “crx-quickstart/opt/filevault” and unzip “filevault.zip”

Step 2 (Vault Verification): Navigate to bin directory,
“{aem-install-folder}/crx-quickstart/opt/filevault/vault-cli-3.1.6/bin/”.

      Run the command “vlt –-version” and you should see output like this:
      “Jackrabbit FileVault [version 3.1.6] Copyright 2013 by Apache Software Foundation. See LICENSE.txt for more information.”

      export JAVA_HOME=$(/usr/libexec/java_home)

      export PATH=$JAVA_HOME/jre/bin:$PATH

Save, Exit and Navigate back to path provided in Step 2 and run “vlt –-version” again

Step 3 (Disable Workflows): When copying large volumes of data, you can turn off renditions.  This can be done by editing “workflow models”. Access “Launcher tab” in workflow console (/libs/cq/workflow/content/console.html) and edit each workflow model that starts with “DAM” and set the ‘Activate’ radio button to “Disable” and Save.  See below:


syntax:
=======

$ vlt rcp --help

Usage:
 rcp -q|-r|-b <size>|-t <seconds>|-R <path>|-u|-n|-e <arg1> [<arg2> ...]|--no-ordering <src> <dst>


worked actual command:
======================
      
     vlt rcp -b 1500 -r -u -n http://arun:arun123!@10.0.5.22:4502/crx/-/jcr:root/content/dam/Test http://admin:admin@10.0.21.30:4503/crx/-/jcr:root/content/dam/Test
     
    
  Note:
  =====
  trick is if it is large content pt -b(batchsize) to 10 or 5 since it may cause network to close because of hugevolume.
  if all node files are of small size use 1500 to get fast batch processing. ie it copy 1500
  and then saving it in remote system.
  
  
  src  - http://arun:arun123!@10.0.5.22:4502/crx/-/jcr:root/content/dam/Test 
  dest - http://admin:admin@10.0.21.30:4503/crx/-/jcr:root/content/dam/Test
    
Explanation:
============
copy first 1500 nodes and saving in bulk.

Copies a node tree from one remote repository to another. Note that <src> points at the source node, and <dst>points at the destination path, which parent node must exist.

Example:
    vlt rcp -e ".*\.txt" -r http://localhost:4502/crx/-/jcr:root/content http://admin:admin@localhost:4503/crx/-/jcr:root/content_copy


      Options:
        -q (--quiet)                        print as little as possible
        -r (--recursive)                    descend recursively
        -b (--batchSize) <size>             number of nodes until intermediate save
        -t (--throttle) <seconds>           number of seconds to wait after an intermediate save
        -R (--resume) <path>                source path to resume operation after a restart
        -u (--update)                       overwrite/delete existing nodes.
        -n (--newer)                        respect lastModified properties for update.
        -e (--exclude) <arg> [<arg> ...]    regexp of excluded source paths.
        --no-ordering                       disable node ordering for updated content
        <src>                               the repository address of the source tree
        <dst>                               the repository address of the destination node



