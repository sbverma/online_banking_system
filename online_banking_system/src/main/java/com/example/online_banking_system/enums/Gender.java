package com.example.online_banking_system.enums;

public enum Gender {
    MALE("MALE"),
    FEMALE("FEMALE"),
    OTHER("OTHER");

    private String type;

    Gender(String type) {
        this.type = type;
    }

    public static Gender getGenderFromString(String genderString) {
        for (Gender gender : values()) {
            if(gender.type.equals(genderString)) {
                return gender;
            }
        }
        return null;
    }
}
