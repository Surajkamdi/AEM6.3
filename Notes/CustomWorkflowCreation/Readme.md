

Workflow is triggered as AEM workflow API - com.adobe.granite.workflow.exec.

STEP 1:
=======
write a class extends com.adobe.granite.workflow.exec.WorkflowProcess interface

https://helpx.adobe.com/experience-manager/using/creating-custom-aem-workflow-steps.html

@Component
@Service
@Properties({
	@Property(name = Constants.SERVICE_DESCRIPTION, value = "Metadata Values"),
	@Property(name = "process.label", value = "Metadata Values") })
public class CustomWorkFlow implements WorkflowProcess{

}
