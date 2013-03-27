package uk.co.xenonique.devoxxuk13.demo;

import uk.co.xenonique.devoxxuk13.demo.CreditProcessor;
import uk.co.xenonique.devoxxuk13.demo.Premium;
import uk.co.xenonique.devoxxuk13.demo.SanctionService;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

/**
 * The type CreditProcessorDecorator
 *
 * @author Peter Pilgrim (peter)
 */
@Decorator
@Premium
public class CreditProcessorDecorator implements CreditProcessor {

    @Inject private SanctionService sanctionService;
    @Inject @Delegate @Premium private CreditProcessor processor;

    @Override
    public void check(String account) {
        System.out.println("Inside the CreditProcessorDecorator#check() ");
        sanctionService.sanction(account, "EURGBP");
        processor.check(account);
        System.out.println("End of the CreditProcessorDecorator#check() ");
    }
}
