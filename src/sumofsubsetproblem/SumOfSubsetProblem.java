/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sumofsubsetproblem;

/**
 *
 * @author Safat
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class SumOfSubsetProblem
{
    private static Integer[] options;
    private static int[] visited;
    private static int desiredSum;
 
    public static void sumOfSubsets(int index, int curSum, int remainSum)
    {
        visited[index] = 1;
        if(options[index] + curSum == desiredSum)//if result found print result with for loop
        {
            System.out.println
        ("The Solutions are:");
            for(int i = 0; i <= index; i++)
            {
                if(visited[i] == 1)
                {
                    System.out.print(options[i] + " ");
                }
            }
            System.out.println();
        }                                                                               
        else if(index + 1 < options.length 
                && curSum + options[index] + options[index + 1] <= desiredSum)//result not found yet. take both, are within bounds and can take next index value.
        {
            sumOfSubsets(index + 1, curSum + options[index], remainSum - options[index]);//take index and call as required.
        }                                                                                                              
        if(index + 1 < options.length 
                && curSum + options[index + 1] <= desiredSum 
                && curSum + remainSum - options[index] >= desiredSum)                       //within bounds take next only current exceeds bound
                                                                                     //so skip and unvisit index and do as required.
        {
            visited[index] = 0;
            sumOfSubsets(index + 1, curSum, remainSum - options[index]);
        }
    }
 
    public static void main(String[] args)
    {
        System.out.println("Subset sum problem with backtracking");
        System.out.println("Please enter the options one by one(stop for -ve values)");
        Scanner sc=new Scanner(System.in);
        List<Integer> myList = new ArrayList<Integer>();
        while(true){
            int a=sc.nextInt();
            if(a<0)break;
            myList.add(a);
        }
        options=(Integer[])myList.toArray(new Integer[myList.size()]);
//        options = new int[]{1, 2, 3, 7, 4, 5, 6,7,8,9,10};
        visited = new int[options.length];
        Arrays.sort(options);
        System.out.println("Please enter the desired sum");
//        desiredSum = 40;
        desiredSum=sc.nextInt();
        int totalSum = 0;
        for(int item : options) {
            totalSum += item;
        }
        //initially both sums are zero
        sumOfSubsets(0, 0, totalSum);
    }
}
