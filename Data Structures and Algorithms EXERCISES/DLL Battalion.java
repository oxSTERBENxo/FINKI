/* Пред командантот на батаљонот наредени се сите војници и во двојно поврзана листа дадени се нивните ID-a. 
На командантот не му се допаѓа како се наредени војниците и решава да одбере еден под-интервал од војници и истиот да го преврти.
Влез: Во првиот ред даден е бројот на војници. Во вториот ред дадени се ID-то на секој од војниците. 
Во третиот ред дадени се два броеви, ID на првиот војник и ID на последниот војник од интервалот. 
Излез: Да се испечати новиот редослед на војниците (т.е. на нивните ID-a), од почеток на листата до крај, и обратно.
Забелешка 1: Интервалот, како и целата листа, ќе содржи барем два војници.
Забелешка 2: Обратете посебно внимание кога интервалoт почнува од првиот војник или завршува со последниот војник. Внимавајте:
1. Даден е целосниот код на структурата којашто треба да се користи. Дадена е и тест класата DLLBattalion.java, 
  со целосно имплементиран input и output. Потребно е да се менува само во рамки на void battalion(DLL<Integer> list, int a, int b)
  функцијата.
2. Притоа, поместувањето на интервалите треба да се однесува на менувањето на самите врски во јазлите од листата.
3. Не смее да менувате во main функцијата !
--------------------------------------------------------------------------------------------
Before the battalion commander are lined up all the soldiers, and in a doubly linked list are given their IDs. 
The commander doesn't like how the soldiers are lined up so he decides to choose one sub-interval and reverse it.  
Input: In the first line you are given the number of soldiers. In the second line you are given the IDs of each solider.
In the third line you are given two numbers, IDs of the first and last solider of the sub-interval.
Output: Print the new solider line-up (i.e. their IDs), from the beginning of the list to the end, and reversed.
Note 1: The sub-interval, as well as the list itself, will have at least two soldiers.
Note 2: Pay special attention when the interval begins with the first soldier of the list, or ends with the last one. Pay attention:
1. All the needed code for the structure that you need to use is given. The test class DLLVojska.java is also given, 
with completely implemented input and output. You only need to change the code of the void battalion(DLL<Integer> list, int a, int b) method.
2. The moving of the intervals needs to be done with changing the links of the nodes in the list.
3. You must not change the main method ! */

import java.util.Scanner;
public class Main{
    //insert the DLL and DLLNode classes
  
    //TODO: implement function
    public static void battalion(DLL<Integer> list, int a, int b) {
        DLLNode<Integer> start= list.find(a);
        DLLNode<Integer> end= list.find(b);
        while(start!=end) {
            int tmp=start.element;
            start.element=end.element;
            end.element=tmp;
            start=start.succ;
            if(start==end){
                break;
            }
            end=end.pred;
        }
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        DLL<Integer> list = new DLL<>();
        for(int i=0;i<n;i++) {
            list.insertLast(input.nextInt());
        }

        int a = input.nextInt();
        int b = input.nextInt();
        battalion(list, a, b);
        System.out.println(list);
        System.out.println(list.toStringR());


    }
}
