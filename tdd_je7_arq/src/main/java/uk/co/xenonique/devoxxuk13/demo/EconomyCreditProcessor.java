package uk.co.xenonique.devoxxuk13.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * The type EconomyCreditProcessor
 *
 * @author Peter Pilgrim (peter)
 */
@Economy
public class EconomyCreditProcessor implements CreditProcessor {

    @Override
    public void check(String account) {
        if ( !account.trim().startsWith("E")) {
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
