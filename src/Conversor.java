import java.util.Scanner;

public class Conversor {
    public static void convertir(String base, String monedaTarget, Consultar consulta, Scanner leer) {
        double cantidad;
        double cantidadConvertida;

        Moneda moneda = consulta.buscar(base, monedaTarget);

        if (moneda == null || moneda.conversion_rate() == 0) {
            System.out.println("No se pudo obtener la tasa de conversión. Intente de nuevo.");
            return;
        }

        System.out.println("La tasa de conversión es:");
        System.out.println("1 " + base + " = " + moneda.conversion_rate() + " " + monedaTarget);
        System.out.println("Ingresa la cantidad de " + base + ":");

        try {
            cantidad = Double.parseDouble(leer.nextLine());
            cantidadConvertida = cantidad * moneda.conversion_rate();
            System.out.println(cantidad + " " + base + " = " + cantidadConvertida + " " + moneda.target_code());
        } catch (NumberFormatException e) {
            System.out.println("Error: Debes ingresar un número válido.");
        }
    }
}
