package model;

public enum TypeOfSex {
    MALE("MALE"),
    FEMALE("FEMALE"),
    X("X"),
    UNKNOWN("UNKNOWN");
    private String value;

    TypeOfSex(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }

}
