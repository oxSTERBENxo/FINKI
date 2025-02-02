/*На влез во оваа задача ќе ви бидат дадени редови како следниот формат: Ime Prezime budzhet ip_adresa vreme grad cena
Пример Jovan Todorov 1000 10.73.112.200 15:30 Bitola 760
Кое што значи дека лицето со Име и Презиме Jovan Todorov, има буџет од 1000 денари, има IP адреса со мрежа 10.73.112 и домаќин (host number) 200, 
и се приклучил во 15:30 часот за да купи билет кон Bitola кој што чини 760 денари. Ќе ви бидат дадени N такви редови, по што ќе следи празен ред па уште M редови 
од истиот формат, кои ќе ги користиме за тестирање. Од редот за тестирање треба да ја извадите IP адресата на мрежата и потоа да го одговорите следното прашање со оваа мрежа:
Од сите N лица на влез, кои што се поврзуваат со истата мрежа (од било кој домаќин во мрежата) колку од нив имале доволно буџет за да го купат билетот; и од овие, 
кој од нив платил најголем износ. (погледнете го тест примерот!) (доколку има повеќе со ист најголем износ тогаш кој е првиот таков во влезот?) 
(секогаш ќе постои барем еден таков) Ова ќе треба да го направите за сите M редови за тестирање! Препорака, користете OBHT и/или CBHT.
----------------------
At the input of this task you will be given rows with the following format: First_name Last_name budget ip_address time city price
Example Jovan Todorov 1000 10.73.112.200 15:30 Bitola 760
Which means that the person with First name and Last name Jovan Todorov, has a budget of 1000 denars, has an IP address with network 10.73.112 and host number 200, 
and joined at 15:30 to buy a ticked to Bitola which costs 760 denars. You will be given N such rows, followed by an empty row and M more rows of the same format,
which we will use for testing. From the test line you need to extract the IP address of the network and then answer the following question with this network:
Of the N people at the input, from the ones who connect from the same network (from any host on the network) how many of them had enough budget to buy the ticket; and
of these, which one paid the highest amount? (if there are more with the same highest amount then which one is the first one in the input?) 
(there will always be at least one such) You will need to do this for all M rows for testing! Recommendation, use OBHT and/or CBHT.*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
class Covek{
    String ime;
    String prezime;
    int budget;
    String ip;
    String time;
    String city;
    int price;

    public Covek(String ime, String prezime, int budget, String ip, String time, String city, int price) {
        this.ime = ime;
        this.prezime = prezime;
        this.budget = budget;
        this.ip = ip;
        this.time = time;
        this.city = city;
        this.price = price;
    }

    @Override
    public String toString() {
        return ime+" "+prezime+" with salary "+budget+" from address " +ip+ " who spent "+price;
    }
}
public class Hesh5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, ArrayList<Covek>> map = new HashMap<>(); //string za ip

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().trim().split("\\s+");
            String ime = data[0];
            String prezime = data[1];
            int budget = Integer.parseInt(data[2]);
            String ip = data[3];
            String time = data[4];
            String city = data[5];
            int price = Integer.parseInt(data[6]);

            String[] ipSplit = ip.split("\\.");
            String network = ipSplit[0]+"."+ipSplit[1]+"."+ipSplit[2];
            Covek c = new Covek(ime, prezime, budget, ip, time, city, price);
            map.putIfAbsent(network, new ArrayList<>());
            map.get(network).add(c);
        }
        sc.nextLine();
        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < m; i++) {
            String[] data = sc.nextLine().trim().split("\\s+");
            String ip = data[3];

            String[] split = ip.trim().split("\\.");
            String network = split[0]+"."+split[1]+"."+split[2];

            int counter = 0;
            int maxPlateno = Integer.MIN_VALUE;
            Covek maxCovek = map.get(network).get(0);
            for(Covek c : map.get(network)) {
                if(c.budget>=c.price){
                    counter++;
                    if(maxPlateno<c.price){
                        maxPlateno=c.price;
                        maxCovek=c;
                    }
                }
            }
            System.out.println("IP network: "+network+ " has the following number of users:");
            System.out.println(counter);
            System.out.println("The user who spent the most from that network is:");
            System.out.println(maxCovek);
            System.out.println();
        }

    }
}
