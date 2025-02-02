/*На еден светски познат предавач секоjдневно му пристигнуваат понуди да држипредавања. За секоjа понуда се дадени датуми, време на почеток,
градот и изно-сот на хонорарот за предавањето (во долари). Ваша задача е за даден датум да го прикажете предавањето кое би му донело наjголема заработка на предавачот.
Доколку нема понуди за дадениот датум да се испечати „No offers”.Влез: Во првиот ред од влезот е даден броjот на понуди, а во секоj нареден ред се дадени: 
датумот и времето на предавањето (формат dd/mm/yyyyhh:mm),градот во коj ´ке се одржува предавањето и износот на хонорарот. Во последниотред е даден датумот 
за коj треба да испечатите коjа понуда е наjдобра за тоj датум. Излез: Деталите на понудата за тоj датум.
Пример:
Влез:
7
27/01/2016 14:00 NewYork 6000
28/01/2016 08:00 Paris 3000
28/01/2016 14:00 Munich 5000
27/01/2016 09:00 Beijing 8000
27/01/2016 08:00 Seattle 4000
28/01/2016 09:00 SaltLakeCity 10000
28/01/2016 09:00 Lagos 12000
27/01/2016
Излез:
09:00 Beijing 8000*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Predavac{
    String datum;
    String time;
    String city;
    int price;

    public Predavac(String datum, String time, String city, int price) {
        this.datum = datum;
        this.time = time;
        this.city = city;
        this.price = price;
    }

    @Override
    public String toString() {
        return time+" "+city+" "+price;
    }
}
public class HashNajdobraPonudaMeow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, ArrayList<Predavac>> map = new HashMap<>();

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[]data = sc.nextLine().trim().split("\\s+");
            String datum = data[0];
            String time = data[1];
            String city = data[2];
            int price = Integer.parseInt(data[3]);

            Predavac p = new Predavac(datum, time, city, price);
            map.putIfAbsent(datum, new ArrayList<>());
            map.get(datum).add(p);

        }
        String date = sc.nextLine();
        int max = Integer.MIN_VALUE;
        Predavac maxPredavac = map.get(date).get(0);
        for(Predavac c: map.get(date)){
            if(max<c.price){
                max = c.price;
                maxPredavac = c;
            }
        }
        System.out.println(maxPredavac);
    }
}
