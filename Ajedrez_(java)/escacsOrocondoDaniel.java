//Daniel Orocondo Alvarez
package Ajedrez;

import Teclat.*;

public class escacsOrocondoDaniel {

    public static void main(String[] args) {

        final int FIL = Teclat.lligInt("Dime la anchura del teclado", 5, 9);
        final int COL = Teclat.lligInt("Dime la altura del teclado", 5, 9);
        final char BUIT = '_';
        final char MOV = '.';
        final char REY = 'R';
        final char DAMA = 'D';
        final char ALFIL = 'A';
        final char TORRE = 'T';
        final char CABALLO = 'C';
        final char PEON = 'P';
        boolean tablerovacio = true;
        boolean jugarAjedrez = true;
        final String letras = "ABCDEFGHI";
        char tablero[][] = new char[FIL + 1][COL + 1];
        do {        //Bucle del juego
            int num = 1;
            System.out.print("  ");
            for (int i = 0; i < COL; i++) {     //Imprimir letras
                System.out.print(" " + letras.charAt(i));
            }
            System.out.println(" ");
            for (int i = 1; i < FIL + 1; i++) {     //Imprimir teclado
                System.out.print(num + " |");
                for (int j = 1; j < COL + 1; j++) {
                    if (tablerovacio) {     //Vaciar teclado
                        tablero[i][j] = BUIT;
                    }
                    System.out.print(tablero[i][j]);
                    System.out.print("|");
                }
                System.out.print(" " + num);
                ++num;
                System.out.println(" ");
            }   //Mostrar tablero
            tablerovacio = false;
            System.out.print("  ");
            for (int i = 0; i < COL; i++) {     //Imprimir letras
                System.out.print(" " + letras.charAt(i));
            }
            System.out.println(" ");
            //Mostrar menu
            int opcion = Teclat.lligInt("""
                                    \n1-\tPoner una pieza
                                    2-\tMostrar los movimientos de una pieza
                                    3-\tBorrar movimientos
                                    4-\tBorrar tablero
                                    5-\tSalir""", 1, 5);
            switch (opcion) {
                case 1 -> {     //Introducir pieza
                    char piezaEscog = Teclat.lligChar("""
                                                  Que pieza quieres escoger?
                                                   Torre(T)
                                                   Alfil(A)
                                                   Dama(D)
                                                   Rey(R)
                                                   Caballo(C)
                                                   Peon(P)
                                                  """, "TADRCP");
                    switch (piezaEscog) {
                        case TORRE -> {
                            System.out.println("Torre");
                        }
                        case ALFIL -> {
                            System.out.println("Alfil");
                        }
                        case DAMA -> {
                            System.out.println("Dama");
                        }
                        case REY -> {
                            System.out.println("Rey");
                        }
                        case CABALLO -> {
                            System.out.println("Caballo");
                        }
                        case PEON -> {
                            System.out.println("Peon");
                        }
                        default -> {
                            System.out.println("Escoge bien la pieza, por favor.");
                        }
                    }
                    int coorFIL = Teclat.lligInt("En que coordenadas de las filas quieres poner la ficha?", 1, FIL);
                    int coorCOL = Teclat.lligInt("En que coordenadas de las columnas quieres poner la ficha?", 1, COL);
                    tablero[coorFIL][coorCOL] = piezaEscog;
                }   //Poner piezas
                case 2 -> {     //Mostrar coordenadas de la pieza
                    int coorMovFIL = Teclat.lligInt("Dime las coordenadas de la fila de la pieza que quieras mostrar el movimiento?", 1, FIL);
                    int coorMovCOL = Teclat.lligInt("Dime las coordenadas de la columna de la pieza que quieras mostrar el movimiento?", 1, COL);
                    switch (tablero[coorMovFIL][coorMovCOL]) {
                        case TORRE -> {
                            movimientoTorre(coorMovFIL, coorMovCOL, COL, FIL, tablero, MOV, BUIT);
                        }   //Movimiento torre
                        case DAMA -> {
                            movimientoDama(coorMovFIL, coorMovCOL, COL, FIL, tablero, MOV, BUIT);
                        }   //Movimiento dama
                        case ALFIL -> {
                            movimientoAlfil(coorMovFIL, coorMovCOL, tablero, MOV, BUIT);
                        }   //Movimiento alfil
                        case REY -> {
                            movimientoRey(coorMovFIL, coorMovCOL, tablero, MOV, BUIT);
                        }   //Movimiento rey    
                        case CABALLO -> {
                            movimientoCaballo(coorMovFIL, coorMovCOL, tablero, MOV, BUIT);
                        }  //Movimiento caballo
                        case PEON -> {
                            movimientoPeon(coorMovFIL, coorMovCOL, tablero, MOV, BUIT);
                        }  //Movimiento peon
                        default -> {
                            System.out.println("Escoge bien las coordenadas de la pieza, por favor");
                            break;
                        }
                    }
                }
                case 3 -> {         //Borrar marcas de movimiento y contarlas
                    int contaMov = 0;
                    for (int i = 1; i < COL + 1; i++) {
                        for (int j = 1; j < FIL + 1; j++) {
                            if (tablero[i][j] == MOV) {
                                tablero[i][j] = BUIT;
                                ++contaMov;
                            }
                        }
                    }
                    System.out.println("Había un total de " + contaMov + "puntos de movimiento");
                }
                case 4 -> {//Borrar tablero
                    tablerovacio = true;
                }
                case 5 -> {//Cerrar programa
                    boolean respCerrarPrograma = Teclat.lligBoolean("Seguro que quieres cerrar el programa?");
                    if (respCerrarPrograma) {
                        jugarAjedrez = false;
                    } else {
                        System.out.println("Esta bien, no se cerrara");
                    }
                }
            }
        } while (jugarAjedrez);
    }

