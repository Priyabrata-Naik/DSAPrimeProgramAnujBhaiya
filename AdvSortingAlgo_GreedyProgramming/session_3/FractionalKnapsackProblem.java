package AdvSortingAlgo_GreedyProgramming.session_3;

import java.util.Arrays;

public class FractionalKnapsackProblem {
    public static void main(String[] args) {

        Item i1 = new Item(60,10);
        Item i2 = new Item(100,20);
        Item i3 = new Item(120,30);

        Item items[] = {i1, i2, i3};
        int capacity = 50;
        double res = fractionalKnapsack(items,capacity);

        System.out.println(res);

    }
//    We can implement Comparable to class item & implement compareTo() method
    static class Item {
        int weight, price;
        public Item(int price, int weight){
            this.weight = weight;
            this.price = price;
        }

//        @Override
//        public int compareTo(Item that) {
//            double ratioThis = (double) this.price / this.weight;
//            double ratioThat = (double) that.price / that.weight;
//
//            if(ratioThis > ratioThat) return -1;
//            if(ratioThis < ratioThat) return 1;
//            return 0;
//        }
    }
    static double fractionalKnapsack(Item items[], int capacity){
        Arrays.sort(items, ((o1, o2) -> {
            double ratioThis = (double) o1.price / o1.weight;
            double ratioThat = (double) o2.price / o2.weight;

            if(ratioThis > ratioThat) return -1;
            if(ratioThis < ratioThat) return 1;
            return 0;
        }));
        double profit = 0;

        for(int i = 0; i < items.length; i++){
            if(items[i].weight <= capacity){
                profit += items[i].price;
                capacity -= items[i].weight;
            }else{
                double fractionProfit = (double) (items[i].price * capacity) / items[i].weight;
                profit += fractionProfit;
                break;
            }
        }
        return profit;
    }
}
