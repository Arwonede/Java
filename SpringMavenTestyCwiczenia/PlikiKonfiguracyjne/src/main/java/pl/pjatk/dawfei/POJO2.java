package pl.pjatk.dawfei;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class POJO2 {

    @Value("${my.custom.property:Default value}")
    private String myCustomProperty;

    @Bean
    public POJO pojo() {
        System.out.println("my.custom.property: " + myCustomProperty);
        if (myCustomProperty == null){
            myCustomProperty = "Default value";
        }
        System.out.println("my.custom.property: " + myCustomProperty);
        return new POJO("sample text", 123, true);
    }

    @Bean
    public List<String> defaultData() {
        System.out.println("my.custom.property: " + myCustomProperty);
        return Arrays.asList("string_a", "string_b", "string_c", "string_d", "string_e");
    }
}