public class IDcard {
    private String seatNo;
    private String name;
    private int yearOfAdmission;
    
    public String getName() {
        return name;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setYearOfAdmission(){
        String sNo = this.getSeatNo();
        String offset = sNo.substring(1, 3);
        String yearInString = "20" + offset;
        this.yearOfAdmission = Integer.valueOf(yearInString);
    }

    public int getYearOfAdmission() {
        return yearOfAdmission;
    }

    IDcard(String sNo, String N){
        this.seatNo = sNo;
        this.name = N;
        setYearOfAdmission();
    }



}

