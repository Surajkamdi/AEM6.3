Issue:
======
in assetshare page   filter decline /querybuilder.json.

Solution:
==========
go to /apache/conf/publish_dispatcher.any

    allow these lines then assetshare page shows all contents.
     /0090 { /type "deny"  /url "*.query.json" }
          /0091 { /type "allow" /url "/bin/querybuilder.json"}
          /0092 { /type "allow" /url "/libs/dam/lightbox.json"}
          /0093 { /type "allow" /url "/libs/granite/csrf/token.json"}
          /0094 { /type "allow" /url "/content/dam/*/jcr:content/querybuilder/left/options*.json"}
          /0095 { /type "allow" /url "/content/dam/*/profile/querybuilder/savedsearch*.json"}
          /0096 { /type "allow" /url "/etc/tags/properties/orientation/*.json"}

