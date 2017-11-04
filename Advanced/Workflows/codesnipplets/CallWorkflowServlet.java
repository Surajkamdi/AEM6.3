

import com.day.cq.workflow.WorkflowService;

@SlingServlet(paths = "/bin/callWorkflow", methods = "GET", metatype = true)
public class CallWorkFlowServlet extends SlingAllMethodsServlet {


    @Reference
	  private WorkflowService workflowService;
  
    //NOTE:
    //only class available in aem instance only need to be injected with @Reference.
    
    private Session session;
  	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {
            session = resourceResolver.adaptTo(Session.class); 
           	WorkflowSession wfSession = workflowService.getWorkflowSession(session);   
             if (!session.nodeExists("/apps/")) {
                  String ParentPath = "/apps/webapi/"; 
                  Node parentNode = session.getNode(ParentPath);  
               
                  if (parentNode != null) {    
                    Node requestNode = parentNode.addNode("request", "nt:unstructured"); 
                    
                    String year = String.valueOf(Calendar.getInstance().get(Calendar.MONTH));
                    String month = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
                    
                    String day = String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
                     Node month = requestNode.addNode("month", "nt:unstructured"); 
                      Node month = requestNode.addNode("year", "nt:unstructured");
                       Node month = requestNode.addNode("date", "nt:unstructured");
                      session.save();
                    
                    
             }
      

    }

}
