import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float f1 = sc.nextFloat();
        float f2 = sc.nextFloat();
        
        int n1 = (int) f1;
        int n2 = (int) f2;
        
        //..... YOUR CODE STARTS HERE .....
         int bitwiseAnd = n1 & n2;
         int bitwiseOr = n1 | n2;
         int bitwiseXor = n1 ^ n2;
         int bitwiseNotNum1 = ~n1 & n2;
        
        System.out.println("Bitwise AND result:"+ " " + bitwiseAnd);
        System.out.println("Bitwise OR result:"+ " " + bitwiseOr);
        System.out.println("Bitwise XOR result:"+ " " + bitwiseXor);
        System.out.println("Bitwise NOT and AND result:"+ " " + bitwiseNotNum1);
        //..... YOUR CODE ENDS HERE .....
    }
}
