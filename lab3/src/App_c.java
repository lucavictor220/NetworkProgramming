import java.util.Optional;
import java.util.concurrent.CountDownLatch;

/**
 * Created by vitiok on 9/14/17.
 */
public class App_c {

    public static void main(String[] args) {
        CountDownLatch dependency1 = new CountDownLatch(1);
        CountDownLatch dependency2 = new CountDownLatch(3);

        // SCHEME c START ==============

        new Activity(Optional.of(() -> System.out.println("Action in 2")),
                Optional.of(dependency1),
                Optional.of(dependency2)).start();

        new Activity(Optional.of(() -> System.out.println("Action in 3")),
                Optional.of(dependency1),
                Optional.of(dependency2)).start();

        new Activity(Optional.of(() -> System.out.println("Action in 4")),
                Optional.of(dependency1),
                Optional.of(dependency2)).start();

        new Activity(Optional.of(() -> System.out.println("Action in 1")),
                Optional.empty(),
                Optional.of(dependency1)).start();

        new Activity(Optional.of(() -> System.out.println("Action in 5")),
                Optional.of(dependency2),
                Optional.empty()).start();


        // SCHEME c END ==============
    }
}
