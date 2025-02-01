/*Студентска служба е посетена од студентите со цел да приложат/земат документи. Студентот може да приложи документи, да побара да си го земе индексот или пак да побара
да си ги земе документите од средно. Кога студентската служба ќе започне со работа се услужуваат студенти од сите три типа паралелно, но исто така сите три шалтера не одат
со иста брзина па услужувањето е со следниот редослед (еден студент што приложува документи, па еден студент што сака да си го земе индексот, па еден студент што сака да
си ги земе документите од средно). Доколку студент чека ред за повеќе услуги кај студентската служба, тој чека ред првин во редицата за приложување на документи, потоа во
редицата за земање на индекс и на крај во редицата за земање на документи од средно. Влез: Во првата линија е даден број на студенти кои имаат дојдено за да бидат услужени
од студентската служба. Потоа 4 редици се внесуваат за секој студент, каде првата линија е име на студент, а во останатите 3 редици се внесува дали има потреба од дадена 
услуга (приложување документи, земање на индекс, земање на документи од средно соодветно), каде 1 значи дека има потреба од услуга од тој тип, 0 значи дека нема потреба 
од услуга од тој тип. Пример:
Иван Ивановски
1
1
0
значи дека студентот Иван Ивановски има за цел да приложи документи и да си го земе индексот.
Излез: Испечати го редоследот на студентите по редослед како завршуваат со сите услуги од студенстката служба.*/


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Student{
    String ime;
    int[] red;

    public Student(String ime, int[] red) {
        this.ime = ime;
        this.red = new int[red.length];
        this.red[0] = red[0];
        this.red[1] = red[1];
        this.red[2] = red[2];
    }
}
public class Queue44 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Student> dokumenti = new LinkedList<Student>();
        Queue<Student> indeks = new LinkedList<>();
        Queue<Student> sredno = new LinkedList<>();

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String ime = sc.nextLine();
            int[] arr = new int[3];
            for(int j = 0; j < 3; j++){
                arr[j]=Integer.parseInt(sc.nextLine());
            }
            Student s = new Student(ime,arr);
            if(arr[0]==1){
                dokumenti.add(s);
            }else if(arr[1]==1){
                indeks.add(s);
            }else if(arr[2]==1){
                sredno.add(s);
            }
        }
        while(!(dokumenti.isEmpty()) || !(indeks.isEmpty()) || !(sredno.isEmpty())){
            if(!dokumenti.isEmpty()){
                Student tmp= dokumenti.remove();
                if(tmp.red[1]==1){
                    indeks.add(tmp);
                }else if(tmp.red[2]==1){
                    sredno.add(tmp);
                }else{
                    System.out.println(tmp.ime);
                }
            }
            if(!indeks.isEmpty()){
                Student tmp=indeks.remove();
                if(tmp.red[2]==1){
                    sredno.add(tmp);
                }else{
                    System.out.println(tmp.ime);
                }
            }
            if(!sredno.isEmpty()){
                Student tmp=sredno.remove();
                System.out.println(tmp.ime);
            }
        }
    }
}


//test case example
//input
/*3
Ана Анастасова
1
1
1
Борис Борисов
1
0
0
Владимир Владимиров
1
1
0*/
//expected
/*Ана Анастасова
Борис Борисов
Владимир Владимиров*/
