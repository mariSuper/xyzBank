package polimorfism;

import org.testng.annotations.Test;

public class PolimorfismTest {

    @Test
    public void testMethod(){
        Masina masina = new Masina("Audi", "A3", 2025);
        masina.pornesteVehicol();
        masina.aplicareReducereStandard();
        masina.aplicareReducereStandard(30);
        masina.aplicareReducereStandard("Cupon de pensie");

        Trotineta trotineta = new Trotineta("bobo", "dudu", 2024);
        trotineta.pornesteVehicol();
    }
}
