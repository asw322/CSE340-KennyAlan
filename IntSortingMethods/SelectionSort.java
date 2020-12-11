package IntSortingMethods;

import java.util.*;

public class SelectionSort extends Sort {
    private int len;
    private int max; 
    private int min;
    private int maxRange; 
    void algorithm() {
    	/* You may change any code within this method */
        sort(this.data);
    }

    /* You may define any new methods you want and may change this method */
    void sort(int[] arr) {
        maxRange = 1000;
        len = arr.length; 

        switch(checkOrdering(arr)){
            case 1:
                System.out.println("array is already sorted");
                break;
            case 2:
                System.out.println("array is reversed");  
                reverseArray(arr);
                break;
            default: 
                // CHECK FOR COUNTING SORT 
                if(max - min < maxRange) {
                    // DO COUNTING SORT
                    System.out.println("using counting sort");
                    countingSort(arr, min, max);
                } else {
                    // BASE CASE: DO QUICK SORT
                    System.out.println("using quick sort");
                    quickSort(arr, 0, arr.length - 1);  
                }
                break;
        }
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

        max = prev;
        min = prev;

        // ALGORITHM TO FIND THE FIRST DIFFERENT PAIR OF VALUES
        while(true) {
            // ALLOCATE RANGES CORRECTLY
            max = Math.max(max, arr[counter]);
            min = Math.min(min, arr[counter]);


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
            // ALLOCATE RANGES CORRECTLY
            max = Math.max(max, arr[counter]);
            min = Math.min(min, arr[counter]);

            prev = arr[i-1];
            
            if(arr[i] > prev && inc == true) {
                continue;
            }
            else if(arr[i] < prev && dec == true) {
                continue;
            } else {
                // RESET THE BOOLEAN VALUES
                inc = false;
                dec = false;
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
    // This is counting sort from the textbook

    public void countingSort(int[] arr, int min, int max) {
        // IMPLEMENT STANDARD COUNTING SORT
        
        int range = max - min;

        // temporary storage array (length = range)
        int[] temp = new int[range + 1];
        int[] sorted = new int[arr.length];

        
        // for (int element: arr){
        //     temp[element - min] += 1;
        // }

        // increment the count of each element in temp array
        // since each element is independent of the next, we can optimize this step 
        // using loop unrolling 
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

        // temp[i] now contains the # of elems equal to i

        // temp[i] now contains the # of elems equal to i
        for (int i = 1; i <= range; i++) {
        temp[i] += temp[i - 1];
        }
        // temp[i] now contains the number of elem <= i
    
        for (int j = 0; j < arr.length; j++) {
        sorted[temp[arr[j] - min] - 1] = arr[j];
        temp[arr[j] - min] -= 1;
        }
        
        System.arraycopy(sorted, 0, arr, 0, sorted.length);
    }

    // BUCKETSORT
    // CR MIGHT NOT NEED TO USE THIS 
    public void bucketSort(int[] arr) {
        // IMPLEMENT STANDARD BUCKET SORT 
    }

    // base algorithm is from textbook pseudo code

    public void quickSort(int[] arr, int start, int end) {
        // MODIFIED VERSION OF QS WITH INSERTION SORT ON SMALLER PARTITIONS
        if(end - start + 1 < 25) {
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
    // this version of insertion sort is based off the pseudocode from:
    // https://en.wikipedia.org/wiki/Insertion_sort#Algorithm
    // it has been slightly modified to fit with our implementation of quicksort

    public void insertionSort(int[] arr, int start, int end){
        for(int i = start + 1; i < end + 1; i++) {
            int value = arr[i];
            int j = i - 1;

            while(j >= start && arr[j] > value) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = value;
        }
    }
}

