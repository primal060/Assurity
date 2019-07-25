$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Details.feature");
formatter.feature({
  "line": 1,
  "name": "Details API",
  "description": "",
  "id": "details-api",
  "keyword": "Feature"
});
formatter.before({
  "duration": 885687014,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 2,
      "value": "#This is Cucumber feature file which uses for the BDD"
    },
    {
      "line": 4,
      "value": "# - Scenario defines the functionality that is going to be tested."
    }
  ],
  "line": 6,
  "name": "Send API call to Details-API and verify the result",
  "description": "",
  "id": "details-api;send-api-call-to-details-api-and-verify-the-result",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@TestIshan"
    }
  ]
});
formatter.step({
  "comments": [
    {
      "line": 7,
      "value": "#When key word uses to show the action under the flow of scenario"
    }
  ],
  "line": 8,
  "name": "I send the \"GET\" request to the endpoint \"DetailsAPI\" with below parameter",
  "rows": [
    {
      "cells": [
        "catalogue",
        "false"
      ],
      "line": 9
    }
  ],
  "keyword": "When "
});
formatter.step({
  "comments": [
    {
      "line": 10,
      "value": "#Then key word uses to show the verification points"
    }
  ],
  "line": 11,
  "name": "I should receive response with below details for \"DetailsAPI\"",
  "rows": [
    {
      "cells": [
        "Status_code",
        "200"
      ],
      "line": 12
    },
    {
      "cells": [
        "Name",
        "Carbon credits"
      ],
      "line": 13
    },
    {
      "cells": [
        "CanRelist",
        "true"
      ],
      "line": 14
    },
    {
      "cells": [
        "Node_Name",
        "Promotions"
      ],
      "line": 15
    },
    {
      "cells": [
        "Promotions_Name",
        "Gallery"
      ],
      "line": 16
    },
    {
      "cells": [
        "Description",
        "2x larger image"
      ],
      "line": 17
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "GET",
      "offset": 12
    },
    {
      "val": "DetailsAPI",
      "offset": 42
    }
  ],
  "location": "APICommonSteps.i_send_the_request_to_the_endpoint_with_below_parameter(String,String,String,String\u003e)"
});
formatter.result({
  "duration": 3492990823,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "DetailsAPI",
      "offset": 50
    }
  ],
  "location": "APICommonSteps.i_should_receive_response_with_below_details(String,String,String\u003e)"
});
formatter.result({
  "duration": 573263720,
  "status": "passed"
});
});