import java.util.Random;

public class DataSetUtil {
    public static int[] genDataset(int size){
        int[] ds = new int[size];
        for (int i=0; i<size; i++) {
            ds[i] = new Random().nextInt(1000);
        }
        return ds;
    }

    public static boolean verify(int[] array) {
        for(int i = 0; i < array.length - 1; i++)
            if (array[i] > array[i+1])
                return false;
        return true;
    }
}
