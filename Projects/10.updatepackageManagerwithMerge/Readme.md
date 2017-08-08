Merge Mode:
===========
To avoid file being cleaned up and want to maintain existing file and want to update only 
new files.

/META-INF/VAULT/filter.xml
==========================

<?xml version="1.0" encoding="UTF-8"?>
<workspaceFilter version="1.0">
    <filter root="/content/dam" mode="merge"/>
</workspaceFilter>

it allows old files to get retained , it wont clean all files , just update which is missed .

NOTE:
====
    filter elements
    The filter elements are independent of each other and define include and exclude patters for subtrees.
    The root of a subtree is defined by the root attribute, which must be an absolute path.

    The filter element can have an optional mode attribute which specified the import mode used when importing content.
    the following values are possible:

    “replace”
    This is the normal behavior. Existing content is replaced completely by the imported content, 
    i.e. is overridden or deleted accordingly.

    1)“merge”
    =========

    Existing content is not modified, i.e. only new content is added and none is deleted or modified.

    2)“update”
    ========
    Existing content is updated, new content is added and none is deleted.
