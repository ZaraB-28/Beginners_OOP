package com.example.filehandling;

public class UserInfo {

    private String name;
    private String province;
    private String gender;
    private int ID;
    private String dob;

    public UserInfo(String name, String province, String gender, int ID, String dob) {
        this.name = name;
        this.province = province;
        this.gender = gender;
        this.ID = ID;
        this.dob = dob;
    }

    public UserInfo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }


}


