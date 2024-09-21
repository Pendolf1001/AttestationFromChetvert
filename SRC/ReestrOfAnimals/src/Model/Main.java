package Model;

public class Main {
    public static void main(String[] args) {
        ReestrOf <Animals> ra=new ReestrOf<>();
        ra.add(new Donkey("Asia", "2020.11.11"));
        ra.add(new Dog("Be be", "2021.12.12"));
        ra.add(new Cat("Gav", "2023.01.11"));
        ra.add(new Horse("Spirit", "2020.09.09"));
//        Animals a= new Donkey("Ila", "2020.02.11");
//        a.addCommand("Ko mne", "Bezhit ko mne");
        System.out.println(ra);
//        System.out.println(a.getCommand());
//        System.out.println(a.execCommand("Ko mne"));


    }
}

