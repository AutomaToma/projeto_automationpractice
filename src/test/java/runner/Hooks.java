package runner;

import core.DriverFactory;
import helpers.ValidationsHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {
    ValidationsHelper helper = new ValidationsHelper();

    @Before
    public void setup(Scenario scenario){
        Object[]vetor = scenario.getSourceTagNames().toArray();
        String ct = "";
        for (Object tag:vetor){
            ct = tag.toString().replace("@","");
            helper.setCt(ct);

        }
        helper.setNomeCt(scenario.getName());
        DriverFactory.getDriver();
    }

    @After
    public void finalize(Scenario scenario){
        DriverFactory.killDriver();
    }

}
