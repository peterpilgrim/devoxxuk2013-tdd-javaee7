package uk.co.xenonique.devoxxuk13.demo;

/**
 * The type SanctionService
 *
 * @author Peter Pilgrim (peter)
 */
public class SanctionService {
    public void sanction( String account, String ccyPair ) {
        System.out.printf("SanctionService#sanction( " +
                "account=%s, other=%s )\n", account, ccyPair);
    }
}
