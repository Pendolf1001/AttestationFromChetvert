package Model;

import java.time.*;
import java.util.*;
import java.time.format.DateTimeFormatter;

class Dog extends Pets{
    private String name;
    private LocalDate birthDate;
    HashMap <String, String> commands;
    private int id;
    private int age;

    public Dog(String name, String birthDate){
        this.name=name;
        setId();
        this.birthDate=setBirthdayDate(birthDate);
        commands=new HashMap<>();
        this.age=setAge();
    }

    public int getId(){
        return this.id;
    }

    private  void setId(){
        Random rnd= new Random();
        this.id=rnd.nextInt((9999 - 1000) + 1) + 1000;
    }

    public String getName(){
        return this.name;
    }




    private LocalDate setBirthdayDate(String birthDate){
        DateTimeFormatter formatter;
        formatter= DateTimeFormatter.ofPattern("yyyy.MM.dd");
        return LocalDate.parse(birthDate, formatter);
    }


    public int setAge(){
        LocalDate date= LocalDate.now();
        int age=Period.between(birthDate, date).getYears();
        return age;
    }

    int getAge(){
        return this.age;
    }

    LocalDate getBirbirthDate(){
        return this.birthDate;
    }

    public String toString(){
        return String.format("%s; Dog  data rozhdenia: %s; (%d years)",this.name, this.birthDate, this.age );
    }


    void addCommand(String key, String move){
        commands.put(key, move);
    }

    String getCommand(){
        if(commands.keySet().isEmpty()){
            return String.format("%s poka ne znaet ni odnoy comandy",this.name);
        }else{
            Set <String> keys = commands.keySet();
            return keys.toString();
        }

    }

    public String execCommand(String key){
        return commands.get(key);
    }

    public String vzyatNaRuchki(){
        return String.format("%s prizhalsya k vam i vi ego gladite", this.name);
    }

    String getYaerBith(){
        return Integer.toString(birthDate.getYear());
    }


}
