/*Дадена е двострано поврзана листа од цели броеви. Дополнително, дадени се и уште еден цел број M и еден природен број k. Треба да се најде првото појавување на M во
листата и тој број да се помести k места на десно. Влез: Во првиот ред од влезот е даден бројот на елементи во листата - N, па во следните следниот ред самите елементи 
одделени со празно место. На крај, во последните два реда дадени се целиот број M и природниот број k. Излез: На излез треба да се испечати листата пред и после промената.
/
You are given a doubly-linked list of integers. Additionally, there is one more integer M and a natural number k. You need to find the first occurence of M in the list 
and move that node k times to the right. Input: The first number in the input is the number of integers in the list - N, then in the next line the elements are given, 
separated by spaces. Then, in the last two lines, the integer M and the natural number k are given. Output: The list before and after the transformation*/

import java.util.Scanner;
//input DLL and DLLNode classes

public class DLL10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DLL<Integer> list = new DLL<Integer>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }
        int m = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(list);
        DLLNode<Integer> found = list.find(m);
        if(found == null){
            System.out.println(list);
            return;
        }
        DLLNode<Integer> tmp = found;
        int flag = 0;
        if(k>0){
            k=k%n;
            if(k!=0){
                for(int i=0;i<k;i++){
                    if(tmp==list.getLast()){
                        tmp=list.getFirst();
                        flag=1;
                    }else{
                        tmp=tmp.succ;
                    }
                }
                if(flag==0){
                    list.insertAfter(m,tmp);
                }else{
                    list.insertBefore(m,tmp);
                }
                list.delete(found);
            }
        }
        System.out.println(list);
    }
}
