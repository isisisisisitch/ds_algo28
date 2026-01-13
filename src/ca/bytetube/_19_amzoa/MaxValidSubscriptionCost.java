package ca.bytetube._19_amzoa;

import java.util.*;

public class MaxValidSubscriptionCost {
    public static void main(String[] args) {
        int[] planCost = {10, 20, 30};
        int[] featureCost = {5, 15, 25};
        int[] incompatiblePlans = {1, 3};
        int[] incompatibleFeatures = {3, 1};
        System.out.println(maxValidSubCost(planCost, featureCost, incompatiblePlans, incompatibleFeatures));
        //55
    }

    public static int solution(int[] planCost, int[] featureCost, int[] incompatiblePlans, int[] incompatibleFeatures) {
        int n = planCost.length;
        int m = featureCost.length;
        int x = incompatiblePlans.length;

        HashMap<Integer, Set<Integer>> incompatible = new HashMap<>();
        for (int i = 0; i < x; i++) {
            if (!incompatible.containsKey(incompatiblePlans[i] - 1)) {
                Set<Integer> temp = incompatible.get(incompatiblePlans[i] - 1);
                temp.add(incompatibleFeatures[i] - 1);
                incompatible.put(incompatiblePlans[i] - 1, temp);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int p = planCost[i];
            for (int j = 0; j < m; j++) {
                int f = featureCost[j];
                if (incompatible.containsKey(p) && !incompatible.get(p).contains(f)) {
                    max = Math.max(max, p + f);
                }
            }
        }

        return max;
    }


    public static int maxValidSubCost(int[] planCost, int[] featureCost,
                                      int[] incompatiblePlans, int[] incompatibleFeatures) {
        int n = planCost.length;
        int m = featureCost.length;
        int X = incompatiblePlans.length;

        Integer[] features = new Integer[m];
        for (int i = 0; i < m; i++) features[i] = i;
        Arrays.sort(features, (o1, o2) -> featureCost[o2] - featureCost[o1]);//m*logm

        HashMap<Integer, Set<Integer>> blockedMap = new HashMap<>();

        for (int i = 0; i < X; i++) {
            int p = incompatiblePlans[i] - 1;
            int f = incompatibleFeatures[i] - 1;
            blockedMap.computeIfAbsent(p, k -> new HashSet<>()).add(f);
        }
        int max = Integer.MIN_VALUE;

        for (int p = 0; p < n; p++) {//n
            Set<Integer> blockedFeatures = blockedMap.getOrDefault(p, Collections.emptySet());
            for (int f : features) {//m
                if (!blockedFeatures.contains(f)) {//most expensive feature
                    max = Math.max(max, planCost[p] + featureCost[f]);
                    break;
                }
            }
        }

        return max;

    }
}
