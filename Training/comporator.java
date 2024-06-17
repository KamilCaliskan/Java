import java.util.*;

class Player {
    String name;
    int score;
    
    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {
    public int compare(Player a, Player b) {
        if (b.score == a.score) {
            return a.name.compareTo(b.name); // sort alphabetically by name if scores are tied
        } else {
            return b.score - a.score; // sort by decreasing score
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Player[] playerArray = new Player[n];
        Checker checker = new Checker();
        
        for (int i = 0; i < n; i++) {
            String name = scan.next();
            int score = scan.nextInt();
            playerArray[i] = new Player(name, score);
        }
        scan.close();
        
        Arrays.sort(playerArray, checker);
        
        for (Player player : playerArray) {
            System.out.printf("%s %d\n", player.name, player.score);
        }
    }
}
