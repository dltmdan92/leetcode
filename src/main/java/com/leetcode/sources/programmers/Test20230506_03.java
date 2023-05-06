package com.leetcode.sources.programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test20230506_03 {
    public static void main(String[] args) {
        System.out.println(solution(
                new String[] {
                        "1000011",
                        "1111000",
                        "0000000",
                        "1101111"
                }
        ));
    }

    private static int solution(String[] maps) {
        boolean islands[][] = new boolean[maps.length][maps[0].length()];
        List<IslandNode> badaList = new ArrayList<>();

        for (int row = 0; row < maps.length; row++) {
            String line = maps[row];
            String[] elements = line.split("");
            for (int col = 0; col < elements.length; col++) {
                islands[row][col] = elements[col].equals("1");
                if (!islands[row][col]) {
                    badaList.add(new IslandNode(row, col));
                }
            }
        }

        int result = 0;
        // UP, DOWN, LEFT, RIGHT
        int[] dirRow = new int[] {-1, 1, 0, 0};
        int[] dirCol = new int[] {0, 0, -1, 1};

        for (IslandNode bada : badaList) {
            int badaRow = bada.getRow();
            int badaCol = bada.getCol();
            islands[badaRow][badaCol] = true;

            result = Math.max(result, dfs(islands, dirRow, dirCol));

            islands[badaRow][badaCol] = false;
        }
        return result;
    }

    /**
     * @param convertedIslands 바다 1곳 메꾼 islands map
     * @param dirRow
     * @param dirCol
     * @return
     */
    private static int dfs(boolean[][] convertedIslands, int[] dirRow, int[] dirCol) {

        int rows = convertedIslands.length;
        int cols = convertedIslands[0].length;

        int result = 0;

        for (int startRow = 0; startRow < rows; startRow++) {
            for (int startCol = 0; startCol < cols; startCol++) {

                if (convertedIslands[startRow][startCol]) {
                    boolean[][] visitable = new boolean[rows][cols];

                    for (int row = 0; row < rows; row++) {
                        boolean[] line = convertedIslands[row];
                        for (int col = 0; col < line.length; col++) {
                            visitable[row][col] = convertedIslands[row][col];
                        }
                    }

                    int currentCount = 0;

                    Stack<IslandNode> stack = new Stack<>();
                    stack.add(new IslandNode(startRow,startCol));
                    visitable[startRow][startCol] = false;
                    currentCount++;

                    while (!stack.isEmpty()) {
                        IslandNode currentIsland = stack.pop();

                        for (int i = 0; i < dirRow.length; i++) {
                            int moveRow = dirRow[i];
                            int moveCol = dirCol[i];
                            int newRow = moveRow + currentIsland.getRow();
                            int newCol = moveCol + currentIsland.getCol();
                            if (newRow >= 0 && newRow < rows
                                    &&
                                    newCol >= 0 && newCol < cols
                            ) {
                                boolean island = convertedIslands[newRow][newCol];
                                if (island && visitable[newRow][newCol]) {
                                    currentCount++;
                                    visitable[newRow][newCol] = false;
                                    stack.add(new IslandNode(newRow, newCol));
                                }
                            }
                        }
                    }
                    result = Math.max(result, currentCount);
                }

            }
        }
        return result;
    }

    public static class IslandNode {
        private final int row;
        private final int col;

        public IslandNode(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

    }

}
