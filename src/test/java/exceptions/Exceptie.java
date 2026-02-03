package exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Exceptie {
    //Exceptie = o eroare ce apare in momentul in care programul ruleaza
    //exceptiile trebuie tratate deoarece contin informatii din interior care pot sa fie exploatate
    //ca sa tratam o exceptie se foloseste structura try & catch / finally

    //2 tipuri de exceptii: unchecked si checked
    //checked => exceptii ce apar in momentul cand vrem sa folosim o anumita clasa
    //unchecked => exceptii care ne iau prin surprindere

    //2 keywords specifice: throw si throws
    //throw => cuvant pe care il folosim cand vrem sa facem trigger la o exceptie
    //throws => cuvant pe care il folosim ca sa adaugam exceptia la semnatura metodei (VECI!!)

    @Test
    public void testMethod() {
//        checkedExample();
//        uncheckedExample();
        throwExample();
    }

    //checked
    public void checkedExample() {
        String path = "src/CustomerData.json";
        File file = new File(path);
        try {
            FileInputStream fileContent = new FileInputStream(file);
        } catch (FileNotFoundException e) {
        }
    }

    //unchecked
    public void uncheckedExample() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        //vreau sa gasesc un element
        WebElement alex = driver.findElement(By.xpath("Alex Dorha"));
        alex.click();
    }

    //keyword specific: throw
    public void throwExample() {
//        String path = "src/CustomerData.json";
//        File file = new File(path);
//        try {
//            FileInputStream fileContent = new FileInputStream(file);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException("Nu accept aceasta problema");
        }
    }
        //keyword specific: throws
//        public void throwsExample () {
//            String path = "src/CustomerData.json";
//            File file = new File(path);
//                  FileInputStream fileContent = new FileInputStream(file);



