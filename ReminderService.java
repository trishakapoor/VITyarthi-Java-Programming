package services;

import models.Assignment;
import java.time.LocalDate;
import java.util.List;

public class ReminderService {

    public static void showUpcoming(List<Assignment> list) {
        for (Assignment a : list) {
            if (a.getDeadline().isAfter(LocalDate.now())) {
                System.out.println("Upcoming: " + a.display());
            }
        }
    }

    public static void showOverdue(List<Assignment> list) {
        for (Assignment a : list) {
            if (a.getDeadline().isBefore(LocalDate.now())) {
                System.out.println("Overdue: " + a.display());
            }
        }
    }
}
