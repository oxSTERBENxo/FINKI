/*Во следната задача треба да изградите бинарно дрво со N јазли, за кое ќе треба да одговорите на Q прашања од видот 
„колку јазли со точно две деца има во поддрвото на избран јазол“.
Секој јазол ќе има уникатно име. Името на коренот на дрвото секогаш ќе ви биде дадено прво. 
Влезот ќе содржи N+Q редови од видот
root ime - Треба да го поставите коренот на дрвото да биде јазелот со име ime
add parent_name child_name - Треба да додадете дете јазел со име child_name на јазелот со име parent_name
ask node_name - Треба да го одговориме прашањето за поддрвото на јазелот со име node_name
*/

//insert nivnite klasi

import java.util.*;

public class Trees3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();
        
        BTree<String> tree = new BTree<String>();

        for(int i = 0; i < n+q; i++) {
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
                System.out.println(DveDeca(tree,kade));

            }
        }
    }

    static BNode<String> find(BTree<String> tree,BNode<String> curr, String key) {
        if(curr==null){
            return null;
        }
        if(curr.info.equals(key)){
            return curr;
        }else{
            BNode<String> levo = find(tree,curr.left,key);
            if(levo!=null){
                return levo;
            }
            BNode<String> desno = find(tree,curr.right,key);
            if(desno!=null){
                return desno;
            }
            return null;
        }
    }

    static int DveDeca(BTree<String> tree,BNode<String> curr) {
        if(curr==null){
            return 0;
        }
        int ans = DveDeca(tree,curr.left) + DveDeca(tree,curr.right);
        
        if(curr.left != null && curr.right != null){
            return 1 + ans;
        }
        return ans;

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
/*0
0
1
0
2
1
2
4
1*/
