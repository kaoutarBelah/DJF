package fr.ubo.hello.controller;

import fr.ubo.hello.bean.Greeting;
import fr.ubo.hello.buisness.GreetingBuisness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GreetingController {

    // Constructeur de la classe GreetingController

    private final GreetingBuisness business;

    @Autowired
    public GreetingController(GreetingBuisness business) {
        this.business = business;
    }

   /* public GreetingController() {
        business = new GreetingBuisness();  // Crée une instance de la classe GreetingBuisness
    }*/
    // Annotation @RequestMapping indiquant que cette méthode répondra aux requêtes HTTP avec le chemin "/greeting"
    @RequestMapping(value = "/greeting")
    public Greeting greeting() {
        // Cette méthode renvoie un objet Greeting en utilisant la méthode createGreetingWithRequiredName du business
        return business.createGreetingWithRequiredName();
    }

    // Annotation @RequestMapping indiquant que cette méthode répondra aux requêtes HTTP avec le chemin "/greeting/{name}"
    // La variable de chemin {name} est capturée et passée en tant que paramètre à la méthode
    @RequestMapping(value = "/greeting/{name}")
    public Greeting greeting(@PathVariable("name") String name) {
        // Cette méthode renvoie un objet Greeting en utilisant la méthode createGreeting du business avec le nom passé en paramètre
        return business.createGreeting(name);
    }

    @RequestMapping(value = "/greeting2")
    public Greeting greeting2(@RequestParam(value = "name", required = false, defaultValue = "world") String name) {
        return business.createGreeting(name);
    }

    @RequestMapping(value = "/greeting3")
    public Greeting greeting3(@RequestParam(value = "name" , required = true) String name){
        return business.createGreeting(name);
    }
}
