import java.util.Scanner;
class Linear_Search{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = {5,7,11,25,97,45};
        int count = 0;
        int len = arr.length;
        System.out.print("Enter the number you want to search : ");
        int num = sc.nextInt();
        for (int i = 0; i < len; i++) {
            if(arr[i] == num){
                count++;
                System.out.println("The element is being found in the array and its index is "+i);
            }
        }
        if (count == 0) {
            System.out.println("The element is not present in the array.");
        }
    }
}