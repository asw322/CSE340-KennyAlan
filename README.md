CSE 340 SORTING PROJECT BY:
ALAN WANG
KENNY LIN

This project was designed and implemented for the CSE 340 extra credit project. The main purpose of this project is to come up with an efficient sorting algorithm that performs well in most cases. We wanted our algorithm to work better than general sorting algorithms such as Merge Sort. While we do realize that merge sort worst case asymptotic runtime is O(nlgn), in practice it is slower than other sorting algorithms like quick sort due to the larger runtime coefficients found in merge sort. 

We developed a sorting algorithm that uses quick sort as a baseline but tried to optimize the algorithm to avoid the worst case O(n^2) runtime when the input array is already pre sorted decreasingly or increasingly. We did this by using a 'checkOrder(int[] arr)' function that returns: 

0 = unsorted
1 = sorted 
    just return it 
2 = sorted in reverse
    reverse and return it 

From this, we can eliminate the worst case runtime from quick sort. 
If checkOrder returns 0, we then want to see if we can use a faster linear time sorting algorithm such as counting sort or bucket sort (bucket sort not implemented here). To do this, we already have the ranges from the linear scan in checkOrder(), then we can check if the range of input array is less than some fixed value. We chose maxRange (set to 1000 now) as this range max and this value can be adjusted. We did this to ensure that we wouldn't have unnecesarrily large space complexity being that the program is bounded by the stack space. (We know we probably wont reach this stack space but we still wanted to be efficient and realistic)





CHECK ORDERING: 
returning values: 
0 IS UNSORTED
1 IS SORTED INCREASING
2 IS SORTED DECREASING


CHECK THE ORDERING OF THE ARRAY (DONE) 
1. IF THE ARRAY IS IN INCREASING SORTED ORDER
    1. return it 
2. IF THE ARRAY IS IN DECREASING SORTED ORDER (DONE)
    1. return reverse array (DONE)
3. ELSE
    1. CHECK IF CAN USE COUNTING SORT 
        1. DO COUNTING SORT
    2. CHEC KIF CAN USE BUCKET SORT
        1. DO BUCKET SORT 
    3. ELSE 
        1. DO QUICKSORT (DONE)



1 2 3 2


