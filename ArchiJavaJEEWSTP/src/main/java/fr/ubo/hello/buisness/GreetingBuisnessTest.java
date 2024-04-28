package fr.ubo.hello.buisness;

import fr.ubo.hello.bean.Greeting;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GreetingBuisnessTest {

    @Test
    public void testCreateGreeting() {
        GreetingBuisness business = new GreetingBuisness();
        Greeting greeting = business.createGreeting("John");
        assertEquals("Hello, John", greeting.getMessage());
    }

    @Test
    public void testCreateGreetingWithRequiredName() {
        GreetingBuisness business = new GreetingBuisness();
        Greeting greeting = business.createGreetingWithRequiredName();
        assertEquals("Name est obligatoire. Merci de le renseigner.", greeting.getMessage());
    }
}
