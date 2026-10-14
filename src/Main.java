import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = "", id = "";
        int courses = 0;
        double[] marks = new double[0];

        while (true) {
            System.out.println("\nMenu:\n1. Enter Student Details\n2. Enter Marks\n3. Display Marks Info.\n4. Display Student Details\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter Student Name: ");
                String raw = sc.nextLine().trim();
                String[] parts = raw.split("\\s+");
                name = "";
                for (String w : parts) {
                    if (!w.isEmpty()) {
                        name += w.substring(0, 1).toUpperCase() + w.substring(1).toLowerCase() + " ";
                    }
                }
                name = name.trim();

                while (true) {
                    System.out.print("Enter ID Number: ");
                    id = sc.nextLine().trim();
                    if (id.matches("4\\d{8}")) break;
                    System.out.println("Invalid ID! Must start with 4 and be 9 digits.");
                }

                while (true) {
                    System.out.print("How many courses last semester? ");
                    courses = sc.nextInt();
                    if (courses > 0 && courses <= 5) break;
                    System.out.println("Number of courses must not exceed 5!");
                }
                marks = new double[courses];

            } else if (choice == 2) {
                System.out.println("Enter Marks for " + courses + " subjects:");
                for (int i = 0; i < courses; i++) {
                    while (true) {
                        double m = sc.nextDouble();
                        if (m >= 0 && m <= 100) {
                            marks[i] = m;
                            break;
                        }
                        System.out.println("Mark must be between 0 and 100!");
                    }
                }
                displayInfo(marks);

            } else if (choice == 3) {
                displayInfo(marks);

            } else if (choice == 4) {
                System.out.println("Name: " + name);
                System.out.println("KKU ID: " + id);
                displayInfo(marks);

            } else if (choice == 5) {
                break;
            }
        }
        sc.close();
    }

    static void displayInfo(double[] marks) {
        if (marks.length == 0) return;
        System.out.println("\nCourse\tMark\tP/F");
        double sum = 0, max = marks[0], min = marks[0];
        for (int i = 0; i < marks.length; i++) {
            sum += marks[i];
            if (marks[i] > max) max = marks[i];
            if (marks[i] < min) min = marks[i];
            System.out.println((i + 1) + "\t" + (int)marks[i] + "\t" + (marks[i] >= 60 ? "Pass" : "Fail"));
        }
        System.out.println("Avg: " + (sum / marks.length));
        System.out.println("Max: " + (int)max);
        System.out.println("Min: " + (int)min);
    }
}