package SeleniumDockerTest.SeleniumDocker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StartDocker {

	public void startDocker() throws IOException, InterruptedException {
		boolean flag = false;
		Runtime runtime = Runtime.getRuntime();
		runtime.exec("cmd /c start DockerUp.bat");
		Calendar cal = Calendar.getInstance();
		Thread.sleep(20000);
		cal.add(Calendar.SECOND, 30);
		long stopTime = cal.getTimeInMillis();
		String file = "logs.txt";
		while (System.currentTimeMillis() < stopTime) {
			if (flag) {
				break;
			}
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String currentLine = reader.readLine();
			while (currentLine != null && !flag) {
				if (currentLine.contains("Registering the node to the hub")) {
					System.out.println("Grid is up");
					flag = true;
					break;
				}
				currentLine = reader.readLine();
			}
			reader.close();

		}
		Assert.assertTrue(flag);
		runtime.exec("cmd /c start scaleBrowsers.bat");
		Thread.sleep(15000);

	}

}
