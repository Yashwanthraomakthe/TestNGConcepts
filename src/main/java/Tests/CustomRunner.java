package Tests;

import java.util.List;

import org.testng.TestNG;

public class CustomRunner {
	public static void main(String[] args) {
        TestNG testng = new TestNG();
        testng.setTestSuites(List.of("C:\\Users\\yashwanth_makthe\\Desktop\\YashwanthProjects\\TestNgHomeTask\\testng.xml"));
        testng.run();
    }
}