package Model;

class AnimalBuilder < T extends Animals>  {
    private T t;


     T animalBuild (String type, String name, String birthDate ){
        if (type.equals("Dog")){
            Dog s=new Dog(name,birthDate );
            t=(T)s;
        }else if(type.equals("Cat")){
            Cat s=new Cat(name,birthDate );
            t=(T)s;
        }else if(type.equals("Hamster")){
            Hamster s=new Hamster(name,birthDate );
            t=(T)s;
        }else if(type.equals("Horse")){
            Horse s=new Horse(name,birthDate );
            t=(T)s;
        }else if(type.equals("Camal")){
            Camal s=new Camal(name,birthDate );
            t=(T)s;
        }else if(type.equals("Donkey")){
            Donkey s=new Donkey(name,birthDate );
            t=(T)s;
        }

        return t;
    }
}