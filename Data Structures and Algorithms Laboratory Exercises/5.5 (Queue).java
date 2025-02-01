/*Студентска служба е посетена од студентите со цел да приложат/земат документи. Студентот може да приложи документи, да побара да си го земе индексот или пак да побара
да си ги земе документите од средно. Кога студентската служба ќе започне со работа се услужуваат студенти од сите три типа паралелно, но исто така сите три шалтера не одат
со иста брзина па услужувањето е со следниот редослед (два студента што ги приложуваат документите, па три студенти што сакаат да си го земат индексот, па еден студент
што сака да си ги земе документите од средно). Доколку студент чека ред за повеќе услуги кај студентската служба, тој чека ред првин во редицата за приложување на документи,
потоа во редицата за земање на индекс и на крај во редицата за земање на документи од средно. Влез: Во првата линија е даден број на студенти кои имаат дојдено за да бидат
услужени од студентската служба. Потоа 4 редици се внесуваат за секој студент, каде првата линија е име на студент, а во останатите 3 редици се внесува дали има потреба
од дадена услуга (приложување документи, земање на индекс, земање на документи од средно соодветно), каде 1 значи дека има потреба од услуга од тој тип, 0 значи дека нема
потреба од услуга од тој тип. Пример:
Иван Ивановски
1
1
0
значи дека студентот Иван Ивановски има за цел да приложи документи и да си го земе индексот.
Излез: Испечати го редоследот на студентите по редослед како завршуваат со сите услуги од студенстката служба.*/


import java.util.*;
class Student{
    String name;
    int[] red;

    public Student(String name, int[] red) {
        this.name = name;
        this.red = new int[red.length];
        this.red[0] = red[0];
        this.red[1] = red[1];
        this.red[2] = red[2];
    }
}

public class Queue5{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<Student> dokmenti = new LinkedList<>();
        Queue<Student> indeks = new LinkedList<>();
        Queue<Student> sredno = new LinkedList<>();

        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            int[] niza = new int[3];
            for (int j = 0; j < 3; j++) {
                niza[j] = Integer.parseInt(sc.nextLine());
            }
            Student s = new Student(name, niza);
            if (niza[0] == 1) {
                dokmenti.add(s);
            } else if (niza[1] == 1) {
                indeks.add(s);
            }
            else if (niza[2] == 1) {
                sredno.add(s);
            }


        }
        while (!(dokmenti.isEmpty()) || !(indeks.isEmpty()) || !(sredno.isEmpty())) {
            for (int s = 0; s < 2 && !dokmenti.isEmpty(); s++) {
                if (!dokmenti.isEmpty()) {
                    Student temp = dokmenti.poll();
                    if (temp.red[1] == 1) {
                        indeks.add(temp);
                    } else if (temp.red[2] == 1) {
                        sredno.add(temp);
                    } else {
                        System.out.println(temp.name);
                    }
                }
            }
            for (int idx = 0; idx < 3; idx++) {
                if (!indeks.isEmpty()) {
                    Student temp = indeks.poll();
                    if (temp.red[2] == 1) {
                        sredno.add(temp);
                    } else {
                        System.out.println(temp.name);
                    }
                }
            }
            for (int b = 0; b < 1; b++) {
                if (!sredno.isEmpty()) {
                    Student temp = sredno.poll();
                    System.out.println(temp.name);
                }
            }

        }

    }
}
