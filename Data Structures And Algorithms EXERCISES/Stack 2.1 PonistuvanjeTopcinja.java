/*Да се напише алгоритам со коj ´ке се имплементира играта “Поништување топчиња”. Во оваа игра на располагање имате топчиња во три различни бои 
(R-црвена, G-зелена и B-сина), обележани со знакот + или -. Поништување на топчиња може да настане само доколку тие се од иста боjа и со спротивен знак.
На почетоксе генерира една случаjна листа со топчиња. Ваша задача е од тоj влез, како доагаат топчињата да направите поништување и да кажете колку, 
од каков тип(+ или -) и од коjа боjа фалат за да се поништат сите топчиња од влезот. Влез: Во влезот е дадена листа од случаjни топчиња и тоа во облик: боjа, знак.
Излез: На излез треба да се испечатат броjот на парови и паровите кои може да се формираат.
Пример: Влез: R+ G- G+ G+ R+ B- B+ R- G+ R- B- B+ B+ R+
Парови кои може да се формираат од овоj список се: (R+,R-); (B+, B-); (B-B+); (R+, R-); (G-, G+); (R+, R-) Остануваат без партнер: G+, G+, B+, R+
Излез: 4 R- G- G- B+
*/

//note: ja fr ne razbiram kako izlezot treba da bide parovite koi moze da se formiraat a vo nivniot primer nemame nikakvi parovi
//sledniov kod pecati kolku parovi se formirale i koi topcinja ostanale bez parovi. topcinjata bez parovi gi pecati vo redosled R, G, B.

import java.util.Scanner;
import java.util.Stack;

public class PonistuvanjeTopcinja {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] tokens = input.split(" ");
        Stack<String> stackR = new Stack<>();
        Stack<String> stackG = new Stack<>();
        Stack<String> stackB = new Stack<>();
        int pairs = 0;

        for (String token : tokens) {
            if (token.startsWith("R")) {
                if (!stackR.isEmpty() && !stackR.peek().equals(token)) {
                    stackR.pop();
                    pairs++;
                } else {
                    stackR.push(token);
                }
            } else if (token.startsWith("G")) {
                if (!stackG.isEmpty() && !stackG.peek().equals(token)) {
                    stackG.pop();
                    pairs++;
                } else {
                    stackG.push(token);
                }
            } else if (token.startsWith("B")) {
                if (!stackB.isEmpty() && !stackB.peek().equals(token)) {
                    stackB.pop();
                    pairs++;
                } else {
                    stackB.push(token);
                }
            }
        }

        System.out.println(pairs);
        while (!stackR.isEmpty()) {
            System.out.print(stackR.pop() + " ");
        }while (!stackG.isEmpty()) {
            System.out.print(stackG.pop() + " ");
        }while (!stackB.isEmpty()) {
            System.out.print(stackB.pop() + " ");
        }

    }
}
