/*Дадена е двострано поврзана листа од цели броеви. Дополнително, даден е и уште еден природен број k. Последните k елементи од листата треба да се поместат
на почетокот на листата, во истиот редослед. Влез: Во првиот ред од влезот е даден бројот на елементи во листата - N, па во следните следниот ред самите елементи
одделени со празно место. На крај, во последниот ред даден е и природниот број k. (k<=N) Излез: На излез треба да се испечати листата пред и после промената.
/
You are given a doubly-linked list of integers. Additionally, there is one more natural number k. You need to replace the last k elements of the list to the beginning
of the list, in the same order.Input: The first number in the input is the number of integers in the list - N, then in the next line the elements are given, separated by 
spaces. Then, in the last line, the natural number k is given. (k<=N) Output: The list before and after the transformation*/

import java.util.Scanner;
//input DLL and DLLNode classes

public class DLL11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DLL<Integer> list = new DLL<Integer>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }
        int k = sc.nextInt();
        System.out.println(list);
        for (int i = 0; i < k; i++) {
            list.insertFirst(list.getLast().element);
            list.deleteLast();
        }
        System.out.println(list);
    }
}
