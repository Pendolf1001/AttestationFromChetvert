package View;

import java.util.*;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;
    private List <String> vybAnimals;


    public ConsoleUI(){
        scanner=new Scanner(System.in);
        presenter=new Presenter(this);
        work=true;
        menu= new MainMenu(this);
        vybAnimals=new ArrayList<>();
        setVybAnim();
    }

    @Override
    public void printRes (String text){
        System.out.println(text);
    }

    @Override
    public void start(){
        hello();
        while (work){
            printMenu();
            execute();
        }
    }

    public void finish(){
        System.out.println("Vsego dobrogo!");
        work=false;
    }

    public void hello(){
        System.out.println("Здраствуйте!");
    }

    public void getInfo(){
        presenter.getInfo();
    }

    public void setVybAnim(){
        vybAnimals.add("Dog");
        vybAnimals.add("Cat");
        vybAnimals.add("Hamster");
        vybAnimals.add("Horse");
        vybAnimals.add("Camal");
        vybAnimals.add("Donkey");
    }

    public void printVybAnim(){
        StringBuilder sb=new StringBuilder();
        int i=1;
        for (String el:vybAnimals){
            sb.append("("+Integer.toString(i++)+") ");
            sb.append(el +"\n");
        }
        System.out.println(sb.toString());
    }

    public void addAnimal(){
        System.out.println("Выбирите тип животного из списка:  ");
        printVybAnim();
        String type="";
        String it = scanner.nextLine();
        if (checkTextForInt(it)){
            int vt= Integer.parseInt(it);
            type= vybAnimals.get(vt-1);

        }else{
            inputError();
        }

        System.out.println("Введите имя животного :");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения в формате гггг.мм.дд ");
        String birthDate=scanner.nextLine();
        presenter.addAnimal (type, name, birthDate );
        System.out.println("Животное успешно добавлено");
    }

    public void getCommandAnimal(){
        if(presenter.getReestrSize()>0){
            System.out.println("Введите номер животного из списка: ");
            String si = scanner.nextLine();
            int i=Integer.parseInt(si);
            if(presenter.getReestrSize()<i){
                System.out.println("Такого номера в реестре нет");
            }else{
                System.out.printf("Животное под номер %s умеет выполнять следующие команды: \n", si);
                presenter.getCommandAnimal (i);
                System.out.println("Это все команды");
            }
        }else{
            System.out.println("В реестре пусто");
        }
    }

    public void addCommand(){
        if(presenter.getReestrSize()>0){
            System.out.println("Введите номер животного из списка: ");
            String si = scanner.nextLine();
            int i=Integer.parseInt(si);
            if(presenter.getReestrSize()<i){
                System.out.println("Такого номера в реестре нет");
            }else{
                System.out.println("Введите название команды");
                String key = scanner.nextLine();
                System.out.printf("Введите действие по команде %s \n", key);
                String move = scanner.nextLine();
                presenter.addCommand (i,key, move );
                System.out.printf("Животное под номером %s обучено команде %s \n",si, key);
            }
        }else{
            System.out.println("В реестре пусто");
        }
    }

    public void execCommand(){
        if(presenter.getReestrSize()>0){
            System.out.println("Введите номер животного из списка: ");
            String si = scanner.nextLine();
            int i=Integer.parseInt(si);
            if(presenter.getReestrSize()<i){
                System.out.println("Такого номера в реестре нет");
            }else{
                System.out.println("Введите название команды");
                String key = scanner.nextLine();
                presenter.execCommand (i,key );
            }
        }else{
            System.out.println("В реестре пусто");
        }
    }

    public void findPoBirthDate(){
        if(presenter.getReestrSize()>0){
            System.out.println("Введите требуемый год ");
            String findDate = scanner.nextLine();
            presenter.findPoBirthDate(findDate);
        }else{
            System.out.println("В реестре пусто");
        }
    }

    private void execute(){
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                try{
                    menu.execute(numCommand);
                }catch(java.time.format.DateTimeParseException e){
                    System.out.println("Neverno vvedena data rozhdeniya");
                }catch(java.lang.IndexOutOfBoundsException e){
                    System.out.println("Takogo varianta v spiske net");
                }catch(RuntimeException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu(){
        System.out.println(menu.menu());
    }

    private void inputError(){
        System.out.println("INPUT_ERROR");
    }

}