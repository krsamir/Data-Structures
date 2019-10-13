import java.util.Scanner;
class triangle_recursion{
    public static int triangle(int num){
        if(num == 1)
            return 1;
        else 
        return (num+triangle(num-1));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number >> ");
        int num = sc.nextInt();
        System.out.println("Triangle number = "+triangle(num)); 

    }
}