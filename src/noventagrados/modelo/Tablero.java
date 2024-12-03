package noventagrados.modelo;

import noventagrados.util.Coordenada;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Representa el tablero del juego Noventa Grados. Está compuesto por una lista
 * de listas de celdas, con un tamaño fijo de 7x7. Cada celda del tablero se
 * identifica mediante una coordenada única (fila, columna).
 * 
 * @author <a href="mailto:mbx1030@alu.ubu.es">Mohammed Amine Belhadri</a>
 * @since 1.0
 * @version 2.0
 */
public class Tablero {

	/** Tamaño fijo del tablero (7x7). */
	private static final int TAMANO = 7;

	/** Lista bidimensional que contiene las celdas del tablero. */
	private final List<List<Celda>> celdas;

	/**
	 * Constructor que inicializa el tablero con celdas vacías. Cada celda está
	 * asociada a una coordenada única dentro del tablero.
	 */
	public Tablero() {
		celdas = new ArrayList<>();
		for (int fila = 0; fila < TAMANO; fila++) {
			List<Celda> filaCeldas = new ArrayList<>();
			for (int columna = 0; columna < TAMANO; columna++) {
				filaCeldas.add(new Celda(new Coordenada(fila, columna)));
			}
			celdas.add(filaCeldas);
		}
	}

	/**
	 * Devuelve el estado del tablero como una cadena de texto.
	 * 
	 * <p>
	 * Por ejemplo, un tablero vacío generará una salida similar a:
	 * </p>
	 * 
	 * <pre>
	 * 0 -- -- -- -- -- -- --
	 * 1 -- -- -- -- -- -- --
	 * 2 -- -- -- -- -- -- --
	 * 3 -- -- -- -- -- -- --
	 * 4 -- -- -- -- -- -- --
	 * 5 -- -- -- -- -- -- --
	 * 6 -- -- -- -- -- -- --
	 *   0  1  2  3  4  5  6
	 * </pre>
	 * 
	 * @return una representación textual del tablero.
	 */
	public String aTexto() {
		StringBuilder sb = new StringBuilder();
		for (int fila = 0; fila < TAMANO; fila++) {
			sb.append(fila).append(" ");
			for (int columna = 0; columna < TAMANO; columna++) {
				Celda celda = celdas.get(fila).get(columna);
				sb.append(celda.estaVacia() ? "--" : celda.consultarPieza().aTexto()).append(" ");
			}
			sb.append("\n");
		}
		sb.append("  ");
		for (int columna = 0; columna < TAMANO; columna++) {
			sb.append(columna).append("  ");
		}
		return sb.toString().trim();
	}

	/**
	 * Crea un clon en profundidad del tablero actual, incluyendo todas las celdas y
	 * piezas.
	 * 
	 * @return una nueva instancia de {@code Tablero} que es idéntica al tablero
	 *         actual.
	 */
	public Tablero clonar() {
		Tablero clon = new Tablero();
		for (int fila = 0; fila < TAMANO; fila++) {
			for (int columna = 0; columna < TAMANO; columna++) {
				Coordenada coordenada = new Coordenada(fila, columna);
				Celda celdaOriginal = obtenerCelda(coordenada);
				if (!celdaOriginal.estaVacia()) {
					clon.colocar(celdaOriginal.consultarPieza().clonar(), coordenada);
				}
			}
		}
		return clon;
	}

	/**
	 * Coloca una pieza en la celda especificada por la coordenada. Si la coordenada
	 * o la pieza son nulas, no se realiza ninguna acción.
	 * 
	 * @param pieza      la pieza a colocar en el tablero.
	 * @param coordenada la coordenada de la celda donde se colocará la pieza.
	 */
	public void colocar(Pieza pieza, Coordenada coordenada) {
		if (pieza != null && coordenada != null) {
			Celda celda = obtenerCelda(coordenada);
			if (celda != null) {
				celda.colocar(pieza);
			}
		}
	}

	/**
	 * Devuelve un clon en profundidad de la celda especificada por la coordenada.
	 * 
	 * @param coordenada la coordenada de la celda a clonar.
	 * @return un clon de la celda o {@code null} si la coordenada no es válida.
	 */
	public Celda consultarCelda(Coordenada coordenada) {
		Celda celda = obtenerCelda(coordenada);
		return (celda != null) ? celda.clonar() : null;
	}

	/**
	 * Devuelve una lista con clones en profundidad de todas las celdas del tablero.
	 * 
	 * @return una lista de clones de las celdas del tablero.
	 */
	public List<Celda> consultarCeldas() {
		List<Celda> clones = new ArrayList<>();
		for (List<Celda> fila : celdas) {
			for (Celda celda : fila) {
				clones.add(celda.clonar());
			}
		}
		return clones;
	}

	/**
	 * Devuelve el número de filas del tablero.
	 * 
	 * @return el número de filas (siempre {@code 7}).
	 */
	public int consultarNumeroFilas() {
		return TAMANO;
	}

	/**
	 * Devuelve el número de columnas del tablero.
	 * 
	 * @return el número de columnas (siempre {@code 7}).
	 */
	public int consultarNumeroColumnas() {
		return TAMANO;
	}

	/**
	 * Elimina la pieza de la celda especificada por la coordenada. Si la celda no
	 * contiene ninguna pieza o la coordenada es inválida, no se realiza ninguna
	 * acción.
	 * 
	 * @param coordenada la coordenada de la celda de la que se eliminará la pieza.
	 */
	public void eliminarPieza(Coordenada coordenada) {
		if (coordenada != null) {
			Celda celda = obtenerCelda(coordenada);
			if (celda != null) {
				celda.eliminarPieza();
			}
		}
	}

	/**
	 * Verifica si una coordenada está dentro de los límites del tablero.
	 * 
	 * @param coordenada la coordenada a verificar.
	 * @return {@code true} si la coordenada está dentro de los límites del tablero;
	 *         {@code false} en caso contrario.
	 */
	public boolean estaEnTablero(Coordenada coordenada) {
		int fila = coordenada.fila();
		int columna = coordenada.columna();
		return fila >= 0 && fila < TAMANO && columna >= 0 && columna < TAMANO;
	}

	/**
	 * Devuelve la celda ubicada en la coordenada especificada.
	 * 
	 * @param coordenada la coordenada de la celda a obtener.
	 * @return la celda correspondiente o {@code null} si la coordenada no es
	 *         válida.
	 */
	public Celda obtenerCelda(Coordenada coordenada) {
		if (estaEnTablero(coordenada)) {
			return celdas.get(coordenada.fila()).get(coordenada.columna());
		}
		return null;
	}

	/**
	 * Calcula el código hash del tablero basado en sus celdas.
	 * 
	 * @return el código hash del tablero.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(celdas);
	}

	/**
	 * Compara este tablero con otro para verificar si son iguales. Dos tableros son
	 * iguales si contienen exactamente las mismas celdas y piezas.
	 * 
	 * @param obj el objeto a comparar con este tablero.
	 * @return {@code true} si los tableros son iguales; {@code false} en caso
	 *         contrario.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Tablero other = (Tablero) obj;
		return Objects.equals(celdas, other.celdas);
	}

	/**
	 * Genera una representación en forma de cadena del tablero, que incluye sus
	 * celdas.
	 * 
	 * @return una cadena que representa el tablero.
	 */
	@Override
	public String toString() {
		return "Tablero [celdas=" + celdas + "]";
	}
}
