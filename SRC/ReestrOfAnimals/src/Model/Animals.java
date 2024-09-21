package Model;

import java.time.*;
import java.util.*;
import java.time.format.DateTimeFormatter;


abstract class Animals {
    String name;
    private LocalDate birthDate;
    HashMap <String, String> commands;
    private int id;
    private int age;

    abstract void addCommand(String key, String move);
    abstract String getCommand();
    abstract String execCommand(String key);
    abstract String getName();
    abstract String getYaerBith();


    int getAge(){
        return this.age;
    }
    LocalDate getBirbirthDate(){
        return this.birthDate;
    }
}
