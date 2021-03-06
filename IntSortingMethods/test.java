public class test {
  private static int len;
  private static int max;
  private static int min;
  public static void main(String[] args) {

    System.out.println("Hello world!");

    // int[] arr = new int[] { 3, 54, 4, 7, 14,
    // 12, 3, 123, 4, 7, 111, 3, 12, 3, 3
    // 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3,
    // 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2,
    // 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1,
    // 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0,
    // 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4,
    // 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0,
    // 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7,
    // 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12,
    // 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2,
    // 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3,
    // 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0,
    // 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1,
    // 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0,
    // 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1,
    // 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0,
    // 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1,
    // 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0,
    // 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1,
    // 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0,
    // 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1,
    // 4, 7, 2, 0, 12 
    // };

    //int[] arr = new int[] {1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 17, 17, 19, 20, 21,22};

    int[] arr = new int[] { 20, 19, 18, 17, 19999, 15, 14, 13, 12, 11, 10, 9, 8, 6, 3, 2, 1, 0 };
    len = arr.length;

    switch (checkOrdering(arr)) {
      case 1:
        System.out.println("array is already sorted!");
        break;
      case 2:
        System.out.println("array is reversed!");
        reverseArray(arr);
        break;
      default:
        // CHECK FOR COUNTING SORT
        if (max - min < 1000) {
          // DO COUNTING SORT
          System.out.println("using counting sort!");
          countingSort(arr, min, max);
        } else {
          // BASE CASE: DO QUICK SORT
          System.out.println("using quick sort!");
          quickSort(arr, 0, arr.length - 1);
        }
    }

    for (int element : arr) {
      System.out.println(element);
    }
  }

  public static void quickSort(int[] arr, int start, int end) {
    // MODIFIED VERSION OF QS WITH INSERTION SORT ON SMALLER PARTITIONS
    if (end - start + 1 < 10) {
      insertionSort(arr, start, end);
      return;
    }

    if (start < end) {
      int partition = partition(arr, start, end);

      quickSort(arr, start, partition - 1);
      quickSort(arr, partition + 1, end);
    }
  }

  // CR THIS
  public static int partition(int[] arr, int start, int end) {
    // textbook implementation
    int pivot = arr[end];
    int i = start - 1;

    for (int j = start; j < end; j++) {
      if (arr[j] < pivot) {
        i += 1;
        swap(arr, i, j);
      }
    }
    swap(arr, i + 1, end);
    return i + 1;
  }

  // SWAP ELEMENTS
  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  // INSERTIONSORT
  // CR THIS
  // public static int[] insertionSort(int[] arr, int start, int end) {
  // for(int i = start; i <= end; i++) {
  // for(int j = i; j > start; j--) {
  // if(arr[i] < arr[j]) {
  // swap(arr, i, j);
  // }
  // }
  // }
  // return arr;
  // }

  // this version of insertion sort is based off the pseudocode from:
  // https://en.wikipedia.org/wiki/Insertion_sort#Algorithm
  // it has been modified to fit with the quicksort implementation

  public static void insertionSort(int[] arr, int start, int end) {
    for (int i = start + 1; i < end + 1; i++) {
      int x = arr[i];
      int j = i - 1;

      while (j >= start && arr[j] > x) {
        arr[j + 1] = arr[j];
        j = j - 1;
      }
      arr[j + 1] = x;
    }
  }

  // public static void countingSort(int[] array, int min, int max) {
  //   max = 12;
  //   min = 3;

  //   int range = max - min;
  //   int[] temp = new int[range + 1];

  //   for(int element : array){
  //     temp[element - min] += 1;
  //   }

  //   int z = 0;
  //   for(int i = min; i <= max; i++){
  //     while(temp[i - min] > 0){
  //       array[z]= i;
  //       z++;
  //       temp[i - min]--;
  //     }
  //   }
  // }

  // This is counting sort from the textbook
  public static void countingSort(int[] arr, int min, int max) {
    // IMPLEMENT STANDARD COUNTING SORT
    // max = 123;
    // min = 3;

    int range = max - min;

    // temporary storage array (length = range)
    int[] temp = new int[range + 1];
    int[] sorted = new int[arr.length];

    // increment the count of each element in temp array
    // for (int element : arr) {
    //   System.out.println("elem = " + element);
    //   System.out.println("min = " + min);
    //   temp[element - min] += 1;
    // }


    int scale = len - 1;
    int k = 0;
    for(k = 0; k < scale; k+=2) {
        temp[arr[k] - min]++; 
        temp[arr[k+1] - min]++;
    }

    // handle the remainder 
    for(; k < scale; k++) {
        temp[arr[k] - min]++;
    }


    for (int i = 1; i <= max - min; i++) {
      temp[i] += temp[i - 1];
    }
    // temp[i] now contains the number of elem <= i
  
    for (int j = 0; j < arr.length; j++) {
      sorted[temp[arr[j] - min] - 1] = arr[j];
      temp[arr[j] - min] -= 1;
    }

    System.arraycopy(sorted, 0, arr, 0, sorted.length);
  }

  // ORDER CHECKER TO PRE CHECK IF SORTED, NOT SORTED, OR REVERESE SORTED 
  // 0: NOT SORTED
  // 1: SORTED
  // 2: REVERSE SORTED
  public static int checkOrdering(int[] arr) {
    System.out.println("starting checkOrdering");

    // ASSUME SINGLE ELEMENT => SORTED
    if (len <= 1) {
      return 1;
    }

    // DATA FIELDS
    int prev = arr[0];
    boolean inc = false;
    boolean dec = false;
    int counter = 1;

    max = prev;
    min = prev;

    // ALGORITHM TO FIND THE FIRST DIFFERENT PAIR OF VALUES
    while (true) {
      // ALLOCATE RANGES CORRECTLY
      max = Math.max(max, arr[counter]);
      min = Math.min(min, arr[counter]);

      System.out.println("max = " + max);
      System.out.println("min = " + min);

      if (arr[counter] > prev) {
        System.out.println("predict increasing..");

        inc = true;
        break;
      } else if (arr[counter] < prev) {
        System.out.println("predict decreasing..");

        dec = true;
        break;
      } else if (arr[counter] == prev && counter < len) {
        counter++;
      } else {
        return 1;
      }
    }

    // CHECK THE REST OF THE ARRAY STARTING FROM COUNTER
    for (int i = counter + 1; i < len; i++) {
      // ALLOCATE RANGES CORRECTLY
      max = Math.max(max, arr[i]);
      min = Math.min(min, arr[i]);

      System.out.println("max = " + max);
      System.out.println("min = " + min);

      prev = arr[i - 1];

      if (arr[i] > prev && inc == true) {
        continue;
      } else if (arr[i] < prev && dec == true) {
        continue;
      } else {
        // RESET THE BOOLEAN VALUES
        inc = false;
        dec = false;
      }
    }

    if (inc) {
      return 1;
    } else if (dec) {
      return 2;
    }

    // DEFAULT CASE
    return 0;
  }

  // REVERSE STRING
  public static void reverseArray(int[] arr) {
    int half = len / 2;
    for (int i = 0; i < half; i++) {
      int temp = arr[i];
      arr[i] = arr[len - 1 - i];
      arr[len - 1 - i] = temp;
    }
  }
}