

public class BubbleSort {
    public static void main(String[] args) {
        int [] dataset = DataSetUtil.genDataset(10);
        // for every elem
        //   starting at beginning of dataset, while this elem is bigger than next
        //     swap this elem with next
        for (int i = 0; i < dataset.length; i++) {
            for (int j = 0; j < dataset.length - 1; j++) {
                if (dataset[j] > dataset[j + 1]) {
                    // swap
                    int temp = dataset[j];
                    dataset[j] = dataset[j + 1];
                    dataset[j + 1] = temp;
                }
            }
            System.out.println(java.util.Arrays.toString(dataset));
        }
        System.out.println(DataSetUtil.verify(dataset));
    }
}
