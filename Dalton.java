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
public class Dalton {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int personas = 1;
        
        while(personas<2){
            personas = sc.nextInt();
            sc.nextLine();
        }
            
        while(personas!=0){
            boolean esDalton = true;
            int anterior = 0;
    

            for (int i = 0; i < personas; i++) {
                int actual = sc.nextInt();
                if(anterior>=actual){
                    esDalton = false;
                    break;
                }
                anterior = actual;
            }
            
            if(esDalton){
                System.out.println("DALTON");
            }else{
                System.out.println("DESCONOCIDOS");
            }
            
            sc.nextLine();
            personas = sc.nextInt();
            while(personas<2 && personas!=0){
                sc.nextLine();
                personas = sc.nextInt();
            }
        }
    }
    
}
