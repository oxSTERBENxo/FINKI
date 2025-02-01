/*Со користење на податочна структура да се наjде дали еден израз има дупли загради или не. Изразот е правилен и содржи само еден вид загради ().
Доколку има да се испечати соодветна порака. Задачата да се реши со временска и мемориска сложеност од O(n).
Влез: Во влезот е даден аритметичкиот израз. Излез: На излез треба да се испечати "Najdeni se dupli zagradi доколку се наjдени дупли загради во изразот. 
Доколку нема се печати “/”.
Забелешка: Задачата се решава исклучиво со една податочна структура и не е дозволено користење на дополнителни други структури.
Пример 1: Влез: (((a+(b)))+(c+d)) Излез: Najdeni se dupli zagradi
Пример 2: Влез:((a)+(b)) Излез:/
*/

//note: nivnata definicija za dupli zagradi ne broi (a) vakvi momenti ko dupli zagradi.

import java.util.Scanner;
import java.util.Stack;

public class StackDupliZagradi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        String input = sc.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == ')') {
                int counter = 0;
                while (!stack.isEmpty() && stack.peek() != '(') {
                    stack.pop();
                    counter++;
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                if (counter == 0) {
                    System.out.println("Najdeni se dupli zagradi");
                    return;
                }
            } else {
                stack.push(c);
            }
        }

        System.out.println("/");
    }
}
