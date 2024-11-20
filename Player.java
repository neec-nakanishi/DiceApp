import java.util.Scanner;

public class Player {
    String name;

    Player(String name) {
        this.name = name;
    }

    void turn(Dice[] dices) {
        System.out.print(name + ": ");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        for (int i = 0; i < dices.length; i++) {
            dices[i].roll();
            System.out.print(dices[i].me + " ");
        }
        System.out.println();
        scan.close();
    }
}
