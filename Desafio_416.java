/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package desafios;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author jorge
 */
public class Desafio_416 {
    private Map<String, Integer>fechas;
    private int casos;

    public Desafio_416() {
        this.fechas = new HashMap<>();
        casos = 0;
    }

    public Map<String, Integer> getFechas() {
        return fechas;
    }

    public int getCasos() {
        return casos;
    }

    public void setCasos(int casos) {
        this.casos = casos;
    }
    
    private void introduceFechas(String cadenaFechas){
        String claveFechas;
        int principioFecha = 0;
        int anio;
        fechas.clear();
        for(int i=0; i<=cadenaFechas.length()-1;i++){
            if(cadenaFechas.charAt(i)==' ' || i==cadenaFechas.length()-1){
                if(i==cadenaFechas.length()-1)
                    anio = Integer.parseInt(cadenaFechas.substring(i-3,i+1));
                else
                    anio = Integer.parseInt(cadenaFechas.substring(i-4,i));
                
                if(anio<=1600 || anio>=2000){
                    principioFecha = i+1;
                    continue;
                }
                claveFechas = cadenaFechas.substring(principioFecha, i-4);
                if(i==cadenaFechas.length()-1)
                    claveFechas = cadenaFechas.substring(principioFecha, i-3);
                principioFecha = i+1;
                if(fechas.containsKey(claveFechas))
                    fechas.put(claveFechas, fechas.get(claveFechas)+1);
                else
                    fechas.put(claveFechas, 1);
            }
        }
    }
    
    private boolean compruebaRepeticion(){
        boolean repetidos = false;
        for(String fecha: fechas.keySet()){
            if(fechas.get(fecha)>1){
                repetidos = true;
                break;
            }
        }
        return repetidos;
    }
    
    
    
    public static void main(String[] args) {
        Desafio_416 d = new Desafio_416();
        Scanner sc = new Scanner(System.in);
        int casos;
        String fechas;
        do{
            casos = sc.nextInt();
            d.setCasos(casos);
            if(d.getCasos()<=0)
                break;
            
            sc.nextLine();
            fechas = sc.nextLine();
            d.introduceFechas(fechas);
            if(d.compruebaRepeticion())
                System.out.println("SI");
            else
                System.out.println("NO");
        }while(casos>0);
    }
}
