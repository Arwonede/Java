package pl.pjatk.dawfei;

import org.springframework.stereotype.Component;

@Component
public class ExampleFive {

    public ExampleFive (CustomProperties customProperties){
        System.out.println(customProperties.getLoginUrl());
        System.out.println(customProperties.getCredentials().getUser());
        System.out.println(customProperties.getCredentials().getPassword());
    }
}