    static public void movimientoTorre(int coorMovFIL, int coorMovCOL, int COL, int FIL, char[][] tablero, char MOV, char BUIT) {
        int numT = 0;
        for (int i = coorMovCOL; i < COL; i++) {
            numT++;
            if (tablero[coorMovFIL][coorMovCOL + numT] == BUIT || tablero[coorMovFIL][coorMovCOL + numT] == MOV) {
                tablero[coorMovFIL][coorMovCOL + numT] = MOV;
            } else {
                break;
            }
        }
        numT = 0;
        for (int i = coorMovFIL; i < FIL; i++) {
            numT++;
            if (tablero[coorMovFIL + numT][coorMovCOL] == BUIT || tablero[coorMovFIL + numT][coorMovCOL] == MOV) {
                tablero[coorMovFIL + numT][coorMovCOL] = MOV;
            } else {
                break;
            }
        }
        numT = 0;
        for (int i = coorMovCOL; i >= 1; i--) {
            numT++;
            if (tablero[coorMovFIL][coorMovCOL - numT] == BUIT || tablero[coorMovFIL][coorMovCOL - numT] == MOV) {
                tablero[coorMovFIL][coorMovCOL - numT] = MOV;
            } else {
                break;
            }
        }
        numT = 0;
        for (int i = coorMovFIL; i >= 1; i--) {
            numT++;
            if (tablero[coorMovFIL - numT][coorMovCOL] == BUIT || tablero[coorMovFIL - numT][coorMovCOL] == MOV) {
                tablero[coorMovFIL - numT][coorMovCOL] = MOV;
            } else {
                break;
            }
        }
    }       //Movimiento Torre

    static public void movimientoDama(int coorMovFIL, int coorMovCOL, int COL, int FIL, char[][] tablero, char MOV, char BUIT) {
        for (int i = 1; i < tablero.length - 1; i++) {
            try {
                if (tablero[coorMovFIL + i][coorMovCOL + i] == BUIT || tablero[coorMovFIL + i][coorMovCOL + i] == MOV) {
                    tablero[coorMovFIL + i][coorMovCOL + i] = MOV;
                } else {
                    break;
                }
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            }
        }
        for (int i = 1; i < tablero.length - 1; i++) {
            try {
                if (tablero[coorMovFIL - i][coorMovCOL + i] == BUIT || tablero[coorMovFIL - i][coorMovCOL + i] == MOV) {
                    tablero[coorMovFIL - i][coorMovCOL + i] = MOV;
                } else {
                    break;
                }
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            }
        }
        for (int i = 1; i < tablero.length - 1; i++) {
            try {
                if (tablero[coorMovFIL + i][coorMovCOL - i] == BUIT || tablero[coorMovFIL + i][coorMovCOL - i] == MOV) {
                    tablero[coorMovFIL + i][coorMovCOL - i] = MOV;
                } else {
                    break;
                }
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            }
        }
        for (int i = 1; i < tablero.length - 1; i++) {
            try {
                if (tablero[coorMovFIL - i][coorMovCOL - i] == BUIT || tablero[coorMovFIL - i][coorMovCOL - i] == MOV) {
                    tablero[coorMovFIL - i][coorMovCOL - i] = MOV;
                } else {
                    break;
                }
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            }
        }
        int numT = 0;
        for (int i = coorMovCOL; i < COL; i++) {
            numT++;
            if (tablero[coorMovFIL][coorMovCOL + numT] == BUIT || tablero[coorMovFIL][coorMovCOL + numT] == MOV) {
                tablero[coorMovFIL][coorMovCOL + numT] = MOV;
            } else {
                break;
            }
        }
        numT = 0;
        for (int i = coorMovFIL; i < FIL; i++) {
            numT++;
            if (tablero[coorMovFIL + numT][coorMovCOL] == BUIT || tablero[coorMovFIL + numT][coorMovCOL] == MOV) {
                tablero[coorMovFIL + numT][coorMovCOL] = MOV;
            } else {
                break;
            }
        }
        numT = 0;
        for (int i = coorMovCOL; i > 1; i--) {
            numT++;
            if (tablero[coorMovFIL][coorMovCOL - numT] == BUIT || tablero[coorMovFIL][coorMovCOL - numT] == MOV) {
                tablero[coorMovFIL][coorMovCOL - numT] = MOV;
            } else {
                break;
            }
        }
        numT = 0;
        for (int i = coorMovFIL; i > 1; i--) {
            numT++;
            if (tablero[coorMovFIL - numT][coorMovCOL] == BUIT || tablero[coorMovFIL - numT][coorMovCOL] == MOV) {
                tablero[coorMovFIL - numT][coorMovCOL] = MOV;
            } else {
                break;
            }
        }
    }       //Movimiento Dama

