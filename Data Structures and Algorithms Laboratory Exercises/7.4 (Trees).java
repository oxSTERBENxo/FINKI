/*Во следната задача треба да изградите бинарно дрво со N јазли, за кое ќе треба да одговорите на Q прашања од видот „која е максималната длабочина во поддрвото на избран јазол“.
Секој јазол ќе има уникатно име. Името на коренот на дрвото секогаш ќе ви биде дадено прво. 
Влезот ќе содржи N+Q редови од видот
root ime - Треба да го поставите коренот на дрвото да биде јазелот со име ime
add parent_name child_name - Треба да додадете дете јазел со име child_name на јазелот со име parent_name
ask node_name - Треба да го одговориме прашањето за поддрвото на јазелот со име node_name
*/

//insert their classes
import java.util.*;

public class Trees4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();

        BTree<String> tree = new BTree<>();

        for(int i = 0; i < n+q; i++){
            String[] input = sc.nextLine().trim().split("\\s+");

            if(input[0].equals("root")){
                tree.makeRoot(input[1]);
            }else if(input[0].equals("add")){
                BNode<String> kade = find(tree,tree.root,input[1]);
                if(input[3].equals("LEFT")){
                    tree.addChild(kade,1,input[2]);
                }else{
                    tree.addChild(kade,2,input[2]);
                }
            }else{
                BNode<String> kade = find(tree,tree.root,input[1]);
                System.out.println(1+tree.depthR(kade));
            }
        }

    }
    static BNode<String> find(BTree<String> tree, BNode<String> current,String key){
        if(current==null){
            return null;
        }
        if(current.info.equals(key)){
            return current;
        }else{
            BNode<String> left = find(tree, current.left, key);
            if(left!=null){
                return left;
            }
            BNode<String> right = find(tree, current.right, key);
            if(right!=null){
                return right;
            }
            return null;
        }
    }
}

//test case
//input
/*11 9
root bravo
add bravo echo LEFT
add echo beard LEFT
ask beard
ask bravo
add bravo foxtrot RIGHT
add beard hotel LEFT
add beard india RIGHT
ask echo
add foxtrot golf LEFT
add golf juliet RIGHT
add india sierra RIGHT
ask foxtrot
ask bravo
ask beard
add echo mike RIGHT
add foxtrot tango RIGHT
ask echo
ask bravo
ask foxtrot*/
//output
/*1
3
3
3
5
3
4
5
3*/

