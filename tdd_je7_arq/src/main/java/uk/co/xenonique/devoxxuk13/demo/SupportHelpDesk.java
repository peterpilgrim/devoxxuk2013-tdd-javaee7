package uk.co.xenonique.devoxxuk13.demo;

import javax.ejb.Stateless;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * The type SupportHelpDesk
 *
 * @author Peter Pilgrim
 */
@Stateless
public class SupportHelpDesk {
    private List<String> agents = Arrays.asList(
            "Agnes", "Brian", "Harry", "Sally", "Tom", "Pamela",
            "Mark", "Wendy", "Marcia", "Graeme", "Pravztik",
            "Hadeep", "Florence", "Robert", "Zoe", "Frank");

    private Random rnd = new Random(new Date().getTime());
    public String getNextAgentName() {
        int x = rnd.nextInt(10000);
        return String.format("%s%05d", agents.get(x % agents.size()), x );
    }
}
