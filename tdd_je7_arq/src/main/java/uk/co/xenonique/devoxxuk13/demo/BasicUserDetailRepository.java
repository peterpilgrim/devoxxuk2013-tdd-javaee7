package uk.co.xenonique.devoxxuk13.demo;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

/**
 * The type BasicUserDetailRepository
 *
 * @author Peter Pilgrim (peter)
 */
@ApplicationScoped
public class BasicUserDetailRepository implements UserDetailRepository {


    private ConcurrentMap<String,User> users = new ConcurrentHashMap<>();

    @Override
    public boolean authenticate(User user) {
        return users.containsKey(user.getUsername()) && (
                user.getUsername().equals("ppilgrim") ||
                user.getUsername().equals("admin") );
    }

    @Override
    public void createUser(User user) {
        users.put(user.getUsername(), user);
    }

    @Override
    public boolean deleteUser(User user) {
        return users.remove(user.getUsername()) != null;
    }

    @Override
    public boolean containsUser(User user) {
        return users.containsKey(user.getUsername());
    }
}
