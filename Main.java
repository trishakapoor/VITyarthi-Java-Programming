import models.Assignment;
import services.*;
import utils.*;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        AssignmentManager manager = new AssignmentManager();
        manager.getAllAssignments().addAll(FileHandler.load());

        while (true) {
            System.out.println("\n===== ASSIGNMENT DEADLINE MANAGER =====");
            System.out.println("1. Add Assignment");
            System.out.println("2. View All");
            System.out.println("3. Upcoming");
            System.out.println("4. Overdue");
            System.out.println("5. Delete");
            System.out.println("6. Exit");

            int choice = InputHelper.getInt("Enter choice: ");

            switch (choice) {
                case 1:
                    String title = InputHelper.getString("Title: ");
                    String subject = InputHelper.getString("Subject: ");
                    String date = InputHelper.getString("Deadline (YYYY-MM-DD): ");
                    String priority = InputHelper.getString("Priority: ");

                    manager.addAssignment(new Assignment(
                            title,
                            subject,
                            LocalDate.parse(date),
                            priority
                    ));
                    break;

                case 2:
                    manager.sortByDeadline();
                    for (Assignment a : manager.getAllAssignments()) {
                        System.out.println(a.display());
                    }
                    break;

                case 3:
                    ReminderService.showUpcoming(manager.getAllAssignments());
                    break;

                case 4:
                    ReminderService.showOverdue(manager.getAllAssignments());
                    break;

                case 5:
                    int index = InputHelper.getInt("Enter index to delete: ");
                    manager.deleteAssignment(index);
                    break;

                case 6:
                    FileHandler.save(manager.getAllAssignments());
                    System.out.println("Saved. Exiting...");
                    return;
            }
        }
    }
}
