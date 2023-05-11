package pl.pjatk.dawfei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class DawfeiApplication {

    public DawfeiApplication(){
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DawfeiApplication.class, args);
        //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Trzecia trzecia = context.getBean(Trzecia.class);
        trzecia.useComponents();
    }
}