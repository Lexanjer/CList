package ru.example.checklist ;


import java.util.ArrayList;

public class CheckListFull {

    private String name;
    private ArrayList<CheckItem> checkList;

    public CheckListFull(String name, ArrayList<CheckItem> checkList) {
        this.name = name;
        this.checkList = new ArrayList<CheckItem>(checkList) ;
    }


    public String getNameCheckList() {
        return name;
    }

    public void setNameCheckList(String name) {
        this.name = name;
    }

    public ArrayList<CheckItem> getCheckList() {
        return checkList;
    }

    public void setCheckList(ArrayList<CheckItem> checkList) {
        this.checkList = checkList;
    }

    @Override
    public String toString() {
        return  '{' + name + ": " +
                checkList +
                '}';
    }
}
