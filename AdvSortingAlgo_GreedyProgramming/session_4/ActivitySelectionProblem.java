package AdvSortingAlgo_GreedyProgramming.session_4;

import java.util.Arrays;

public class ActivitySelectionProblem {
    public static void main(String[] args) {

        int s[] = {10, 12, 20};
        int f[] = {20, 25, 30};
        int res = activitySelection(s,f);

        System.out.println(res);

    }
    static class Activity{
        int start, finish;

        public Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
    static int activitySelection(int s[], int f[]){
        int n = s.length;
        Activity activities[] = new Activity[n];

        for(int i = 0; i < n; i++){
            activities[i] = new Activity(s[i], f[i]);
        }
//        for(Activity e: activities){
//            System.out.println("start " + e.start+" finish " + e.finish);
//        }
//        System.out.println();
        Arrays.sort(activities, ((o1, o2) -> {
            return o1.finish - o2.finish;
        }));

        int count = 1;
        int curFinish = activities[0].finish;

        for(int i = 1; i < n; i++){
            if(activities[i].start >= curFinish){
                count++;
                curFinish = activities[i].finish;
            }
        }
        return count;
    }
}
