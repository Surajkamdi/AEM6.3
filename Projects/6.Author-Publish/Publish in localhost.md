Author:
=======
C:\AEM 6.2\cq5-author-p4502.jar

C:\AEM 6.2\crx-quickstart\

when double click you can see publish folder gets generated inside

C:\AEM 6.2\crx-quickstart\Publish\cq-publish-p4503.jar

C:\AEM 6.2\crx-quickstart\Publish\crx-quickstart



To enable Replication from localhost:4502 to localhost:4503
===========================================================
        
Default Agent (publish)
Agent that replicates to the default publish instance.

Agent is enabled. Replicating to http://localhost:4503/bin/receive?sling:authRequestLogin=1
Queue is idle
View log
Test Connection


Test Results:
=============

http://localhost:4502/etc/replication/agents.author/publish.test.html



Replication test to http://localhost:4503/bin/receive?sling:authRequestLogin=1

      06.07.2017 21:36:14 - Create new HttpClient for Default Agent
      06.07.2017 21:36:14 - * Auth User: admin
      06.07.2017 21:36:14 - * HTTP Version: 1.1
      06.07.2017 21:36:14 - adding header: Action:Test
      06.07.2017 21:36:14 - adding header: Path:/content
      06.07.2017 21:36:14 - adding header: Handle:/content
      06.07.2017 21:36:14 - deserialize content for delivery
      06.07.2017 21:36:14 - No message body: Content ReplicationContent.VOID is empty
      06.07.2017 21:36:14 - Sending POST request to http://localhost:4503/bin/receive?sling:authRequestLogin=1
      06.07.2017 21:36:14 - sent. Response: 200 OK
      06.07.2017 21:36:14 - ------------------------------------------------
      06.07.2017 21:36:14 - Sending message to localhost:4503
      06.07.2017 21:36:14 - >> POST /bin/receive HTTP/1.0
      06.07.2017 21:36:14 - >> Action: Test
      06.07.2017 21:36:14 - >> Path: /content
      06.07.2017 21:36:14 - >> Handle: /content
      06.07.2017 21:36:14 - >> Referer: about:blank
      06.07.2017 21:36:14 - >> Content-Length: 0
      06.07.2017 21:36:14 - >> Content-Type: application/octet-stream
      06.07.2017 21:36:14 - --
      06.07.2017 21:36:14 - << HTTP/1.1 200 OK
      06.07.2017 21:36:14 - << Date: Fri, 07 Jul 2017 04:36:14 GMT
      06.07.2017 21:36:14 - << X-Content-Type-Options: nosniff
      06.07.2017 21:36:14 - << Content-Type: text/plain; charset=UTF-8
      06.07.2017 21:36:14 - << Content-Length: 26
      06.07.2017 21:36:14 - << 
      06.07.2017 21:36:14 - << ReplicationAction TEST ok.
      06.07.2017 21:36:14 - Message sent.
      06.07.2017 21:36:14 - ------------------------------------------------
      06.07.2017 21:36:14 - Replication (TEST) of /content successful.
