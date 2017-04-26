package ru.example.checklist ;



public class CheckItem {

    private String option;
    private String value;

    public CheckItem(String option, String value){

        this.option =option;
        this.value = value;


    }

    public String getValue() {
        return this.value;
    }

    public String getOption() {
        return this.option;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setOption(String option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return option + ", "+ value + "; ";
    }
}
