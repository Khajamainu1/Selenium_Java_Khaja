package com.automation.reports;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AllureReports {

    public static Process allureServerProcess;
    public static void generateAndOpenAllureReport() {
        try {
            // Path to the Allure executable
            String allurePath = "C:/Users/khaja.mohinuddin/Downloads/allure-2.30.0/allure-2.30.0/bin/allure.bat";

            // Generate the Allure report
            Process generateProcess = new ProcessBuilder(allurePath, "generate", "allure-results", "--clean", "-o", "allure-report")
                    .inheritIO() // Inherit I/O to see output in console
                    .start();
            generateProcess.waitFor();

            // Open the Allure report
            allureServerProcess = new ProcessBuilder(allurePath, "open", "allure-report")
                    .inheritIO() // Inherit I/O to see output in console
                    .start();

            // Wait for a specific time before stopping the server (e.g., 10 minutes)
            TimeUnit.SECONDS.sleep(30);

            // Stop the Allure server
            allureServerProcess.destroy();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
