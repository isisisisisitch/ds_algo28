package ca.bytetube._18_ggoa;

public class TokenBoard {

    public static int solution(int[] points, String tokens) {
        boolean prevT = false;
        int total = 0;
        for (int i = 0; i < points.length; i++) {
            if (tokens.charAt(i) == 'T') {
                total += points[i];
                if (prevT) total += 1;
                prevT = true;
            } else prevT = false;
        }
        return total;

    }
//    public static int solution(int[] points, String tokens) {
//        int total = 0;
//        for (int i = 0; i < tokens.length(); i++) {
//            if (tokens.charAt(i) == 'T') {
//                total += points[i];
//                if (i > 0 && tokens.charAt(i - 1) == 'T') {
//                    total++;
//                }
//            }
//        }
//        return total;
//    }

    public static void main(String[] args) {
        int[] points1 = {3, 4, 5, 2, 3};
        String tokens1 = "TEETT";
        System.out.println(
                solution(points1, tokens1)); // 9
        int[] points2 = {3, 2, 1, 2, 2};
        String tokens2 = "ETTTE";
        System.out.println(

                solution(points2, tokens2)); // 7
        int[] points3 = {2, 2, 2, 2};
        String tokens3 = "TTTT";
        System.out.println(

                solution(points3, tokens3)); // 11
    }

}
