public class Game {
    private int[][] winnerArray = {{0, 2, 1},
                                    {1, 0, 2},
                                    {2, 1, 0}};
    int[] player = new int[2];

    public Game() {
        System.out.println("=== Welcome to Rock-Paper-Scissors game ===");
    }

    public void checkWinner(){
        switch(winnerArray[player[0]][player[1]]){
            case 0:
                System.out.println("Draw!");
                break;
            case 1:
                System.out.println("Player 1 win!");
                break;
            case 2:
                System.out.println("Player 2 win!");
                break;
        }
    }

    public int validation(String input) throws IllegalArgumentException{
        switch(input){
            case "rock":
                return 0;
            case "paper":
                return 1;
            case "scissors":
                return 2;
            default:
                throw new IllegalArgumentException("Bad Choice!");
        }
    }
}
