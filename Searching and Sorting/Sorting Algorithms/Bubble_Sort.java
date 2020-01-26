class Bubble_Sort{
    public static void main(String[] args) {
        int arr[] = {95,25,77,7,27,52};                         //declaration of array
        int len = arr.length;                                   // length of the array
        System.out.println("\nUnsorted Array : \n");
        for(int j = 0; j<len;j++){                          
            System.out.print(arr[j]+"\t");
        }
        for (int i = 0; i < len-1; i++) {                   
            for (int j = 0; j < (len-1)-i; j++) {       
                if (arr[j] > arr[j+1]) {
                    int  temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("\nSorted Array : \n");
        for(int j = 0; j<len;j++){
            System.out.print(arr[j]+"\t");
        }

        /**
         * Basic principle of bubble Sorting >> 
         * Compare the adjacent elements and swap them if condition is met.
         * 
         * Bubble Sort in ascending
         * In each inner iteration:
         * the previous element is compared to the next element.If the previous element is larger than the next element then there is swapping
         * between the elements.In this way the larger element is transerversed in the next position of the array.
         * So at the end of one whole iteration i.e.(for j = 0;j < (len-1)-i ;j++) the largest element in the current array moves at the end
         * of the array
         * In each outer iteration:
         * In first iteration of the outer loop >> Largest number goes to the last position.
         * In Second iteration of the outer loop >> Second Largest number goes to the second last position.
         * and consecutively one by one every elements takes there respective position. 
         * 
         * There is a condition in the second loop i.e. j < (len-1)-i  
         * through which we iterate only on unsorted elements. 
         * We don't need to iterate on the sorted elements again.
         *  
         */
    }
}