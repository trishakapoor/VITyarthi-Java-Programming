package utils;

import models.Assignment;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class FileHandler {

    public static void save(List<Assignment> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/assignments.txt"))) {
            for (Assignment a : list) {
                bw.write(a.toString());
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println("Error saving file.");
        }
    }

    public static List<Assignment> load() {
        List<Assignment> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("data/assignments.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                list.add(new Assignment(
                        parts[0],
                        parts[1],
                        LocalDate.parse(parts[2]),
                        parts[3]
                ));
            }
        } catch (Exception e) {
            System.out.println("No previous data found.");
        }
        return list;
    }
}
