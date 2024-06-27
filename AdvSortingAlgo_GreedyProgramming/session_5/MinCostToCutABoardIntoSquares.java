package AdvSortingAlgo_GreedyProgramming.session_5;

import java.util.Arrays;
import java.util.Collections;

public class MinCostToCutABoardIntoSquares {
    public static void main(String[] args) {

        Integer h[] = {4, 1, 2};
        Integer v[] = {2, 1, 3, 1, 4};
        int res = minCostToCutBoard(h,v);

        System.out.println(res);

    }
    static int minCostToCutBoard(Integer h[], Integer v[]){
        int horBoardCount = 1;
        int verBoardCount = 1;
        Arrays.sort(h, Collections.reverseOrder());
        Arrays.sort(v, Collections.reverseOrder());
        int cost = 0;
        int i = 0, j = 0; // i -> v , j -> h

        while(i < v.length && j < h.length){
            if(h[j] < v[i]){
                cost += v[i] * horBoardCount;
                i++;
                verBoardCount++;
            }else{
                cost += h[j] * verBoardCount;
                j++;
                horBoardCount++;
            }
        }
        int totalVerticalCost = 0;
        while(i < v.length){
            totalVerticalCost += v[i];
            i++;
        }
        cost += totalVerticalCost * horBoardCount;

        int totalHorizontalCost = 0;
        while(j < h.length){
            totalHorizontalCost += h[j];
            j++;
        }
        cost += totalHorizontalCost * verBoardCount;

        return cost;
    }
}
