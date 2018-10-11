public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        AbstractDuckFactory abstractDuckFactory = new CountingDuckFactory();
        simulator.simulateV1();
        simulator.simulateV2();
        simulator.simulateV3();
        simulator.simulateV4(abstractDuckFactory);
        simulator.simulateV5(abstractDuckFactory);
    }
    void simulateV1() {
        System.out.println("- - - - - - V1 - - - - - -");
        Quackable mallardDuck = new MallardDuck();
        Quackable redheadDuck = new RedheadDuck();
        Quackable duckCall = new DuckCall();
        Quackable rubberDuck = new RubberDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());
        Quackable pigeon = new PigeonAdapter(new Pigeon());

        System.out.println("Duck Simulator");
        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);
        simulate(pigeon);

    }
    void simulateV2() {
        System.out.println("\n - - - - - - V2 - - - - - -");
        Quackable mallardDuck = new QuackCounter(new QuackEcho(new MallardDuck()));
        Quackable redheadDuck = new QuackCounter(new QuackEcho(new RedheadDuck()));
        Quackable duckCall = new QuackCounter(new QuackEcho(new DuckCall()));
        Quackable rubberDuck = new QuackCounter(new QuackEcho(new RubberDuck()));
        Quackable gooseDuck = new GooseAdapter(new Goose());
        Quackable pigeon = new PigeonAdapter(new Pigeon());
        System.out.println("Duck Simulator");
        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);
        simulate(pigeon);
        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");
    }

    void simulateV3() {
        System.out.println("\n - - - - - - V3 - - - - - -");
        QuackCounter.setNumberOfQuack(0);
        Quackable mallardDuck = new QuackEcho(new QuackCounter(new MallardDuck()));
        Quackable redheadDuck = new QuackEcho(new QuackCounter(new RedheadDuck()));
        Quackable duckCall = new QuackEcho(new QuackCounter(new DuckCall()));
        Quackable rubberDuck = new QuackEcho(new QuackCounter(new RubberDuck()));
        Quackable gooseDuck = new GooseAdapter(new Goose());
        Quackable pigeon = new PigeonAdapter(new Pigeon());
        System.out.println("Duck Simulator");
        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);
        simulate(pigeon);
        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");
    }
    void simulateV4(AbstractDuckFactory abstractDuckFactory){
        QuackCounter.setNumberOfQuack(0);
        System.out.println("\n - - - - - - V4 - - - - - -");
        Quackable mallardDuck = abstractDuckFactory.createMallardDuck();
        Quackable redheadDuck = abstractDuckFactory.createRedheadDuck();
        Quackable duckCall = abstractDuckFactory.createDuckCall();
        Quackable rubberDuck = abstractDuckFactory.createRubberDuck();
        Quackable gooseDuck =new GooseAdapter(new Goose());
        Quackable pigeonDuck =new PigeonAdapter(new Pigeon());
        System.out.println("Duck Simulator: With Abstract Factory");
        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);
        simulate(pigeonDuck);
        System.out.println("The ducks quacked "+QuackCounter.getQuacks()+" times.");
    }

    void simulateV5(AbstractDuckFactory abstractDuckFactory){
        QuackCounter.setNumberOfQuack(0);
        System.out.println("\n - - - - - - V5 - - - - - -");
        Quackable mallardDuck = abstractDuckFactory.createMallardDuck();
        Quackable redheadDuck = abstractDuckFactory.createRedheadDuck();
        Quackable duckCall = abstractDuckFactory.createDuckCall();
        Quackable rubberDuck = abstractDuckFactory.createRubberDuck();
        Quackable gooseDuck =new GooseAdapter(new Goose());
        Quackable pigeonDuck =new PigeonAdapter(new Pigeon());
        System.out.println("Duck Simulator: With Abstract Factory");
        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);
        simulate(pigeonDuck);
        System.out.println("\nDuck Simulator: With Composite - Flocks");
        Flock allDuck = new Flock();
        allDuck.addDuck(mallardDuck);
        allDuck.addDuck(redheadDuck);
        allDuck.addDuck(rubberDuck);
        allDuck.addDuck(duckCall);
        allDuck.addDuck(gooseDuck);
        allDuck.addDuck(pigeonDuck);

        Quackable redHead1 = new RedheadDuck();
        Quackable redHead2 = new RedheadDuck();
        Quackable redHead3 = new RedheadDuck();
        Flock redHeadDuckFlock = new Flock();
        redHeadDuckFlock.addDuck(redHead1);
        redHeadDuckFlock.addDuck(redHead2);
        redHeadDuckFlock.addDuck(redHead3);

        System.out.println("Duck Simulator: Whole Flock Simulation");
        simulate(allDuck);

        System.out.println("\nDuck Simulator: redHeadDuck Flock Simulation");
        simulate(redHeadDuckFlock);

        System.out.println("The ducks quacked "+QuackCounter.getQuacks()+" times.");
    }
    void simulate(Quackable duck) {
        duck.quack();
    }
}
