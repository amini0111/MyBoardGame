package noventagrados.util;

/**
 * La enumeración {@code TipoPieza} representa los diferentes tipos de piezas disponibles en el juego Noventa Grados.
 * 
 * <p>Cada tipo de pieza está asociado a un carácter que la identifica:
 * 'P' para el peón y 'R' para la reina.</p>
 * 
 * <p>La enumeración incluye métodos para consultar el carácter asociado a cada tipo de pieza.</p>
 * 
 * Los tipos de piezas definidos son:
 * <ul>
 *   <li>{@code PEON}: Representado por la letra 'P'.</li>
 *   <li>{@code REINA}: Representado por la letra 'R'.</li>
 * </ul>
 * 
 * @author <a href="mailto:mbx1030@alu.ubu.es">Mohammed Amine Belhadri</a>
 * @since 1.0
 * @version 2.0
 */
public enum TipoPieza {

	/**
	 * Tipo de pieza Peón, representado por la letra 'P'.
	 */
	PEON('P'),

	/**
	 * Tipo de pieza Reina, representado por la letra 'R'.
	 */
	REINA('R');

	/** Carácter que identifica al tipo de pieza. */
	private final char caracter;

	/**
	 * Constructor de la enumeración {@code TipoPieza}.
	 * 
	 * <p>
	 * Asocia un carácter identificador al tipo de pieza.
	 * </p>
	 * 
	 * @param caracter el carácter que representa el tipo de pieza ('P' para Peón,
	 *                 'R' para Reina).
	 */
	private TipoPieza(char caracter) {
		this.caracter = caracter;
	}

	/**
	 * Devuelve el carácter asociado al tipo de pieza.
	 * 
	 * <p>
	 * El carácter es: 'P' para el peón y 'R' para la reina.
	 * </p>
	 * 
	 * @return el carácter que representa el tipo de pieza.
	 */
	public char toChar() {
		return this.caracter;
	}
}
