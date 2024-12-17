//Daniel Orocondo Alvarez
package buscaminas;

import java.util.Random;
import Teclat.*;

public class buscaminasOrocondoDaniel {

    //Secuencia de constantes usadas a lo largo del código
    static char BANDERA = 'P';
    static char TAPAT = 'X';
    static char BUIT = '_';
    static char MINA = '#';

    private static char[][] crearTaulerVisible() {      //Funcion para crear el tablero visible
        final int FIL = Teclat.lligInt("Dime la cantidad de filas", 3, 9);
        final int COL = Teclat.lligInt("Dime la cantidad de columnas", 3, 9);
        char taulervisible[][] = new char[FIL][COL];
        for (int i = 0; i < FIL; i++) {
            for (int j = 0; j < COL; j++) {
                taulervisible[i][j] = TAPAT;
            }
        }
        return taulervisible;
    }

    static boolean[][] crearTaulerMines(char[][] taulervisible, int qmp) {  //Funcion para crear el tablero de minas a partir del tablero visible
        boolean taulerDeMinas[][] = new boolean[taulervisible.length][taulervisible[0].length];
        for (int i = 0; i < taulerDeMinas.length; i++) {
            for (int j = 0; j < taulerDeMinas[0].length; j++) {
                taulerDeMinas[i][j] = false;
            }
        }
        Random random = new Random();
        Random random2 = new Random();
        for (int i = 0; i < qmp; i++) {
            int randomNum1 = random.nextInt(taulerDeMinas.length);
            int randomNum2 = random.nextInt(taulerDeMinas[0].length);
            if (taulerDeMinas[randomNum1][randomNum2] == true) {
                i--;
            } else {
                taulerDeMinas[randomNum1][randomNum2] = true;
            }
        }
        return taulerDeMinas;
    }

    static boolean minada(boolean[][] taulerDeMinas, int coorFIL, int coorCOL) {    //Funcion para comprobar si hay mina en una posición
        return (taulerDeMinas[coorFIL][coorCOL]);
    }

    static boolean incorrectaVis(char[][] taulervisible, int coorFIL, int coorCOL) {       //Funcion para comprobar si laas coordenadas estan fuera del tablero visibles
        if (coorFIL >= 0 && coorFIL < taulervisible.length && coorCOL >= 0 && coorCOL < taulervisible[0].length) {
            return true;
        } else {
            return false;
        }
    }

    static boolean incorrectaBool(boolean[][] taulerDeMinas, int coorFIL, int coorCOL) {       //Funcion para comprobar si laas coordenadas estan fuera del tablero de minas
        if (coorFIL >= 0 && coorFIL < taulerDeMinas.length && coorCOL >= 0 && coorCOL < taulerDeMinas[0].length) {
            return true;
        } else {
            return false;
        }
    }

