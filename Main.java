import java.util.*;

class Student {
    int id;
    String name;
    int age;

    Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1 Add Student");
            System.out.println("2 View Students");
            System.out.println("3 Delete Student");
            System.out.println("4 Search Student");
            System.out.println("5 Update Student");
            System.out.println("6 Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    list.add(new Student(id, name, age));
                    System.out.println("✅ Student Added Successfully");
                    break;

                case 2:
                    if (list.isEmpty()) {
                        System.out.println("⚠ No students found");
                    } else {
                        System.out.println("\nID\tName\tAge");
                        for (Student s : list) {
                            System.out.println(s.id + "\t" + s.name + "\t" + s.age);
                        }
                        System.out.println("Total Students: " + list.size());
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();

                    boolean removed = list.removeIf(s -> s.id == did);

                    if (removed)
                        System.out.println("✅ Student Deleted");
                    else
                        System.out.println("❌ Student Not Found");
                    break;

                case 4:
                    System.out.print("Enter ID to search: ");
                    int sid = sc.nextInt();

                    boolean found = false;
                    for (Student s : list) {
                        if (s.id == sid) {
                            System.out.println("Found → " + s.id + " " + s.name + " " + s.age);
                            found = true;
                        }
                    }
                    if (!found)
                        System.out.println("❌ Student Not Found");
                    break;

                case 5:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    boolean updated = false;
                    for (Student s : list) {
                        if (s.id == uid) {
                            System.out.print("Enter New Name: ");
                            s.name = sc.nextLine();
                            System.out.print("Enter New Age: ");
                            s.age = sc.nextInt();
                            updated = true;
                            System.out.println("✅ Student Updated");
                        }
                    }
                    if (!updated)
                        System.out.println("❌ Student Not Found");
                    break;

                case 6:
                    System.out.println("Exiting Program...");
                    System.exit(0);
            }
        }
    }
}
