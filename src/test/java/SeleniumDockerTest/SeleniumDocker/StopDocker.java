package SeleniumDockerTest.SeleniumDocker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StopDocker {

	
	public void stopDocker() throws IOException, InterruptedException {
		boolean flag = false;
		Runtime runtime = Runtime.getRuntime();
		runtime.exec("cmd /c start stopDocker.bat");
		Calendar cal = Calendar.getInstance();
		Thread.sleep(10000);
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
				if (currentLine.contains("selenium-hub exited")) {
					System.out.println("Grid is closed");
					flag = true;
					break;
				}
				currentLine = reader.readLine();
			}
			reader.close();

		}
		Assert.assertTrue(flag);
		Thread.sleep(15000);
		File delteFile = new File("logs.txt");
		if(delteFile.delete()) {
			System.out.println("Log file is deleted");
		}

	}

}
