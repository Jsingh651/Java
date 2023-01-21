public class Driver extends Car {
//     public String displayGas() {
//     return "The current gas level is: " + this.car.getGasLevel();
//   }

    public void drive (){
        setGasLevel(getGas() -1);
        System.out.println("Your driving...");
        displayGas();
    }
    public void boosters (){
        setGasLevel(getGas() -3);
        System.out.println("You used a booster.");
        displayGas();

    }
    public void fuel (){
        setGasLevel(getGas() +2);
        System.out.println("You filled up your car.");
        displayGas();
    }

}