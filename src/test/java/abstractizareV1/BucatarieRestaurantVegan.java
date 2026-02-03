package abstractizareV1;

public class BucatarieRestaurantVegan extends Restaurant implements IRestaurantVegan {
    public BucatarieRestaurantVegan(String nume, String adresa, int telefon) {
        super(nume, adresa, telefon);

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
