package models;
public class OrganModel implements Identifiable {
    private String BloodType;
    private int Size;
    private String ExpirationDate;
    private String Type;
    private int PatientID;
    private int DonorID;
    private int OrganID;
    @Override
    public long getId() {
        return OrganID;
    }

    @Override
    public void setId(long id) {
        this.OrganID = (int) id;
    }

    public String getBloodType(){return BloodType;}
    public void setBloodType(String BloodType){this.BloodType = BloodType;}

    public int getSize(){return Size;}
    public void setSize(int Size){this.Size = Size;}

    public String getExpirationDate(){return ExpirationDate;}
    public void setExpirationDate(String ExpirationDate){this.ExpirationDate = ExpirationDate;}

    public String getType(){return Type;}
    public void setType(String Type){this.Type = Type;}

    public int getPatientID(){return PatientID;}
    public void setPatientID(int PatientID){this.PatientID = PatientID;}

    public int getDonorID(){return DonorID;}
    public void setDonorID(int DonorID){this.DonorID = DonorID;}

}
