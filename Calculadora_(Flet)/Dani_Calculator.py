import flet as ft

def main(page: ft.Page):
    page.title = "Calculadora - By Dani"
    page.vertical_alignment = ft.MainAxisAlignment.CENTER
    page.horizontal_alignment = ft.CrossAxisAlignment.CENTER

    buttonsize = 70

    def boton0(e):
        if pantalla.value != "0":
            pantalla.value = pantalla.value + "0"
        pantalla.update()

    def boton1(e):
        pantalla.value = pantalla.value = "1" if pantalla.value == "0" else pantalla.value + "1"
        pantalla.update()

    def boton2(e):
        pantalla.value = pantalla.value = "2" if pantalla.value == "0" else pantalla.value + "2"
        pantalla.update()

    def boton3(e):
        pantalla.value = pantalla.value = "3" if pantalla.value == "0" else pantalla.value + "3"
        pantalla.update()

    def boton4(e):
        pantalla.value = pantalla.value = "4" if pantalla.value == "0" else pantalla.value + "4"
        pantalla.update()

    def boton5(e):
        pantalla.value = pantalla.value = "5" if pantalla.value == "0" else pantalla.value + "5"
        pantalla.update()

    def boton6(e):
        pantalla.value = pantalla.value = "6" if pantalla.value == "0" else pantalla.value + "6"
        pantalla.update()

    def boton7(e):
        pantalla.value = pantalla.value = "7" if pantalla.value == "0" else pantalla.value + "7"
        pantalla.update()

    def boton8(e):
        pantalla.value = pantalla.value = "8" if pantalla.value == "0" else pantalla.value + "8"
        pantalla.update()

    def boton9(e):
        pantalla.value = pantalla.value = "9" if pantalla.value == "0" else pantalla.value + "9"
        pantalla.update()

    def botondiv(e):
        pantalla.value = pantalla.value + "/"
        pantalla.update()

    def botonmult(e):
        pantalla.value = pantalla.value + "*"
        pantalla.update()

    def botonresta(e):
        pantalla.value = pantalla.value + "-"
        pantalla.update()

    def botonsuma(e):
        pantalla.value = pantalla.value + "+"
        pantalla.update()

    def botonresult(e):
        pantalla.value = str(eval(pantalla.value))
        pantalla.update()

    def botondel(e):
        pantalla.value = "0"
        pantalla.update()

    pantalla = ft.TextField(
        value = "0",
        read_only=True,
        bgcolor=ft.colors.WHITE,
        expand=True,
        text_size=25,
        text_align=ft.TextAlign.RIGHT
        )
        
    boton0 = ft.Container(
        content=ft.Text("0",theme_style=ft.TextThemeStyle.HEADLINE_SMALL),
        margin=10,
        alignment=ft.alignment.center,
        bgcolor=ft.colors.GREY_100,
        width=buttonsize,
        height=buttonsize,
        border_radius=10,
        ink=True,
        on_click=boton0
    )
    
    boton1 = ft.Container(
        content=ft.Text("1",theme_style=ft.TextThemeStyle.HEADLINE_SMALL),
        margin=10,
        alignment=ft.alignment.center,
        bgcolor=ft.colors.GREY_100,
        width=buttonsize,
        height=buttonsize,
        border_radius=10,
        ink=True,
        on_click=boton1,
    )
    
    boton2 = ft.Container(
        content=ft.Text("2",theme_style=ft.TextThemeStyle.HEADLINE_SMALL),
        margin=10,
        alignment=ft.alignment.center,
        bgcolor=ft.colors.GREY_100,
        width=buttonsize,
        height=buttonsize,
        border_radius=10,
        ink=True,
        on_click=boton2,
    )

    boton3 = ft.Container(
        content=ft.Text("3",theme_style=ft.TextThemeStyle.HEADLINE_SMALL),
        margin=10,
        alignment=ft.alignment.center,
        bgcolor=ft.colors.GREY_100,
        width=buttonsize,
        height=buttonsize,
        border_radius=10,
        ink=True,
        on_click=boton3,
    )

    boton4 = ft.Container(
        content=ft.Text("4",theme_style=ft.TextThemeStyle.HEADLINE_SMALL),
        margin=10,
        alignment=ft.alignment.center,
        bgcolor=ft.colors.GREY_100,
        width=buttonsize,
        height=buttonsize,
        border_radius=10,
        ink=True,
        on_click=boton4,
    )

    boton5 = ft.Container(
        content=ft.Text("5",theme_style=ft.TextThemeStyle.HEADLINE_SMALL),
        margin=10,
        alignment=ft.alignment.center,
        bgcolor=ft.colors.GREY_100,
        width=buttonsize,
        height=buttonsize,
        border_radius=10,
        ink=True,
        on_click=boton5,
    )

    boton6 = ft.Container(
        content=ft.Text("6",theme_style=ft.TextThemeStyle.HEADLINE_SMALL),
        margin=10,
        alignment=ft.alignment.center,
        bgcolor=ft.colors.GREY_100,
        width=buttonsize,
        height=buttonsize,
        border_radius=10,
        ink=True,
        on_click=boton6,
    )

    boton7 = ft.Container(
        content=ft.Text("7",theme_style=ft.TextThemeStyle.HEADLINE_SMALL),
        margin=10,
        alignment=ft.alignment.center,
        bgcolor=ft.colors.GREY_100,
        width=buttonsize,
        height=buttonsize,
        border_radius=10,
        ink=True,
        on_click=boton7,
    )

    boton8 = ft.Container(
        content=ft.Text("8",theme_style=ft.TextThemeStyle.HEADLINE_SMALL),
        margin=10,
        alignment=ft.alignment.center,
        bgcolor=ft.colors.GREY_100,
        width=buttonsize,
        height=buttonsize,
        border_radius=10,
        ink=True,
        on_click=boton8,
    )

    boton9 = ft.Container(
        content=ft.Text("9",theme_style=ft.TextThemeStyle.HEADLINE_SMALL),
        margin=10,
        alignment=ft.alignment.center,
        bgcolor=ft.colors.GREY_100,
        width=buttonsize,
        height=buttonsize,
        border_radius=10,
        ink=True,
        on_click=boton9,
    )
    
    botondiv = ft.Container(
        content=ft.Text("/",theme_style=ft.TextThemeStyle.HEADLINE_SMALL),
        margin=10,
        alignment=ft.alignment.center,
        bgcolor=ft.colors.CYAN_100,
        width=buttonsize,
        height=buttonsize,
        border_radius=10,
        ink=True,
        on_click=botondiv
    )

    botonmult = ft.Container(
        content=ft.Text("*",theme_style=ft.TextThemeStyle.HEADLINE_SMALL),
        margin=10,
        alignment=ft.alignment.center,
        bgcolor=ft.colors.CYAN_100,
        width=buttonsize,
        height=buttonsize,
        border_radius=10,
        ink=True,
        on_click=botonmult
    )

    botonresta = ft.Container(
        content=ft.Text("-",theme_style=ft.TextThemeStyle.HEADLINE_SMALL),
        margin=10,
        alignment=ft.alignment.center,
        bgcolor=ft.colors.CYAN_100,
        width=buttonsize,
        height=buttonsize,
        border_radius=10,
        ink=True,
        on_click=botonresta
    )

    botonsuma = ft.Container(
        content=ft.Text("+",theme_style=ft.TextThemeStyle.HEADLINE_SMALL),
        margin=10,
        alignment=ft.alignment.center,
        bgcolor=ft.colors.CYAN_100,
        width=buttonsize,
        height=buttonsize,
        border_radius=10,
        ink=True,
        on_click=botonsuma
    )
    
    botonresult = ft.Container(
        content=ft.Text("=",theme_style=ft.TextThemeStyle.HEADLINE_SMALL),
        margin=10,
        alignment=ft.alignment.center,
        bgcolor=ft.colors.BLUE_400,
        width=buttonsize,
        height=buttonsize,
        border_radius=10,
        ink=True,
        on_click=botonresult
    )
        
    botondel = ft.Container(
        content=ft.Text("AC",theme_style=ft.TextThemeStyle.HEADLINE_SMALL),
        margin=10,
        alignment=ft.alignment.center,
        bgcolor=ft.colors.CYAN_100,
        width=buttonsize,
        height=buttonsize,
        border_radius=10,
        ink=True,
        on_click=botondel
    )
    
    colcalculadora = ft.Column(
            [   ft.Row([pantalla]),
                ft.Divider(),
                ft.Row([boton7 ,boton8, boton9, botondiv],alignment=ft.MainAxisAlignment.SPACE_BETWEEN),
                ft.Row([boton4 ,boton5, boton6, botonmult],alignment=ft.MainAxisAlignment.SPACE_BETWEEN),
                ft.Row([boton1 ,boton2, boton3, botonresta],alignment=ft.MainAxisAlignment.SPACE_BETWEEN),
                ft.Row([botondel, boton0, botonresult, botonsuma],alignment=ft.MainAxisAlignment.SPACE_BETWEEN)
            ]
        )
    calculator_bg = ft.Container(
        content=colcalculadora,
        margin=10,
        padding=10,
        bgcolor=ft.colors.GREY_400,
        width=400,
        height=520,
        border_radius=10,
        shadow=ft.BoxShadow(
        spread_radius=1,
        blur_radius=15,
        color=ft.colors.BLUE_300)
    )
    
    page.add(calculator_bg)

ft.app(target=main)