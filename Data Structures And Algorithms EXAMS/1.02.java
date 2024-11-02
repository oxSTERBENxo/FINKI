/*Дадена е двојно поврзана листа од двојно поврзани листи. Да се најде сума на секоја од подлистите, а потоа производ на овие суми
Влез: Број N кој кажува колку листи има, Број М кој кажува колку елементи има во секоја листа
Во следните М линии се податоците 1<=A<=1000 за секоја од листите 
Излез: Еден број што е производот на сумите од листите.
Пример:
Влез:             Излез:2352000
4
4
6 13 16 7 
7 23 9 11 
8 0 8 19 
6 6 9 11
------------------------------------------------------------------------
A double linked list of double linked lists is given. Find the sum of each sub-list, and then the product of all those sums.
Input: An integer N that tells us how many lists there are. An integer M that tells us how many elements there are in each list.
Output: The product of the sums of the sub-lists.
*/

//koristam samo edna lista.
import java.util.Scanner;

public class Kolokviumska2_DLL {
  //insert the DLL and DLLNode classes
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        DLL<Integer> list= new DLL<Integer>();
        long proizvod=1;
        for (int i = 0; i < n; i++) {
            long sum=0;
            for (int j = 0; j < m; j++) {
                list.insertLast(sc.nextInt());
                DLLNode <Integer> node=list.getLast();
                sum+=node.element;
                if(j==m-1){
                    proizvod*=sum;
                }
            }
        }
        System.out.println(proizvod);

    }
}
