package Examen2.Ej2;

import java.util.ArrayList;

public class Lista {
    ArrayList<Robot> listado;

    public Lista(ArrayList<Robot> listado) {
        this.listado = listado;
    }
    
    //adders
    public void add(Robot r){
        this.listado.add(r);
    }

    //toString
    @Override
    public String toString() {
        String returned =  "Lista:";
        for (Robot robot : listado) {
            returned+="\n"+robot.toString();
        }
        return returned;
    }

    //pedirId
    public String pedirID(String id){
        int pos= -1;
        for (int i=0;i<listado.size();i++) {
            if (id.compareTo(listado.get(i).getId())==0) {
                pos=i;
                break;
            }
        }

        if (pos==-1) {
            return "no existe ningun robot con esa id";
        }
        Robot encontrado = mayorModeloMismasPiezas(pos);
        if (encontrado==null) {
            return "Robot encontrado: "+listado.get(pos).toString()+ "\nNo existe un robot de mayor modelo con el mismo numero de piezas";
        }
        return "Robot encontrado: "+listado.get(pos).toString()+ "\nRobot de mayor modelo con el mismo numero de piezas:" +encontrado.toString();
    }
    public Robot mayorModeloMismasPiezas(int pos){
        ArrayList<Robot> piezas = mismasPiezas(listado.get(pos));
        if (piezas.size()<1) {
            return null;
        }
        piezas.sort(new SortModeloPiezas());
        return piezas.get(0);
    }
    public ArrayList<Robot> mismasPiezas(Robot b){
        ArrayList<Robot> same = new ArrayList<Robot>();
        
        for (Robot robot : listado) {
            if (robot.getnPiezas()==b.getnPiezas()&&robot.getId().compareTo(b.getId())!=0) {
                same.add(robot);
            }
        }
        return same;
    }
    
    //ordenar
    public void ordenar(){
        listado.sort(new SortModeloPiezas());
    }
}
