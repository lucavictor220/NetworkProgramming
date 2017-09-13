import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.RandomVectorGenerator;

import java.util.Random;

/**
 * Created by vitiok on 8/30/17.
 */
public class RandomNumbersVector implements RandomNumberVectorGenerator {

    private int length;
    private Random random;

    RandomNumbersVector(int length) {
        this.length = length;
    }

    public int[] nextVector() {
        int[] vector = new int[length];
        random = new Random();

        for (int i = 0; i < vector.length; ++i) {
            vector[i] = random.nextInt(2000);
        }

        return vector;
    }
}
