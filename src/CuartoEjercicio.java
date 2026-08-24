import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CuartoEjercicio {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        driver.manage().window().maximize();

        try {
            driver.get("https://the-internet.herokuapp.com/checkboxes");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='checkbox']")));
            List<WebElement> casillas = driver.findElements(By.cssSelector("input[type='checkbox']"));

            WebElement c1 = casillas.get(0);
            WebElement c2 = casillas.get(1);

            if (!c1.isSelected()){
                c1.click();
            }

            if (!c2.isSelected()){
                c2.click();
            }

            Boolean primerSel = c1.isSelected();
            Boolean segundaSel = c2.isSelected();

            System.out.println("Primera casilla seleccionada: " + primerSel);
            System.out.println("Segunda casilla seleccionada: "+ segundaSel);

            if (primerSel && segundaSel){
                System.out.println("Ambas casillas quedaron seleccionadas");
            }else{
                System.out.println("Algunuas casilla no se verifico NO paso la prueba");
            }

        }finally {
            driver.quit();
        }
    }
}
