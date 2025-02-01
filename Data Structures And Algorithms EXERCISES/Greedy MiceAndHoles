/*На едно поле има N глувци и N отвори во земјата, распоредени по права линија. Во секој отвор може да се смести само 1 глушец. Секој глушец може да остане на истата позиција, 
да се помести едно место на десно од x до x+1, или да се помести едно место на лево од x до x-1. Секое поместување зема 1 минута. Повеќе глувци може да се движат истовремено.
Да се најде кој глушец во кој отвор да се смести, со тоа што ќе се минимизира вкупното потребно време, односно времето до и последниот глушец да дојде до доделениот отвор.
Влез: Во првиот ред одделени со празно место се дадени позициите на глувците, а во вториот ред исто одделени со празно место се дадени позициите на отворите.
Излез: Минималното време во минути за да се сместат сите глувци во одреден отвор.
-----------------------------------------------------------------------------------
There are N Mice and N holes are placed in a straight line. Each hole can accommodate only 1 mouse. A mouse can stay at his position, move one step right from x to x + 1, 
or move one step left from x to x -1. Any of these moves consumes 1 minute. More than 1 mouse can move at the same time. Assign mice to holes so that the time when the 
last mouse gets inside a hole is minimized. Input: In the first line of input, separated with spaces, you are given the position of the mice, and in the second line, 
also separated with spaces, are the positions of the holes. Output: The minimum time in minutes for all the mice to get in a certain hole.*/

import java.util.Arrays;
import java.util.Scanner;

public class Main {
  
    //TODO: implement function
    public static int minTime(int mice[], int holes[]) {
        Arrays.sort(mice);
        Arrays.sort(holes);
        int n=mice.length;
        int maxTime=0,time=0;
        for(int i=0;i<n;i++) {
            time = mice[i] - holes[i];
            if (time < 0){
                time = -time;
            }
            if(maxTime <= time){
                maxTime=time;
            }
        }
        return maxTime;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String line = input.nextLine();
        String parts[] = line.split(" ");
        int mice[] = new int[parts.length];
        for(int i=0;i<parts.length;i++) {
            mice[i] = Integer.parseInt(parts[i]);
        }

        line = input.nextLine();
        parts = line.split(" ");
        int holes[] = new int[parts.length];
        for(int i=0;i<parts.length;i++) {
            holes[i] = Integer.parseInt(parts[i]);
        }

        System.out.println(minTime(mice, holes));
    }
}
