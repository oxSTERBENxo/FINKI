/*
Дадена е еднострана поврзана листа од броеви со дупликати. За дадена вредност на info поле во листата, да се обезбеди бројот на повторувања на тој број да биде парен. 
Доколку за дадената вредност на инфо полето, бројот на елементи со таа вредност е непарен, треба да се додаде истиот елемент пред првото појавување на елементот со таа вредност  во листата. Забелешка: 0 е парен број. 
Влез: Во првиот ред се внесуваат бројот на елементи во листата, па потоа самите елементи, а на крај се внесува бројот (вредноста) кој ќе се осигураме дека се појавува парен број на пати.
Излез:Листата со парен број на дупликати за дадената вредност
Примери:
Влез:                         Излез: 1 2 5 7 7 9 12
6  
1 2 5 7 9 12              
7
Влез:                         Излез: 7 7 1 2 7 5 9 7 12
8
7 1 2 7 5 9 7 12
7
-----------------------------------------------------------------------------
A single linked list of duplicate numbers is given. For a given value of an info field in the list, ensure that the number of repetitions (duplicates) of that number is even. If for the given value of the info field,
the number of elements with that value is odd, an element with the same value should be added before the first appearance of the value. Note: 0 is an even number.
Input: In the first line, the number of elements in the list are given, then the elements themselves, and finally, the number (value) that will ensure that it appears an even number of times.
Output: The list with an even number of duplicates for a given value is printed on output.
*/

import java.util.Scanner;

public class Kolokviumska1_SLL {
  //insert the SLL and SLLNode classes
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        SLL <Integer> list = new SLL<Integer>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }
        int k = sc.nextInt();
        int counter=0;
        for (SLLNode <Integer> i=list.getFirst();i!=null;i=i.succ) {
            if(k==i.element){
                counter++;
            }
        }
        if (counter%2==1) {
            SLLNode<Integer> node = list.getFirst();
            while (node != null) {
                if (k == node.element) {
                    list.insertBefore(k, node);
                    break;
                }
                node = node.succ;
            }
        }
        System.out.println(list);
    }
}
