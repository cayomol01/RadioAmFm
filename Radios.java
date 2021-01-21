import java.util.*;

class Radios implements Interface{
    private String s;
    private double estacion = 0;
    private boolean encendido = false; //false es apagado y true significa encendido
    private boolean radio = true; //True es am false es fm
    private String mensajeguardar ;
    private String mensajeseleccionar;
    private ArrayList<Double> guardadas = new ArrayList<Double>();
    private double maxa = 1610;
    private double mina = 530;
    private double maxf = 107.9;
    private double minf = 87.9;

    public Radios(){
        for(int i = 0; i<12; i++){
            guardadas.add(0d);
        }
    }

    public boolean encenderApagar(){
        if(encendido== false){
            encendido = true;
            estacion = mina;
        }
        else{
            encendido = false;
        }
        return encendido;
    }

    public boolean amFm(){
        if(radio == true){
            radio = false;
            estacion = minf;
        }
        else if (radio == false){
            radio = true;
            estacion = mina;
        }
        return radio;
    }

    public String guardar(int btn){
        guardadas.set(btn-1, estacion);
        mensajeguardar= "Su estación se ha guardado en el botón: ";
        mensajeguardar += btn;
        return mensajeguardar;
    }

    public String seleccionar(int btn){
        if(guardadas.get(btn-1).equals(0d)){
            mensajeseleccionar = "\nNo hay ninguna estación guardada en el lugar indicado...\n";

        }
        else{
            mensajeseleccionar = "\nUsted ha seleccionado el botón: " + btn + "\n";
            estacion = guardadas.get(btn-1);
            if(estacion>=mina && estacion<=maxa){
                radio = true;
            }
            else{
                radio = false;
            }
        }

        return mensajeseleccionar;
    }

 
    public double avanzar(){
        if (radio == true){
            if (estacion+10>maxa){
                estacion = mina;
            }
            else{
                estacion += 10;
            }

        }
        else{
            if (estacion+0.2 > maxf){
                estacion = minf;
            }
            else{
                estacion += 0.2;
            }
        }
        return estacion;
    }

    public String toString(){
        if(radio == true){
            s = "la estacion actual es: " + String.valueOf(estacion) + " AM\n";  
        }
        else{
            s = "la estacion actual es: " + String.valueOf(estacion) + " FM\n";  
        }
        
        return s; 
    }
}
