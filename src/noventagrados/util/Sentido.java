package noventagrados.util;

/**
 * La enumeración {@code Sentido} modela los cuatro sentidos posibles en los que se pueden realizar movimientos
 * dentro del juego Noventa Grados.
 * 
 * <p>Las direcciones disponibles son:</p>
 * <ul>
 *   <li>{@code VERTICAL_N}: Desplazamiento hacia el norte (fila -1, columna 0).</li>
 *   <li>{@code VERTICAL_S}: Desplazamiento hacia el sur (fila +1, columna 0).</li>
 *   <li>{@code HORIZONTAL_E}: Desplazamiento hacia el este (fila 0, columna +1).</li>
 *   <li>{@code HORIZONTAL_O}: Desplazamiento hacia el oeste (fila 0, columna -1).</li>
 * </ul>
 * 
 * <p>Cada sentido tiene un desplazamiento asociado en filas y columnas, que se puede consultar mediante
 * métodos específicos.</p>
 * 
 * @author <a href="mailto:mbx1030@alu.ubu.es">Mohammed Amine Belhadri</a>
 * @since 1.0
 * @version 2.0
 */
public enum Sentido {

	/**
	 * Desplazamiento hacia el norte (fila -1, columna 0).
	 */
	VERTICAL_N(-1, 0),

	/**
	 * Desplazamiento hacia el sur (fila +1, columna 0).
	 */
	VERTICAL_S(+1, 0),

	/**
	 * Desplazamiento hacia el este (fila 0, columna +1).
	 */
	HORIZONTAL_E(0, +1),

	/**
	 * Desplazamiento hacia el oeste (fila 0, columna -1).
	 */
	HORIZONTAL_O(0, -1);

	/** Desplazamiento en filas asociado al sentido. */
	private final int desplazamientoEnFilas;

	/** Desplazamiento en columnas asociado al sentido. */
	private final int desplazamientoEnColumnas;

	/**
	 * Constructor de la enumeración {@code Sentido}.
	 * 
	 * <p>
	 * Asocia un desplazamiento específico en filas y columnas a cada sentido.
	 * </p>
	 * 
	 * @param desplazamientoEnFilas    desplazamiento en filas asociado al sentido.
	 * @param desplazamientoEnColumnas desplazamiento en columnas asociado al
	 *                                 sentido.
	 */
	private Sentido(int desplazamientoEnFilas, int desplazamientoEnColumnas) {
		this.desplazamientoEnFilas = desplazamientoEnFilas;
		this.desplazamientoEnColumnas = desplazamientoEnColumnas;
	}

	/**
	 * Consulta el desplazamiento en filas asociado al sentido.
	 * 
	 * @return el desplazamiento en filas para este sentido.
	 */
	public int consultarDesplazamientoEnFilas() {
		return desplazamientoEnFilas;
	}

	/**
	 * Consulta el desplazamiento en columnas asociado al sentido.
	 * 
	 * @return el desplazamiento en columnas para este sentido.
	 */
	public int consultarDesplazamientoEnColumnas() {
		return desplazamientoEnColumnas;
	}
}
