package com.leetcode.sources.codility;

public class AirplaneSeat {

    public static void main(String[] args) {
        System.out.println(solution(22, "1A 3C 2B 20G 5A"));
    }

    private static int solution(int N, String S) {
        boolean[][] alreadySeated = new boolean[N][10];

        String[] seattedSeats = S.split(" ");

        if (!S.isBlank()) {
            for (String seattedSeat : seattedSeats) {

                int row = Integer.parseInt(seattedSeat.substring(0, seattedSeat.length() - 1)) - 1;
                int col = seattedSeat.substring(seattedSeat.length() - 1).charAt(0) - 'A';

                alreadySeated[row][col] = true;
            }
        }

        // 통로 cols: [1,2] [3,4] / [5,6] [7,8]

        int count = 0;

        for (int i = 0; i < alreadySeated.length; i++) {

            if (!alreadySeated[i][1] && !alreadySeated[i][2] && !alreadySeated[i][3] && !alreadySeated[i][4]) {
                count++;
                if (!alreadySeated[i][5] && !alreadySeated[i][6] && !alreadySeated[i][7] && !alreadySeated[i][8]) {
                    count++;
                }
            }
            else if (!alreadySeated[i][5] && !alreadySeated[i][6] && !alreadySeated[i][7] && !alreadySeated[i][8]) {
                count++;
            } else if (!alreadySeated[i][3] && !alreadySeated[i][4] && !alreadySeated[i][5] && !alreadySeated[i][6]) {
                count++;
            }


        }


        return count;
    }

}
