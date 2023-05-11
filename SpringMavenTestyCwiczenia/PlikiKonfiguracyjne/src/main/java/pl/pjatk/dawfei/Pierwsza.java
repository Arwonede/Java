package pl.pjatk.dawfei;

import org.springframework.stereotype.Component;

@Component
public class Pierwsza {

    private final Druga druga;

    public Pierwsza(Druga druga) {
        this.druga = druga;
    }

    public String getName() {
        return "Pierwsza";
    }

    public void printNames() {
        System.out.println(getName() + " - printNames()");
        System.out.println(druga.getName() + " - printNames()");
    }

    public void printInfo() {
        System.out.println(getName() + " - printInfo()");
    }
}