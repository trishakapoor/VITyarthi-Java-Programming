package services;

import models.Assignment;
import java.util.*;

public class AssignmentManager {
    private List<Assignment> assignments = new ArrayList<>();

    public void addAssignment(Assignment a) {
        assignments.add(a);
    }

    public List<Assignment> getAllAssignments() {
        return assignments;
    }

    public void deleteAssignment(int index) {
        if (index >= 0 && index < assignments.size()) {
            assignments.remove(index);
        }
    }

    public void sortByDeadline() {
        assignments.sort(Comparator.comparing(Assignment::getDeadline));
    }
}
