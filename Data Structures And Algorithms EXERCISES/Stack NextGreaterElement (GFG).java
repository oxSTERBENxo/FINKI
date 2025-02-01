/*Problem: Given an array, find the next greater element for each element.
Concept Used: Stack to keep track of elements and find NGE in O(n) time
ex: 
input:
7
7 1 5 3 9 2 6
output:
9 5 9 9 -1 6 -1 */

import java.util.Scanner;
import java.util.Stack;
public class StackNextGreaterElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = n-1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() <=arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        for(int i:ans){
            System.out.print(i+" ");
        }

    }
}
