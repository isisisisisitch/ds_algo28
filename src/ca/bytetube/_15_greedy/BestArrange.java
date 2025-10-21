package ca.bytetube._15_greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Some projects need to use a meeting room for presentations,
 * and the meeting room cannot host two presentations at the same time.
 * You are given the start time and end time of each project (as an array of intervals).
 * You need to schedule the presentations to maximize the number of sessions that can be held in the meeting room.
 * Return: the maximum number of presentations that can be scheduled.
 */
public class BestArrange {
    public static void main(String[] args) {
        Meeting[] meetings1 = {
                new Meeting(1, 3),
                new Meeting(2, 4),
                new Meeting(3, 5),
                new Meeting(0, 6),
                new Meeting(5, 7),
                new Meeting(8, 9)
        };

        System.out.println("Max sessions = " + bestArrange(meetings1, 0));

        Meeting[] meetings3 = {
                new Meeting(1, 5),
                new Meeting(2, 6),
                new Meeting(3, 7)
        };

        System.out.println("Max sessions = " + bestArrange(meetings3, 0));
    }

    public static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        @Override
        public String toString() {
            return "Meeting{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static int bestArrange(Meeting[] meetings, int current) {
        int count = 0;
        Arrays.sort(meetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                return o1.end - o2.end;
            }
        });
        List<Meeting> arranged = new ArrayList<>();
        for (Meeting m : meetings) {
            if (current <= m.start) {
                arranged.add(m);
                count++;
                current = m.end;
            }
        }

        System.out.println("arranged meetings :" + arranged);

        return count;
    }
}
