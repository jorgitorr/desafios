/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package desafios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jorge
 */
public class Pollitos328 {
    /**
     * imprime el gallinero con los granos
     * @param gallinero 
     */
    public static void imprimirGallinero(int[][]gallinero){
        for(int i=0; i<gallinero.length; i++){
            for(int j=0; j<gallinero[0].length; j++){
                System.out.print(gallinero[i][j] + " ");
            }
            System.out.println();
        }
    }
    /**
     * @return el gallinero de cada pollo
     */
    public static int[][] colocaGranos(int[][]gallinero, String[]pollo){
        int verticalPollo = Integer.parseInt(pollo[0])-1;//le resto 1 para tener la pos en la matriz
        int horizontalPollo = Integer.parseInt(pollo[1])-1;//le resto 1 para tener la pos en la matriz
        String direcionPollo = pollo[2];
        int pasosPollo = Integer.parseInt(pollo[3]);
        int distanciaN = 0, distanciaE = 0, distanciaO = 0, distanciaS = 0;
        
        
        //pos pollo:
        gallinero[verticalPollo][horizontalPollo] = 1;
            
        //empieza con una dirección cada pollo y luego cambia su direcion segun la que tienen
        do{
            if(verticalPollo>=0 && horizontalPollo>=0 && verticalPollo < gallinero.length && horizontalPollo < gallinero[0].length){
                    if(direcionPollo.equalsIgnoreCase("N")){
                    for(int distancia=0; distancia<=distanciaS; distancia++){
                        --verticalPollo;
                        if(verticalPollo>=0 && horizontalPollo>=0 && verticalPollo < gallinero.length && horizontalPollo < gallinero[0].length && pasosPollo > 0){
                            gallinero[verticalPollo][horizontalPollo] += 1;
                            ++distanciaN;
                            --pasosPollo;
                        }
                        else
                            break;
                    }
                    direcionPollo = "E";
                }else if(direcionPollo.equalsIgnoreCase("S")){
                    for(int distancia=0; distancia<=distanciaN; distancia++){
                        ++verticalPollo;
                        if(verticalPollo>=0 && horizontalPollo>=0 && verticalPollo < gallinero.length && horizontalPollo < gallinero[0].length && pasosPollo > 0){
                            gallinero[verticalPollo][horizontalPollo] += 1;
                            ++distanciaS;
                            --pasosPollo;
                        }
                        else
                            break;
                    }
                    direcionPollo = "O";
                }else if(direcionPollo.equalsIgnoreCase("E")){
                    for(int distancia=0; distancia<=distanciaO; distancia++){
                        ++horizontalPollo;
                        if(verticalPollo>=0 && horizontalPollo>=0 && verticalPollo < gallinero.length && horizontalPollo < gallinero[0].length && pasosPollo > 0){
                            gallinero[verticalPollo][horizontalPollo] += 1;
                            ++distanciaE;
                            --pasosPollo;
                        }
                        else
                            break;
                    }
                    direcionPollo = "S";
                }else if(direcionPollo.equalsIgnoreCase("O") || direcionPollo.equalsIgnoreCase("W")){
                    for(int distancia=0; distancia<=distanciaE; distancia++){
                        --horizontalPollo;
                        if(verticalPollo>=0 && horizontalPollo>=0 && verticalPollo < gallinero.length && horizontalPollo < gallinero[0].length && pasosPollo > 0){
                            gallinero[verticalPollo][horizontalPollo] += 1;
                            ++distanciaO;
                            --pasosPollo;
                        }
                        else
                            break;
                    }
                    direcionPollo = "N";
                }
            }else{
                break;
            }
        }while(pasosPollo>0);
        return gallinero;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int casos = sc.nextInt();
        sc.nextLine();
        List <Integer> infoGallineroyNumPollos;
        int gallinero[][];
        String pollo[];
        
        for(int caso = 0; caso<casos; caso++){
            infoGallineroyNumPollos = new ArrayList();
            for(int i=0; i<3; i++){
                infoGallineroyNumPollos.add(sc.nextInt());
            }
            
            //CREACION DEL GALLINERO
            gallinero = new int[infoGallineroyNumPollos.get(0)][infoGallineroyNumPollos.get(1)];//fil y col
            
            
            for(int j=0; j<infoGallineroyNumPollos.get(2); j++){
                //cada pollo
                pollo = new String[4];
                //GUARDA INFO DE CADA POLLO
                for(int k=0; k<4; k++){
                    pollo[k] = sc.next();
                }
                //EL GALLINERO DE CADA POLLO
                colocaGranos(gallinero,pollo); 
            }
            
            imprimirGallinero(gallinero);
            System.out.println("---");
        }
    }
}
