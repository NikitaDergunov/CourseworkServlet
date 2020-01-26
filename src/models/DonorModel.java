package models;

public class DonorModel implements Identifiable{
    private boolean Sex;
    private String BloodType;
    private String Status;
    private int OrganID;
    private int DonorID;
    @Override
    public long getId() {return DonorID;}

    @Override
    public void setId(long id) { this.DonorID =(int) id; }

    public boolean getSex(){return Sex;}
    public void setSex(boolean Sex){this.Sex = Sex;}

    public String getBloodType(){return BloodType;}
    public void setBloodType(String BloodType){this.BloodType = BloodType;}

    public String getStatus(){return Status;}
    public void setStatus(String Status){this.Status=Status;}

    public int getOrganID(){return OrganID;}
    public void setOrganID(int OrganID){this.OrganID=OrganID;}
}
