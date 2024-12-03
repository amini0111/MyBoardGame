package noventagrados.modelo;

/**
 * Representa una jugada en el juego Noventa Grados. Una jugada se define por
 * una celda de origen y una celda de destino.
 * 
 * La clase {@code Jugada} utiliza el formato de un registro ({@code record}),
 * lo que garantiza que es inmutable y que los valores de las celdas origen y
 * destino no pueden modificarse después de la creación de la instancia.
 *
 * @param origen  la celda desde donde se realiza la jugada, no puede ser nula.
 * @param destino la celda a la que se dirige la jugada, no puede ser nula.
 * 
 * @author <a href="mailto:mbx1030@alu.ubu.es">Mohammed Amine Belhadri</a>
 * @since 1.0
 * @version 2.0
 */
public record Jugada(Celda origen, Celda destino) {

	/**
	 * Genera una representación en texto de la jugada, indicando las coordenadas de
	 * la celda de origen y la celda de destino, separadas por un guion.
	 * 
	 * <p>
	 * Por ejemplo, si la celda de origen tiene las coordenadas (0, 0) y la celda de
	 * destino (1, 1), el texto generado será "00-11".
	 * </p>
	 *
	 * @return una cadena que representa la jugada en el formato "origen-destino".
	 */
	public String aTexto() {
		return origen.consultarCoordenada().aTexto() + "-" + destino.consultarCoordenada().aTexto();
	}
}
