import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int choice;

        do
        {
            System.out.println("\n--- Student Data Entry Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search by PRN");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            try
            {
                switch (choice)
                {
                    case 1:
                        System.out.print("Enter PRN: ");
                        long prn = sc.nextLong();
                        sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Dept: ");
                        String dept = sc.nextLine();
                        System.out.print("Enter Batch: ");
                        String batch = sc.nextLine();
                        System.out.print("Enter CGPA: ");
                        double cgpa = sc.nextDouble();
                        Student student = new Student(prn, name, dept, batch, cgpa);
                        StudentOperations.addStudent(student);
                        break;
                    case 2:
                        StudentOperations.displayAllStudents();
                        break;
                    case 3:
                        System.out.print("Enter PRN to search: ");
                        long prnSearch = sc.nextLong();
                        StudentOperations.searchByPRN(prnSearch);
                        break;
                    case 4:
                        System.out.print("Enter PRN to update: ");
                        long prnUpdate = sc.nextLong();
                        sc.nextLine();
                        System.out.print("Enter New Name: ");
                        String newName = sc.nextLine();
                        System.out.print("Enter New Dept: ");
                        String newDept = sc.nextLine();
                        System.out.print("Enter New Batch: ");
                        String newBatch = sc.nextLine();
                        System.out.print("Enter New CGPA: ");
                        double newCgpa = sc.nextDouble();
                        sc.nextLine();
                        StudentOperations.updateStudent(prnUpdate, newName, newDept, newBatch, newCgpa);
                        break;
                    case 5:
                        System.out.print("Enter PRN to delete: ");
                        long prnDelete = sc.nextLong();
                        StudentOperations.deleteStudent(prnDelete);
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
            catch (Exception e)
            {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 6);
    }
}