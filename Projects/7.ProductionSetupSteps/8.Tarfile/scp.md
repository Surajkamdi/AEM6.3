download from different server scp
==================================

/var/log/Test/VPN-LFS-9.1.2r32-mcore-update.tar.gz

go to

/var/log>scp arun@10.0.0.62: /upgrate/vpn/9.1/*r32* .

/var/log>cd updates

/var/log/updates>./update.sh


change permission of folder to copy:
=====================================
To copy folder source to destination makesure you change the permission to all people from 
remote to copy.

    >chmod -R 777 /home/java/


    N   Description                      ls   binary    
    0   No permissions at all            ---  000
    1   Only execute                     --x  001
    2   Only write                       -w-  010
    3   Write and execute                -wx  011
    4   Only read                        r--  100
    5   Read and execute                 r-x  101
    6   Read and write                   rw-  110
    7   Read, write, and execute         rwx  111


Recursively copy a folder from a remote system to local:
==========================================================
need -r recursive otherwise it says it is a not a file.

    admin >  scp -r  arunkumar_sadhasivam@10.0.1.52:/mnt/aemold/crx-quickstart/  .
