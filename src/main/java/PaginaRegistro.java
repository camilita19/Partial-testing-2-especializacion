import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * Author: camila ramirez neira
 */
public class PaginaRegistro extends BasePage {
  private final By firstNameInput = By.id("input-firstname");
  private final By lastNameInput = By.id("input-lastname");
  private final By emailInput = By.id("input-email");
  private final By telephoneInput = By.id("input-telephone");
  private final By passwordInput = By.id("input-password");
  private final By passwordConfirmInput = By.id("input-confirm");
  private final By subscribeRadioNoInput = By.xpath("//*[@value='0']");
  private final By privatePolicyInput = By.name("agree");
  private final By continueButton = By.xpath("//*[@value='Continue']");

  public PaginaRegistro(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public void completarForm(String firstName, String lastName, String email, String telephone, String password) throws InterruptedException {
    Thread.sleep(1000);
    this.sendText(firstName, firstNameInput);
    this.sendText(lastName, lastNameInput);
    this.sendText(email, emailInput);
    this.sendText(telephone, telephoneInput);
    this.sendText(password, passwordInput);
    this.sendText(password, passwordConfirmInput);
    this.click(subscribeRadioNoInput);
    this.click(privatePolicyInput);
    this.click(continueButton);

  }

}
