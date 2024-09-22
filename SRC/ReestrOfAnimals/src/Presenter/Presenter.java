package Presenter;

import Model.Service;
import View.*;

public class Presenter{

    private View view;
    private final Service service;

    public Presenter (View view){
        this.view=view;
        service=new Service();
    }

    public void addAnimal (String type, String name,  String birthDate ){
        service.add(type, name,   birthDate);
        getInfo();
    }

    public void getInfo(){
        view.printRes(service.toString());
    }

    public int getReestrSize(){
        return service.getReestrSize();
    }

    public void getCommandAnimal(int i){
        view.printRes(service.getCommand(i));
    }

    public void addCommand(int i, String key, String move){
        service.addCommand(i,key, move);
    }

    public void execCommand(int i,String key){
        view.printRes(service.execCommand(i,key));
    }

    public void findPoBirthDate (String findDate){
        view.printRes(service.findPoBirthDate(findDate));
    }

}