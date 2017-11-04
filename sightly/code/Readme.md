    <div data-sly-use.WEB="com.core.components.TestFormField" data-sly-unwrap>

     <p style="margin-top:0px">${WEB.testObject.namelabel @ i18n}</p>

      <p style="margin-top:0px">${WEB.testObject.emaillabel @ i18n}</p>

       <p style="margin-top:0px">${WEB.testObject.submitlabel @ i18n}</p>



SIGHTLY API COMPONENT
========================
  
   
    public class TestFormField extends WCMUse {
		private TestFormPOJO testObject = new TestFormPOJO();

		public TestFormPOJO getTestObject() {
			return testObject;
		}

		@Override
		public void activate() throws Exception {
			Node node;
			String Test_form_path = getProperties().get("formPath", String.class);
			if (Test_form_path == null) {
				Test_form_path = getResource().getPath();
			} else {
				Node curNode = getResourceResolver()
				 .getResource(Test_form_path + "/jcr:content").adaptTo(Node.class);
				Test_form_path = nodeIteratorValue(curNode, "testformfield");
			}
			node = getResourceResolver().getResource(Test_form_path).adaptTo(Node.class);

			testObject.setNamelabel(getPropValue(node, "user_label", "Name));
			testObject.setEmaillabel(getPropValue(node, "email_label", "Email"));
			testObject.setSubmitlabel(getPropValue(node, "submit_label", "Submit"));
	} 


    } 

above values get from the node in jcr:/content

dialog.xml
============

        <jcr:root xmlns:cq="http://www.day.com/jcr/cq/1.0" xmlns:jcr="http://www.jcp.org/jcr/1.0"
            jcr:primaryType="cq:Dialog"
            title="dialog"
            xtype="dialog">
            <items
                jcr:primaryType="cq:Widget"
                xtype="tabpanel">
                <items jcr:primaryType="cq:WidgetCollection">
                    <form_feild_path
                        jcr:primaryType="cq:Panel"
                        title="Form Field Path">
                        <items jcr:primaryType="cq:WidgetCollection">
                            <formPath
                                jcr:primaryType="cq:Widget"
                                fieldDescription="form Related info needs to be fectched"
                                fieldLabel="Form Path"
                                name="./formPath"
                                xtype="pathfield"/>
                        </items>
                    </form_feild_path>
                    <form_variables
                        jcr:primaryType="cq:Panel"
                        title="Form Variables">
                        <items jcr:primaryType="cq:WidgetCollection">
                            <namelabel
                                jcr:primaryType="cq:Widget"
                                fieldDescription="First sub section title be configured here"
                                fieldLabel="Name "
                                name="./name_label"
                                validateOnBlur="true"
                                xtype="textfield"/>

                            <emaillabel
                                jcr:primaryType="cq:Widget"
                                fieldDescription="First sub section title be configured here"
                                fieldLabel="Name "
                                name="./email_label"
                                validateOnBlur="true"
                                xtype="textfield"/>

                             <submitlabel
                                jcr:primaryType="cq:Widget"
                                fieldDescription="First Button label can be set here"
                                fieldLabel="Button Text One"
                                name="./submit_label"
                                validateOnBlur="true"
                                xtype="textfield"/>


                    </form_variables>
                    ..
               </items>
            </items>
        </jcr:root>





FORM POJO OBJECT
==================

    public class TestFormPOJO {
	private String namelabel;
	private String emaillabel;
	private String submitlabel;
  
    }
  
    
 Flow:
 =====
  
  TestFormPojo --> map to dialog.xml (tag ) -->
  
  e.g:
  ====
  namelabel of TestFormPOJO --> <namelabel> tag of dialog.xml
  
  name attribute of dialog.xml --> map to TestFormField access attribute

        testObject.setNamelabel(getPropValue(node, "user_label", "Name));
	testObject.setEmaillabel(getPropValue(node, "email_label", "Email"));
	testObject.setSubmitlabel(getPropValue(node, "submit_label", "Submit"));

        <namelabel
              jcr:primaryType="cq:Widget"
              fieldDescription="First sub section title be configured here"
              fieldLabel="Name "
              name="./name_label"
              validateOnBlur="true"
              xtype="textfield"/>
