public class Car {
    private int gas;

    public Car(){
        gas = 10;
    }
    public void displayGas(){
        System.out.println(String.format("The gas level for this car is %s/10",gas));
    }

    public int getGas() {
    return gas;
}
public void setGasLevel(int gas) {
    if (gas > 10) {
    this.gas = 10;
    } else {
      this.gas = gas;
    }
  }


}