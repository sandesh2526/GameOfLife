package com.Life;
import java.util.*;
public class Life {
    public static Scanner scanner = new Scanner(System.in); 

   public int[][] calculateMapping(int[][] pre) {
        int post[][] = new int[pre.length][pre.length];
        int test[][] = new int[pre.length][pre.length];
        for (int i = 0; i < pre.length; i++) {
            for (int j = 0; j < pre.length; j++) {
                switch (neighbourCount(pre,i,j)) {
                    case 0:
                    
                    case 1:
                        post[i][j] = 0;
                        break;
                    case 2:
                        post[i][j] = pre[i][j];    
                        break;
                    case 3:
                        post[i][j] = 1;
                        break;
                        
                    default:
                        post[i][j] = 0;
                }
                test[i][j] = neighbourCount(pre, i, j);
            }
        }
        pre = copyMap(pre,post);
        System.out.println("The answer is:");
        writeMap(pre);
        System.out.println("Following is the count: ");
        writeMap(test);        
        return pre;
    }


    public int[][] copyMap(int[][] pre, int[][] post) {
        for (int i = 0; i < post.length; i++) {
            for (int j = 0; j < post.length; j++) {
                pre[i][j] = post[i][j];
            }
        }
        return pre;
    }

    public int neighbourCount(int[][] pre, int i, int j) {
        int count = 0;
        if(i == 0)
        {
            if(j == 0)
            {
                count += pre[i+1][j]+pre[i][j+1]+pre[i+1][j+1];
            }
            else if (j == pre.length-1) {
                count += pre[i][j-1]+pre[i+1][j-1]+pre[i+1][j];
            }
            else if(0<j && j<pre.length-1)
            {
                count += pre[i][j-1]+pre[i][j+1]+pre[i+1][j]+pre[i+1][j-1]+pre[i+1][j+1];
            }
        }
        else if(i == pre.length-1)
        {
            if(j == 0)
            {
                count += pre[i-1][j]+pre[i-1][j+1]+pre[i][j+1];
            }
            else if (j == pre.length-1) {
                count += pre[i-1][j]+pre[i-1][j-1]+pre[i][j-1];
            }
            else if(0<j && j<pre.length-1)
            {
                count += pre[i][j-1]+pre[i][j+1]+pre[i-1][j]+pre[i-1][j+1]+pre[i-1][j-1];
            }
        }
        else if(0<i && i<pre.length)
        {
            if(j == 0)
            {
                count += pre[i-1][j]+pre[i+1][j]+pre[i][j+1]+pre[i-1][j+1]+pre[i+1][j+1];
            }
            else if (j == pre.length-1) {
                count += pre[i-1][j]+pre[i+1][j]+pre[i][j-1]+pre[i-1][j-1]+pre[i+1][j-1];
            }
            else if(0<j && j<pre.length-1)
            {
                count += pre[i-1][j]+pre[i+1][j]+pre[i][j-1]+pre[i-1][j-1]+pre[i+1][j-1]+pre[i][j+1]+pre[i-1][j+1]+pre[i+1][j+1];
            }
        }
        return count;
    }

    public void writeMap(int[][] pre) {
        for (int i = 0; i < pre.length; i++) {
            for (int j = 0; j < pre.length; j++) {
                System.out.print(pre[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public int[][] initializeArray(int[][] pre, int n) {
    	pre = new int[n][n];
        System.out.println("Please enter the array elements");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //System.out.print("Enter the cell"+i+" "+j+" :");
                pre[i][j] = scanner.nextInt();
            }
        }
        return pre;
    }
}