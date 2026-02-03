package abstractizareV2;

public abstract class Restaurant {
    // recunoastem o clasa abstracta dupa cuvantul abstract
    // o clasa abstracta poate sau nu sa contina metode abstracte
    // intr-o clasa abstracta putem sa avem metode de tip public, private, portected
    // o clasa care mosteneste o clasa abstracta trebuie sa implementeze toate metodele abstracte
    // o clasa abstracta poate implementa o interfata
    // o clasa abstracta poate contine un cosntructor => NU poti face un Obiect din acesta
    // ca sa facem o metoda abstracta intr-o clasa abstracta trebuie sa adaugam cuvantul 'abstract'

    private String nume;
    private String adresa;
    private int telefon;

    public abstract void servesteHumus();
    public abstract void servesteSalataVerde();
    public abstract void servesteSucAvocado();
    public abstract void servesteBurger();
    public abstract void servestePaste();
    public abstract void servesteCostite();
    public abstract void servestePizza();
}
