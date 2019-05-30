package models;

import java.util.ArrayList;

public class Section{
    private String sectionName;
    private static ArrayList<Section> mInstances = new ArrayList<>();

    public Section(String sectionName){
        this.sectionName = sectionName;
        mInstances.add(this);
    }

    public String getSection(){return sectionName;}

//    public static ArrayList<Section> getAll(){
//        return mInstances;
//    }
//
//    public static void clearAllSections(){
//        mInstances.clear();
//    }
//
//    public void update(String sectionName){
//        this.sectionName = sectionName;
//        mInstances.add(this);
//    }

}