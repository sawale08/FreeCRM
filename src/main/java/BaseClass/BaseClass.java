package BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utils.TestUtil;

public class BaseClass {

	public static WebDriver driver;
	public static String browser;
	public Properties prop;
	public void initialization()
	{
		FileInputStream fs = null;
		try {
			fs = new FileInputStream("C:\\Users\\Croma-PC\\workspace\\EndToEndAutomation\\src\\main\\java\\Utils\\UserDetails");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if((prop.getProperty("browser")).equals("Firefox"))
		{
			System.setProperty("webdriver.firefox.driver", "C:\\Users\\Croma-PC\\workspace\\EndToEndAutomation\\src\\test\\resources\\Driver\\firefoxdriver.exe");
			driver = new ChromeDriver();
			driver.get(prop.getProperty("url"));
		} else if(prop.getProperty("browser").equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Croma-PC\\workspace\\EndToEndAutomation\\src\\test\\resources\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(prop.getProperty("url"));
			
		}
		
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
			
		}
		
	}

	/*
public class ReadPropertiesFileTest {
   public static void main(String args[]) throws IOException {
      Properties prop = readPropertiesFile("credentials.properties");
      System.out.println("username: "+ prop.getProperty("username"));
      System.out.println("password: "+ prop.getProperty("password"));
   }
   public static Properties readPropertiesFile(String fileName) throws IOException {
      FileInputStream fis = null;
      Properties prop = null;
      try {
         fis = new FileInputStream(fileName);
         prop = new Properties();
         prop.load(fis);
      } catch(FileNotFoundException fnfe) {
         fnfe.printStackTrace();
      } catch(IOException ioe) {
         ioe.printStackTrace();
      } finally {
         fis.close();
      }
      return prop;
   }
	 */

