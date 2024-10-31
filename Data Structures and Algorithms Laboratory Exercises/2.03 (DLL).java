/*За дадена двојно поврзана листа од N цели броеви, треба да се најде бројот на елементи такви што просекот на елементите од пред него во листата е поголем од просекот 
на елементи после него во листата. Влез: Првиот број од влезот е бројот на елементи во листата N, а потоа во следниот ред се дадени самите елементи одделени со празно место.
Излез: Бројот на елементи што го задоволуваат условот.
--------------------------------------------------------------------------
For a given doubly-linked list with N integers, you need to find the number of elements such that the average of all elements before it is bigger than the average of 
all elements after it in the list. Input: The first number in the input is the number of integers in the list N, then in the next line the elements are given, 
separated by spaces. Output: The number of elements that satisfy the condition.*/

import java.util.Scanner;
//insert the DLL and DLLNode classes
public class  Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DLL<Integer> lista = new DLL<Integer>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            lista.insertLast(sc.nextInt());
        }
        int counter=0;
        for (DLLNode<Integer> i = lista.getFirst().succ; i != null && i.succ!=null; i = i.succ) {
            boolean flag = false;
            float avg1=0, avg2=0;
            int c1 = 0, c2 = 0;
            for(DLLNode<Integer> j = lista.getFirst(); j != null; j = j.succ){
                if(j==i) {
                    flag = true;
                    continue;
                }
                if(!flag){
                    avg1+=j.element;
                    c1++;
                }
                if(flag) {
                    avg2+=j.element;
                    c2++;
                }

            }
            if(avg1/c1>avg2/c2){
                counter++;
            }
        }
        System.out.println(counter);
    }

}
