package priorityQueueAndDisjointSets.liveSession_1;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromADataStream {
    public static void main(String[] args) {



    }
    static class MedianFinder{

        PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;
        public MedianFinder(){
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            minHeap = new PriorityQueue<>();
        }
        public void addNum(int num){
            if(maxHeap.isEmpty() || maxHeap.peek() >= num){
                maxHeap.add(num);
            }else{
                minHeap.add(num);
            }

            if(maxHeap.size() > minHeap.size()+1){
                minHeap.add(maxHeap.poll());
            }else if(maxHeap.size() < minHeap.size()){
                maxHeap.add(minHeap.poll());
            }
        }
        public double findMedian(){
            if(maxHeap.size() == minHeap.size()){
                return (maxHeap.peek()+minHeap.peek())/2.0;
            }else{
                return maxHeap.peek();
            }
        }
    }
}
