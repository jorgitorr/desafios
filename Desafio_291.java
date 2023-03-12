/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package desafios;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author jorge
 */
public class Desafio_291 {
    private Map<String,Integer>mapaPalabras;
    private List<String>palabras;

    public Desafio_291() {
        this.mapaPalabras = new TreeMap<>();
        this.palabras = new ArrayList<>();
    }
    
    private void limpiarMapa(){
        mapaPalabras.clear();
    }

    public Map<String, Integer> getMapaPalabras() {
        return mapaPalabras;
    }

    public void setMapaPalabras(Map<String, Integer> mapaPalabras) {
        this.mapaPalabras = mapaPalabras;
    }

    public List<String> getPalabras() {
        return palabras;
    }

    public void setPalabras(List<String> palabras) {
        this.palabras = palabras;
    }
    
    private void limpiarArray(){
        palabras.clear();
    }

    private void ingresaFraseArray(String frase) {
        int inicioPalabra = 0;
        int finPalabra = 0;
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == ' ' || i == frase.length() - 1) {
                finPalabra = i;
                if (i == frase.length() - 1) 
                    finPalabra++;
                /*
                beginIndex - the beginning index, inclusive.
                endIndex - the ending index, exclusive.
                */
                palabras.add(frase.substring(inicioPalabra, finPalabra));
                inicioPalabra = i + 1;
            }
        }
    }

    
    private void introducePalabra(String palabra){
        if(mapaPalabras.containsKey(palabra.toLowerCase())){
            for(String p: mapaPalabras.keySet()){
                if(p.equalsIgnoreCase(palabra))
                    mapaPalabras.put(p, mapaPalabras.get(p)+1);
            }
        }else
            mapaPalabras.put(palabra.toLowerCase(), 1);
    }
    
    void printMap(){
        for(String p: mapaPalabras.keySet()){
            System.out.println(p + "->" + mapaPalabras.get(p));
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Desafio_291 d = new Desafio_291();
        int numLineas;
        
        do{
            numLineas = sc.nextInt();
            sc.nextLine();
            
            
            if(numLineas==0)
                break;
            
            for(int i=0; i<numLineas; i++){
                d.ingresaFraseArray(sc.nextLine());
                for (String palabra : d.getPalabras()) {
                    d.introducePalabra(palabra);
                }
                d.limpiarArray();
            }
            d.printMap();
            d.limpiarMapa();
        }while(numLineas!=0);
        
    }
    
}
