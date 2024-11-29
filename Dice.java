public class Dice {
    int me = 1;

    public void roll() {
        me = (int)(Math.random() * 6) + 1;
    }
}
