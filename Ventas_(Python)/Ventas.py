#Daniel Orocondo 1 DAM
noms = []
qVentas = []
preus = []
GestionDeTienda = True

while GestionDeTienda:
    print("Que opción quieres hacer?")
    respuesta = int(input("\n 1. Introducir un articulo nuevo\n 2. Hacer una venta\n 3. Mostrar información\n 4. Borrar un articulo\n 5. Borrar todos los articulos\n 6. Salir\n\n"))

    if respuesta == 1:  # Introducir nuevo articulo
        nuevoProd = input("Dime el nombre del nuevo producto\n")
        noms.append(nuevoProd)
        nuevoPrecio = float(input("Dime el precio del nuevo producto\n"))
        preus.append(nuevoPrecio)
        qVentas.append(0)

    elif respuesta == 2:  # Nueva venta
        NomCompraProducto = input("Que producto quieres comprar?\n")
        ProductoExiste = False
        for posicion in range(0, len(noms)):  # Comprobar existencia del producto
            if NomCompraProducto == noms[posicion]:
                NumVent = float(input("Dime que cantidad quieres comprar\n"))
                qVentas[posicion] += NumVent
                ProductoExiste = True
                break
        if not ProductoExiste:
            print("No has puesto correctamente el nombre, intentalo de nuevo")

    elif respuesta == 3:  # Lista
        mostrarInversa = input("Quieres mostrarlo de forma inversa o no inversa? ")
        if mostrarInversa == "s" or mostrarInversa == "S":
            indiceInicial = (len(noms) - 1)
            indiceFinal = -1
            paso = -1
        else:
            indiceInicial = 0
            indiceFinal = len(noms)
            paso = 1

        print(f"\n{"NOMBRE":<14} {"CANT.":>12} {"PRECIO":>13} {"IMPORTE":>16}")
        preuTotal = 0
        for posició in range(indiceInicial, indiceFinal, paso):  # Mostrar lista con toda la información de los vectores
            importArticle = (qVentas[posició] * preus[posició])
            print(f"{noms[posició]:<14} {qVentas[posició]:>13} {preus[posició]:>12} {importArticle:>16}")
            preuTotal += importArticle
        print(f"\t\t\t\t TOTAL: {preuTotal:>16}\n")

        maxVent = 0
        maxVentArt = 0
        maxIng = 0
        maxIngArt = 0
        for posicion in range(0, len(qVentas)):  # Buscar articulo con más ventas y articulo con más ingresos
            if maxVent < qVentas[posicion]:
                maxVent = qVentas[posicion]
                maxVentArt = noms[posicion]
            if maxIng < (qVentas[posicion] * preus[posicion]):
                maxIng = (qVentas[posicion] * preus[posicion])
                maxIngArt = noms[posicion]
        print(f"Articulo con más ventas: {maxVentArt}, con {maxVent} unidades")
        print(f"Articulo con más ingresos: {maxIngArt}, con {maxIng} unidades\n")

    elif respuesta == 4:  # Borrar producto
        NomBorrarProducto = input("Que producto quieres borrar?\n")
        ProductoExiste = False
        for posicion in range(0, len(noms)):  # Comprobar existencia del producto
            if NomBorrarProducto == noms[posicion]:
                noms.remove(NomBorrarProducto)
                preus.pop(posicion)
                qVentas.pop(posicion)
                ProductoExiste = True
                break
        if not ProductoExiste:
            print("Articulo no encontrado, intentalo de nuevo")

    elif respuesta == 5:  # Borrar todos
        noms = []
        preus = []
        qVentas = []

    elif respuesta == 6:  # Salir
        FinPrograma = input("Estas seguro de que quieres terminar? (s/n) ")
        if FinPrograma == "s" or FinPrograma == "S":
            GestionDeTienda = False
    else:
        print("Escoge una de las 6 opciones")
