/*Поради епидемиjа на сезонски грип при секое тестирање на даден пациент се зачувува општината во коjа живее, неговото презиме и информациjа дали е позитивен или негативен
на вирусот. Потребни се статистички податоци за да се одреди ризик факторот за дадена општина. Ваша задача е за дадена општина на излез да го испечатите ризик факторот во
дадената општина. Ризик факторотсе пресметува на следниот начин: Ризик фактор = броj на позитивни пациенти броj на негативни пациенти + броj на позитивни пациенти 
Забелешка: Можно е да се поjават пациенти со исто презиме. Истите требада се земат како посебни вредности во статистиката. Влез: На влез наjпрво е даден броjот на пациенти 𝑁,
а потоа секоj пациент едаден во нов ред во форматот: „Општина во коjа живее” „Презиме на пациент”„Резултати од тестот(positive/negative)”. 
На краj е дадена општината за коjатреба да се пресмета ризик факторот. Излез: Децимален броj заокружен на две децимали коj го претставува ризикфакторот за дадената општина.
Пример: Влез:
6
Centar Stojanoski negative
Centar Trajkovski positive
Centar Petkovski positive
Karpos Stojanoski positive
Karpos Trajkovski negative
Centar Trajkovski positive
Centar
Излез: 0.75
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Pacient{
    String opstina;
    String prezime;
    String isPozitiven;

    public Pacient(String opstina, String prezime, String isPozitiven) {
        this.opstina = opstina;
        this.prezime = prezime;
        this.isPozitiven = isPozitiven;
    }
}
public class HashCoronaVirusTypeShi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, ArrayList<Pacient>> map = new HashMap<>();
        int n =Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().trim().split("\\s+");
            String opstina  = data[0];
            String prezime = data[1];
            String isPozitiven = data[2];

            Pacient p = new Pacient(opstina, prezime, isPozitiven);
            map.putIfAbsent(opstina, new ArrayList<>());
            map.get(opstina).add(p);
        }
        String opstina = sc.nextLine();
        int counter = 0, totalCounter = 0;
        for(Pacient p: map.get(opstina) ) {
            totalCounter++;
            if(p.isPozitiven.equals("positive")) {
                counter++;
            }
        }
        double rizik = (double)counter/totalCounter;
        System.out.printf("%.2f\n",rizik); //za printanje na 2 decimali, % e placeholder, .2 e za 2 decimali, f e za floating point aka double oti e
    }
}


