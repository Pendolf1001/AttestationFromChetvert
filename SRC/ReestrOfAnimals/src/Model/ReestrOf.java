package Model;

import java.time.*;
import java.util.*;
import java.time.format.DateTimeFormatter;

class ReestrOf <T extends Animals>{
    private List <T> reestrOfAnimals;
    int countPets;
    int countPackAnimals;

    ReestrOf(){
        this.reestrOfAnimals=new ArrayList<>();
        int countPets=0;
        int countPackAnimals=0;
    }

    ReestrOf(T t){
        this.reestrOfAnimals=new ArrayList<>();
        this.reestrOfAnimals.add(t);
        int countPets=0;
        int countPackAnimals=0;
        addCounter(t);
    }

    void add(T t){
        if (!(reestrOfAnimals.contains(t))){
            reestrOfAnimals.add(t);
            addCounter(t);
        }
    }

    public String toString(){
        StringBuilder sb=new StringBuilder();
        if (reestrOfAnimals.isEmpty()){
            return "V reestre net zhivotnih";

        }else{
            int i=1;
            sb.append("Na danniy moment v resstre: \n");
            sb.append("vuchnyh zhivotnih:  " + Integer.toString(countPackAnimals)+"\n");
            sb.append("domashnih zhivotnih:  " + Integer.toString(countPets)+"\n");
            sb.append("a imenno: \n");
            for (T el:reestrOfAnimals){
                sb.append("("+Integer.toString(i++)+") ");
                sb.append(el +"\n");
            }
            sb.append("********************************** \n");
            sb.append("vsego: "+ Integer.toString(countPackAnimals+countPets ) +"\n");

        }

        return sb.toString();

    }

    private void addCounter(T t){
        if (t instanceof PackAnimals){
            countPackAnimals++;
        }
        if (t instanceof Pets){
            countPets++;
        }
    }

    T get(int i){
        return reestrOfAnimals.get(i-1);
    }

    public String findPoBirthDate (String findDate){
        StringBuilder sb=new StringBuilder();
        sb.append(String.format("V %s godu rodilis: \n ",findDate));
        for (T el:reestrOfAnimals){
            if (el.getYaerBith().equals(findDate)){
                sb.append(el.getName()+" - "+ el.getBirbirthDate().toString()+  "\n");
            }
        }
        if(sb.length()<25){
            sb.append("Takih net.");
        }
        return sb.toString();
    }
}

