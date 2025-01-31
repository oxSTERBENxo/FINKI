/*Problem: Given a string, reverse it using a stack.
Concept Used: LIFO (Last In, First Out) property of the stack.*/
import java.util.Scanner;
import java.util.Stack;

public class StackReverseAStringUsingStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        Stack<Character> stack = new Stack<>();

        for (Character ch : str.toCharArray()){
            stack.push(ch);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
