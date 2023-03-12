/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package desafios;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Jorge 
 * Juego del ahorcado
 */
public class Ahorcado {
        
    static private final String[] palabras_secretas = {"reingenieria", "cubeta","tunelizacion", "protocolo",
    "puertos", "conexion", "broadcasting", "direccion","internet", "router", "switch", "wifi", "estandar", 
    "socket", "transporte","enlace", "capas", "arquitectura", "cliente", "servidor", "proxy", "firewall","redes", 
    "LAN", "WAN", "MAN", "hub", "concentrador", "datagrama", "puente","fibra", "TCP", "UDP", "mascara", "gateway", 
    "servidor", "DNS", "cliente","conmutacion", "circuito", "satelite", "coaxial", "microondas", "seÃ±al","ingrarrojos", 
    "token", "anillo", "bus", "control", "flujo", "congestion","enrutamiento", "aplicacion", "correo", "peertopeer"};

    public static String damePalabraAleatoria(){
        List<String> palabras = Arrays.asList(palabras_secretas);
        Collections.shuffle(palabras);
        return palabras.get(0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pSecreta=Ahorcado.damePalabraAleatoria();
        String pGuiones = "", caracterIntroducido , caracterAnterior = "";
        int cont = 0;
        final int intentosMax = 10;
        
        for(int i=0; i<pSecreta.length(); i++){
            pGuiones += "-";
        }
        
        while(cont<intentosMax){
            
            if(pGuiones.equals(pSecreta)){
                System.out.println("Enhorabuena!! Adivinaste en " + cont + " intentos");
                break;
            }
            
            System.out.print("Ingresa una letra o la palabra a adivinar: ");
            caracterIntroducido = sc.nextLine();
            
            while(pGuiones.contains(caracterIntroducido) || caracterAnterior.equals(caracterIntroducido)){
                System.out.print("La letra ya ha sido introducida anteriormente, "
                        + "por favor introduce otro caracter: ");
                caracterIntroducido = sc.nextLine();
            }
            
            caracterAnterior = caracterIntroducido;
           
            if(pSecreta.equals(caracterIntroducido)){
                pGuiones = pSecreta;
                System.out.println("Enhorabuena!! Adivinaste en " + cont + " intentos");
                break;
            }
            
            for(int i=0; i<pSecreta.length(); i++){
                if(caracterIntroducido.equals(pSecreta.charAt(i) + "")){
                    pGuiones = pGuiones.substring(0, i) + caracterIntroducido + pGuiones.substring(i+1);
                }
            }
            
            cont++;
            
            System.out.println("Intentos " + cont + ": " + pGuiones + "\n");
        }
        
        if(cont==intentosMax){
            System.out.println("Lo siento! Has perdido");
        }
        
    }
}