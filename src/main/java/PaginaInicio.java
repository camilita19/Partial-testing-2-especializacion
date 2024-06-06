import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Author: camila ramirez neira
 */
public class PaginaInicio extends BasePage {
  private final By myAccount = By.xpath("//*[@title='My Account']");
  private final By registerButton = By.linkText("Register");
  private final By searchInput = By.name("search");
  private final By searchButton = By.cssSelector(".fa.fa-search");
  private final By addToCartButton = By.cssSelector(".product-thumb .fa-shopping-cart");

  public PaginaInicio(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public void goRegister() throws  InterruptedException {
    Thread.sleep(1000);
    this.click(myAccount);
    this.click(registerButton);
  }

  public  void search(String product) throws InterruptedException {
    Thread.sleep(1000);
    this.sendText(product, searchInput);
    this.click(searchButton);
  }

  public void addToCart() throws InterruptedException {
    Thread.sleep(1000);
    this.click(addToCartButton);
  }

}
