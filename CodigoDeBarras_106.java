/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package desafios;

import java.util.Scanner;

/**
 *
 * @author jorgearru
 */
public class CodigoDeBarras_106 {
   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final String EEUU = "0";
        final String BULGARIA = "380";
        final String INGLATERRA = "50";
        final String IRLANDA = "539";
        final String NORUEGA = "70";
        final String VENEZUELA = "759";
        final String CUBA = "850";
        final String INDIA = "890";
        final String PORTUGAL = "560";
        
        Scanner sc = new Scanner(System.in);
        String codigoBarras, codigoBarrasConCeros;
        int longitudCodigo, codigo;
        boolean EAN8, codigoCorrecto;
        
        while(true){
            EAN8 = false;
            codigoCorrecto = false;
            longitudCodigo = 0;
            codigo = 0;
            codigoBarrasConCeros = "";
            codigoBarras = "";
            
            codigoBarras = sc.nextLine();
            
            if(codigoBarras.equals("0"))
                break;
            
            //comprueba si es ean8 o ean13
            if(codigoBarras.length()<=8){
                EAN8 = true;
            }else if(codigoBarras.length()>8 && codigoBarras.length()<=13){
                EAN8 = false;
            }

            //añade 0 si el numero es menor que 13 o menor que 8 dependiendo
            //del resultado anterior
            //ESTO SE PUEDE PONER EN UN METODO PARA NO REPETIR CODIGO
            if(EAN8){
                if(codigoBarras.length()<8){
                    longitudCodigo = codigoBarras.length();
                    while(longitudCodigo<8){
                        codigoBarrasConCeros+="0";
                        longitudCodigo++;
                    }
                }
            }else{
                if(codigoBarras.length()<13){
                    longitudCodigo = codigoBarras.length();
                    while(longitudCodigo<13){
                        codigoBarrasConCeros+="0";
                        longitudCodigo++;
                    }
                }
            }

            //le añade los ceros al codigo de barras, y si no tiene añade el codigo igual
            codigoBarrasConCeros += codigoBarras;

            //multiplica el impar por 3 a partir del segundo numero por la izquierda
            //y el otro lo deja igual y los suma
            int posicionNumero = 0, suma = 0;
            
            for(int i=codigoBarrasConCeros.length()-2; i>=0; i--){
                posicionNumero++;//se suma una posicion para saber si es par o impar el numero, también se puede hacer con un boolean
                if(posicionNumero%2!=0 || posicionNumero==1){//si el numero es impar
                    suma += Integer.parseInt(codigoBarrasConCeros.charAt(i) + "")*3;

                }else{//si es par
                    suma += Integer.parseInt(codigoBarrasConCeros.charAt(i) + "");
                }
            }


            while(suma%10!=0){
                codigo++;
                suma++;
            }
            
            String codigoControl;
            //paso el codigoControl a string, que es el codigo pero en String
            codigoControl = codigo + "";

            String ultimoNumeroCodigo = codigoBarrasConCeros.charAt(codigoBarrasConCeros.length()-1) + "";
            if(codigoControl.equals(ultimoNumeroCodigo)){
                codigoCorrecto = true;
            }else{
                codigoCorrecto = false;
            }

            //codigo correcto o incorrecto
            
            if(codigoCorrecto){
                if(!EAN8){
                    System.out.print("SI");

                    if(codigoBarrasConCeros.substring(0).equals(EEUU) || codigo == 0){
                        System.out.print(" EEUU");
                    }else if(codigoBarrasConCeros.substring(0,3).equals(BULGARIA)){
                        System.out.print(" INGLATERRA");
                    }else if(codigoBarrasConCeros.substring(0,2).equals(INGLATERRA)){
                        System.out.print(" INGLATERRA");
                    }else if(codigoBarrasConCeros.substring(0,3).equals(IRLANDA)){
                        System.out.print(" IRLANDA");
                    }else if(codigoBarrasConCeros.substring(0,3).equals(PORTUGAL)){
                        System.out.print(" PORTUGAL");
                    }else if(codigoBarrasConCeros.substring(0,3).equals(NORUEGA)){
                        System.out.print(" NORUEGA");
                    }else if(codigoBarrasConCeros.substring(0,3).equals(VENEZUELA)){
                        System.out.print(" VENEZUELA");
                    }else if(codigoBarrasConCeros.substring(0,3).equals(CUBA)){
                        System.out.print(" CUBA");
                    }else if(codigoBarrasConCeros.substring(0,3).equals(INDIA)){
                        System.out.print(" INDIA");
                    }else{
                        System.out.print(" DESCONOCIDO");
                    }
                }else{
                    System.out.println("SI");
                }
                
            }else{
                System.out.println("NO");
            }
        }
           
    }
    
}
