package uk.co.xenonique.devoxxuk13.embedded;

import static org.junit.Assert.*;
import org.junit.*;

public class TraditionalUnitTest {

    // Notice the static declaration here
    static SampleSingleton singleton = new SampleSingleton();

    @Test
    public void shouldRetrieveIncrementalCount() {
        int x = singleton.count();
        int y = singleton.count();
        assertTrue( y > x );
    }

    @Test
    public void shouldRetrieveFullName() {
       // fail("not implemented");
    }

}

