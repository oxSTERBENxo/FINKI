/*На влез во оваа задача ќе ви бидат дадени редови како следниот формат: Ime Prezime budzhet ip_adresa vreme grad cena
Пример: Jovan Todorov 1000 10.73.112.200 15:30 Bitola 760
Кое што значи дека лицето со Име и Презиме Jovan Todorov, има буџет од 1000 денари, има IP адреса со мрежа 10.73.112 и домаќин (host number) 200, 
и се приклучил во 15:30 часот за да купи билет кон Bitola кој што чини 760 денари. Ќе ви бидат дадени N такви редови, по што ќе следи празен ред па уште M редови
од истиот формат, кои ќе ги користиме за тестирање. Од редот за тестирање треба да го извадите градот и потоа да го одговорите следното прашање со овој град:
Од сите N лица на влез, кои купуваат билет за до истиот град колку од нив се вклучиле подоцна од 11:59; и од овие, кој од нив се вклучил најрано? 
(погледнете го тест примерот!) (доколку има повеќе со исто најмало време тогаш кој е првиот таков во влезот?) (секогаш ќе постои барем еден таков)
Ова ќе треба да го направите за сите M редови за тестирање!
Препорака, користете OBHT и/или CBHT. //preporaka ne koristete krindz se
----------------------
At the input of this task you will be given rows with the following format: First_name Last_name budget ip_address time city price
Example Jovan Todorov 1000 10.73.112.200 15:30 Bitola 760
Which means that the person with First name and Last name Jovan Todorov, has a budget of 1000 denars, has an IP address with network 10.73.112 and host number 200, 
and joined at 15:30 to buy a ticked to Bitola which costs 760 denars. You will be given N such rows, followed by an empty row and M more rows of the same format, 
which we will use for testing. From the test row you need to extract the city and then answer the following question with this city: Of the N people at the input, 
from the ones who buy a ticket to the same city how many of them joined later than 11:59; and of these, which one joined the earliest?
(if there are more with the same minimum time then which one is the first one in the entry?) (there will always be at least one) You will need to do this for all M rows
for testing! Recommendation, use OBHT and/or CBHT.*/

import java.util.*;

class Person {
    String name;
    String surname;
    int budget;
    String ip;
    String time;
    String city;
    int price;

    public Person(String name, String surname, int budget, String ip, String time, String city, int price) {
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
        return name + " " + surname + " with salary " + budget + " from address " + ip + " who logged in at " + time;
    }
}

public class Hesh3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, ArrayList<Person>> map = new HashMap<>(); //po key grad vadime lista od luge
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().trim().split("\\s+");
            String name = data[0];
            String surname = data[1];
            int budget = Integer.parseInt(data[2]);
            String ip = data[3];
            String time = data[4];
            String city = data[5];
            int price = Integer.parseInt(data[6]);
            Person p = new Person(name, surname, budget, ip, time, city, price);

            map.putIfAbsent(city, new ArrayList<>());
            map.get(city).add(p);
        }
        sc.nextLine();
        int M = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < M; i++) {
            String[] data = sc.nextLine().trim().split("\\s+");
            String city = data[5];

            Person earliestPerson = map.get(city).get(0);
            int earliestTime = Integer.MAX_VALUE;
            int counter = 0;

            for (Person p : map.get(city)) {
                String[] timeParts = p.time.trim().split(":");
                int hours = Integer.parseInt(timeParts[0]);
                int minutes = Integer.parseInt(timeParts[1]);
                int totalMins = hours * 60 + minutes;

                if (totalMins >= 12 * 60) {
                    counter++;
                    if (totalMins < earliestTime) {
                        earliestTime = totalMins;
                        earliestPerson = p;
                    }
                }

            }

            System.out.println("City: " + city + " has the following number of customers:");
            System.out.println(counter);
            System.out.println("The user who logged on earliest after noon from that city is:");
            System.out.println(earliestPerson);
            System.out.println();
        }
    }
}
