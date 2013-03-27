package uk.co.xenonique.devoxxuk13.demo;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Verifies the operation of the uk.co.xenonique.devoxxuk13.demo.SupportHelpDeskTest
 *
 * @author Peter Pilgrim
 */
@RunWith(Arquillian.class)
public class SupportHelpDeskTest {

    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
                .addClasses(SupportHelpDesk.class)
                .addAsManifestResource(
                        EmptyAsset.INSTANCE,
                        ArchivePaths.create("beans.xml"));
        return jar;
    }

    @EJB SupportHelpDesk desk;

    @Test
    public void shouldRetrieveDifferentAgents() {
        System.out.printf("Support help desk = %s\n", desk );
        Set<String> agents = new HashSet<>();
        final int N=10;
        for ( int j=0; j<10; ++j ) {
            String agent  = desk.getNextAgentName();
            System.out.printf("The next agent = %s\n", agent );
            assertNotNull(agent);
            agents.add(agent);
        }
        assertEquals( N, agents.size());
    }
}
