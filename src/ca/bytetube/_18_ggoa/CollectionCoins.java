package ca.bytetube._18_ggoa;

public class CollectionCoins {
    public static void main(String[] args) {
        test("C..T...C", 0);
        test("T..C..C..C", 3);
        test("CCTTCC", 1);
        test("CCC.....", 0);
        test("T..C..T..C", 2);
        test("C..C..T", 0);
        test("..T.C..C.T.C..C", 2);
        test("TCTCTC", 2);
        test("TT.T.CCCCC", 3);
    }

    private static void test(String board, int expected) {
        int ans = solution(board);
        System.out.printf("board = \"%s\" -> collected = %d (expected %d)%n", board, ans, expected);
    }


    public static int solution(String board){
        int count = 0;
        boolean hasT;

        for (int i = 0; i < 3; i++) { //0, 1, 2
            hasT = false;
            for (int j = i; j < board.length(); j += 3) {
                if (hasT && board.charAt(j) == 'C') {
                    count++;
                } else if (board.charAt(j) == 'T') hasT = true;
            }
        }
        return count;
    }




    public static int solution1(String board) {
        int count = 0;
        for (int i = 3; i < board.length(); i++) {
            if (board.charAt(i) == 'C' && board.charAt(i - 3) == 'T') {
                count += 1;
                if (i != board.length() - 1) {
                    board = board.substring(0, i) + 'T' + board.substring(i + 1);
                }
            } else if (board.charAt(i) == '.' && board.charAt(i - 3) == 'T') {
                if (i != board.length() - 1) {
                    board = board.substring(0, i) + 'T' + board.substring(i + 1);
                }
            }
        }
        return count;
    }

}
