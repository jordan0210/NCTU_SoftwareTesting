import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Game game = new Game();

        Scanner input = new Scanner(System.in);
        System.out.println("Enter Player 1 choice (rock, paper or scissors):");
        String player1 = input.next();
        game.player[0] = game.validation(player1);

        System.out.println("Enter Player 2 choice (rock, paper or scissors):");
        String player2 = input.next();
        game.player[1] = game.validation(player2);

        game.checkWinner();
    }
}
