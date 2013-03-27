package uk.co.xenonique.devoxxuk13.demo;

import static org.junit.Assert.*;
import org.junit.*;

public class TraditionalUnitTest {

    // Notice the static declaration here
    static UserDetailRepository userDetailRepo = new BasicUserDetailRepository();

    @Test
    public void shouldCreateUser() {
        User user = new User("frostj", "Jack", "Frost");
        assertFalse( userDetailRepo.containsUser(user ));

        userDetailRepo.createUser(user);
        assertTrue( userDetailRepo.containsUser(user ));
    }


    @Test
    public void shouldDeleteUser() {
        User user = new User("frostj", "Jack", "Frost");
        assertTrue( userDetailRepo.containsUser(user ));

        userDetailRepo.deleteUser(user);
        assertFalse( userDetailRepo.containsUser(user ));
    }


    @Test
    public void shouldAuthenticateUser() {
        User user = new User("admin", "System", "Administrator");

        assertFalse( userDetailRepo.authenticate(user ));
        userDetailRepo.createUser(user);
        assertTrue( userDetailRepo.authenticate(user ));
    }
}

