package fr.ubo.hello.buisness;

import fr.ubo.hello.bean.Greeting;
import org.springframework.stereotype.Component;

@Component
public class GreetingBuisness {

    public Greeting createGreeting(String name) {
        Greeting greeting = new Greeting();
        greeting.setMessage("Hello, " + name);
        return greeting;
    }

    public Greeting createGreetingWithRequiredName() {
        Greeting greeting = new Greeting();
        greeting.setMessage("Name est obligatoire. Merci de le renseigner.");
        return greeting;
    }

}
