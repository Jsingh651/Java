public class Mammals{
    public int energyLvl;
    public static final int DEFAULT_ENERGY = 100;

    // Constructor
    public void Mammal() {
        this.energyLvl = DEFAULT_ENERGY;
    }

    public void displayMalmmal (){
        System.out.println(String.format("My energy level is %s", energyLvl));
    }

    public int getEnergy(){
        return energyLvl;
    }

    public void setEnergy(int energyLvl){
        this.energyLvl = energyLvl;
    }


}