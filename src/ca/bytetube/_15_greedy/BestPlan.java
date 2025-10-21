package ca.bytetube._15_greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Input:
 * • Parameter 1: a positive integer array costs
 * • Parameter 2: a positive integer array profits
 * • Parameter 3: a positive integer k
 * • Parameter 4: a positive integer m
 * <p>
 * costs[i] represents the cost required to start project i,
 * profits[i] represents the profit earned after deducting the cost (i.e., the net gain).
 * k means you can do at most k projects, and they must be done sequentially (not in parallel).
 * m is your initial capital.
 * <p>
 * Explanation:
 * After you finish a project, you immediately receive its profit, which can then be used to fund the next project.
 * <p>
 * Output:
 * Return the maximum amount of money you can have after completing up to k projects.
 */
public class BestPlan {
    public static void main(String[] args) {
        int[] costs =   {10,40,60,140,30};
        int[] profits = {10,20,25,35,10};
        System.out.println(bestPlan(costs,profits,4,50));
    }

    public static class Project {
        int cost;
        int profit;

        public Project(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public int getProfit() {
            return profit;
        }

        public void setProfit(int profit) {
            this.profit = profit;
        }

        @Override
        public String toString() {
            return "Project{" +
                    "cost=" + cost +
                    ", profit=" + profit +
                    '}';
        }
    }

    public static int bestPlan(int[] costs, int[] profits, int k, int m) {

        Project[] projects = new Project[costs.length];
        for (int i = 0; i < projects.length; i++) {
            projects[i] = new Project(costs[i], profits[i]);
        }

        PriorityQueue<Project> minCostQ = new PriorityQueue<>(new Comparator<Project>() {
            @Override
            public int compare(Project o1, Project o2) {
                return o1.cost - o2.cost;
            }
        });

        minCostQ.addAll(Arrays.asList(projects));

        PriorityQueue<Project> maxProfitQ = new PriorityQueue<>(new Comparator<Project>() {
            @Override
            public int compare(Project o1, Project o2) {
                return o2.profit - o1.profit;
            }
        });

        for (int i = 0; i <= k; i++) {
            while (!minCostQ.isEmpty() && minCostQ.peek().cost <= m) {
                maxProfitQ.add(minCostQ.poll());
            }
            Project project = maxProfitQ.poll();
            System.out.println(project);
            if (project != null) {
                m += project.profit;
            }
        }


        return m;

    }


}
