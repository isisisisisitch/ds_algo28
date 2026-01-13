package ca.bytetube._19_amzoa;

import java.util.ArrayList;

public class GetTimeToStabilize {
    public static void main(String[] args) {
        System.out.println(getTimeToStabilize("database",'a'));
    }

    //doublyList : Node:prev,next,value
    public static int getTimeToStabilize(String pipeSize, char failedService) {
        int n = pipeSize.length();
        char[] s = pipeSize.toCharArray();
        int[] prev = new int[n];
        int[] next = new int[n];
        boolean[] alive = new boolean[n];

        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = (i + 1 < n) ? i + 1 : -1;
            alive[i] = true;
        }

        ArrayList<Integer> cur = new ArrayList<>();//[0,2,4]
        for (int i = 0; i < n; i++) {
            int r = next[i];
            if (r != -1 && s[r] == failedService) {
                cur.add(i);
            }
        }

        int round = 0;
        while (!cur.isEmpty()) {
            round++;

            ArrayList<Integer> affectedFailed = new ArrayList<>();//[1,3,5]
            for (int index : cur) {//[1,3]
                if (!alive[index]) continue;
                int r = next[index];//3
                if (r != -1 && s[r] == failedService) {
                    affectedFailed.add(r);//3,5
                }
            }

            for (int index : cur) {
                //index = 3, prev[3] = 1, next = 5
                if (!alive[index]) continue;
                alive[index] = false;
                int l = prev[index], r = next[index];
                if (l != -1) next[l] = r;
                if (r != -1) prev[r] = l;
            }

            ArrayList<Integer> nxt = new ArrayList<>();
            for (int fIndex : affectedFailed) {
                if (!alive[fIndex]) continue;// failed may be already removed (affectedFailed = 3)
                int l = prev[fIndex];
                if (l != -1 && alive[l]) {
                    nxt.add(l);
                }
            }

            cur = nxt;//[1,3]

        }

        return round;
    }
}
