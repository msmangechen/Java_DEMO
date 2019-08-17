package com.mercury.java_core.shallow_deep;

public class CloneChild implements Cloneable {

    private String field;


    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }


    @Override
    protected Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}