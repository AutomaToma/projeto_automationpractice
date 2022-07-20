package pages;

import core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompraPage extends BasePage {

    WebDriver driver = DriverFactory.getDriver();

    public CompraPage() {
        PageFactory.initElements(driver, this);
    }

    //    Mapeamento

 //MÉTODO

    public void selecionarCategoria(String categoria){
        WebElement cat=driver.findElement(By.xpath("(//a[text()='"+ categoria +"'])[2]"));
        cat.click();

    }

    public void selecionarProduto(String produto){
        WebElement prod= driver.findElement(By.xpath("//a[contains(text(),'"+ produto +"')]"));
        prod.click();

    }

}
