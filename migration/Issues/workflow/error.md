02.11.2017 00:34:09.108 *WARN* [OsgiInstallerImpl] com.adobe.granite.workflow.core
[com.adobe.granite.workflow.core.job.TimeoutHandler(244)] Could not get service
from ref [com.adobe.granite.workflow.exec.WorkflowProcess]
02.11.2017 00:34:09.108 *WARN* [OsgiInstallerImpl] com.adobe.granite.workflow.core
[com.adobe.granite.workflow.core.job.TimeoutHandler(244)] DependencyManager :
invokeBindMethod : Service not available from service registry for ServiceReference 
[com.adobe.granite.workflow.exec.WorkflowProcess] for reference WorkflowProcess
02.11.2017 00:34:09.109 *ERROR* [FelixDispatchQueue] com.adobe.granite.workflow.core FrameworkEvent ERROR 
(org.osgi.framework.ServiceException: Service factory returned null. 



02.11.2017 00:34:09.112 *WARN* [OsgiInstallerImpl] com.adobe.acs.acs-aem-commons-bundle
[com.adobe.acs.commons.workflow.synthetic.impl.SyntheticWorkflowRunnerImpl(2993)] 
Could not get service from ref [com.adobe.granite.workflow.exec.WorkflowProcess]
02.11.2017 00:34:09.112 *WARN* [OsgiInstallerImpl] com.adobe.acs.acs-aem-commons-bundle
[com.adobe.acs.commons.workflow.synthetic.impl.SyntheticWorkflowRunnerImpl(2993)] DependencyManager :
invokeBindMethod : Service not available from service registry for ServiceReference [com.adobe.granite.workflow.exec.WorkflowProcess] for reference com.adobe.granite.workflow.exec.WorkflowProcess
02.11.2017 00:34:09.113 *ERROR* [FelixDispatchQueue] com.adobe.acs.acs-aem-commons-bundle FrameworkEvent ERROR
(org.osgi.framework.ServiceException: Service factory returned null.  


02.11.2017 00:34:09.112 *ERROR* [OsgiInstallerImpl] com.veritas.cq.foundation.core 
[com.webapi.core.workflow.TranslationFlow(7327)] Error during instantiation of the implementation object (java.lang.NullPointerException)
 
 
 Solution:
 =========
 
 NOTE: 
 ======
  error says "Could not get service
from ref [com.adobe.granite.workflow.exec.WorkflowProcess]"  so replace with aem 6.3 om.day.cq.workflow.exec.WorkflowProcess and
equivalent supporting class like workflowsession,item,historyitem like below.

 Instead of 
 
 AEM 6.0
 ========
 
 
 import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;

use (AEM 6.3)
==============
 
 
 import com.day.cq.workflow.WorkflowException;
import com.day.cq.workflow.WorkflowSession;
import com.day.cq.workflow.exec.HistoryItem;
import com.day.cq.workflow.exec.WorkItem;
import com.day.cq.workflow.exec.WorkflowProcess;
import com.day.cq.workflow.metadata.MetaDataMap;
