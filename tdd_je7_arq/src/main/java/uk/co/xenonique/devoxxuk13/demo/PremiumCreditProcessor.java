package uk.co.xenonique.devoxxuk13.demo;

import uk.co.xenonique.devoxxuk13.demo.CreditProcessor;
import uk.co.xenonique.devoxxuk13.demo.Premium;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * The type PremiumCreditProcessor
 *
 * @author Peter Pilgrim (peter)
 */
@Premium
public class PremiumCreditProcessor implements CreditProcessor {

    @Override
    public void check(String account) {
        if ( !account.trim().startsWith("1234")) {
            throw new RuntimeException("account:["+account+"] is not valid!");
        }
        System.out.printf("Account [%s] is Okay\n", account );
    }

    @PostConstruct
    public void acquireResource() {
        System.out.println( this.getClass().getSimpleName()+"#acquireResource()" );
    }

    @PreDestroy
    public void releaseResource() {
        System.out.println( this.getClass().getSimpleName()+"#releaseResource()" );
    }
}
