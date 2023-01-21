public class Bat extends Mammals{
    private static final int DEFAULT_ENERGY = 300;

    // Constructor
    public Bat() {
        super();
        this.energyLvl = DEFAULT_ENERGY;
    }
    public void fly (){
        System.out.println("I am flying argghhhhh");
        this.energyLvl -= 50;
        displayBatlvl();
    }
    public void eatHumans (){
        System.out.println("I am eating humans");
        this.energyLvl += 25;
        displayBatlvl();
    }
    public void attackTowns (){
        System.out.println("Screams and cries of 100's of people being burned!! :)");
        this.energyLvl -= 100;
        displayBatlvl();
    }

    public void displayBatlvl (){
        System.out.println(String.format("My energy level is %s", energyLvl));
    }

    }
