import java.util.Scanner;

public class LagbajaSchoolApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int passMark = 50;

        System.out.print("How many classes do you want to enter?: ");
        int numClasses = input.nextInt();
        while (numClasses < 1) {
            System.out.print("Enter at least 1 class: ");
            numClasses = input.nextInt();
        }
        input.nextLine();

        for (int classNumber = 0; classNumber < numClasses; classNumber++) {
            System.out.print("\nEnter name of Class " + (classNumber + 1) + ": ");
            String className = input.nextLine();

            System.out.print("Enter the number of students in " + className + ": ");
            int numStudents = input.nextInt();

            System.out.print("Enter the number of subjects: ");
            int numSubjects = input.nextInt();

        String[] studentNames = new String[numStudents];
        String[] subjectNames = new String[numSubjects];
        double[][] scores = new double[numStudents][numSubjects];
        input.nextLine();

        for (int count = 0; count < numSubjects; count++) {
            System.out.print("Enter name of Subject " + (count + 1) + ": ");
            subjectNames[count] = input.nextLine();
        }
       
        for (int index = 0; index < numStudents; index++) {
            System.out.print("\nEnter name of Student " + (index + 1) + ": ");
            studentNames[index] = input.nextLine();


            for (int count = 0; count < numSubjects; count++) {
                System.out.print("  Enter score for " + studentNames[index] + " in " + subjectNames[count] + " (0-100): ");

                int score = input.nextInt();
                while (score < 0 || score > 100) {
                    System.out.print("  Invalid. Score must be between 0 and 100: ");
                    score = input.nextInt();
                }
                input.nextLine();
                scores[index][count] = score;
                System.out.println("  Saving >>>>>>>>>>>>>>>>>>>>");
                System.out.println("  Saved successfully");
                
            }
        }
        double[] studentTotals = new double[numStudents];
        for (int index = 0; index < numStudents; index++) {
            for (int count = 0; count < numSubjects; count++) {
                studentTotals[index] += scores[index][count];
            }
        }



   
        System.out.println("\n==================================================================");
        System.out.println("                     LAGBAJA SCHOOLS STUDENT SUMMARY                 ");
        System.out.println("==================================================================");



        System.out.printf("%-15s", "Student");
        for (int count = 0; count < numSubjects; count++) {
            System.out.printf("%-12s", subjectNames[count]);
        }
        System.out.printf("%-10s%-10s%-10s\n", "Total", "Average", "POS");
        System.out.println("------------------------------------------------------------------");

        double classTotal = 0;        
        for (int index = 0; index < numStudents; index++) {
            System.out.printf("%-15s", studentNames[index]);
            for (int count = 0; count < numSubjects; count++) {
                System.out.printf("%-12.2f", scores[index][count]);
            }
                
            double studentAverage = studentTotals[index] / numSubjects;
            classTotal += studentTotals[index];
            
            int position = 1;
            for (int student = 0; student < numStudents; student++) {
                if (studentTotals[student] > studentTotals[index]) {
                    position++;
                }
            }

            System.out.printf("%-10.2f%-10.2f%-10d\n", studentTotals[index], studentAverage, position);
        }
        System.out.println("=====================================================================");

        System.out.println(" ================= SUBJECT SUMMARY =================");

        
        int hardestSubject = 0;
        int mostFails = 0;
        int easiestSubject = 0;
        int mostPasses = 0;

        for (int count = 0; count < numSubjects; count++) {
            int highestStudent = 0;
            int lowestStudent = 0;
            double subjectTotal = 0;
            int passes = 0;
            int fails = 0;

            for (int index = 0; index < numStudents; index++) {
                if (scores[index][count] > scores[highestStudent][count]) {
                    highestStudent = index;
                }
                if (scores[index][count] < scores[lowestStudent][count]) {
                    lowestStudent = index;
                }
                subjectTotal += scores[index][count];
                if (scores[index][count] >= passMark) {
                    passes++;
                } else {
                    fails++;
                }
            }

            if (fails > mostFails) {
                mostFails = fails;
                hardestSubject = count;
            }
            if (passes > mostPasses) {
                mostPasses = passes;
                easiestSubject = count;
            }

            System.out.println("\n" + subjectNames[count]);
            System.out.println("Highest scoring student is: " + studentNames[highestStudent] + " scoring " + scores[highestStudent][count]);
            System.out.println("Lowest scoring student is: " + studentNames[lowestStudent] + " scoring " + scores[lowestStudent][count]);
            System.out.println("Total Score is: " + subjectTotal);
            System.out.printf("Average score is: %.2f%n", subjectTotal / numStudents);
            System.out.println("Number of passes: " + passes);
            System.out.println("Number of Fails: " + fails);
        }
        
            System.out.println("\nThe hardest subject is " + subjectNames[hardestSubject] + " with " + mostFails + " failures");
            System.out.println("The easiest subject is " + subjectNames[easiestSubject] + " with " + mostPasses + " passes");
            System.out.println("Class total score is: " + classTotal);
            System.out.printf("Class Average score is: %.2f%n", classTotal / numStudents);
            System.out.println("==================================================================");
        }
    }
}


