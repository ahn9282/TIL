package facade_pattern.yc;

public class SmartHomeFacade {

    private Thermostat thermostat;
     private CoffeeMaker coffeeMaker;
    private Lights lights;

     public SmartHomeFacade(Thermostat thermostat, CoffeeMaker coffeeMaker, Lights lights) {
         this.thermostat = thermostat;
         this.coffeeMaker = coffeeMaker;
         this.lights = lights;

     }

     public void wakeUp(){
         System.out.println("Waking up ..");
         thermostat.setTemperature(22);
         lights.on();
         coffeeMaker.brewCoffee();
     }

     public void leaveHome(){
         System.out.println("Leaving home ..");
         thermostat.setTemperature(18);
         lights.off();
     }
}