    static public void movimientoAlfil(int coorMovFIL, int coorMovCOL, char[][] tablero, char MOV, char BUIT) {
        // Movimientos en diagonal hacia la derecha abajo
        for (int i = 1; i < tablero.length - 1; i++) {
            try {
                if (tablero[coorMovFIL + i][coorMovCOL + i] == BUIT || tablero[coorMovFIL + i][coorMovCOL + i] == MOV) {
                    tablero[coorMovFIL + i][coorMovCOL + i] = MOV;
                } else {
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
        // Movimientos en diagonal hacia la izquierda abajo
        for (int i = 1; i < tablero.length - 1; i++) {
            try {
                if (tablero[coorMovFIL - i][coorMovCOL + i] == BUIT || tablero[coorMovFIL - i][coorMovCOL + i] == MOV) {
                    tablero[coorMovFIL - i][coorMovCOL + i] = MOV;
                } else {
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
        // Movimientos en diagonal hacia la derecha arriba
        for (int i = 1; i < tablero.length - 1; i++) {
            try {
                if (tablero[coorMovFIL + i][coorMovCOL - i] == BUIT || tablero[coorMovFIL + i][coorMovCOL - i] == MOV) {
                    tablero[coorMovFIL + i][coorMovCOL - i] = MOV;
                } else {
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
        // Movimientos en diagonal hacia la izquierda arriba
        for (int i = 1; i < tablero.length - 1; i++) {
            try {
                if (tablero[coorMovFIL - i][coorMovCOL - i] == BUIT || tablero[coorMovFIL - i][coorMovCOL - i] == MOV) {
                    tablero[coorMovFIL - i][coorMovCOL - i] = MOV;
                } else {
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
    }       //Movimiento Alfil

    static public void movimientoRey(int coorMovFIL, int coorMovCOL, char[][] tablero, char MOV, char BUIT) {
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                try {
                    if (tablero[coorMovFIL + i][coorMovCOL + j] == BUIT || tablero[coorMovFIL + i][coorMovCOL + j] == MOV) {
                        tablero[coorMovFIL + i][coorMovCOL + j] = MOV;
                    }
                } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                }
            }
        }
    }       //Movimiento Rey

    static public void movimientoCaballo(int coorMovFIL, int coorMovCOL, char[][] tablero, char MOV, char BUIT) {
        try {
            tablero[coorMovFIL + 2][coorMovCOL - 1] = MOV;
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
        }
        try {
            tablero[coorMovFIL + 2][coorMovCOL + 1] = MOV;
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
        }
        try {
            tablero[coorMovFIL + 1][coorMovCOL + 2] = MOV;
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
        }
        try {
            tablero[coorMovFIL + 1][coorMovCOL - 2] = MOV;
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
        }
        try {
            tablero[coorMovFIL - 1][coorMovCOL + 2] = MOV;
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
        }
        try {
            tablero[coorMovFIL - 1][coorMovCOL - 2] = MOV;
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
        }
        try {
            tablero[coorMovFIL - 2][coorMovCOL - 1] = MOV;
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
        }
        try {
            tablero[coorMovFIL - 2][coorMovCOL + 1] = MOV;
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
        }
    }       //Movimiento Caballo

    static public void movimientoPeon(int coorMovFIL, int coorMovCOL, char[][] tablero, char MOV, char BUIT) {
        if (coorMovFIL == 2 && (tablero[coorMovFIL][coorMovCOL + 1]) == BUIT && (tablero[coorMovFIL][coorMovCOL + 2]) == BUIT) {
            tablero[coorMovFIL][coorMovCOL + 1] = MOV;
            tablero[coorMovFIL][coorMovCOL + 2] = MOV;
        } else if ((tablero[coorMovFIL][coorMovCOL + 1]) == BUIT) {
            tablero[coorMovFIL][coorMovCOL + 1] = MOV;
        }
    }      //Movimiento Peon
}
