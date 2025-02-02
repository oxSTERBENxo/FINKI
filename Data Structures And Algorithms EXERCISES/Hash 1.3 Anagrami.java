/*Користеj´ки хеш табела да се групираат сите анаграми од дадена листа со зборови. Анаграми се зборови кои се добиваат со преуредување на буквите од зборот. 
На пример spar е анаграм на rasp. Влез: Во првиот ред е даден броjот на зборови 𝑁 . Во наредните 𝑁 реда се дадени зборовите кои треба да се додадат во табелата. 
Во следниот ред е даден зборот за коj треба да се испечати броjот на анаграми во табелата. Излез: Броjот на анаграми во табелата за дадениот збор.
Пример: Влез:
6
eat
tea
tan
ate
nat
bat
ant
Излез:
2
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class HashAnagramiTypeShi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String word = sc.nextLine();
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String newWord = new String(chars);
            map.put(newWord, map.getOrDefault(newWord, 0) + 1);
        }
        String lastWord = sc.nextLine();
        char[] chars = lastWord.toCharArray();
        Arrays.sort(chars);
        lastWord = new String(chars);
        if(map.containsKey(lastWord)) {
            System.out.println(map.get(lastWord));
        }else{
            System.out.println("Nema anagrami meow");
        }
    }
}

// forata e da gi sortirame site zborovi.
//e sega we consider deka a word is an anagram to itself
//poso ne znam kako drukse da ja resam poz
//i oni taka ja resavaat ig...

//eve primer test case
//input
/*
4
listen
silent
enlist
inlets
listen
*/
//output 4
