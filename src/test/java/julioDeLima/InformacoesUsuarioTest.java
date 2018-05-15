package julioDeLima;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class InformacoesUsuarioTest {
	
	private WebDriver navegador;
	private String url;
	
	@Before
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Eduardo\\Programas\\ChromeDriver\\chromedriver.exe");
		navegador = new ChromeDriver();
		navegador.manage().window().maximize();
		url = "http://www.juliodelima.com.br/taskit";
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void testLoginUsuarioVálido() {
		navegador.get(url);
		WebElement SignIn = navegador.findElement(By.linkText("Sign in"));
		SignIn.click();
		//Estrutura utilizar um elemento superior
		WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));
		formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");
		formularioSignInBox.findElement(By.name("password")).sendKeys("123456");
		//
		navegador.findElement(By.linkText("SIGN IN")).click();
//		WebElement me = navegador.findElement(By.className("me"));
//		String textoNoElemento = me.getText();
//		assertEquals("Hi, Julio", textoNoElemento);
		WebElement me =  navegador.findElement(By.className("me"));
		me.click();
		WebElement moreDataAboutYou = navegador.findElement(By.linkText("MORE DATA ABOUT YOU"));
		moreDataAboutYou.click();
		WebElement addmoredata = navegador.findElement(By.xpath("/html/body/div[1]/div/div/div/div[4]/div[2]/button"));
		addmoredata.click();
		WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));
		//Estrutura ComboBox
		WebElement campoBox = popupAddMoreData.findElement(By.name("type"));
		new Select(campoBox).selectByVisibleText("Phone");
		//
		popupAddMoreData.findElement(By.name("contact")).sendKeys("+55 11 91234-5678");
		popupAddMoreData.findElement(By.linkText("SAVE")).click();
		
		WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
		
		//Validação
		String mensagem = mensagemPop.getText();
		assertEquals("Your contact has been added!", mensagem);
	}	
		
	@After
	public void tearsdown() {
//		navegador.quit();
	}

}