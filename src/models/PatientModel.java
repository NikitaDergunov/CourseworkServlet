package models;

public class PatientModel implements Identifiable {
    private String Name;
    private int PatientID;
    private boolean Sex;
    private String BloodType;
    private  int Severity;
    private String OrganNeded;

    @Override
    public long getId() {return PatientID;}

    @Override
    public void setId(long id) { this.PatientID =(int) id; }

    public String getName(){return Name;}
    public void setName(String Name){this.Name = Name;}

    public boolean getSex(){return Sex;}
    public void setSex(boolean Sex){this.Sex = Sex;}

    public String getBloodType(){return BloodType;}
    public void setBloodType(String BloodType){this.BloodType = BloodType;}

    public int getSeverity(){return Severity;}
    public void setSeverity(int Severity){this.Severity = Severity;}

    public String getOrganNeded(){return OrganNeded;}
    public void setOrganNeded(String OrganNeded){this.OrganNeded =OrganNeded;}
}
