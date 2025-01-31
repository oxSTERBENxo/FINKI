/*Да се провери коректноста на заградите во еден израз. Еден израз има коректни загради ако:
- За секоjа лева заграда, подоцна следува соодветна десна заграда 
- За секоjадесна заграда претходно постои лева заграда
- Секоj под-израз ме´гу пар од две загради содржи коректен броj на загради.
Примери на изрази со коректни и некоректни загради: s x (s – a) x (s – b) x (s - c) коректни, (– b + sqrt[b2 – 4ac]) / 2a коректни
s x (s – a) x (s – b x (s – c) некоректни, s x (s – a) x s – b) x (s – c) некоректни, (– b + sqrt[b2 – 4ac)] / 2a некоректни
Влез: Во влезот е даден изразот коj се внесува. Излез: На излез треба да се испечати дали заградите во изразот се коректни или не.
Пример: Влез: s x (s - a) x (s - b) x (s - c) Излез: s x (s - a) x (s - b) x (s - c) ima korektni zagradi.*/

//using the java Stack implementation

import java.util.Scanner;
import java.util.Stack;

public class StackZagradi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<Character>();
        String fraza = sc.nextLine();
        int valindost = 1;
        for (int i = 0; i < fraza.length(); i++) {
            char current = fraza.charAt(i);

            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
            } else if (current == ')' || current == ']' || current == '}') {
                if (stack.isEmpty()) {
                    valindost = 0;
                    break;
                }
                char top = stack.pop();
                if (!((top == '(' && current == ')') ||
                        (top == '[' && current == ']') ||
                        (top == '{' && current == '}'))) {
                    valindost = 0;
                    break;
                }
            }
        }
        if(stack.isEmpty()){
            valindost = 1;
        }
        if(valindost == 1){
            System.out.println("korektni");
        }else{
            System.out.println("nekorektni");
        }
    }
}

