package Model;

public class Service{
    private ReestrOf sReestr;
    private AnimalBuilder ab;

    public Service(){
        sReestr=new ReestrOf();
        ab=new AnimalBuilder();
    }

    public void add (String type, String name,  String birthDate ){
        sReestr.add(ab.animalBuild(type, name, birthDate));
    }

    public String toString(){
        return sReestr.toString();
    }

    public String getCommand(int i){
        if (i>sReestr.getSize()){
            throw new RuntimeException("V reestre net takogo varianta");
        }
        return sReestr.get(i).getCommand();
    }

    public void addCommand(int i, String key, String move){
        if (i>sReestr.getSize()){
            throw new RuntimeException("V reestre net takogo varianta");
        }
        sReestr.get(i).addCommand(key, move);
    }

    public String execCommand(int i,String key){
        if (i>sReestr.getSize()){
            throw new RuntimeException("V reestre net takogo varianta");
        }

        if(sReestr.get(i).execCommand(key)==null){
            return "Животное не реагирует на команду, наверное оно её не знает";
        }else{
            return sReestr.get(i).execCommand(key);
        }
    }

    public String findPoBirthDate (String findDate){
        return sReestr.findPoBirthDate(findDate);
    }

    public int getReestrSize(){
        return sReestr.getSize();
    }


}