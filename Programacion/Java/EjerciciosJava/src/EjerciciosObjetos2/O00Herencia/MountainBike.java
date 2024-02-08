package EjerciciosObjetos2.O00Herencia;

public class MountainBike extends Bicycle {
    private String suspension;

    public MountainBike(int startCadence, int startSpeed, int startGear, String suspensionType){
        super(startCadence, startSpeed, startGear);
        this.setSuspension(suspensionType);
    }

    public String getSuspension(){
      return this.suspension;}
    public void setSuspension(String suspensionType) {
        this.suspension = suspensionType;}

    @Override
    public String toString() {
        return "MountainBike [suspension=" + suspension + "]";
    }
} 
