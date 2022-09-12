package evidences;

import core.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Evidences {

    Logger logger = LogManager.getLogger(this);

    public void tirarPrint(String mensagem){
        SimpleDateFormat fomatar = new SimpleDateFormat("dd-MM-yyyy");
        String pastaDoPrint = fomatar.format(new Date());
        String caminhoDoPrint = ".//evidences//" + pastaDoPrint + "//" + mensagem + ".png";

        File print = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(print, new File(caminhoDoPrint));
        } catch (IOException e) {
            logger.info("Não foi possível printar a tela!");

        }

    }

}
