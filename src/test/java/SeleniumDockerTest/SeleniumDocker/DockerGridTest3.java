package SeleniumDockerTest.SeleniumDocker;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class DockerGridTest3 {

	@Test
	public void test3() throws MalformedURLException{
		// TODO Auto-generated method stub
		DesiredCapabilities desCap =DesiredCapabilities.chrome();
		URL url = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url,desCap);
		driver.get("https://Google.com");
		System.out.println(driver.getTitle());
		
	}

}
