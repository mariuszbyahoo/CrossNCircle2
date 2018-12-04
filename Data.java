import java.util.Random;
import java.util.Scanner;

public class Data {
    private int command;
    private String[][] tab = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
    public boolean gameOver = false;

    public void printTable() {
        System.out.println("  1 2 3");
        // dla obsłużenia tablicy dwuwymiarowej, żeby była dalej zachowana możliwość rozszerzania tablicy w obydwu wymiarach
        // potrzebne jest wykonanie pętli for dla wymiaru pierwszego i zagnieździć w nim pętlę for dla wymiaru drugiego,
        // co ciekawe pokazuje się metoda pokazująca "długość" drugiego wymiaru; tab[i].length
        // jako że na początku pętla drukuje obydwa wymiary w jednym wierszu, potrzebne jest po zamknięciu pętli drugiego wymiaru
        // wydrukowanie znaku nowej linii - pusty sout.

        for (int i = 0; i < tab.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < tab[i].length; j++) {
                System.out.print("|" + tab[i][j]);
            }
            System.out.println("|");
        }
    }

    public void move(String val) {
        int y = 0;
        int x = 0;
        Scanner input = new Scanner(System.in);
        command = input.nextInt();

        if (command >= 1 && command <= 3) {
            x = command - 1;
            command = input.nextInt();
            if (command >= 1 && command <= 3) {
                y = command - 1;
            } else {
                System.out.println("Niepoprawny ruch");
            }
        } else {
            System.out.println("Niepoprawny ruch");
        }


        if (!tab[y][x].equals(" ")) {
            System.out.println("Pole zajęte, spróbuj jeszcze raz");
        } else {
            tab[y][x] = val;
        }
    }
    public void moveAi(String val) {
        while (true){
            Random rn = new Random();
            int x = rn.nextInt(tab.length);
            int y = rn.nextInt(tab.length);
            if (tab[y][x].equals(" ")) {
                tab[y][x] = val;
                break;
            }
        }
    }

    public void checkEnd() {
        this.gameOver = endGameInRow() || endGameInColumn() || checkEndInSlash() || checkEndInReverseSlash();
    }

    private boolean endGameInColumn() {
        boolean result = false;
        for (int i = 0 ; i < tab.length ; i++){
            if(checkEndInColumn(i)){
                result = true;
                break;
            }
        }
        return result;
    }

    private boolean endGameInRow() {
        boolean result = false;
        for (int i = 0 ; i < tab.length ; i++){
            if(checkEndInRow(i)){
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean checkEndInRow(int rowNumber) {
        boolean gameOver = true;
        for (int i = 1; i < tab[rowNumber].length; i++) {
            String current = tab[rowNumber][i];
            String previous = tab[rowNumber][i - 1];
            if (current.equals(" ") || !current.equals(previous)) {
                gameOver = false;
                break;
            }
        }
        return gameOver;
    }

    public boolean checkEndInColumn(int columnNumber) {
        boolean gameOver = true;
        for (int i = 1; i < tab.length; i++) {
            String current = tab[i][columnNumber];
            String previous = tab[i - 1][columnNumber];

            if (current.equals(" ") || !current.equals(previous)) {
                gameOver = false;
                break;
            }
        }
        return gameOver;
    }
    public boolean checkEndInSlash(){
        boolean result = true;
        for(int i = 1 ; i < tab.length ; i++){
            if(tab[i][i].equals(" ") || !tab[i][i].equals(tab[i-1][i-1])){
                result = false;
                break;
            }
        }
        return result;
    }
    public boolean checkEndInReverseSlash(){
        boolean result = true;
        for(int i = 1 , j = tab.length - 2 ; i < tab.length && j >= 0 ; i++ , j--){
            if(tab[i][j].equals(" ") || !tab[i][j].equals(tab[i-1][j+1])){
                result = false;
                break;
            }
        }
        return result;
    }
}
