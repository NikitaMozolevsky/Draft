package by.mozolevskij.pharmacy.example.pattern.creational.factory;

public class FactoryPattern {

    /**
     *
     * 
     *
     * */

    public static void main(String[] args) {
        EnergeticFactory energeticFactory = new EnergeticFactory();
        energeticFactory.createEnergetic(EnergeticType.COLA);
    }
}
class EnergeticFactory {
    public Energetic createEnergetic(EnergeticType energeticType) {
        Energetic energetic = null;
        switch (energeticType) {
            case COLA: {
                energetic = new Cola();
                break;
            }
            case SPRITE: {
                energetic = new Sprite();
                break;
            }
            case FANTA: {
                energetic = new Fanta();
                break;
            }
        }
        return energetic;
    }
}

 class Energetic {
    public String name;

    public void gazirovanie(String name) {
        System.out.println(name + " gazirovanie");
    }

    public void saharirovanie(String name) {
        System.out.println(name + " saharirovanie");
    }
}


    class Cola extends Energetic {
    }

    class Fanta extends Energetic {
    }

    class Sprite extends Energetic {
    }


enum EnergeticType {
    COLA,
    FANTA,
    SPRITE
}