    static int qma(boolean[][] taulerDeMinas, int coorFIL, int coorCOL) {       //Funcion para detectar las minas adyacentes de la coordenada indicada
        int qma = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                try {
                    if (taulerDeMinas[coorFIL + i][coorCOL + j]) {
                        qma++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
        }
        return qma;
    }

    static public boolean destapada(char[][] taulervisible, int coorFIL, int coorCOL) {         //Funcion para comprobar si una posición destapada
        if (taulervisible[coorFIL][coorCOL] == BUIT) {
            return true;
        } else {
            return false;
        }
    }

    static public int qDestapada(char[][] taulervisible) {      //Funcion para comprobar la cantidad de casillas destapadas
        int qDestapades = 0;
        for (int i = 0; i < taulervisible.length; i++) {
            for (int j = 0; j < taulervisible[0].length; j++) {
                if (taulervisible[i][j] == TAPAT || taulervisible[i][j] == BANDERA) {
                } else {
                    qDestapades++;
                }
            }
        }
        return qDestapades;
    }

    static public void mostraTauler(char[][] taulervisible, boolean[][] taulerDeMinas, boolean mostrarMinas) {      //Funcion para mostrar el tablero creado anteriormente
        int num = 0;
        System.out.print("  ");
        for (int i = 0; i < taulervisible[0].length; i++) {     //Imprimir letras
            System.out.print(" " + num);
            ++num;
        }
        num = 0;
        System.out.println(" ");
        for (int i = 0; i < taulervisible.length; i++) {     //Imprimir teclado
            System.out.print(num + " |");
            for (int j = 0; j < taulervisible[0].length; j++) {
                if (mostrarMinas && taulerDeMinas[i][j] == true) {
                    System.out.print("#");
                } else {
                    System.out.print(taulervisible[i][j]);
                }
                System.out.print("|");
            }
            System.out.print(" " + num);
            ++num;
            System.out.println(" ");
        }   //Mostrar tablero
        System.out.print("  ");
        num = 0;
        for (int i = 0; i < taulervisible[0].length; i++) {     //Imprimir letras
            System.out.print(" " + num);
            ++num;
        }
        System.out.println(" ");
    }

    static public boolean pica(char[][] taulervisible, boolean[][] taulerDeMinas, int coorFIL, int coorCOL) {       //Funcion para "picar" en una coordenada dentro del tablero
        if (taulerDeMinas[coorFIL][coorCOL] == false) {
            destapa(taulervisible, taulerDeMinas, coorFIL, coorCOL);
            return false;
        } else {
            return true;
        }
    }

    static public void destapa(char[][] taulervisible, boolean[][] taulerDeMinas, int coorFIL, int coorCOL) {       //Funcion para destapar recursivamente las casillas adyacentes si es posible destaparlas
        char numMin = Integer.toString(qma(taulerDeMinas, coorFIL, coorCOL)).charAt(0);
        //   |_|_|_|
        //   |_|X|_|
        //   |_|_|_|
        try {
            if (taulerDeMinas[coorFIL][coorCOL] == true || taulervisible[coorFIL][coorCOL] == BUIT) {
            } else if (numMin == '0') {
                taulervisible[coorFIL][coorCOL] = BUIT;
            } else {
                taulervisible[coorFIL][coorCOL] = numMin;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }

        //   |_|X|_|
        //   |_|_|_|
        //   |_|_|_|
        numMin = Integer.toString(qma(taulerDeMinas, coorFIL + 1, coorCOL)).charAt(0);
        boolean coorDaltLliure = true;
        try {
            if (taulerDeMinas[coorFIL + 1][coorCOL] == true || taulervisible[coorFIL + 1][coorCOL] == BUIT) {
                coorDaltLliure = false;
            } else if (numMin == '0') {
                taulervisible[coorFIL + 1][coorCOL] = BUIT;
                destapa(taulervisible, taulerDeMinas, coorFIL + 1, coorCOL);
            } else {
                taulervisible[coorFIL + 1][coorCOL] = numMin;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }

        //   |_|_|_|
        //   |_|_|_|
        //   |_|X|_|
        numMin = Integer.toString(qma(taulerDeMinas, coorFIL - 1, coorCOL)).charAt(0);
        boolean coorBaixLliure = true;
        try {
            if (taulerDeMinas[coorFIL - 1][coorCOL] == true || taulervisible[coorFIL - 1][coorCOL] == BUIT) {
                coorBaixLliure = false;
            } else if (numMin == '0') {
                taulervisible[coorFIL - 1][coorCOL] = BUIT;
                destapa(taulervisible, taulerDeMinas, coorFIL - 1, coorCOL);
            } else {
                taulervisible[coorFIL - 1][coorCOL] = numMin;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }

        //   |_|_|_|
        //   |X|_|_|
        //   |_|_|_|
        numMin = Integer.toString(qma(taulerDeMinas, coorFIL, coorCOL - 1)).charAt(0);
        boolean coorIZQLliure = true;
        try {
            if (taulerDeMinas[coorFIL][coorCOL - 1] == true || taulervisible[coorFIL][coorCOL - 1] == BUIT) {
                coorIZQLliure = false;
            } else if (numMin == '0') {
                taulervisible[coorFIL][coorCOL - 1] = BUIT;
                destapa(taulervisible, taulerDeMinas, coorFIL, coorCOL - 1);
            } else {
                taulervisible[coorFIL][coorCOL - 1] = numMin;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }

        //   |_|_|_|
        //   |_|_|X|
        //   |_|_|_|
        numMin = Integer.toString(qma(taulerDeMinas, coorFIL, coorCOL + 1)).charAt(0);
        boolean coorDerLliure = true;
        try {
            if (taulerDeMinas[coorFIL][coorCOL + 1] == true || taulervisible[coorFIL][coorCOL + 1] == BUIT) {
                coorDerLliure = false;
            } else if (numMin == '0') {
                taulervisible[coorFIL][coorCOL + 1] = BUIT;
                destapa(taulervisible, taulerDeMinas, coorFIL, coorCOL + 1);
            } else {
                taulervisible[coorFIL][coorCOL + 1] = numMin;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }

        //   |_|_|_|
        //   |_|_|_|
        //   |X|_|_|
        if (coorIZQLliure == true && coorBaixLliure == true) {
            numMin = Integer.toString(qma(taulerDeMinas, coorFIL - 1, coorCOL - 1)).charAt(0);
            try {
                if (taulerDeMinas[coorFIL - 1][coorCOL - 1] == true || taulervisible[coorFIL - 1][coorCOL - 1] == BUIT) {
                } else if (numMin == '0') {
                    taulervisible[coorFIL - 1][coorCOL - 1] = BUIT;
                    destapa(taulervisible, taulerDeMinas, coorFIL - 1, coorCOL - 1);
                } else {
                    taulervisible[coorFIL - 1][coorCOL - 1] = numMin;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }

        //   |_|_|X|
        //   |_|_|_|
        //   |_|_|_|
        if (coorDerLliure == true && coorDaltLliure == true) {
            numMin = Integer.toString(qma(taulerDeMinas, coorFIL + 1, coorCOL + 1)).charAt(0);
            try {
                if (taulerDeMinas[coorFIL + 1][coorCOL + 1] == true || taulervisible[coorFIL + 1][coorCOL + 1] == BUIT) {
                } else if (numMin == '0') {
                    taulervisible[coorFIL + 1][coorCOL + 1] = BUIT;
                    destapa(taulervisible, taulerDeMinas, coorFIL + 1, coorCOL + 1);
                } else {
                    taulervisible[coorFIL + 1][coorCOL + 1] = numMin;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }

        //   |X|_|_|
        //   |_|_|_|
        //   |_|_|_|
        if (coorDaltLliure == true && coorIZQLliure == true) {
            numMin = Integer.toString(qma(taulerDeMinas, coorFIL + 1, coorCOL - 1)).charAt(0);
            try {
                if (taulerDeMinas[coorFIL + 1][coorCOL - 1] == true || taulervisible[coorFIL + 1][coorCOL - 1] == BUIT) {
                } else if (numMin == '0') {
                    taulervisible[coorFIL + 1][coorCOL - 1] = BUIT;
                    destapa(taulervisible, taulerDeMinas, coorFIL + 1, coorCOL - 1);
                } else {
                    taulervisible[coorFIL + 1][coorCOL - 1] = numMin;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }

        //   |_|_|_|
        //   |_|_|_|
        //   |_|_|X|
        if (coorDerLliure == true && coorBaixLliure == true) {
            numMin = Integer.toString(qma(taulerDeMinas, coorFIL - 1, coorCOL + 1)).charAt(0);
            try {
                if (taulerDeMinas[coorFIL - 1][coorCOL + 1] == true || taulervisible[coorFIL - 1][coorCOL + 1] == BUIT) {
                } else if (numMin == '0') {
                    taulervisible[coorFIL - 1][coorCOL + 1] = BUIT;
                    destapa(taulervisible, taulerDeMinas, coorFIL - 1, coorCOL + 1);
                } else {
                    taulervisible[coorFIL - 1][coorCOL + 1] = numMin;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
    }

    public static void main(String[] args) {        //Main que desencandena el juego del buscaminas
        boolean jugarBuscaminas;
        do {        //Bucle para repetir partida en caso de solicitarlo
            char[][] taulerVisibleCreat = crearTaulerVisible();
            int qmp = Teclat.lligInt("Dime la cantidad de minas que quieres poner", 1, (taulerVisibleCreat.length * taulerVisibleCreat[0].length) - 8);
            boolean[][] taulerDeMinasCreat = crearTaulerMines(taulerVisibleCreat, qmp);
            boolean jugarPartida = true;
            boolean partidaGanada = true;
            int qMinesTrobades = 0;
            System.out.println("================QUE EMPIECE EL JUEGO================\n");
            do {        //Bucle para jugar al buscaminas usando el menu y a la vez comprobar si hay o no hay victoria
                if (qDestapada(taulerVisibleCreat) == ((taulerVisibleCreat.length * taulerVisibleCreat[0].length) - qmp)) {
                    jugarPartida = false;
                } else {
                    mostraTauler(taulerVisibleCreat, taulerDeMinasCreat, false);
                    System.out.println("\n Has encontrado un total de " + qMinesTrobades + " de " + qmp + "\n");
                    int res = Teclat.lligOpcio("Escoge una opción", "Picar", "Poner bandera");
                    switch (res) {      //Menu para escoger opcion 
                        case 1 -> {     //Pica
                            int coorFIL = Teclat.lligInt("Escoge una coordenada", 0, taulerVisibleCreat.length - 1);
                            int coorCOL = Teclat.lligInt("Escoge una coordenada", 0, taulerVisibleCreat[0].length - 1);
                            if (pica(taulerVisibleCreat, taulerDeMinasCreat, coorFIL, coorCOL) == false) {
                                System.out.println("\n===========");
                                System.out.println("Sense mina.");
                                System.out.println("Perfecte :D");
                                System.out.println("===========\n");
                                mostraTauler(taulerVisibleCreat, taulerDeMinasCreat, false);
                            } else {
                                System.out.println("\n===================================================");
                                System.out.println("!!!!!!!!!!!!       MINA    TROBADA        !!!!!!!");
                                System.out.println("===================================================\n");
                                partidaGanada = false;
                                jugarPartida = false;
                            }
                        }
                        case 2 -> {     //Poner bandera
                            int coorFIL = Teclat.lligInt("Escoge una coordenada", 0, taulerVisibleCreat.length - 1);
                            int coorCOL = Teclat.lligInt("Escoge una coordenada", 0, taulerVisibleCreat[0].length - 1);
                            if (taulerVisibleCreat[coorFIL][coorCOL] == BANDERA) {
                                taulerVisibleCreat[coorFIL][coorCOL] = TAPAT;
                                qMinesTrobades--;
                            } else {
                                taulerVisibleCreat[coorFIL][coorCOL] = BANDERA;
                                qMinesTrobades++;
                            }
                            mostraTauler(taulerVisibleCreat, taulerDeMinasCreat, false);
                        }
                        case 0 -> {     //Salir
                            boolean acabarPartida = Teclat.lligBoolean("Estas seguro de que quieres acabar la partida");
                            if (acabarPartida) {
                                jugarPartida = false;
                                partidaGanada = false;
                            }
                        }
                    }
                }
            } while (jugarPartida);
            if (partidaGanada) {
                System.out.println("\n****************************");
                System.out.println("\n     Has guanyat :D\n");
                System.out.println("****************************\n");
            } else {
                System.out.println("\n****************************");
                System.out.println("\n     Has perdut D:\n");
                System.out.println("****************************\n");
            }
            mostraTauler(taulerVisibleCreat, taulerDeMinasCreat, true);
            jugarBuscaminas = Teclat.lligBoolean("Quieres jugar otra partida");
        } while (jugarBuscaminas == true);
    }
}