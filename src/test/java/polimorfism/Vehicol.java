package polimorfism;

public class Vehicol {

    // Polimorfism e de 2 feluri: DINAMIC(override) si STATIC(overload)
// Dinamic = intr-o ierarhie de clase obtinute prin mostenire - o metoda poate avea implementari diferite
    //apare doar in relatia de MOSTENIRE
// STATIC = posibilitatea ca o metoda deja declarata sa aibe o structura la nivel de declarare diferita
    //metoda se diferentiaza prin numarul sau tipul de paramentrii diferiti

    private String marca;
    private String model;
    private int an;

    public Vehicol(String marca, String model, int an) {
        this.marca = marca;
        this.model = model;
        this.an = an;
    }
    //Polimorfism DINAMIC
    public void pornesteVehicol(){
        System.out.println("Vehicolul porneste de la buton");
    }
}
