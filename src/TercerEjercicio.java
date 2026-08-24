import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TercerEjercicio {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        driver.manage().window().maximize();

        try {
            driver.get("https://the-internet.herokuapp.com/dropdown");
            WebElement lista = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dropdown")));
            Select listaSel = new Select(lista);
            listaSel.selectByVisibleText("Option 2");

            String opcionSeleccionada = listaSel.getFirstSelectedOption().getText();
            System.out.println("El texto seleccionado fue: " + opcionSeleccionada);

            if (opcionSeleccionada.contains("Option 2")){
                System.out.println("La prueba paso");
            }else{
                System.out.println("la prueba fallo");
            }
        }finally {
            driver.quit();
        }
    }
}
