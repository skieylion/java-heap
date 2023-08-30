package project.java.domain;

import lombok.Getter;

@Getter
public enum RoomClass {
    ECONOMY("эконом"), BUSINESS("бизнес");

    private final String type;

    RoomClass(String type) {
        this.type = type;
    }

}
