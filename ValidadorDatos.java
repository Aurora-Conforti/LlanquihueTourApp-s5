package util;

/**
 * Clase utilitaria con metodos estaticos de validacion reutilizables
 * para distintas partes del sistema de Llanquihue Tour.
 *
 * Centraliza las validaciones basicas para evitar duplicar logica
 * en las clases de modelo y de servicio.
 *
 * @author Aurora Conforti
 * @version 1.0
 */
public class ValidadorDatos {

    /**
     * Valida que un texto no sea nulo ni este vacio.
     *
     * @param texto Texto a validar.
     * @return true si el texto es valido (no nulo y no vacio).
     */
    public static boolean esTextoValido(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    /**
     * Valida que un numero entero sea positivo.
     *
     * @param numero Numero a validar.
     * @return true si el numero es mayor o igual a cero.
     */
    public static boolean esNumeroPositivo(int numero) {
        return numero >= 0;
    }

    /**
     * Intenta convertir un texto a numero entero de forma segura,
     * capturando el error si el formato no es valido.
     *
     * @param texto Texto que representa un numero.
     * @return el numero entero si la conversion fue exitosa, o -1 si hubo error.
     */
    public static int convertirAEnteroSeguro(String texto) {
        try {
            return Integer.parseInt(texto.trim());
        } catch (NumberFormatException e) {
            System.out.println("Error de formato: '" + texto + "' no es un numero valido.");
            return -1;
        }
    }

    /**
     * Valida que una linea leida desde un archivo tenga la cantidad de
     * campos esperada antes de procesarla.
     *
     * @param partes        Arreglo de campos obtenidos al separar la linea.
     * @param cantidadEsperada Cantidad de campos que la linea deberia tener.
     * @return true si la cantidad de campos coincide con lo esperado.
     */
    public static boolean tieneCantidadDeCamposValida(String[] partes, int cantidadEsperada) {
        return partes != null && partes.length == cantidadEsperada;
    }
}
