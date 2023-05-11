package pl.pjatk.dawfei;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(value = "my.custom.property.enabled", havingValue = "true")
public class ConditionalBean {

    private String message;

    public ConditionalBean(@Value("${my.custom.property.message}") String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(message);
    }
}