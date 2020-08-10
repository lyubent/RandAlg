import java.util.Arrays;
import java.util.Random;

public class BubbleSortRec 
{
	public static void main(String[] args)
	{
		int arr[] = genData();
		// Show generated Arr. 
		System.out.println("Input:  " + Arrays.toString(arr));

		// sort recursively. 
		bubbleSort(arr, arr.length);

		// print the sorted array
		System.out.println("Output: " + Arrays.toString(arr));
	}

	// Rec bubble sort on sub-arrs of the full array. 
	public static void bubbleSort(int arr[], int n)
	{
		int subIndex = n - 1; // <-- Can be removed. Only for clarity.
		for (int i = 0; i < subIndex; i++) {
			if (arr[i] > arr[i + 1]) {
				swap(arr, i, i + 1);
			}
		}
		// Call if we got items left to sort. 
		if (subIndex > 1) {
			bubbleSort(arr, subIndex);
		}
	}

	// Swaps two numbs
	private static void swap(int arr[], int i, int j)
	{
		// Wouldn't be prudent to avoid using a temp var here. 
		// We can swap using the below but array assigment is more costly than the 
		// temp variable that will be placed in stack mem.
		// if arr[i] = 3 and arr[j] = 7
		// L will be arr[i], R will be arr[j]
        // L = L * R | L=21 R=7
        // R = L / R | L=21 R=3
        // L = L / R | L=7  R=3
		int temp = arr[i]; 
		arr[i] = arr[j];
		arr[j] = temp;
	}

    // returns Arr of length 10 filled with random numbers.
	private static int[] genData() {
		Random r = new Random();
		
		int[] arr = new int[10];
		for (int i = 0; i<10; i++) {
			arr[i] = r.nextInt(50) - 25;
		}

		return arr;
	}
}