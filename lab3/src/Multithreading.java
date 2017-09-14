/**
 * Created by vitiok on 9/13/17.
 */
public class Multithreading {

    public static void main(String[] args) {
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        task1.start();
        task2.start();
    }
}
