package pl.budzisz.mariusz.cross_n_circle.players;

import pl.budzisz.mariusz.cross_n_circle.Data;
import pl.budzisz.mariusz.cross_n_circle.figures.Figures;
import pl.budzisz.mariusz.cross_n_circle.view.Window;

import java.util.Scanner;

public class PlayerHuman extends Player {

    private Scanner input = new Scanner(System.in);

    public PlayerHuman(Figures figure, Data data, Window window) {
        super(figure, data, window);
    }

    @Override
    public void move() {
        boolean correct = false;
        while(!correct) {
            System.out.println("Wiersz numer: ");
            int x = input.nextInt() - 1;
            System.out.println("Kolumna numer: ");
            int y = input.nextInt() - 1;
            if (!data.tab[x][y].equals(Figures.EMPTY)) {
                System.out.println("Zly ruch! ");
                correct = false;
            } else {
                data.tab[x][y] = figure;
                correct = true;
            }
        }
    }
}
