import java.util.ArrayList;
public class ResultSheet extends IDcard{
    private int amountOfCourses;
    ArrayList<Integer> marksList = new ArrayList<Integer>();

    public void addMarks(int marks){
        this.marksList.add(marks);
    }

    public void setAmountOfCourses(int c){
        this.amountOfCourses = c;
    }

    public int getAmountOfCourses(){
        return amountOfCourses;
    }

    private double getGPA(int marks){
        if(marks < 50){
            return 0.0;
        }
        else if(marks >= 50 && marks < 53){
            return 1.0;
        }
        else if(marks >= 53 && marks < 57){
            return 1.4;
        }
        else if(marks >= 57 && marks < 61){
            return 1.8;
        }
        else if(marks >= 61 && marks < 64){
            return 2.0;
        }
        else if(marks >= 64 && marks < 68){
            return 2.4;
        }
        else if(marks >= 68 && marks < 71){
            return 2.8;
        }
        else if(marks >= 71 && marks < 75){
            return 3.0;
        }
        else if(marks >= 75 && marks < 80){
            return 3.4;
        }
        else if(marks >= 80 && marks < 85){
            return 3.8;
        }
        else{
            return 4.0;
        }
    }
    
    public double calculateCGPA(){
        double gpaTotal = 0;
        for (int x=0; x < this.amountOfCourses; x++){
            int markScore = marksList.get(x);
            gpaTotal += this.getGPA(markScore);
        }
        return (gpaTotal/this.amountOfCourses);
    }

    public void displayResults(){
        String formattedCGPA = String.format("%.2f",this.calculateCGPA());
        System.out.print("Name: "+super.getName()+"\n"+"Seat No: "+super.getSeatNo()+"\n"+
        "Year of admission: "+super.getYearOfAdmission()+"\n"+"CGPA: "+formattedCGPA);
    }

    ResultSheet(String sNo, String name){
        super(sNo, name);
    }
}