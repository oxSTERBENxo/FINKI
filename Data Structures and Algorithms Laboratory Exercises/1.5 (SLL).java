/*Дадена е еднострана поврзана листа чии што јазли содржат по еден String. Дополнително, даден е и уште еден природен број L. Во дадената листа потребно е сите 
јазли коишто содржат String со должина L да се поместат на крај на листата, задржувајќи го и оригиналниот распоред на елементите.
Влез: Во првиот ред од влезот е даден бројот на елементи во листата - N, па во следните N редови се дадени самите елементи (String-ови) од листата. 
На крај, во последниот ред е даден бројот L. Излез: На излез треба да се испечати листата пред и после промената.
/
You are given a single linked list with String nodes. Additionally, you are given one more integer L. You need to move all nodes from the list that contain a
String with exactly L characters to the end of the list, keeping the original order of elements as well. Input: In the first line from the input the number of elements 
in the list is given - N, and then in the next N lines the elements themselves. In the last line, the integer L is given. Output: The list before and after the transformation*/

import java.util.Scanner;
//input SLL and SLLNode classes

public class SLL05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SLL<String> list = new SLL<String>();
        int n = sc.nextInt();
        int k=n;
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.next());
        }
        int L = sc.nextInt();
        System.out.println(list);
        SLLNode<String> i = list.getFirst();
        while(i != null && k!=0) {
            k--;
            SLLNode<String> curr = i.succ;
            if(i.element.length()==L){
                list.insertLast(i.element);
                list.delete(i);
            }
            i = curr;
        }
        System.out.println(list);
    }
}
