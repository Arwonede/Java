package pl.pjatk.dawfei;

import org.springframework.stereotype.Component;

@Component
public class Druga {

    public String getName() {
        return "Druga";
    }

    public void printInfo() {
        System.out.println(getName() + " - printInfo()");
    }
}