package polimorfism;

public class Trotineta extends Vehicol {
    public Trotineta(String marca, String model, int an) {
        super(marca, model, an);
    }

    // polimorfism dinamic
    public void pornesteVehicol(){
        System.out.println("Trotineta porneste daca are bateria incarcata");

    }
}
