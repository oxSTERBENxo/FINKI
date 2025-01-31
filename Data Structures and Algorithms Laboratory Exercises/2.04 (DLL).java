/*Дадена е двострано поврзана листа од цели броеви. Дополнително, даден е и уште еден природен број k. Елементите во листата треба да се ротираат k пати на лево.
Влез: Во првиот ред од влезот е даден бројот на елементи во листата - N, па во следните следниот ред самите елементи одделени со празно место. 
На крај, во последниот ред даден е и природниот број k. Излез: На излез треба да се испечати листата пред и после промената.
/
You are given a doubly-linked list of integers. Additionally, there is one more natural number k. You need to rotate the elements of the list k times to the left.
Input: The first number in the input is the number of integers in the list - N, then in the next line the elements are given, separated by spaces. 
Then, in the last line, the natural number k is given. Output: The list before and after the transformation*/

import java.util.Scanner;
//input DLL and DLLNode classes

public class DLL08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DLL<Integer> list = new DLL<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }
        int k = sc.nextInt();
        if(n!=0 && k>0){
            k=k%n;
            if(k!=0){
                DLLNode<Integer> head = list.getFirst();
                for (int i = 0; i < k; i++) {
                    head=head.succ;
                }
                DLLNode<Integer> tail = head.pred;

                tail.succ=null;
                head.pred=null;

                list.getLast().succ=list.getFirst();
                list.getFirst().pred=list.getLast();

                list.deleteList();
                list.insertFirst(head.element);
                DLLNode<Integer> temp = head.succ;
                while(temp!=null){
                    list.insertLast(temp.element);
                    temp=temp.succ;
                }
            }
        }
        System.out.println(list);
    }
}
