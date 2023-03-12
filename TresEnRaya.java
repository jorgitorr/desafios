package desafios;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.util.Scanner;

/**
 *
 * @author jorgearru
 */
public class TresEnRaya {
    private char[]tablero;
    private int partidas;
    private char turno;
    private boolean ganador;

    public TresEnRaya() {
        this.tablero = new char[9];
        this.partidas = 9;
        this.turno = 'X';
        this.ganador = false;
    }

    public void getTablero(){
        String line = "";
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i] == 0) {
                line += " ";
            } else {
                line += tablero[i];
            }
            if (i % 3 == 2) {
                System.out.println(String.format("| %c | %c | %c |", line.charAt(0), line.charAt(1), line.charAt(2)));
                System.out.println("+---+---+---+");
                line = "";
            }
        }
    }

    
    private boolean checkPos(int pos){
        boolean ocupado = false;
        if(pos<0 || pos>=9)
            ocupado = true;
        else if(tablero[pos]=='X' || tablero[pos]=='0')
            ocupado = true;
        return ocupado;
    }
    
    public void checkGanador(){
        if(tablero[0]==turno && tablero[1]==turno && tablero[2]==turno)
            ganador = true;
        if(tablero[3]==turno && tablero[4]==turno && tablero[5]==turno)
            ganador = true;
        if(tablero[6]==turno && tablero[7]==turno && tablero[8]==turno)
            ganador = true;
        if(tablero[0]==turno && tablero[4]==turno && tablero[8]==turno)
            ganador = true;
        if(tablero[2]==turno && tablero[4]==turno && tablero[6]==turno)
            ganador = true;     
    }
    

    public void juega(){
        Scanner sc = new Scanner(System.in);
        int pos;

        do{
            do{
                System.out.println("Introduce la posicion de " + turno);
                pos = sc.nextInt()-1;
            }while(checkPos(pos));
            
            tablero[pos] = turno;
            
            getTablero();
            checkGanador();
            
            if(ganador)
                break;
            else if(turno == 'X')
                turno = '0';
            else
                turno = 'X';
            partidas--;
            
        }while(partidas>0 && !ganador);
        
        if(ganador)
            System.out.println("El ganador es " + turno);
        else
            System.out.println("Empate");
    }
    public static void main(String[] args) {
        TresEnRaya partida = new TresEnRaya();
        partida.juega();
    }
    
}
