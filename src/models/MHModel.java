package models;
public class MHModel implements Identifiable{
    private String History;
    private int PatientID;
    private String DateOfAdmission;
    @Override
    public long getId() {return PatientID;}

    @Override
    public void setId(long id) {this.PatientID = (int) id;}

    public String getHistory(){return History;}
    public void setHistory(String History){this.History = History;}

    public String getDateOfAdmission(){return DateOfAdmission;}
    public void setDateOfAdmission(String DateOfAdmission){this.DateOfAdmission = DateOfAdmission;}
}
