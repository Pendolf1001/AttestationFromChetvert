package Model;

public class Main {
    public static void main(String[] args) {

        Animals a= new Donkey("Asia", "2020.11.11");
        a.addCommand("Ko mne", "Bezhit ko mne");
        System.out.println(a);
        System.out.println(a.getCommand());
        System.out.println(a.execCommand("Ko mne"));


    }
}

