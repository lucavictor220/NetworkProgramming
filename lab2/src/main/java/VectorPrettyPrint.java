/**
 * Created by vitiok on 8/30/17.
 */
public class VectorPrettyPrint {

    public void print(int[] vector) {
        System.out.print("[");
        int index = 0;
        for (int i : vector) {
            if (index % 20 == 0 && index != 0) {
                System.out.print("\n");
            }
            if (index == vector.length - 1) {
                System.out.print(i);
            } else {
                System.out.print(i + ", ");
            }

            index++;
        }
        System.out.println("]");
    }
}
