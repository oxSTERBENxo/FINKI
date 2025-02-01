/*Да се напише алгоритам коj ´ке врши евалуациjа на израз во постфикс нотациjа. Пример 5 9 + 2 * 6 5 * + изразот е во постфикс нотациjа, и го претставува
изразот (5 + 9) * 2 + 6 * 5, со што по евалуациjата резултатот треба да биде 14 * 2 + 30 = 58.
Влез: Во влезот е даден изразот коj се внесува. Излез: На излез треба да се испечати резултатот од евалуациjата на изразот.
Пример: Влез: 5 9 + 2 * 6 5 * + Излез: Rezultatot e 58.0*/

import java.util.Scanner;
import java.util.Stack;

public class StackPostfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String operation = sc.nextLine();

        String[] tokens = operation.split(" "); //note: to handle multiple spaces use \\s+ as regex
        Stack<Double> stack = new Stack<>();

        for (String i : tokens) {
            if (!(i.equals("+") || i.equals("-") || i.equals("*") || i.equals("/"))) {
                stack.push(Double.parseDouble(i));
            } else {
                if (stack.size() < 2) {
                    System.out.println("Invalid input");
                    return;
                }

                double b = stack.pop();
                double a = stack.pop();
                double ans = 0.0;

                if (i.equals("+")) {
                    ans = a + b;
                } else if (i.equals("-")) {
                    ans = a - b;
                } else if (i.equals("*")) {
                    ans = a * b;
                } else if (i.equals("/")) {
                    if (b == 0) {
                        System.out.println("Error: Dev by 0");
                        return;
                    }
                    ans = a / b;
                } else {
                    System.out.println("Error: Unknown operation");
                }
                stack.push(ans);

            }

        }
        System.out.println(stack.pop());
    }
}

// check out
// https://github.com/avonamolos/symmetrical-winner/blob/main/algorithms/src/stacks/postfixNotation.java
