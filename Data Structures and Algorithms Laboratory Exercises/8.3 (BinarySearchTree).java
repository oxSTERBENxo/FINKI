/*Дадено ви е бинарно пребарувачко дрво со N цели броеви. Напишете функција со која за бинарно пребарувачко дрво и избран елемент Т од дрвото:
ќе најдете колку елементи во дрвото се поголеми од T Ќе треба да ја искористите таа функција Q пати при градењето на дрвото. Влезот ќе содржи N+Q редови од видот 
insert value - Треба да ја вметнете вредноста value во дрвото.
ask value - Треба да одговорите колку елементи во дрвото имаат вредност поголема од value
*/

//input their classes

import java.util.*;
public class Trees8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();
        
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        
        for(int i = 0; i < n+q; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");
            
            if(input[0].equals("insert")) {
                tree.insert(Integer.parseInt(input[1]));
            }else{
                System.out.println(pogolemi(tree,tree.getRoot(),Integer.parseInt(input[1])));
            }
        }
    }
    
    static int pogolemi(BinarySearchTree<Integer> tree, BNode<Integer> curr, int key) {
        if(curr==null){
            return 0;
        }
        if(curr.info<=key){
            return pogolemi(tree,curr.right,key);
        }else{
            return 1+pogolemi(tree,curr.left,key)+pogolemi(tree,curr.right,key);
        }
    }
}
//test case
//input
/*10 7
insert 6
insert 3
insert 7
ask 3
ask 6
insert 4
insert 1
insert 2
insert 5
insert 9
ask 3
ask 9
insert 8
insert 10
ask 8
ask 4
ask 5*/
//output
/*2
1
5
0
2
6
5*/




