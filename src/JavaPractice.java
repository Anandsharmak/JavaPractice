//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main (String[] args) throws IOException {
        File file = new File(
                "./src/test.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        File fileoutput = new File("./src/result.txt");
        //Instantiating the PrintStream class
        PrintStream stream = new PrintStream(fileoutput);
        System.setOut(stream);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            String inputLine[] = br.readLine().trim().split(" ");
            long[] arr = new long[n];
            for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
            long[] res = new Solution().nextLargerElement(arr, n);
            for (int i = 0; i < n; i++)
                System.out.print(res[i] + " ");
            System.out.println();
        }
    }
}




// } Driver Code Ends


class Solution
{

    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    {
        Stack <Long> q=new Stack<>();
        q.push(arr[arr.length-1]);
        arr[arr.length-1]=-1;

        for(int  i=arr.length-2;i>=0;i--){
            long curr=arr[i];
            // System.out.println(q.toString());
            while(q.size()!=0&&q.peek()<=arr[i])
                q.pop();

            if(q.size()==0)
                arr[i]=-1;
            else
                arr[i]=q.peek();

            q.add(curr);

        }
        return arr;
    }
}