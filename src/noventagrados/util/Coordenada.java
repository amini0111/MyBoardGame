package noventagrados.util;

/**
 * La clase {@code Coordenada} representa una posición en una matriz o tablero,
 * definida por una fila y una columna.
 * 
 * 
 * 
 * <p>
 * Esta clase proporciona métodos para obtener las coordenadas individuales y
 * una representación en texto de la posición.
 * </p>
 * 
 * @param fila    el número de la fila en la coordenada.
 * @param columna el número de la columna en la coordenada.
 * 
 * @author <a href="mailto:mbx1030@alu.ubu.es">Mohammed Amine Belhadri</a>
 * @since 1.0
 * @version 2.0
 */
public record Coordenada(int fila, int columna) {

	/**
	 * Devuelve una representación en texto de la coordenada.
	 * 
	 * <p>
	 * El formato de la salida es una concatenación de los valores de fila y
	 * columna, sin espacios ni separadores. Por ejemplo, una coordenada en la fila
	 * 3 y columna 5 se representará como "35".
	 * </p>
	 * 
	 * @return una cadena de texto que representa la coordenada, en el formato "fila
	 *         + columna".
	 */
	public String aTexto() {
		return "" + fila + columna;
	}
}
