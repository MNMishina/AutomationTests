package stepDefinitions;

import org.junit.Before;

import java.io.IOException;

public class Hooks {

    @Before         //@Before("@DeletePlace")
        public void beforeScenario() throws IOException {
            // execute this code only when place_id is null
            StepDefinition m = new StepDefinition();
            if (StepDefinition.place_id == null) {
                m.add_place_payload("Shetty", "Romanian", "Asia");
                m.user_calls_with_http_request("AddPlaceAPI", "POST");
                m.verifyPlace_IdCreatedMapsToUsing("Shetty", "getPlaceAPI");
            }
        }
    }
