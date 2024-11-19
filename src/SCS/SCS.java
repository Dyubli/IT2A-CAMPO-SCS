package SCS;

import java.util.Scanner;

public class SCS {

    public static void main(String[] args) {
        boolean exit = true;
        Scanner sc = new Scanner(System.in);
        String resp;

        do {
            System.out.println("");
           
            System.out.println("+-----------------------+");
            System.out.println("|       MAIN MENU       |");
            System.out.println("|-----------------------|");
            System.out.println("| 1. Student            |");
            System.out.println("| 2. Medicine           |");
            System.out.println("| 3. Clinic RecordsLog  |");
            System.out.println("| 4. Exit               |");
            System.out.println("+-----------------------+");

            int choice;
            while (true) {
                System.out.print("Enter choice: ");
                if (sc.hasNextInt()) {
                    choice = sc.nextInt();
                    if (choice >= 1 && choice <= 4) {
                        break;
                    } else {
                        System.out.println("Please enter a number between 1 and 4.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid number.");
                    sc.next();
                }
            }

            switch (choice) {
                case 1:
                    Student st = new Student();
                    st.mainStudent();
                    break;
                case 2:
                    Medicine md = new Medicine();
                    md.mainMedicine();
                    break;
                case 3:
                    ClinicRecordsLogs crl = new ClinicRecordsLogs();
                    crl.mainRecords();
                    break;
                case 4:
                    System.out.println("Thank YOu!");
                    System.exit(0);
            }
            
         System.out.print("Do you want to Continue? Yes or No: ");
            resp = sc.next();
            
            while(!resp.equalsIgnoreCase("yes") && !resp.equalsIgnoreCase("no")) {
                System.out.println("Invalid input, Enter again: ");
                resp = sc.next();
            }
           
            } while(resp.equalsIgnoreCase("yes"));
        
            System.out.println("\nThank you!");
                
    }
}
