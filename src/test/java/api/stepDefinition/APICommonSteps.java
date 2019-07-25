package api.stepDefinition;

import apiObject.DetailsAPIObject;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import utills.APIUtills;

import java.util.HashMap;
import java.util.Map;

public class APICommonSteps {

    //This use to store API objects which created in the set up method
    Map<String, APIUtills> apiObjects;
    //This uses to log the info based on different situation on this class
    final Log logger = LogFactory.getLog(APICommonSteps.class);

    //With This before annotation(hook) we can set up the requirement to run the test. Kind of pre conditions
    @Before
    public void setUP() {
        // Here we create API objects which we can use in the step definitions-(Usage- OOP inheritance)
        apiObjects = new HashMap<String, APIUtills>();
        apiObjects.put("DetailsAPI", new DetailsAPIObject());
    }

    @When("^I send the \"([^\"]*)\" request to the endpoint \"([^\"]*)\" with below parameter$")
    public void i_send_the_request_to_the_endpoint_with_below_parameter(String reqType, String apiName, Map<String, String> featureData) throws Throwable {
        //Here assign the created objects in setUp() method. Get the object from the Map using API name passed from Feature file
        APIUtills APIObject = (APIUtills) this.apiObjects.get(apiName);
        //Get the details from feature file which need to send API request and call processRequest method to process the API request using data in feature file
        APIObject.processRequest(featureData);
        // Here based on call type(GET,POST and etc) it call the relevant method to send the request
        if ("GET".equals(reqType)) {
            //This will send the API request calling getResponse method in API object class if it doesn't override
            APIObject.getResponse();
        }


    }

    @Then("^I should receive response with below details for \"([^\"]*)\"$")
    public void i_should_receive_response_with_below_details(String apiName, Map<String, String> featureData) throws Throwable {
//Here assign the created objects in setUp() method. Get the object from the Map using API name passed from Feature file
        APIUtills APIObject2 = (APIUtills) this.apiObjects.get(apiName);
//This will process and valid the response with using provided data in feature file
        APIObject2.processResponse(featureData);
    }
}
