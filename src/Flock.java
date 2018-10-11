import java.util.ArrayList;

public class Flock implements Quackable {

    ArrayList<Quackable> quackables = new ArrayList();


    public void addDuck(Quackable quacker) {
        quackables.add(quacker);
    }

    @Override
    public void quack() {
        for(Quackable quacker:quackables){
            quacker.quack();
            System.out.println("Quack Quack Quack");
        }
    }
}
