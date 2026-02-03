package abstractizareV1;

public class BucatarieRestaurantTotal extends Restaurant implements IRestaurantVegan, IRestaurantNonVegan{
    public BucatarieRestaurantTotal(String nume, String adresa, int telefon) {
        super(nume, adresa, telefon);
    }
    @Override
    public void servesteBurger() {
    }
    @Override
    public void servestePaste() {
    }
    @Override
    public void servesteCostite() {
    }
    @Override
    public void servestePizza() {
    }
    @Override
    public void servesteHumus() {
    }
    @Override
    public void servesteSalataVerde() {
    }
    @Override
    public void servesteSucAvocado() {
    }
}
