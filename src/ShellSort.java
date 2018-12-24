public class ShellSort {

    public static void main(String[] args) {
        shellSort(new int[]{23, 7, 111, 42, 7, 0, -2, 52});
    }

    // input:  23, 7, 111, 42,  7,  0, -2,  52
    // output: -2, 0,   7,  7, 23, 42, 52, 111
    private static void shellSort(int[] arr) {
        // Step 1: pick a sequence for creating slices for sorting
        // Knuth's seq (1, 4, 13, 40, 121) is regarded as best fitting for the avg. case.
        // http://sun.aei.polsl.pl/~mciura/publikacje/shellsort.pdf
        // 
        // Start at 1
        //   While current knuthIntrval lt or eq length / 3
        //     get interval = (3 * prev_interval) + 1
        int gap = 1;
        while(gap <= arr.length/3) {
            gap = 3 * gap + 1;
        }

        while( gap > 0) {
            for (int i=0,j=i+gap; j<arr.length; i++,++j) {
                // swap?
                if(arr[i]>arr[j]) {
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
            gap=gap/2;
        }
        displayArray(arr);
    }

    private static void displayArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for(Integer i : arr) {
            sb.append(i + ", ");
        }
        System.out.print(sb.toString().substring(0, sb.length() - 2));
    }
}
