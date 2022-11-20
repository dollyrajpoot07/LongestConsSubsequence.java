// Given an array of integers, find the length of the longest sub-sequence such that elements in the subsequence are 
// consecutive integers, the consecutive numbers can be in any order. 

// Examples:  

// Input: arr[] = {1, 9, 3, 10, 4, 20, 2}
// Output: 4
// Explanation: The subsequence 1, 3, 4, 2 is the longest subsequence of consecutive elements

// Input: arr[] = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}
// Output: 5
// Explanation: The subsequence 36, 35, 33, 34, 32 is the longest subsequence of consecutive elements.

import java.io.*;
import java.util.PriorityQueue;

public class LongestConsSubsequence {

    static int findLongestConseqSubseq(int arr[], int N) {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < N; i++) {

            pq.add(arr[i]);
        }
        int prev = pq.poll();
        int c = 1;
        int max = 1;

        for (int i = 1; i < N; i++) {
            if (pq.peek() - prev > 1) {
                c = 1;
                prev = pq.poll();
            } else if (pq.peek() - prev == 0) {
                prev = pq.poll();
            }

            else {
                c++;
                prev = pq.poll();
            }

            if (max < c) {
                max = c;
            }
        }
        return max;
    }

    public static void main(String args[]) throws IOException {
        int arr[] = { 1, 9, 3, 10, 4, 20, 2 };
        int n = arr.length;
        System.out.println("Length of the Longest consecutive subsequence is " + findLongestConseqSubseq(arr, n));
    }
}
