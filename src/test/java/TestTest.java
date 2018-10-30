import org.junit.Test;
import org.openqa.selenium.By;

public class TestTest extends TestBase {

    private User user = new User("login", "password");

    @Test
    public void testLogin() throws Exception {
        driver.get("https://trello.com/home");
        driver.findElement(By.linkText("Войти")).click();
        driver.findElement(By.id("user")).clear();
        driver.findElement(By.id("user")).sendKeys(user.getLogin());
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(user.getPassword());
        driver.findElement(By.id("login")).click();
        driver.findElement(By.linkText("Перейти к вашим доскам.")).click();
    }

    @Test
    public void testAddBoard() throws Exception {
        testLogin();
        driver.get("https://trello.com/lix373/boards");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[5]/a[1]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"classic\"]/div[5]/div/div[2]/div/div/div/ul/li[1]/a")).click();
        Thread.sleep(100);
        driver.findElement(By.xpath("//*[@id=\"classic\"]/div[4]/div/div/div/form/div/div/div[1]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"classic\"]/div[4]/div/div/div/form/div/div/div[1]/input")).sendKeys("test");
        Thread.sleep(100);
        driver.findElement(By.xpath("//*[@id=\"classic\"]/div[4]/div/div/div/form/button")).click();
    }
}
