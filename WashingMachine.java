package com.Java.Project;

import java.util.Scanner;

public class WashingMachine {
    
    // Constants for different wash cycle options
    private static final int DELICATE = 1;
    private static final int NORMAL = 2;
    private static final int HEAVY_DUTY = 3;
    
    // Constants for the duration of each wash cycle (in minutes)
    private static final int DELICATE_DURATION = 30;
    private static final int NORMAL_DURATION = 45;
    private static final int HEAVY_DUTY_DURATION = 60;
    
    // Variables to store the current temperature and time remaining for the wash cycle
    private static int currentTemperature = 0;
    private static int remainingTime = 0;
    
    public static void main(String[] args) {
        // Display a welcome message
        System.out.println("Welcome to the washing machine simulator!");
        
        // Display the available wash cycle options
        System.out.println("Please select a wash cycle:");
        System.out.println("1. Delicate");
        System.out.println("2. Normal");
        System.out.println("3. Heavy duty");
        
        // Prompt the user to enter a wash cycle option
        Scanner scanner = new Scanner(System.in);
        int washCycleOption = scanner.nextInt();
        
        // Determine the duration and temperature for the selected wash cycle
        int cycleDuration = 0;
        switch (washCycleOption) {
            case DELICATE:
                cycleDuration = DELICATE_DURATION;
                currentTemperature = 30;
                break;
            case NORMAL:
                cycleDuration = NORMAL_DURATION;
                currentTemperature = 40;
                break;
            case HEAVY_DUTY:
                cycleDuration = HEAVY_DUTY_DURATION;
                currentTemperature = 60;
                break;
            default:
                System.out.println("Invalid option selected.");
                System.exit(0);
        }
        
        // Display the duration and temperature for the selected wash cycle
        System.out.println("Selected wash cycle: " + washCycleOption);
        System.out.println("Cycle duration: " + cycleDuration + " minutes");
        System.out.println("Temperature: " + currentTemperature + " degrees Celsius");
        
        // Prompt the user to start the wash cycle
        System.out.println("Press 's' to start the wash cycle.");
        String start = scanner.next();
        if (start.equals("s")) {
            remainingTime = cycleDuration;
            System.out.println("Wash cycle started.");
        } else {
            System.out.println("Wash cycle cancelled.");
            System.exit(0);
        }
        
        // Run the wash cycle
        while (remainingTime > 0) {
            // Display the time remaining and current temperature
            System.out.println("Time remaining: " + remainingTime + " minutes");
            System.out.println("Temperature: " + currentTemperature + " degrees Celsius");
            
            // Adjust the temperature as necessary
            if (currentTemperature < 30) {
                currentTemperature = 30;
                System.out.println("Temperature adjusted to " + currentTemperature + " degrees Celsius");
            } else if (currentTemperature > 60) {
                currentTemperature = 60;
                System.out.println("Temperature adjusted to " + currentTemperature + " degrees Celsius");
            }
            
            // Decrease the remaining time by 1 minute and wait for 1 minute
            remainingTime--;
            try {
                Thread.sleep(1000 * 60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        // Display a message indicating that the wash cycle is complete
        System.out.println("Wash cycle complete. Enjoy your day!");
}
}