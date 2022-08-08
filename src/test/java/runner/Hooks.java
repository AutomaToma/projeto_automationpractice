package runner;

import core.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @Before
    public void setup(){
        DriverFactory.getDriver();
    }

    @After
    public void finalize(){
        DriverFactory.killDriver();
    }

}
