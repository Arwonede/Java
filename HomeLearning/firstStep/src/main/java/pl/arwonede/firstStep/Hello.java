package pl.arwonede.firstStep;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Configuration //dana klasa ma być konfiguracją
//@Service //dana klasa ma być usługodawcą/ma coś nam dostarczać
//@Component //dana klasa ma byc częścią springa, bez sprecyzowania jej celów
@RestController //dana klasa ma stanowić interfejs restowy
//@Controller //dana klasa ma przesyłać dane
//@Repository //dana klasa która ma zarządzać danymi
public class Hello {

    @GetMapping("/sayHello") //adnotacja z parametrem endpointu aby metoda była WEBowa
    public String sayHello(){
        return "hello";
    }

}
