public class test {
  public static void main(String[] args) {

    System.out.println("Hello world!");

    int[] array = new int[] {3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 
      3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12,
      3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12,
      3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12,
      3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12,
      3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12,
      3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12,
      3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12,
      3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12,
      3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12,
      3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12, 3, 1, 4, 7, 2, 0, 12 };

    quickSort(array, 0, array.length - 1);

    for (int element: array) {
      System.out.println(element);
    }
  }

  public static void quickSort(int[] arr, int start, int end) {
    // MODIFIED VERSION OF QS WITH INSERTION SORT ON SMALLER PARTITIONS
    if(end - start + 1 < 1000) {
        insertionSort(arr, start, end);
        return;
    }

    int partition = partition(arr, start, end);
    quickSort(arr, start, partition - 1);
    quickSort(arr, partition + 1, end);
  }

  // CR THIS
  public static int partition(int[] arr, int start, int end) {
      int pivot = start + (end - start) / 2;
      int i = start; 

      for(int j = start; j < end; j++) {
          if(arr[j] < arr[pivot]) {
              swap(arr, i, j);
              i++;
          }
      }
      swap(arr, i, pivot);
      return i;
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
  //     for(int i = start; i <= end; i++) {
  //         for(int j = i; j > start; j--) {
  //             if(arr[i] < arr[j]) {
  //                 swap(arr, i, j);
  //             }
  //         }
  //     }
  //     return arr; 
  // }

  // this version of insertion sort is based off the pseudocode from:
  // https://en.wikipedia.org/wiki/Insertion_sort#Algorithm

  public static void insertionSort(int[] arr, int start, int end){
    for(int i = start + 1; i < end + 1; i++){
      int value = arr[i];
      int j = i - 1;

      while(j >= start && arr[j] > value){
        arr[j + 1] = arr[j];
        j = j - 1;
      }
      arr[j + 1] = value;
    }
  }

}