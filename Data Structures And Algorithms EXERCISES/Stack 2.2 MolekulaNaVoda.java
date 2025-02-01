/*Да се напише алгоритам со коj ´ке се имплементира играта “Направи молекулна вода”. Во оваа игра на располагање имате два типа атоми (H-водород, и O-кислород). 
За да се направи молекула на вода (H2O) потребно е да имате два атоми на водород и еден атом на кислород. На почеток се генерира една случаjнасеквенца од атоми.
Ваша задача е од тоj влез, како доа´гаат атомите да генерирате молекули и да кажете колку такви молекули се креирале, и кои атоми останале несврзани.
Влез: Во влезот е дадена секвенца од случаjни атоми
Излез: На излез треба да се испечати броjот на молекули H2O, и несврзаните атоми од водород и кислород.
Пример: Влез: H H O H H O H H O H H H H H O H O H O O H O O H H H
Излез: 8 H O
*/

import java.util.Scanner;
import java.util.Stack;

public class StackMolekulaNaVoda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> vodorod = new Stack<>();
        Stack<String> kislorod = new Stack<>();
        int molekula =0;
        String input = sc.nextLine();
        String[] arr = input.split(" ");

        for(String i: arr){
            if(i.equals("H")){
                vodorod.push(i);
            }else if(i.equals("O")){
                kislorod.push(i);
            }

            if(vodorod.size()>=2 && !kislorod.empty()){
                kislorod.pop();
                vodorod.pop();
                vodorod.pop();
                molekula++;
            }
        }

        System.out.println(molekula);
        while(!vodorod.isEmpty()){
            System.out.println(vodorod.pop());
        }
        while(!kislorod.isEmpty()){
            System.out.println(kislorod.pop());
        }
    }
}
