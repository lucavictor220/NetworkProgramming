/**
 * Created by vitiok on 9/13/17.
 */
public class Task2 extends Thread {

    public void run() {
        for (int i = 0; i < 5; ++i) {
            System.out.println("=> TASK 2 Execution");
            try {
                Thread.sleep(500);
            } catch (Exception e) {}
        }
    }
}
