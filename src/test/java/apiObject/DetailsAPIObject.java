package apiObject;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import utills.APIUtills;

import java.util.List;
import java.util.Map;


public class DetailsAPIObject extends APIUtills {
    final Log logger = LogFactory.getLog(DetailsAPIObject.class);

    public void processRequest(Map<String, String> featureData) {

        /*Basically here set up the request with relevant request headers, parameters, End points.
         * This can be more parameterized. But for understanding purpose I put the data here.
         * And this is override method.
         * */
        try {
            APIUtills.httpRequest.header("Content-Type", "application/json");
            setBaseURI("https://api.tmsandbox.co.nz");
            setBasePath("v1");
            APIUtills.path = "Categories/6327/Details.json";
            setParam("catalogue", String.valueOf(featureData.get("catalogue")));

        } catch (Exception e) {
            logger.info(e);
        }
    }

    public void processResponse(Map<String, String> featureData) {
        /*
         *This method will process and validate the response
         * */
        try {
            //Here it will check status code to check whether its success or not
            if ((String.valueOf(res.getStatusCode())).equals(featureData.get("Status_code"))) {

                // Get Response Body
                ResponseBody r_body = res.getBody();

                // Get JSON Representation from Response Body
                JsonPath jsonPathEvaluator = res.jsonPath();

                //Here it validates the [Name = "Carbon credits"]. It checks response value with expected value mention in the feature file
                Assert.assertEquals(String.valueOf(featureData.get("Name")), jsonPathEvaluator.get("Name"));

                //Here it validates the [CanRelist = true]. It checks response value with expected value mention in the feature file
                Assert.assertEquals(Boolean.valueOf(featureData.get("CanRelist")), jsonPathEvaluator.get("CanRelist"));


                Boolean expected_condition = false;
                //Here it validates whether it has [The Promotions element with Name = "Gallery" has a Description that contains the text "2x larger image"]
                //We get the List inside the json arry and assign in to Map
                List<Map<String, String>> jsonArrayList = jsonPathEvaluator.getList(String.valueOf(featureData.get("Node_Name")));

                //Since it has arrays inside [Promotion] node We need to go inside and find the element as per expected condition in the spec
                for (int i = 0; i < jsonArrayList.size(); i++) {

                    if (jsonArrayList.get(i).get("Name").equals(featureData.get("Promotions_Name"))) {
                        if (jsonArrayList.get(i).get("Description").contains(featureData.get("Description"))) {
                            expected_condition = true;
                            logger.info("The Promotions element with Name = " + jsonArrayList.get(i).get("Name") + " has a Description that contains the text " + jsonArrayList.get(i).get("Description"));
                        }
                    }
                }
                Assert.assertTrue(expected_condition);


            }

        } catch (Exception e) {
            logger.info(e);
        }
    }
}
