import java.util.*;

public class TicTacToe {

    public static ArrayList<Integer> playerPositions = new ArrayList<>();
    public static ArrayList<Integer> cpuPositions = new ArrayList<>();

    public static void main(String[] args) {
        char[][] gameBoard =
                {
                        {' ', '|', ' ', '|', ' '},
                        {'-', '+', ' ', '+', '-'},
                        {' ', '|', ' ', '|', ' '},
                        {'-', '+', ' ', '+', '-'},
                        {' ', '|', ' ', '|', ' '},
                };
        printGameBoard(gameBoard);
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter the value in (1-9) to start");
            int playerpos = scan.nextInt();
            while (playerPositions.contains(playerpos) || cpuPositions.contains(playerPositions)) {
                System.out.println("Positions Taken......Please try Another number");
                playerpos = scan.nextInt();
            }
            switchCaseGame(playerpos, gameBoard, "player");
            String wn = winnerCheck();
            if (wn.length() > 0) {
                System.out.println(wn);
                break;
            }
            Random rnd = new Random();
            int posCom = rnd.nextInt(9) + 1;
            while (cpuPositions.contains(posCom) || cpuPositions.contains(playerPositions)) {
                System.out.println("Positions Taken");
                posCom = rnd.nextInt(9) + 1;
            }
            switchCaseGame(posCom, gameBoard, "com");
            printGameBoard(gameBoard);
            wn = winnerCheck();
            if (wn.length() > 0) {
                System.out.println(wn);
                break;
            }
        }
    }

    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static void switchCaseGame(int playerpos, char[][] gameBoard, String user) {
        char symbol = 0;
        if (user.equals("player")) {
            symbol = 'X';
            playerPositions.add(playerpos);
        } else if (user.equals("com")) {
            symbol = 'O';
            cpuPositions.add(playerpos);
        }

        switch (playerpos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }


    public static String winnerCheck() {


        List topRow = Arrays.asList(1, 2, 3);
        List middleRow = Arrays.asList(4, 5, 6);
        List bottomRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List middleCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List leftDia = Arrays.asList(1, 5, 9);
        List rightDia = Arrays.asList(3, 5, 7);

        List<List> al = new ArrayList<List>();
        al.add(topRow);
        al.add(middleRow);
        al.add(bottomRow);
        al.add(leftCol);
        al.add(middleCol);
        al.add(leftDia);
        al.add(rightCol);
        al.add(topRow);
        al.add(rightDia);

        for (List l : al) {
            if (playerPositions.containsAll(l)) {
                System.out.println("Winner");
                break;
            } else if (cpuPositions.containsAll(l)) {
                System.out.println("CPU WON...YOU LOOOOSER");
                break;
            } else if (cpuPositions.size() + playerPositions.size() == 9) {
                System.out.println("MATCH DRAWN!!!!!!!!!!");
                break;
            }
        }
        return "";
    }
}

