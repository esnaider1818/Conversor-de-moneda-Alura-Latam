import java.util.Scanner;

public class PrincipalMenu {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Consultar consulta = new Consultar();
        int opcion = 0;
        while (opcion != 7 ){

            System.out.println("""
                    ********************************
                    Bienvenido al conversor de monedas
                    
                    Escoja el numero para convertir su moneda o digite 7 para salir del conversor
                    
                     1.Dolar a peso argentino.
                     2.Peso argentino a dolar.
                     3.Dolar a real brasileño.
                     4.Real brasileño a Dolar
                     5.Dolar a peso Colombiano.
                     6.Peso Colombiano a Dolar.
                     7.salir """);
            opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {
                case 1 -> Conversor.convertir("USD", "ARS", consulta, leer);
                case 2 -> Conversor.convertir("ARS", "USD", consulta, leer);
                case 3 -> Conversor.convertir("USD", "BRL", consulta, leer);
                case 4 -> Conversor.convertir("BRL", "USD", consulta, leer);
                case 5 -> Conversor.convertir("USD", "COP", consulta, leer);
                case 6 -> Conversor.convertir("COP", "USD", consulta, leer);
                case 7 -> System.out.println("Saliendo del conversor...");
                default -> System.out.println("digito un caracter invalido");
            }

    }





        }
}
