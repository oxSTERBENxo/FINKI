/*Даден е код на модифициран програмски јазик каде функциите се претставени со отворен и затворен таг ("imeFunkcija" и "endimeFunkcija"). 
Ваша задача е да дефинирате дали даден програмски код е валиден.
Пример валиден код:
func1
func2
endfunc2
func3
endfunc3
endfunc1
Пример невалиден код (испуштен е затворен таг за func3):
func1
func2
endfunc2
func3
endfunc1
Влез: Код со модифициран програмски јазик, каде секој таг е напишан во нов ред. Се внесуваат тагови се додека не се внесе "x".
Излез: "Valid" - доколку е валиден кодот, "Invalid" - доколку не е валиден кодот.
/
*/

import java.util.Scanner;
import java.util.Stack;

public class Stack1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        
        while (true) {
            String s = sc.nextLine(); 
            if (s.equals("x")) {
                break; 
            }

            if (s.startsWith("end")) {
                String funcName = s.substring(3); 

                if (stack.isEmpty() || !stack.peek().equals(funcName)) {
                    System.out.println("Invalid");
                    return;
                }
                stack.pop(); 
            } else {
                stack.push(s); 
            }
        }

        if(stack.isEmpty()){
            System.out.println("Valid");
        }else{
            System.out.println("Invalid");
        }
    }
}
