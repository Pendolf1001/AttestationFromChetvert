package Model;

import java.time.*;
import java.util.*;
import java.time.format.DateTimeFormatter;

class Donkey extends PackAnimals{
    private String name;
    private LocalDate birthDate;
    HashMap <String, String> commands;
    private int id;
    private int age;
    boolean zapryazhon;

    public Donkey(String name, String birthDate){
        this.name=name;
        setId();
        this.birthDate=setBirthdayDate(birthDate);
        commands=new HashMap<>();
        this.age=setAge();
        this.zapryazhon=false;
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
        if(zapryazhon){
            return String.format("%s; Donkey;  data rozhdenia: %s; Zapryazhon (%d years)",this.name, this.birthDate, this.age );
        }else{
            return String.format("%s; Donkey;  data rozhdenia: %s; Nezapryazhon (%d years)",this.name, this.birthDate, this.age );
        }
    }

    void addCommand(String key, String move){
        if (this.id%3==0){
            commands.put(key, "Uporno etogo ne delaet");
        }else{
            commands.put(key, move);
        }
    }

    String getCommand(){
        if(commands.keySet().isEmpty()){
            return String.format("%s poka ne znaet ni odnoy comandy",this.name);
        }else{
            Set <String> keys = commands.keySet();
            return keys.toString();
        }

    }

    String getYaerBith(){
        return Integer.toString(birthDate.getYear());
    }

    String execCommand(String key){
        String otv=commands.get(key);
        return otv;
    }

    void zapryach(){
        if(!zapryazhon){
            this.zapryazhon=true;
        }else{
            this.zapryazhon=false;
        }
    }

    String noPoshel(){
        if (zapryazhon){
            if (this.id%3==0){
                return String.format("%s upryamitsa i ne hochet nichego vezti", this.name);
            }else{
                return String.format("%s vezet telegu kuda vi ego napravlyaite", this.name);
            }
        }else{
            return "Ne Nokay tut, ne zapryagala";
        }
    }




}
