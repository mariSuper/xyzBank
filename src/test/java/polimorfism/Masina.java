package polimorfism;

public class Masina extends Vehicol {
    public Masina(String marca, String model, int an) {
        super(marca, model, an);
    }

    // polimorfism dinamic
    public void pornesteVehicol() {
//        super.pornesteVehicol();
        System.out.println("Masina porneste de la cheie");
    }

    // polimorfism static
    public void aplicareReducereStandard() {
        System.out.println("In ianuarie se aplica 5% reducere");
    }
    public void aplicareReducereStandard(int procent) {
        System.out.println("Pentru masina se aplica "+procent+"% reducere");
    }
    public void aplicareReducereStandard(String cupon) {
        System.out.println("Pentru masina se aplica un cupon de reducere");
    }

}



