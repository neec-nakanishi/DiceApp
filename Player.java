import java.util.Scanner;

public class Player {
    String name;
    int point;

    Player(String name) {
        this.name = name;
    }

    void turn(Dice[] dices) {
        // Enterキーを押したらサイコロを振るようにする
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        for (int i = 0; i < dices.length; i++) {
            dices[i].roll();
            System.out.print(dices[i].me + " ");
        }
    }
}
