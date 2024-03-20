import java.util.Scanner;
public class AppStart{
    public static void main(String[] args){
        ResultSheet r1 = new ResultSheet("B22110006067", "Khizer");

        System.out.print("Enter amount of courses: ");
        Scanner myScanner = new Scanner(System.in);
        int amountOfCourses = myScanner.nextInt();
        r1.setAmountOfCourses(amountOfCourses);

        for(int i = 0; i < amountOfCourses; i++){
            System.out.print("Enter marks (Course " + (i+1) + "): ");
            r1.addMarks(myScanner.nextInt());
        }

        r1.displayResults();

        myScanner.close();
    }
}