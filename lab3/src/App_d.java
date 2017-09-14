import java.util.Optional;
import java.util.concurrent.CountDownLatch;

/**
 * Created by vitiok on 9/14/17.
 */
public class App_d {

    public static void main(String[] args) {
        CountDownLatch dependency1 = new CountDownLatch(1);
        CountDownLatch dependency2 = new CountDownLatch(3);

        // SCHEME d START ==============

        new Activity(Optional.of(() -> System.out.println("Action nr 2")),
                Optional.empty(),
                Optional.of(dependency2)).start();

        new Activity(Optional.of(() -> System.out.println("Action nr 3")),
                Optional.empty(),
                Optional.of(dependency2)).start();

        new Activity(Optional.of(() -> System.out.println("Action nr 4")),
                Optional.of(dependency2),
                Optional.of(dependency1)).start();

        new Activity(Optional.of(() -> System.out.println("Action nr 1")),
                Optional.empty(),
                Optional.of(dependency2)).start();

        new Activity(Optional.of(() -> System.out.println("Action nr 5")),
                Optional.of(dependency1),
                Optional.empty()).start();

        new Activity(Optional.of(() -> System.out.println("Action nr 6")),
                Optional.of(dependency1),
                Optional.empty()).start();

        new Activity(Optional.of(() -> System.out.println("Action nr 7")),
                Optional.of(dependency1),
                Optional.empty()).start();

        // SCHEME d END ==============
    }
}
