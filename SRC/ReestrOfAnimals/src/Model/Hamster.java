package Model;

import java.time.*;
import java.util.*;
import java.time.format.DateTimeFormatter;

class Hamster extends Pets{
    private String name;
    private LocalDate birthDate;
    HashMap <String, String> commands;
    private int id;
    private int age;

    public Hamster(String name, String birthDate){
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
        return String.format("%s; Hamster; data rozhdenia: %s; (%d years)",this.name, this.birthDate, this.age );
    }


    void addCommand(String key, String move){
        HashMap <Integer, String> truecommands=new HashMap<>();
        truecommands.put(0, "Nositsya po cletke");
        truecommands.put(1, "Smotrit na vas i morgaet, zevaet i prodolzhaet smotret");
        truecommands.put(2, "Umivaetsya");
        truecommands.put(3, "Shurshit");
        truecommands.put(4, "Zapihivaet chtoto za sheki");
        truecommands.put(5, "Lezhit v svoem domike i spit");
        truecommands.put(6, "Pishit");
        truecommands.put(7, "Begaet v kolese");
        truecommands.put(8, "Koposhitsa v opilkah");
        truecommands.put(9, "Smotrit v prostranstvo pered soboy s zadumchivym vidom, zabyv dazhe, chto neobhodimo postoyanno zhevat");
        Random rnd= new Random();
        int tk=rnd.nextInt((9 - 1) + 1) + 1;
        commands.put(key, truecommands.get(tk));
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
        String otv=commands.get(key);
        commands.remove(key);
        this.addCommand(key,"ChtoUgodno");
        return otv;
    }

    public String vzyatNaRuchki(){
        return String.format("%s postoznno norovit uscolznut iz vashih ruk", this.name);
    }

    String getYaerBith(){
        return Integer.toString(birthDate.getYear());
    }


}