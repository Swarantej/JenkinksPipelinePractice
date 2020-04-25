package SeleniumDockerTest.SeleniumDocker;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DockerGridTest1 {

	@BeforeTest
	public void startDockerScale() throws IOException, InterruptedException {
		File delteFile = new File("logs.txt");
		if(delteFile.delete()) {
			System.out.println("Log file is deleted");
		}
		StartDocker sd = new StartDocker();
		sd.startDocker();
	}
	
	@AfterTest
	public void stopDocker() throws IOException, InterruptedException {
		StopDocker stopDckr = new StopDocker();
		stopDckr.stopDocker();
	}
	
	
	@Test
	public void test1() throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		DesiredCapabilities desCap =DesiredCapabilities.chrome();
		URL url = new URL("http://localhost:4444/wd/hub");
		
		
		
		RemoteWebDriver driver = new RemoteWebDriver(url,desCap);
		driver.get("https://hyperledger.org");
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		
	}

}
