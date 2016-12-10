
/**
 * High level pseudu:
 * for every element in dataset starting at index 1
 *   while current element is larger than previous
 *     swap current element and previous
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] dataset = DataSetUtil.genDataset(10000);
        for(int i = 1; i < dataset.length; i++) {
             for (int j = i; j > 0; j--) {
                if (dataset[j] < dataset[j-1]) {
                    int temp = dataset[j];
                    dataset[j] = dataset[j - 1];
                    dataset[j - 1] = temp;
                }
            }
        }
        System.out.println(DataSetUtil.verify(dataset));
    }
}
