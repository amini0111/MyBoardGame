package noventagrados.util;

/**
 * La enumeración {@code Color} representa los colores disponibles en el juego
 * Noventa Grados: blanco y negro.
 * 
 * <p>
 * Cada color está asociado a un carácter identificador: 'B' para blanco y 'N'
 * para negro.
 * </p>
 * 
 * <p>
 * La enumeración proporciona métodos para consultar el color contrario y para
 * obtener el carácter asociado a cada color.
 * </p>
 * 
 * @author <a href="mailto:mbx1030@alu.ubu.es">Mohammed Amine Belhadri</a>
 * @since 1.0
 * @version 2.0
 */
public enum Color {

	/**
	 * Color blanco, representado por la letra 'B'.
	 */
	BLANCO('B'),

	/**
	 * Color negro, representado por la letra 'N'.
	 */
	NEGRO('N');

	/** Carácter que identifica al color. */
	private final char letra;

	/**
	 * Constructor de la enumeración {@code Color}.
	 * 
	 * @param letra el carácter que representa el color ('B' para blanco, 'N' para
	 *              negro).
	 */
	private Color(char letra) {
		this.letra = letra;
	}

	/**
	 * Devuelve el color contrario al color actual.
	 * 
	 * <p>
	 * Por ejemplo, si el color actual es {@code BLANCO}, el método devuelve
	 * {@code NEGRO}. Si el color actual es {@code NEGRO}, el método devuelve
	 * {@code BLANCO}.
	 * </p>
	 * 
	 * @return el color contrario al actual.
	 */
	public Color consultarContrario() {
		return (this == BLANCO) ? NEGRO : BLANCO;
	}

	/**
	 * Obtiene el carácter asociado al color.
	 * 
	 * <p>
	 * El carácter es: 'B' para el color blanco y 'N' para el color negro.
	 * </p>
	 * 
	 * @return el carácter que representa el color.
	 */
	public char toChar() {
		return this.letra;
	}
}
