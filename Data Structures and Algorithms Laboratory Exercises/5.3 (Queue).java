/*Библиотека е посетена од студентите со цел да изнајмат еден или повеќе типови на книги. Дадена книга може да припаѓа на една од трите категории: 
Наука, Научна фантастика или Историја. Кога библиотеката ќе започне со работа се услужуваат студенти од сите три типа паралелно, но исто така сите три шалтера
не одат со иста брзина па услужувањето е со следниот редослед (два студента што ги бараат книга од тип Наука, па еден студент што бара книга од тип Научна фантастика,
па два студенат што бараат книга од тип Историја). Доколку студент чека ред за книги од различен тип, тој чека ред првин во редицата за книга од тип Наука,
потоа во редицата за книга од тип Научна фантастика и на крај во редицата за книга од тип Историја (во зависност ако ги бара овие книги за позајмување).
Влез: Во првата линија е даден број на студенти кои имаат дојдено во библиотеката да позајмат книга. Потоа 4 редици се внесуваат за секој студент, каде првата линија
е име на студент, а во останатите 3 редици се внесува дали студентот ќе позајми книга од даден тип (Наука, Научна фантастика и Историја соодветно), каде 1 значи дека
има за цел да позајми книга од тој тип, 0 значи дека нема да позајми книга од тој тип. Пример:
Иван Ивановски
1
1
0
значи дека студентот Иван Ивановски има за цел да позајми книга од тип Наука и тип Научна фантастика, но не има за цел да позајми книга од тип Историја.
Излез: Испечати го редоследот на студентите по редослед како завршуваат со позајмување на сите книги.*/

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Student {
    String ime;
    int[] redica;

    public Student(String ime, int[] redica) {
        this.ime = ime;
        this.redica = new int[redica.length];
        this.redica[0] = redica[0];
        this.redica[1] = redica[1];
        this.redica[2] = redica[2];
    }
}

public class Queue33 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      
        Queue<Student> nauka = new LinkedList<>();
        Queue<Student> fantastika = new LinkedList<>();
        Queue<Student> istorija = new LinkedList<>();

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String ime = sc.nextLine();
            int[] arr = new int[3];
            for (int j = 0; j < 3; j++) {
                arr[j] = Integer.parseInt(sc.nextLine());
            }
            Student s = new Student(ime, arr);
            if (arr[0] == 1) {
                nauka.add(s);
            } else if (arr[1] == 1) {
                fantastika.add(s);
            } else if (arr[2] == 1) {
                istorija.add(s);
            }
        }
        while (!(nauka.isEmpty()) || !(fantastika.isEmpty()) || !(istorija.isEmpty())) {
            for (int nau = 0; nau < 2 && !nauka.isEmpty(); nau++) {
                Student tmp = nauka.remove();
                if (tmp.redica[1] == 1) {
                    fantastika.add(tmp);
                } else if (tmp.redica[2] == 1) {
                    istorija.add(tmp);
                } else {
                    System.out.println(tmp.ime);
                }

            }
            for (int fan = 0; fan < 1 && !fantastika.isEmpty(); fan++) {
                Student tmp = fantastika.remove();
                if (tmp.redica[2] == 1) {
                    istorija.add(tmp);
                } else {
                    System.out.println(tmp.ime);
                }

            }
            for (int ist = 0; ist < 2 && !istorija.isEmpty(); ist++) {
                Student tmp = istorija.remove();
                System.out.println(tmp.ime);

            }
        }
    }
}
