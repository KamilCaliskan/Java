// Puzzle is a sliding blocks game that takes place on a k * k grid with ((k * k) - 1) tiles each numbered from 1 to N
//Your task is to reposition the tiles to their proper order
import java.io.*;
import java.util.*;

public class Solution {

    static class State {
        int[][] board;
        int emptyRow, emptyCol;
        int moves;
        List<String> path;
        int cost;

        State(int[][] board, int emptyRow, int emptyCol, int moves, List<String> path) {
            this.board = board;
            this.emptyRow = emptyRow;
            this.emptyCol = emptyCol;
            this.moves = moves;
            this.path = new ArrayList<>(path);
            this.cost = moves + heuristic(board);
        }

        static int heuristic(int[][] board) {
            int h = 0;
            int n = board.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int value = board[i][j];
                    if (value != 0) {
                        int targetRow = value / n;
                        int targetCol = value % n;
                        h += Math.abs(i - targetRow) + Math.abs(j - targetCol);
                    }
                }
            }
            return h;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        int[][] board = new int[k][k];
        int emptyRow = 0, emptyCol = 0;

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                board[i][j] = Integer.parseInt(br.readLine());
                if (board[i][j] == 0) {
                    emptyRow = i;
                    emptyCol = j;
                }
            }
        }

        solvePuzzle(k, board, emptyRow, emptyCol);
    }

    private static void solvePuzzle(int k, int[][] board, int emptyRow, int emptyCol) {
        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(s -> s.cost));
        Set<String> visited = new HashSet<>();

        State initial = new State(board, emptyRow, emptyCol, 0, new ArrayList<>());
        pq.add(initial);
        visited.add(serialize(board));

        while (!pq.isEmpty()) {
            State current = pq.poll();

            if (isSolved(current.board)) {
                System.out.println(current.moves);
                for (String move : current.path) {
                    System.out.println(move);
                }
                return;
            }

            for (int[] dir : new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }) {
                int newRow = current.emptyRow + dir[0];
                int newCol = current.emptyCol + dir[1];

                if (newRow >= 0 && newRow < k && newCol >= 0 && newCol < k) {
                    int[][] newBoard = deepCopy(current.board);
                    swap(newBoard, current.emptyRow, current.emptyCol, newRow, newCol);

                    if (!visited.contains(serialize(newBoard))) {
                        String move = getMove(dir);
                        List<String> newPath = new ArrayList<>(current.path);
                        newPath.add(move);

                        State newState = new State(newBoard, newRow, newCol, current.moves + 1, newPath);
                        pq.add(newState);
                        visited.add(serialize(newBoard));
                    }
                }
            }
        }
    }

    private static boolean isSolved(int[][] board) {
        int k = board.length;
        int value = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (board[i][j] != value++) {
                    return false;
                }
            }
        }
        return true;
    }

    private static String serialize(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            for (int cell : row) {
                sb.append(cell).append(",");
            }
        }
        return sb.toString();
    }

    private static int[][] deepCopy(int[][] board) {
        int[][] copy = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            copy[i] = board[i].clone();
        }
        return copy;
    }

    private static void swap(int[][] board, int r1, int c1, int r2, int c2) {
        int temp = board[r1][c1];
        board[r1][c1] = board[r2][c2];
        board[r2][c2] = temp;
    }

    private static String getMove(int[] dir) {
        if (Arrays.equals(dir, new int[] { 0, 1 })) return "RIGHT";
        if (Arrays.equals(dir, new int[] { 1, 0 })) return "DOWN";
        if (Arrays.equals(dir, new int[] { 0, -1 })) return "LEFT";
        if (Arrays.equals(dir, new int[] { -1, 0 })) return "UP";
        return "";
    }
}
