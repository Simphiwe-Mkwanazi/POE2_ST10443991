/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registration;

/**
 *
 * @author lab_services_student
 */
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Tasks {

    public static void main(String[] args) {
        // Create an instance of Registration to handle user authentication
        boolean loggedin = false;
        // Used boolean to break code so that it may run 
        Registration userAuth = new Registration();
        userAuth.registerUser();
        
        loggedin = userAuth.loginUser(userAuth.username, userAuth.password);
        
        // Check if the user is logged in
        if (loggedin) {
            // Declaring variables for task management
            String Task_Name;
            String Task_Decision;
            String Developer_Name;
            String Developer_Surname;
            String Task_Status;

            int Task_Status_Question = 0;
            int Task_Duration = 0;
            int i = 0;
            int Total_Duration = 0;

            // List to store task information
            ArrayList<String> taskList = new ArrayList<>();

            // Prompting user for choice
            int choice = Integer.parseInt(JOptionPane.showInputDialog("1. Add Tasks, 2. Show Report, 3. Quit"));

            // Creating an instance of taskManager
            TaskManager taskManager = new TaskManager();

            // Handling user choice
            if (choice == 1) {
                // Prompting user for number of tasks
                int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks:"));
                // Loop to add tasks
                while (i < numTasks) {
                    // Declaring variables for task details
                    String name = "";
                    String TaskDescription = "";
                    String Duration = "";
                    String FirstLetters = "";
                    String LastLetters = "";

                    int num = 0;

                    // Prompting user for task details
                    Task_Name = JOptionPane.showInputDialog("Enter the task name");
                    Task_Decision = JOptionPane.showInputDialog("Give a description of your task");
                    Developer_Name = JOptionPane.showInputDialog("Enter your name");
                    Developer_Surname = JOptionPane.showInputDialog("Enter your surname");

                    Task_Duration = Integer.parseInt(JOptionPane.showInputDialog("How many hours is your task going to take"));
                    Task_Status_Question = Integer.parseInt(JOptionPane.showInputDialog("What is the current status of your task: 1. To Do, 2. Done, 3. Doing"));

                    // Mapping status code to status string
                    if (Task_Status_Question == 1) {
                        Task_Status = "To Do";
                    } else if (Task_Status_Question == 2) {
                        Task_Status = "Done";
                    } else if (Task_Status_Question == 3) {
                        Task_Status = "Doing";
                    } else {
                        Task_Status = "To Do";
                    }

                    // Passing task details to taskManager
                    taskManager.TaskDescription(Task_Decision);
                    taskManager.TaskID(FirstLetters, LastLetters, num);
                    taskManager.TaskDetails(Task_Name, Task_Decision, Developer_Name, Developer_Surname, Task_Duration, num, Total_Duration);
                    Total_Duration = taskManager.returnTotalHours(Task_Duration, Total_Duration);
                    
                    // Storing task information in the list
                    taskList.add("Task Name: " + Task_Name + "\nTask Description: " + Task_Decision + "\nDeveloper Name: " + Developer_Name + " " + Developer_Surname + "\nTask Duration: " + Task_Duration + " hours\nTask Status: " + Task_Status + "\n");

                    i++;
                }

                // Display all tasks
                StringBuilder tasks = new StringBuilder();
                for (String task : taskList) {
                    tasks.append(task).append("\n");
                }
                JOptionPane.showMessageDialog(null, tasks.toString(), "All Tasks", JOptionPane.INFORMATION_MESSAGE);

                JOptionPane.showMessageDialog(null, "Total Duration: " + Total_Duration);

            } else if (choice == 2) {
                // Placeholder for future functionality
                JOptionPane.showMessageDialog(null, "Coming Soon.");
            } else if (choice == 3) {
                // Logging out
                JOptionPane.showMessageDialog(null,"You have now been logged out");
            } else if (choice > 3) {
                // Invalid selection
                JOptionPane.showMessageDialog(null, "Invalid selection");
            }

            // Displaying farewell message
            JOptionPane.showMessageDialog(null, "Thank you for using EasyKanban");
        } else {
            JOptionPane.showMessageDialog(null, "Login unsuccessful. Please try again.");
        }
    }
}

class TaskManager {
    public void TaskDescription(String description) {
        // Process task description
    }

    public void TaskID(String firstLetters, String lastLetters, int num) {
        // Generate and process task ID
    }

    public void TaskDetails(String name, String description, String devName, String devSurname, int duration, int num, int totalDuration) {
        // Process and display task details
    }

    public int returnTotalHours(int taskDuration, int totalDuration) {
        return totalDuration + taskDuration;
    }
} 

