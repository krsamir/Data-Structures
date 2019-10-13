import java.util.Scanner;
class triangle_iteration{
    public static int triangle(int num){
        int total = 0;
        while (num > 0) {
            total = total + num;
            num--;
        }
        return total;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number >> ");
        int num = sc.nextInt(); 
        System.out.println("The triangle no = "+triangle(num));
    }
}