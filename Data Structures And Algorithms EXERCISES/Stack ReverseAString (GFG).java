/*Problem: Given a string, reverse it using a stack.
Concept Used: LIFO (Last In, First Out) property of the stack.*/

import java.util.Scanner;
import java.util.Stack;

public class StackReverseAStringUsingStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String str = sc.nextLine();
        Stack<String> stack = new Stack<>();

        String[] chars = str.split("");

        for (String ch : chars) {
            stack.push(ch);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop()); 
        }
    }
}
