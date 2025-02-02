/*Задача 1. Родендени
Во заводот на статистика се прави ново истражување каде што се открива броjот на луѓе родени во секоj месец. Ваша задача е за даден месец да прикажете колку
луѓе се родени во тоj месец. Влез: Во првиот ред од влезот е даден броjот на луѓе 𝑁 , а во секоj нареден ред е даден датумот на раѓање. Во последниот ред е даден
месецот за коj треба да се прикаже броjот на луѓе родени во тоj месец. Излез: Броj на луѓе кои се родени во тоj месец. Доколку нема лу´ге родени во тоj месец да се 
испечати „Empty”. Пример:
Влез:
4
20.7.1976
16.7.1988
18.7.1966
5.6.1988
7
Излез: 3*/

import java.util.*;

public class HashRodendeni {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, List<String>> map = new HashMap<>();

        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String[] dateParts = sc.nextLine().trim().split("\\.");
            int month = Integer.parseInt(dateParts[1]);
            String date = String.join(".", dateParts);

            map.putIfAbsent(month, new ArrayList<>());
            map.get(month).add(date);
        }
        int m = Integer.parseInt(sc.nextLine().trim());
        int count = 0;
        for (String date : map.get(m)) {
            count++;
        }

        if (count > 0) {
            System.out.println(count);
        } else {
            System.out.println("Empty");
        }

        sc.close();
    }
}

//nepotrebno e sho zacuvuvam strings ama nmvz. eve i drug nacin podolu kaj sho rabotime so counterot poveke
//ova mozebi e i podobro resenie


// import java.util.HashMap;
// import java.util.Scanner;

// public class HashRodendeni {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         HashMap<Integer,Integer> map = new HashMap<>();
//         int n = Integer.parseInt(sc.nextLine());
//         for(int i = 0; i < n; i++) {
//             String[] datum = sc.nextLine().trim().split("\\.");
//             int mesec = Integer.parseInt(datum[1]);
//             map.put(mesec,map.getOrDefault(mesec,0)+1); //getOrDefault da kazeme gi setnuva site values aka counterite za site meseci na 0 i posle si se inkrementira kako doagja do specificen mesec
//         }
//         int m = Integer.parseInt(sc.nextLine());
//         int count = map.get(m);
//         if(count>0){
//             System.out.println(count);
//         }else{
//             System.out.println("Empty");
//         }
//     }
// }
