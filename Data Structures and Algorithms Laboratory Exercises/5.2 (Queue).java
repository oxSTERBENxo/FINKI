/*Библиотека е посетена од студентите со цел да изнајмат еден или повеќе типови на книги. Дадена книга може да припаѓа на една од трите категории: 
Наука, Научна фантастика или Историја. Кога библиотеката ќе започне со работа првин се услужени студентите кои чекаат ред за книга од тип Наука, 
потоа студентите кои чекаат ред за книга од тип научна фантастика и на крај студентите кои чекаат ред за книга од тип Историја.
Доколку студент чека ред за книги од различен тип, тој чека ред првин во редицата за книга од тип Наука, потоа во редицата за книга од тип Научна фантастика
и на крај во редицата за книга од тип Историја (во зависност ако ги бара овие книги за позајмување).
Влез: Во првата линија е даден број на студенти кои имаат дојдено во библиотеката да позајмат книга. Потоа 4 редици се внесуваат за секој студент, 
каде првата линија е име на студент, а во останатите 3 редици се внесува дали студентот ќе позајми книга од даден тип (Наука, Научна фантастика и Историја соодветно), 
каде 1 значи дека има за цел да позајми книга од тој тип, 0 значи дека нема да позајми книга од тој тип.
Пример:
Иван Ивановски
1
1
0
значи дека студентот Иван Ивановски има за цел да позајми книга од тип Наука и тип Научна фантастика, но не има за цел да позајми книга од тип Историја.
Излез: Испечати го редоследот на студентите по редослед како завршуваат со позајмување на сите книги.*/

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

public class Queue2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<Student> nauka = new LinkedList<>();
        Queue<Student> fantastika = new LinkedList<>();
        Queue<Student> istorija = new LinkedList<>();

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            int[] niza = new int[3];
            for (int j = 0; j < 3; j++) {
                niza[j] = Integer.parseInt(sc.nextLine());
            }
            Student s = new Student(name, niza);
            if (niza[0] == 1) {
                nauka.add(s);
            } else if (niza[1] == 1) {
                fantastika.add(s);
            }
            else if (niza[2] == 1) {
                istorija.add(s);
            }

        }
        for (int i = 0; i < n; i++) {
            while (!nauka.isEmpty()) {
                Student temp = nauka.remove();
                if (temp.red[1] == 1) {
                    fantastika.add(temp);
                } else if (temp.red[2] == 1) {
                    istorija.add(temp);
                } else {
                    System.out.println(temp.name);
                }
            }
            while (!fantastika.isEmpty()) {
                Student temp = fantastika.remove();
                if (temp.red[2] == 1) {
                    istorija.add(temp);
                } else {
                    System.out.println(temp.name);
                }
            }
            while (!istorija.isEmpty()) {
                Student temp = istorija.remove();
                System.out.println(temp.name);
            }
        }

    }
}
