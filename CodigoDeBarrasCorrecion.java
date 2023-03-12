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
public class CodigoDeBarrasCorrecion {
      public static void main(String[] args) {
          
          final String EEUU = "0";
          final String BULGARIA = "380";
          final String INGLATERRA = "50";
          final String IRLANDA = "539";
          final String PORTUGAL = "560";
          final String NORUEGA = "70";
          final String VENEZUELA = "759";
          final String CUBA = "850";
          final String INDIA = "890";
                
          Scanner sc =  new Scanner(System.in); 
          
          while (true){
                String codigo = sc.nextLine();
                if (codigo.equals("0"))
                    break;
              
                int longitud=codigo.length();
              
                if (longitud >=0 && longitud < 8)
                    for (int i=0; i<8-longitud;i++)
                        codigo += "0" + codigo;
                else if (longitud > 8 && longitud < 13)
                    for (int i=0; i<13-longitud;i++)
                        codigo += "0" + codigo;                  
                else if (longitud > 13)
                    continue;
                
                int n;
                boolean impar = true;//para cambiar entre valores ya que una vez se hace una, que es multiplcando por 3 y la otra se hace sin multiplicar
                int calculo = 0;

                for (int i = longitud-2; i >= 0; i--) {
                    n = Integer.parseInt(""+codigo.charAt(i));
                    if (impar) {
                        calculo += n * 3;
                        impar=false;
                    }
                    else {
                        calculo += n;
                        impar = true;
                    }
                }

                int codigoControl = Integer.parseInt(""+codigo.charAt(longitud-1));//le suma el ultimo número al calculo que se ha ido haciendo

                String valorPais;
                if ((codigoControl + calculo) %10 == 0) {
                    if (longitud==13) {
                        String resp ="SI";
                        if ((""+codigo.charAt(0)).equals(EEUU))
                            resp += " EEUU";
                        else if (codigo.substring(0,2).equals(INGLATERRA))
                            resp += " Inglaterra";
                        else if (codigo.substring(0,2).equals(NORUEGA))
                            resp += " Noruega";
                        else {
                            String pais = codigo.substring(0,3);
                            switch(pais){
                                    case BULGARIA: resp+= " Bulgaria"; break;
                                    case IRLANDA: resp+= " Irlanda"; break;
                                    case PORTUGAL: resp+= " Portugal"; break;
                                    case VENEZUELA: resp+= " Venezuela"; break;
                                    case CUBA: resp+= " Cuba"; break;
                                    case INDIA: resp+= " India"; break;
                                    default: resp += " Desconocido"; break;
                            }
                        }
                        System.out.println(resp);
                    } else
                      System.out.println("SI");
                } else
                  System.out.println("NO");         
          }
     }
}
