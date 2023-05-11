package pl.pjatk.dawfei;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Trzecia {

    private final ApplicationContext applicationContext;

    @Autowired
    public Trzecia(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void useComponents() {
        Pierwsza pierwsza = applicationContext.getBean("pierwsza", Pierwsza.class);
        Druga druga = applicationContext.getBean("druga", Druga.class);

        pierwsza.printNames();
        pierwsza.printInfo();
        druga.printInfo();
    }
}