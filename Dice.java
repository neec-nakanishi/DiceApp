public class Dice {
    int me;

    public void roll() {
        me = (int) (Math.random() * 6) + 1;
    }
}
