package uk.co.xenonique.devoxxuk13.embedded;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Singleton;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The type SampleSingleton
 *
 * @author Peter Pilgrim
 */
@Singleton
public class SampleSingleton {
    private AtomicInteger counter = new AtomicInteger(5000);
    @PostConstruct
    public void init() {
        System.out.printf(">>>> %s.init() called\n",
                getClass().getSimpleName());
    }

    @PreDestroy
    public void destroy() {
        System.out.printf(">>>> %s.destroy() called\n",
                getClass().getSimpleName());
    }

    public int count() {
        return counter.getAndAdd(2);
    }

    public String getFullName() {
        return "Peter Pilgrim";
    }
}
