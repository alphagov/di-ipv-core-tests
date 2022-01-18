package gov.di_ipv_core.step_definitions;

import gov.di_ipv_core.utilities.Driver;
import io.cucumber.java.After;

public class Hooks {
    @After
    public void tearDown (){
        Driver.closeDriver();
    }
}
