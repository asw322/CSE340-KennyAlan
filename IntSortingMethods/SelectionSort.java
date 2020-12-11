package IntSortingMethods;

public class SelectionSort extends Sort {
    private int len;
    void algorithm() {
    	/* You may change any code within this method */
        sort(this.data);
    }

    /* You may define any new methods you want and may change this method */
    void sort(int[] arr) {
        // custom implementation

        switch(checkOrdering(arr)){
            case 1:
                break;
            case 2:
                reverseArray(arr);
                break;
            default: 
                quickSort(arr, 0, arr.length - 1);        
        }
        
        // quickSort(arr, 0, arr.length - 1);

        // default algorithm from project

        // int n = arr.length;
        // len = n;

        // // One by one move boundary of unsorted subarray
        // for (int i = 0; i < n - 1; i++) {
        //     // Find the minimum element in unsorted array
        //     int min_idx = i;
        //     for (int j = i + 1; j < n; j++)
        //         if (arr[j] < arr[min_idx])
        //             min_idx = j;

        //     // Swap the found minimum element with the first
        //     // element
        //     int temp = arr[min_idx];
        //     arr[min_idx] = arr[i];
        //     arr[i] = temp;
            
        // }
    }

    // AUTHOR NAME
    public String getAuthor() {
    	/* You MUST change the following line of code if you want credit.*/
        return "asw322 kel422";
    }

    // ORDER CHECKER TO PRE CHECK IF SORTED, NOT SORTED, OR REVERESE SORTED 
    // 0: NOT SORTED
    // 1: SORTED
    // 2: REVERSE SORTED
    public int checkOrdering(int[] arr) {
        // ASSUME SINGLE ELEMENT => SORTED 
        if(len <= 1) {
            return 1;
        }
        
        // DATA FIELDS  
        int prev = arr[0];
        boolean inc = false;
        boolean dec = false; 
        int counter = 1;

        // ALGORITHM TO FIND THE FIRST DIFFERENT PAIR OF VALUES
        while(true) {
            if(arr[counter] > prev) {
                inc = true;
                break;
            }
            else if(arr[counter] < prev) {
                dec = true;
                break; 
            }
            else if(arr[counter] == prev && counter < len) {
                counter++;
            }
            else {
                return 1;
            }
        }


        // CHECK THE REST OF THE ARRAY STARTING FROM COUNTER
        for(int i = counter + 1; i < len; i++) {
            prev = arr[i-1];
            
            if(arr[i] > prev && inc == true) {
                continue;
            }
            else if(arr[i] < prev && dec == true) {
                continue;
            }
            else {
                // THE REST OF THE ARRAY DOES NOT FOLLOW THE ORDERING FIRST FOUND, NOT SORTED
                return 0;
            }
        }

        if(inc) {return 1;}
        else if(dec) {return 2;}

        // DEFAULT CASE
        return 0;
    }


    // REVERSE STRING
    public void reverseArray(int[] arr) {
        int half = len / 2;
        for(int i = 0; i < half; i++) {
            int temp = arr[i];
            arr[i] = arr[len - 1 - i];
            arr[len - 1 - i] = temp;
        }
    }

    // SWAP ELEMENTS
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    // HERE IS WHERE THE SORTING ALGORITHMS WILL BE:

    // COUNTINGSORT
    public void countingSort(int[] arr) {
        // IMPLEMENT STANDARD COUNTING SORT
    }

    // BUCKETSORT
    // CR MIGHT NOT NEED TO USE THIS 
    public void bucketSort(int[] arr) {
        // IMPLEMENT STANDARD BUCKET SORT 
    }

    // base algorithm is from textbook pseudo code

    public void quickSort(int[] arr, int start, int end) {
        // MODIFIED VERSION OF QS WITH INSERTION SORT ON SMALLER PARTITIONS
        if(end - start + 1 < 10) {
            insertionSort(arr, start, end);
            return;
        }
    
        if (start < end){
          int partition = partition(arr, start, end);
           
          quickSort(arr, start, partition - 1);
          quickSort(arr, partition + 1, end);
        }
      }
    
      // CR THIS
      public int partition(int[] arr, int start, int end) {
          // textbook implementation 
          int pivot = arr[end];
          int i = start - 1;
    
          for (int j = start; j < end; j++){
            if (arr[j] < pivot){
              i += 1;
              swap(arr, i, j);
            }
          }
          swap(arr, i + 1, end);
          return i + 1;
      }

    // INSERTIONSORT
    // CR THIS
    // public void insertionSort(int[] arr, int start, int end) {
    //     for(int i = start; i <= end; i++) {
    //         for(int j = i; j > start; j--) {
    //             if(arr[i] < arr[j]) {
    //                 swap(arr, i, j);
    //             }
    //         }
    //     }
    // }

    // this version of insertion sort is based off the pseudocode from:
    // https://en.wikipedia.org/wiki/Insertion_sort#Algorithm
    // it has been slightly modified to fit with our implementation of quicksort

    public void insertionSort(int[] arr, int start, int end){
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

