package pages;

import core.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class HomePage extends BasePage{

    WebDriver driver  = DriverFactory.getDriver();
    Utils utils = new Utils();

    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    // MAPEAMENTO DE ELEMENTO

    // MÉTODOS


}
