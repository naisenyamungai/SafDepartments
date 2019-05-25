package models;

import java.util.ArrayList;

public class Department {

    private String departmentName;
    private String departmentAbbreviation;
    private String divisionName;
    private static ArrayList<Department> mInstances = new ArrayList<>();

    public Department (String departmentAbbreviation, String departmentName, String divisionName){
        this.departmentName = departmentName;
        this.departmentAbbreviation = departmentAbbreviation;
        this.divisionName = divisionName;
        mInstances.add(this);
    }

    public String getName(){
        return departmentName;
    }

    public String getAbb(){ return departmentAbbreviation;}

    public String getDivision(){ return divisionName;}


    public static ArrayList<Department> getAll(){
        return mInstances;
    }



    public static void clearAllDepartments(){
        mInstances.clear();
    }



}

