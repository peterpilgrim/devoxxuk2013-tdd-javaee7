package uk.co.xenonique.devoxxuk13.demo;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.xenonique.devoxxuk13.demo.Economy;

import javax.inject.Inject;

import static org.junit.Assert.assertNotNull;


@RunWith(Arquillian.class)
public class EconomyCreditProcessorTest {

    @Deployment
    public static JavaArchive createDeployment() {
		JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
            .addClasses(Economy.class,
                CreditProcessor.class,
                EconomyCreditProcessor.class )
			.addAsManifestResource(
                    EmptyAsset.INSTANCE, "beans.xml");
		System.out.println(jar.toString(true));
		return jar;			
    }

    private @Inject @Economy CreditProcessor processor;

    @Test
    public void should_give_user_economy_credit() {
        System.out.printf("processor = %s\n", processor );
        assertNotNull(processor);
        processor.check("E777");
    }
} 	

