class Selection_Sort{
    public static void main(String[] args) {
        //This is a program for selection sort.
        int arr[] = {4,9,7,1,3,6,5};                //Declaration of the array
        int len = arr.length;
        int smallest,index = 0;
        System.out.println("Original array : ");
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i]+"\t");
        }  

        for (int i = 0; i < len; i++) {             //Outer loop
            smallest = arr[i];                      //intialising variable smallest with the element  
                                                    //on which we are performing our operation 
            for (int k = i; k < len; k++) {         //inner loop which will find the smallest in the array
                                                    //It will start from the position after the array position where it was last sorted(as K= i)

                if(arr[k] < smallest){
                    smallest = arr[k];              //the new smallest item after being transversed into array
                    index = k;                      //index where the smallest number was found
                }
                                            
            }
            int temp = arr[i];                      //storing the unsorted element which is to be swapped to the differrent position
            arr[i] = smallest;                      //Storing the smallest element found in the last iteration
            arr[index] = temp;                      //as we know the index of the element where the smallest Number was found so 
        }

        System.out.println();
        System.out.println("Sorted array : ");
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i]+"\t");
        }   
        /**The outer loop is to select the position on which we need to perform our operation 
         * we will perform sorting by finding the minimum number in the array each time 
         * and assign its correct position,which is done by the second loop;
         * Swapping (It is done by the outer loop.)
         * arr[i] is stored in temp variable i.e. the variable where we are performing our operation.As this position is controlled by outer loop
         * The selected position is overwritten by the smallest number found in the last operation.
         * now the position from where the smallest number was taken is substituted with element in the previous position.
        */
    }
}
