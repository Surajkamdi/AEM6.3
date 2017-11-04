import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.HistoryItem;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;

@Component
@Service
public class BasicWorkflow implements WorkflowProcess {
 
  @Reference
	private ResourceResolverFactory resolverFactory;
  
   @SuppressWarnings("deprecation")
	public void execute(WorkItem item, WorkflowSession wfSession, MetaDataMap args) throws WorkflowException {  
    	
         
       
 
 }
 
 }
