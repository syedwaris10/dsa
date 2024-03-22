package leetcode.design.singletonwithtwist;

import java.io.Serial;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * Implement the singleton pattern with a twist. First,
 * instead of storing one instance, store two instances.
 * And in every even call of getInstance(),
 * return the first instance and in every
 * odd call of getInstance(),
 * return the second instance.
 *
 */

final public class SingleTon implements Serializable {
    private static SingleTon evenInstance;
    private static SingleTon oddInstance;
    private static final AtomicInteger requestCount = new AtomicInteger(0);
    private static final Object lock = new Object();

    private SingleTon() {
        if (evenInstance != null || oddInstance != null) {
            throw new IllegalStateException("Singleton instance already exists");
        }
    }
    private static SingleTon getEvenInstance() {
        if (evenInstance == null) {
            synchronized (lock) {
                if (evenInstance == null) {
                    evenInstance = new SingleTon();
                }
            }

        }

        System.out.println("Even: " + evenInstance);
        return evenInstance;
    }

    private static SingleTon getOddInstance() {
        if (oddInstance == null) {
            synchronized (lock) {
                if (oddInstance == null) {
                    oddInstance = new SingleTon();
                }
            }

        }

        System.out.println("Odd: " + oddInstance);
        return oddInstance;
    }

    public static SingleTon getInstance() {
         requestCount.getAndIncrement();

         return requestCount.get() % 2 == 0 ? getEvenInstance() : getOddInstance();
    }

    @Serial
    protected Object readResolve() {
        return requestCount.get() % 2 == 0 ? getEvenInstance() : getOddInstance();
    }
}
