import Reportes.ExtentFactory;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.time.Duration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Author: camila ramirez neira
 */
public class RegistroTest {
  public  WebDriver driver;
  private WebDriverWait wait;
  static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES/RegistroTest.html");
  static ExtentReports extent;
  public String firstName = "camila";
  public String lastName = "ramirez";
  public String email = "pruebaparcial@test.com";
  public String telephone = "3123456789";
  public String password = "testUser1";

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
   PaginaInicio paginaInicio = new PaginaInicio( driver, wait );
   paginaInicio.setUp();
   paginaInicio.getUrl("https://opencart.abstracta.us/index.php?route=common/home");
  }

  @Test
  public void testRegistro() throws InterruptedException {
    ExtentTest test = extent.createTest("Prueba de registro de usuario - Exitosa");
    test.log(Status.INFO, "Comienza el test");
    PaginaInicio paginaInicio = new PaginaInicio(driver, wait);
   PaginaRegistro paginaRegistro = new PaginaRegistro(driver, wait);

   paginaInicio.goRegister();
    test.log(Status.PASS,"Llega a la página de Registro");

    test.log(Status.INFO, "Se comienza a completar el formulario");
    paginaRegistro.completarForm(firstName,lastName,email,telephone,password);
    test.log(Status.PASS, "Se completa el registro");

   paginaInicio.close();
  }

  @AfterAll
  public static void reporte() {
    extent.flush();
  }

}
