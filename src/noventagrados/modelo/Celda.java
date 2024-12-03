package noventagrados.modelo;

import java.util.Objects;

import noventagrados.util.Color;
import noventagrados.util.Coordenada;

/**
 * Representa una celda en el tablero del juego Noventa Grados. Cada celda está
 * asociada a una coordenada y puede contener una pieza o estar vacía.
 * 
 * @author <a href="mailto:mbx1030@alu.ubu.es">Mohammed Amine Belhadri</a>
 * @since 1.0
 * @version 2.0
 */
public class Celda {

	/** Coordenada de la celda. */
	private final Coordenada coordenada;

	/** Pieza ubicada en la celda. Puede ser nula si la celda está vacía. */
	private Pieza pieza;

	/**
	 * Constructor de la clase Celda.
	 * 
	 * @param coordenada la coordenada asociada a la celda, no puede ser nula.
	 */
	public Celda(Coordenada coordenada) {
		this.coordenada = coordenada;
		this.pieza = null;
	}

	/**
	 * Clona la celda, creando una copia profunda de ella.
	 * 
	 * @return una nueva instancia de {@code Celda} con los mismos valores que la
	 *         actual.
	 */
	public Celda clonar() {
		Celda clon = new Celda(this.coordenada);
		if (this.pieza != null) {
			clon.pieza = this.pieza.clonar();
		}
		return clon;
	}

	/**
	 * Coloca una pieza en la celda.
	 * 
	 * @param pieza la pieza a colocar en la celda, puede ser nula para vaciar la
	 *              celda.
	 */
	public void colocar(Pieza pieza) {
		this.pieza = pieza;
	}

	/**
	 * Consulta el color de la pieza ubicada en la celda.
	 * 
	 * @return el color de la pieza si existe, o {@code null} si la celda está
	 *         vacía.
	 */
	public Color consultarColorDePieza() {
		return (this.pieza != null) ? this.pieza.consultarColor() : null;
	}

	/**
	 * Consulta la coordenada de la celda.
	 * 
	 * @return la coordenada asociada a esta celda.
	 */
	public Coordenada consultarCoordenada() {
		return coordenada;
	}

	/**
	 * Consulta la pieza ubicada en la celda.
	 * 
	 * @return la pieza en la celda, o {@code null} si la celda está vacía.
	 */
	public Pieza consultarPieza() {
		return pieza;
	}

	/**
	 * Elimina la pieza de la celda, dejándola vacía.
	 */
	public void eliminarPieza() {
		this.pieza = null;
	}

	/**
	 * Verifica si la celda está vacía.
	 * 
	 * @return {@code true} si la celda no contiene ninguna pieza, {@code false} en
	 *         caso contrario.
	 */
	public boolean estaVacia() {
		return this.pieza == null;
	}

	/**
	 * Genera un hash code único para la celda.
	 * 
	 * @return el hash code de la celda.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(coordenada, pieza);
	}

	/**
	 * Compara esta celda con otra para verificar si son iguales. Dos celdas son
	 * iguales si tienen la misma coordenada y contienen la misma pieza.
	 * 
	 * @param obj el objeto a comparar con esta celda.
	 * @return {@code true} si ambas celdas son iguales, {@code false} en caso
	 *         contrario.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Celda other = (Celda) obj;
		return Objects.equals(coordenada, other.coordenada) && Objects.equals(pieza, other.pieza);
	}

	/**
	 * Representa la celda como una cadena de texto.
	 * 
	 * @return una representación en forma de texto de la celda, que incluye la
	 *         coordenada y la pieza.
	 */
	@Override
	public String toString() {
		return "Celda [coordenada=" + coordenada + ", pieza=" + pieza + "]";
	}
}
