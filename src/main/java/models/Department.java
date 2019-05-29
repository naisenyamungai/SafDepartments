package models;

import java.util.ArrayList;

public class Department {

    private String departmentName;
    private String departmentAbbreviation;
    private String divisionName;

    private String sectionName;
    private String yourJobTitle;
    private String employeeName;
    private String employeeNumber;
    private String yourResponsibilities;
    private int id;
    private static ArrayList<Department> mInstances = new ArrayList<>();
    private ArrayList<String> sections = new ArrayList();
// get(dep/:id/section/new)
// dep.getSections().add(section)

    public Department(){};

    public Department (String departmentAbbreviation, String departmentName, String divisionName, String sectionName){
        this.departmentName = departmentName;
        this.departmentAbbreviation = departmentAbbreviation;
        this.divisionName = divisionName;
        this.sectionName = sectionName;
        this.yourJobTitle = yourJobTitle;
        this.employeeName = employeeName;
        this.employeeNumber = employeeNumber;
        this.yourResponsibilities = yourResponsibilities;
        mInstances.add(this);
        this.id = mInstances.size();

    }

    public ArrayList<String> getSections() {
        return sections;
    }


    public String getName(){
        return departmentName;
    }

    public String getAbb(){ return departmentAbbreviation;}

    public String getDivision(){ return divisionName;}

    public String getSection(){return sectionName;}

    public String getTitle(){return yourJobTitle;}

    public String getEmployeeName(){return employeeName;}

    public String getEmployeeNumber(){return employeeNumber;}

    public String getResponsibilities(){return yourResponsibilities;}

    public int getId(){return id;}


    public static ArrayList<Department> getAll(){
        return mInstances;
    }


    public static void clearAllDepartments(){
        mInstances.clear();
    }

    public static Department findById(int id){
        return mInstances.get(id-1);
    }

    public void update(String departmentAbbreviation, String departmentName, String divisionName, String sectionName){
        this.departmentName = departmentName;
        this.departmentAbbreviation = departmentAbbreviation;
        this.divisionName = divisionName;
        this.sectionName = sectionName;
        this.yourJobTitle = yourJobTitle;
        this.employeeName = employeeName;
        this.employeeNumber = employeeNumber;
        this.yourResponsibilities = yourResponsibilities;
        mInstances.add(this);
    }


}

