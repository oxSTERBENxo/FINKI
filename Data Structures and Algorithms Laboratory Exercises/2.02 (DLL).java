/*Дадена е двострано поврзана листа од цели броеви. Дополнително, дадени се и уште еден цел број M и еден природен број k. Треба да се најде првото појавување на M 
во листата и тој број да се помести k места на лево.
Влез: Во првиот ред од влезот е даден бројот на елементи во листата - N, па во следните следниот ред самите елементи одделени со празно место. 
На крај, во последните два реда дадени се целиот број M и природниот број k. Излез: На излез треба да се испечати листата пред и после промената.
----------------------------------------------------------------------------------
You are given a doubly-linked list of integers. Additionally, there is one more integer M and a natural number k. You need to find the first occurence of M 
in the list and move that node k times to the left.
Input: The first number in the input is the number of integers in the list - N, then in the next line the elements are given, separated by spaces. 
Then, in the last two lines, the integer M and the natural number k are given.Output: The list before and after the transformation*/

import java.util.Scanner;
//insert the DLL and DLLNode classes here
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DLL <Integer> niza=new DLL<Integer>();
        int n=sc.nextInt();
        for(int i=1;i<=n;i++){
            niza.insertLast(sc.nextInt());
        }
        int m=sc.nextInt();
        int k=sc.nextInt();
        DLLNode target=niza.find(m);
        DLLNode curr=target;
        boolean flag=false;
        while(k>0){
            if(curr.pred==null){
                flag=true;
                curr=niza.getLast();
            }else{
            curr=curr.pred;
            }
            k--;
        }
        if(flag){
            niza.insertAfter(m,curr);
        }else{
            niza.insertBefore(m,curr);
        }
        niza.delete(target);

        System.out.println(niza);
    }
}
