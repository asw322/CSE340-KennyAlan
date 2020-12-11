public class test {
  public static void main(String[] args) {

    System.out.println("Hello world!");

    int[] array = new int[] { 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3,
        1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1,
        4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4,
        7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7,
        2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2,
        0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0,
        12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0,
        12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0,
        12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0,
        12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0,
        12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12 };

      switch(checkOrdering(array)){
        case 1:
          System.out.println("The array is already sorted");
          break;
        case 2:
          System.out.println("The array is reversed");
          reverseArray(array);
          break;
        default: 
          System.out.println("The array is no sorted");
          quickSort(array, 0, array.length - 1);        
      }
      

    for (int element : array) {
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

  // ORDER CHECKER TO PRE CHECK IF SORTED, NOT SORTED, OR REVERESE SORTED
  // 0: NOT SORTED
  // 1: SORTED
  // 2: REVERSE SORTED
  public static int checkOrdering(int[] arr) {
    // ASSUME SINGLE ELEMENT => SORTED
    int len = arr.length;
    
    if (len <= 1) {
      return 1;
    }

    // DATA FIELDS
    int prev = arr[0];
    boolean inc = false;
    boolean dec = false;
    int counter = 1;

    // ALGORITHM TO FIND THE FIRST DIFFERENT PAIR OF VALUES
    while (true) {
      if (arr[counter] > prev) {
        inc = true;
        break;
      } else if (arr[counter] < prev) {
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
      prev = arr[i - 1];

      if (arr[i] > prev && inc == true) {
        continue;
      } else if (arr[i] < prev && dec == true) {
        continue;
      } else {
        // THE REST OF THE ARRAY DOES NOT FOLLOW THE ORDERING FIRST FOUND, NOT SORTED
        return 0;
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