package uk.co.xenonique.devoxxuk13.demo;

/**
 * The type UserDetailRepository
 *
 * @author Peter Pilgrim (peter)
 */
public interface UserDetailRepository {

    boolean authenticate(User user);

    void createUser(User user);

    boolean deleteUser(User user);

    boolean containsUser( User user );
}
