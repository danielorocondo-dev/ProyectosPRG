#Daniel Orocondo 1 DAM
import random

CasCorrecte = False
while CasCorrecte == False:  # Bucle per a comprobar el numero introduit correctament
    posMax = input("\nCuantas casillas quieres en el tablero? (Tiene que ser un número entre 10 y 100) ")
    if posMax.isnumeric():
        posMax = int(posMax)
        if posMax >= 10 and posMax <= 100:
            CasCorrecte = True
            print("Perfecto")
        else:
            print("\nError. Tienes que poner un numero entre 10 y 100 (ambos incluidos)")
    else:
        print("\nTienes que poner un número entero y positivo entre 10 y 100")

jugarpartida = True
numPar = 0
mejorP = 0
mejorCas = 0

while jugarpartida == True:  # Bucle per a jugar partidas
    numPar += 1
    print(f"\nCOMENZAMOS LA PARTIDA {numPar}")
    print("Estoy en la casilla 0")
    posFicha = 0
    tirDado = 0
    cont6 = 0

    while posFicha != posMax:  # Bucle fins arribar a la posició maxima del tauler
        resDado = random.randint(1, 6)
        suma = True
        for i in range(1, resDado + 1):  # Bucle del dau per sumar la posició o rebotar
            if suma == True:
                posFicha += 1
                if posFicha == posMax:
                    suma = False
                else:
                    posFicha -= 1
        tirDado += 1
        if resDado == 6:  # Filtre de traure parades de burro
            cont6 += 1
        else:
            cont6 = 0
        if cont6 == 2:
            print("He sacado otro 6. Arrancada de Rossí-. Parada de burro, voy a la casilla 0")
            posFicha = 0
            cont6 = 0

        print(f"Has sacado un {resDado} y estas en la casilla {posFicha}")
        if posFicha % 5 == 0 and posFicha != posMax and posFicha + 5 <= posMax:  # Filtre de l'oca a oca
            posFicha += 5
            print(f"De oca a oca y tiro porque me toca. Avanzo a la casilla {posFicha}")

    print(f"Ganaste! con {tirDado} tiradas de dado")
    if numPar == 1:  # Contador de la mejor partida
        mejorCas = tirDado
        mejorP = numPar
    elif mejorCas >= tirDado:
        mejorP = numPar
        mejorCas = tirDado

    res = input("Quieres otra partida? (s/n)")  # Filtre un altra partida
    if res != "s" and res != "S":
        jugarpartida = False

print(f"***La mejor partida ha sido la número {mejorP} con solo {mejorCas} tiradas de dado***")
