/*На влез во оваа задача ќе ви бидат дадени редови како следниот формат: Ime Prezime budzhet ip_adresa vreme grad cena
Пример Jovan Todorov 1000 10.73.112.200 15:30 Bitola 760
Кое што значи дека лицето со Име и Презиме Jovan Todorov, има буџет од 1000 денари, има IP адреса со мрежа 10.73.112 и домаќин (host number) 200, 
и се приклучил во 15:30 часот за да купи билет кон Bitola кој што чини 760 денари. Ќе ви бидат дадени N такви редови, по што ќе следи празен ред па уште M редови
од истиот формат, кои ќе ги користиме за тестирање. Од редот за тестирање треба да ја извадите IP адресата на мрежата и потоа да го одговорите следното прашање со 
оваа мрежа: Од сите N лица на влез, кои што се поврзуваат со истата мрежа (од било кој домаќин во мрежата) колку од нив се вклучиле подоцна од 11:59; и од овие,
кој од нив се вклучил најрано? (погледнете го тест примерот!)(доколку има повеќе со исто најмало време тогаш кој е првиот таков во влезот?) (секогаш ќе постои барем еден таков)
Ова ќе треба да го направите за сите M редови за тестирање! Препорака, користете OBHT и/или CBHT.
----------------------
At the input of this task you will be given rows with the following format: First_name Last_name budget ip_address time city price
Example Jovan Todorov 1000 10.73.112.200 15:30 Bitola 760
Which means that the person with First name and Last name Jovan Todorov, has a budget of 1000 denars, has an IP address with network 10.73.112 and host number 200, 
and joined at 15:30 to buy a ticked to Bitola which costs 760 denars. You will be given N such rows, followed by an empty row and M more rows of the same format, 
which we will use for testing. From the test line you need to extract the IP address of the network and then answer the following question with this network:
Of the N people at the input, from the ones who connect from the same network (from any host on the network) how many of them logged in later than 11:59; and of these, 
which one logged in the earliest? (if there are more with the same minimum time then which one is the first one in the input?) (there will always be at least one of them)
You will need to do this for all M rows for testing!
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class Customer{
    String name;
    String surname;
    int budget;
    String ip;
    String time;
    String city;
    int price;

    public Customer(String name, String surname, int budget, String ip, String time, String city, int price) {
        this.name = name;
        this.surname = surname;
        this.budget = budget;
        this.ip = ip;
        this.time = time;
        this.city = city;
        this.price = price;
    }

    @Override
    public String toString() {
        return name+" "+surname+" with salary "+budget+" from address " +ip+ " who logged in at "+time;
    }
}

public class Hesh4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, List<Customer>> map = new HashMap<>();
        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().trim().split("\\s+");
            String name = data[0];
            String surname = data[1];
            int budget = Integer.parseInt(data[2]);
            String ip = data[3];
            String time = data[4];
            String city = data[5];
            int price = Integer.parseInt(data[6]);

            String[] ipParts = ip.trim().split("\\.");
            String network = ipParts[0]+"."+ipParts[1]+"."+ipParts[2];

            Customer c = new Customer(name, surname, budget, ip, time, city, price);
            map.putIfAbsent(network, new ArrayList<>());
            map.get(network).add(c);
        }
        sc.nextLine();
        int m = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < m; i++) {
            String[] data = sc.nextLine().trim().split("\\s+");
            String ip = data[3];
            String[] ipParts = ip.split("\\.");
            String network = ipParts[0]+"."+ipParts[1]+"."+ipParts[2];

            Customer minCustomer = map.get(network).get(0);
            int minTime = Integer.MAX_VALUE;
            int counter = 0;
            for(Customer c : map.get(network)) {
                String[] timeData = c.time.trim().split(":");
                int hours = Integer.parseInt(timeData[0]);
                int minutes = Integer.parseInt(timeData[1]);
                int TimeInMin = hours * 60 + minutes;
                if(TimeInMin >= 12*60) {
                    if(TimeInMin<minTime) {
                        minTime = TimeInMin;
                        minCustomer = c;
                    }
                    counter++;
                }
            }
            System.out.println("IP network: "+network+" has the following number of users:");
            System.out.println(counter);
            System.out.println("The user who logged on earliest after noon from that network is:");
            System.out.println(minCustomer);
            System.out.println();
        }

    }
}

//ex test case 
/*input
5
Jovan Todorov    1000    10.73.112.200     16:30   Bitola     760
Mitko Janev      4350    132.28.112.200    12:15   Krusevo    4000
Sara Dobreva     2700    10.73.60.29       14:35   Bitola     2500
Mence Trajanova  4000    10.73.112.112     11:25   Bitola     4200
Viktor Jovev     2200    10.73.112.79      15:15   Strumica   1800

1
Jovan Todorov    1000    10.73.112.200     16:30   Bitola     760*/
/*output
IP network: 10.73.112 has the following number of users:
2
The user who logged on earliest after noon from that network is:
Viktor Jovev with salary 2200 from address 10.73.112.79 who logged in at 15:15*/
