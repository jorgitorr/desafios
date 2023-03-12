/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package desafios;

import java.util.Scanner;

/**
 *
 * @author jorge
 */
public class Bolos208 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bolasTotales, bolasDePie;
        while(true){
            bolasTotales = 0; bolasDePie = 0;
            
            int filasTotales = Integer.parseInt(sc.next());
            int filaElegida = Integer.parseInt(sc.next());
            
            if(filasTotales==0 && filaElegida==0)
                break;
            
            //filas totales 
            for (int i = 1; i <= filasTotales; i++) {
                bolasTotales += i;
            }
            
            //bolas tiradas
            int cont = filasTotales;
            int i = 1;
            bolasDePie = bolasTotales;
            while(cont>=filaElegida && filaElegida>0){
                bolasDePie-=i;
                i++;
                cont--;
            }
            
            System.out.println(bolasDePie);
        }
        
        
    }
    
    
    /**CODIGO MEJORADO POR CHATPT
     * import java.util.Scanner;

    public class Bolos208 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int filasTotales, filaElegida;
            while (true) {
                filasTotales = Integer.parseInt(sc.next());
                filaElegida = Integer.parseInt(sc.next());

                if (filasTotales == 0 && filaElegida == 0) {
                    break;
                }

                // Calcular el número total de bolas
                int bolasDePie = (filasTotales * (filasTotales + 1)) / 2;

                // Restar las bolas de cada fila desde la fila elegida hasta la última fila
                int bolasPorFila = filasTotales;
                while (filaElegida > 0) {
                    bolasDePie -= bolasPorFila;
                    bolasPorFila--;
                    filaElegida--;
                }

                System.out.println(bolasDePie);
            }
        }
    }
     */
    
}
