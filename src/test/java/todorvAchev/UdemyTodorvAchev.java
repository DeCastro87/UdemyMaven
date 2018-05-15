package todorvAchev;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UdemyTodorvAchev {

		private WebDriver driver;
		private String url;

		@Before
		public void setUp(){

			System.setProperty("webdriver.chrome.driver", "D:\\Eduardo\\\\Programas\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver(); // driver
			driver.manage().window().maximize(); // maximar tamanho da página
			driver.manage().deleteAllCookies();

			url = "http://testing.todvachev.com/";

		}

		@After
		public void tearsdown(){
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.quit(); // fechar página
		}

		@Test
		public void ValidarElementosName(){
			driver.get(url+"/selectors/name/"); //caminho
			WebElement CampoTexto = driver.findElement(By.name("myName"));
			CampoTexto.sendKeys("TESTE");			
		}

		@Test
		public void ValidarElementosId(){
			driver.get(url+"/selectors/id/");
			WebElement Imagem = driver.findElement(By.id("testImage"));
			if (Imagem.isDisplayed() == true){
				System.out.println("imagem exibida");
			}
		}

		@Test
		public void ValidarElementosClass(){
			driver.get(url+"/selectors/class-name/");
			WebElement Class = driver.findElement(By.className("testClass"));		
			System.out.println(Class.getText());
		}

}