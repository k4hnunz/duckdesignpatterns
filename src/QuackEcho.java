public class QuackEcho implements Quackable{

    Quackable quackable;

    public QuackEcho(Quackable quackable) {
        this.quackable = quackable;
    }

    @Override
    public void quack() {
        quackable.quack();
        System.out.print("Echo ");
        quackable.quack();

    }
}
