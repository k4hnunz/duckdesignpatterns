public class QuackCounter implements Quackable {

    Quackable duck;
    static int numberOfQuack;

    public QuackCounter(Quackable duck) {
        this.duck = duck;
    }

    @Override
    public void quack() {
        duck.quack();
        numberOfQuack++;
    }

    public static int getQuacks() {
        return numberOfQuack;
    }

    public static void setNumberOfQuack(int numberOfQuack) {
        QuackCounter.numberOfQuack = numberOfQuack;
    }
}
