/*
 * Autores: Cayetano Molina, Diego Castellanos
 * Driver del programa que muestra el men� y todo lo dem�s
 */

import java.util.*;

class RadiosDriver{
    public static void main(String[] args){
        Radios radio = new Radios();
        Scanner scan = new Scanner(System.in);
        int opcion = 0;
        int btn = 0;
        int elec = 0;
        boolean frec;//Controlar que frecuencia es

        System.out.println("Bienvenido a su radio del carro!");
        System.out.println("Para empezar le mostraremos el menú para saber que quiere hacer");

        //Menú de opciones
        while(opcion!=6){
            System.out.println("\n1. Prender Radio");
            System.out.println("2. Cambiar de AM a FM");
            System.out.println("3. Avanzar el dial de las emisoras");
            System.out.println("4. Guardar la emisora más reciente en los botones");
            System.out.println("5. Seleccionar el botón con algúna emisora guardada");
            System.out.println("6. Apagar la radio\n");
            opcion = scan.nextInt();
            if(opcion==1){
                System.out.println("\nUsted ha elegido prender la radio");
                System.out.println("Se ha prendido la radio");
                System.out.println("Ahora la radio se encuentra en la frecuencia AM");
                radio.encenderApagar(); //Enciende la radio
                System.out.println(radio); //Muestra la estación actual
            } 
            else if(opcion==2){
                System.out.println("\nUsted ha elegido cambiar de AM a FM");
                frec = radio.amFm(); //Cambia al inicio de cada frecuencia de radio
                if(frec==true){
                    System.out.println("La radio ahora se encuentra en la frecuencia AM");
                }
                else{
                    System.out.println("La radio ahora se encuentra en la frecuencia FM");
                }
                System.out.println(radio); //Muestra la estación actual
            }
            else if(opcion==3){
                System.out.println("\nUsted ha avanzado en el dial de las emisoras");
                radio.avanzar(); //Avanza en el dial de las emisoras dependiendo de la frecuencia de radio
                System.out.println(radio);
            }
            else if(opcion==4){
                System.out.println("\nUsted ha elegido guardar la estación más reciente en uno de los botones");
                System.out.println("En qué botón desea guardar la estación/ 1-12 ?");
                btn = scan.nextInt();
                System.out.println("\n" + radio.guardar(btn));//Guarda la emisora actual en el botón escogido

            }
            else if(opcion==5){
                System.out.println("\nPor favor eliga alguna estación");
                elec = scan.nextInt();//El usuario elige una estacion con una emisora guardada
                System.out.println(radio.seleccionar(elec));
                System.out.println(radio);//Muestra la emisora guardada en ese bot�n 
                
            }
            else if(opcion==6){
            	scan.close();//Cierra el scan y termina el programa
            	radio.encenderApagar();
                System.out.println("Gracias por usar la radio!");
            }

        }

    }
}