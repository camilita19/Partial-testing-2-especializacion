import Reportes.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.time.Duration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Author: camilaramirez neira
 */
public class BuscadorCarroTest {
  public WebDriver driver;
  private WebDriverWait wait;
  static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES/SearchTest.html");
  static ExtentReports extent;
  public String product = "Iphone";

  @BeforeAll
  public static void crearReporte() {
    System.out.println("Ejecutando crearReporte()");
    extent = ExtentFactory.getInstance();
    extent.attachReporter(info);
  }

  @BeforeEach
  public void inicio() {
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, Duration.ofSeconds(3));
   PaginaInicio paginaInicio = new PaginaInicio(driver, wait);
   paginaInicio.setUp();
   paginaInicio.getUrl("https://opencart.abstracta.us/index.php?route=common/home");
  }

  @Test
  public void buscarIPhone() throws InterruptedException {
    ExtentTest test = extent.createTest("Prueba de búsqueda de iPhone");
    test.log(Status.INFO, "Comienza el test");
   PaginaInicio homePage = new PaginaInicio(driver, wait);

    homePage.search(product);
    homePage.addToCart();
  }

}
