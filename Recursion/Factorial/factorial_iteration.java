import java.util.Scanner;
class factorial_iteration{
    public static int factorial(int num){
        int fact = 1;
        if(num == 1 || num == 0){
            return 1;
        }
        else
        while(num>1){
            fact = fact * num;
            num--;
        }
        return fact;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number >> ");
        int num = sc.nextInt();
        System.out.println("Factorial of the number is "+factorial(num));
    }
}