package noventagrados.control;

import noventagrados.modelo.Tablero;
import noventagrados.modelo.Celda;
import noventagrados.modelo.Pieza;
import noventagrados.util.Color;
import noventagrados.util.Coordenada;
import noventagrados.util.Sentido;
import noventagrados.util.TipoPieza;

/**
 * Clase genérica para realizar consultas sobre un tablero de juego. Es
 * parametrizable solo por subtipos de tipo Tablero.
 *
 * @param <T> tipo del tablero (debe extender Tablero).
 * 
 * @author <a href="mailto:mbx1030@alu.ubu.es">Mohammed Amine Belhadri</a>
 * @since 1.0
 * @version 2.0
 */
public class TableroConsultor<T extends Tablero> {

	/** Tablero sobre el que se realizarán las consultas. */
	private final T tablero;

	/**
	 * Constructor que inicializa el consultor con un tablero.
	 * 
	 * @param tablero el tablero sobre el que se realizarán consultas.
	 */
	public TableroConsultor(T tablero) {
		this.tablero = tablero;
	}

	/**
	 * Calcula el sentido entre dos coordenadas.
	 * 
	 * @param origen  coordenada de origen.
	 * @param destino coordenada de destino.
	 * @return el sentido entre las coordenadas o {@code null} si no es válido.
	 */
	public Sentido calcularSentido(Coordenada origen, Coordenada destino) {
		int deltaFila = destino.fila() - origen.fila();
		int deltaColumna = destino.columna() - origen.columna();

		Sentido sentido = null;

		if (deltaFila == 0) {
			if (deltaColumna > 0) {
				sentido = Sentido.HORIZONTAL_E;
			} else if (deltaColumna < 0) {
				sentido = Sentido.HORIZONTAL_O;
			}
		} else if (deltaColumna == 0) {
			if (deltaFila > 0) {
				sentido = Sentido.VERTICAL_S;
			} else if (deltaFila < 0) {
				sentido = Sentido.VERTICAL_N;
			}
		}

		return sentido;
	}

	/**
	 * Calcula la distancia entre dos coordenadas en la misma horizontal.
	 * 
	 * @param origen  coordenada de origen.
	 * @param destino coordenada de destino.
	 * @return la distancia horizontal o -1 si no están en la misma horizontal.
	 */
	public int consultarDistanciaEnHorizontal(Coordenada origen, Coordenada destino) {
		if (origen.fila() == destino.fila()) {
			return Math.abs(destino.columna() - origen.columna());
		}
		return -1;
	}

	/**
	 * Calcula la distancia entre dos coordenadas en la misma vertical.
	 * 
	 * @param origen  coordenada de origen.
	 * @param destino coordenada de destino.
	 * @return la distancia vertical o -1 si no están en la misma vertical.
	 */
	public int consultarDistanciaEnVertical(Coordenada origen, Coordenada destino) {
		if (origen.columna() == destino.columna()) {
			return Math.abs(destino.fila() - origen.fila());
		}
		return -1;
	}

	/**
	 * Consulta el número de piezas de un tipo y color en el tablero.
	 * 
	 * @param tipoPieza el tipo de pieza.
	 * @param color     el color de las piezas.
	 * @return el número de piezas del tipo y color indicados.
	 */
	public int consultarNumeroPiezas(TipoPieza tipoPieza, Color color) {
		int contador = 0;
		for (Celda celda : tablero.consultarCeldas()) {
			Pieza pieza = celda.consultarPieza();
			if (pieza != null && pieza.consultarTipoPieza() == tipoPieza && pieza.consultarColor() == color) {
				contador++;
			}
		}
		return contador;
	}

	/**
	 * Consulta el número de piezas en la misma horizontal de una coordenada.
	 * 
	 * @param coordenada la coordenada de referencia.
	 * @return el número de piezas en la misma horizontal.
	 */
	public int consultarNumeroPiezasEnHorizontal(Coordenada coordenada) {
		int contador = 0;
		for (int columna = 0; columna < tablero.consultarNumeroColumnas(); columna++) {
			Coordenada actual = new Coordenada(coordenada.fila(), columna);
			Celda celda = tablero.consultarCelda(actual);
			if (celda != null && !celda.estaVacia()) {
				contador++;
			}
		}
		return contador;
	}

	/**
	 * Consulta el número de piezas en la misma vertical de una coordenada.
	 * 
	 * @param coordenada la coordenada de referencia.
	 * @return el número de piezas en la misma vertical.
	 */
	public int consultarNumeroPiezasEnVertical(Coordenada coordenada) {
		int contador = 0;
		for (int fila = 0; fila < tablero.consultarNumeroFilas(); fila++) {
			Coordenada actual = new Coordenada(fila, coordenada.columna());
			Celda celda = tablero.consultarCelda(actual);
			if (celda != null && !celda.estaVacia()) {
				contador++;
			}
		}
		return contador;
	}

	/**
	 * Comprueba si la reina de un color está en el centro del tablero.
	 * 
	 * @param color el color de la reina.
	 * @return {@code true} si la reina está en el centro, {@code false} en caso
	 *         contrario.
	 */
	public boolean estaReinaEnElCentro(Color color) {
		Coordenada centro = new Coordenada(tablero.consultarNumeroFilas() / 2, tablero.consultarNumeroColumnas() / 2);
		Celda celdaCentral = tablero.consultarCelda(centro);
		if (celdaCentral != null && !celdaCentral.estaVacia()) {
			Pieza pieza = celdaCentral.consultarPieza();
			return pieza.consultarTipoPieza() == TipoPieza.REINA && pieza.consultarColor() == color;
		}
		return false;
	}

	/**
	 * Comprueba si hay una reina de un color en el tablero.
	 * 
	 * @param color el color de la reina.
	 * @return {@code true} si hay una reina del color indicado, {@code false} en
	 *         caso contrario.
	 */
	public boolean hayReina(Color color) {
		for (Celda celda : tablero.consultarCeldas()) {
			Pieza pieza = celda.consultarPieza();
			if (pieza != null && pieza.consultarTipoPieza() == TipoPieza.REINA && pieza.consultarColor() == color) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Devuelve una representación en texto del consultor.
	 * 
	 * @return una cadena con la información del consultor.
	 */
	@Override
	public String toString() {
		return "TableroConsultor [tablero=" + tablero + "]";
	}
}
