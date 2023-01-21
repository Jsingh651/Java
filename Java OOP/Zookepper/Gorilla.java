public class Gorilla extends Mammals{
        public Gorilla() {
        super();
    }
    public void throwbanana(){
        setEnergy(getEnergy() - 5);
            System.out.println("You lost 5 energy points");
        
    }
    public void eatBananas(){
        setEnergy(getEnergy() + 10);
        System.out.println("You gained 10 energy points");
        
    }

    public void climb(){
        setEnergy(getEnergy() + 10);
        System.out.println("You lost 10 energy points and now I have points");
         displayMalmmal();

    }
    
}