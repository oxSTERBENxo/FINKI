/*Дадена е еднострана поврзана листа чии што јазли содржат по еден String. Дополнително, даден е и уште еден природен број L. Од дадената листа потребно е да се најде
последниот јазел којшто содржи String со должина L и да се премести на почеток на листата. Влез: Во првиот ред од влезот е даден бројот на елементи во листата - N,
па во следните N редови се дадени самите елементи (String-ови) од листата. На крај, во последниот ред е даден бројот L. Излез: На излез треба да се испечати 
листата пред и после промената.
/
You are given a single linked list with String nodes. Additionally, you are given one more integer L. You need to find the last node that contains a String with exactly L
characters, and move it to the front of the list. Input: In the first line from the input the number of elements in the list is given - N, and then in the next N lines 
the elements themselves. In the last line, the integer L is given. Output: The list before and after the transformation*/


import java.util.Scanner;
//input SLL and SLLNode class
public class SLL06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        SLL<String> list = new SLL<String>();
        for (int i = 0; i < N; i++) {
            list.insertLast(sc.next());
        }
        int L = sc.nextInt();
                        System.out.println(list);

        list.mirror();
        SLLNode<String> i= list.getFirst();
        while (i != null) {
            SLLNode<String> next=i.succ;
            if(i.element.length()==L){
                list.insertLast(i.element);
                list.delete(i);
                list.mirror();
                System.out.println(list);
                return;
            }
            i=next;
        }
        list.mirror();
        System.out.println(list);

    }
}
