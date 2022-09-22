package evidences;

import core.DriverFactory;
import helpers.ValidationsHelper;
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
    ValidationsHelper helper = new ValidationsHelper();

    public void tirarPrint(String mensagem){
        String ct = helper.getCt();
        SimpleDateFormat fomatar = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
        SimpleDateFormat fomatarHora = new SimpleDateFormat("HH-mm");
        String pastaDoPrint = fomatar.format(new Date());
        String caminhoDoPrint = ".//evidences// " + pastaDoPrint + " // " + ct + " // " + mensagem + ".png";

        File print = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(print, new File(caminhoDoPrint));
        } catch (IOException e) {
            logger.info("Não foi possível printar a tela!");

        }

    }

}
