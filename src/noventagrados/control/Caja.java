package noventagrados.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import noventagrados.modelo.Pieza;
import noventagrados.util.Color;
import noventagrados.util.TipoPieza;

/**
 * Representa una caja que contiene piezas de un único color en el juego Noventa
 * Grados. La caja tiene un tamaño limitado de hasta 7 piezas y permite
 * almacenar únicamente piezas del mismo color que el color asignado a la caja.
 * 
 * @author <a href="mailto:mbx1030@alu.ubu.es">Mohammed Amine Belhadri</a>
 * @since 1.0
 * @version 2.0
 */
public class Caja {

	/** Color asignado a la caja. */
	private final Color color;

	/** Lista de piezas contenidas en la caja. */
	private final List<Pieza> piezas;

	/**
	 * Constructor de la clase Caja. Inicializa la caja vacía con el color asignado.
	 * 
	 * @param color el color de la caja. No puede ser nulo.
	 * @throws IllegalArgumentException si el color es nulo.
	 */
	public Caja(Color color) {
		if (color == null) {
			throw new IllegalArgumentException("El color no puede ser nulo.");
		}
		this.color = color;
		this.piezas = new ArrayList<>();
	}

	/**
	 * Añade una pieza a la caja.
	 * 
	 * Solo se añaden piezas cuyo color coincida con el de la caja y si la caja no
	 * ha alcanzado su límite de 7 piezas.
	 * 
	 * @param pieza la pieza que se desea añadir. Si es nula o tiene un color
	 *              diferente al de la caja, no se añade.
	 */
	public void añadir(Pieza pieza) {
		if (pieza == null || pieza.consultarColor() != this.color) {
			return;
		}
		if (piezas.size() < 7) {
			piezas.add(pieza);
		}
	}

	/**
	 * Crea un clon en profundidad de la caja, incluyendo todas las piezas
	 * contenidas en ella.
	 * 
	 * @return un clon de la caja.
	 */
	public Caja clonar() {
		Caja clon = new Caja(this.color);
		for (Pieza pieza : this.piezas) {
			clon.añadir(pieza.clonar());
		}
		return clon;
	}

	/**
	 * Consulta el color de la caja.
	 * 
	 * @return el color de la caja.
	 */
	public Color consultarColor() {
		return this.color;
	}

	/**
	 * Devuelve una lista de clones en profundidad de todas las piezas contenidas en
	 * la caja.
	 * 
	 * @return una lista de clones de las piezas.
	 */
	public List<Pieza> consultarPiezas() {
		List<Pieza> clones = new ArrayList<>();
		for (Pieza pieza : piezas) {
			clones.add(pieza.clonar());
		}
		return clones;
	}

	/**
	 * Devuelve el número total de piezas contenidas en la caja.
	 * 
	 * @return el número de piezas en la caja.
	 */
	public int contarPiezas() {
		return piezas.size();
	}

	/**
	 * Devuelve el número de piezas de un tipo específico contenidas en la caja.
	 * 
	 * @param tipoPieza el tipo de pieza a contar (por ejemplo, PEON o REINA).
	 * @return el número de piezas del tipo especificado.
	 */
	public int contarPiezas(TipoPieza tipoPieza) {
		int contador = 0;
		for (Pieza pieza : piezas) {
			if (pieza.consultarTipoPieza() == tipoPieza) {
				contador++;
			}
		}
		return contador;
	}

	/**
	 * Calcula el código hash para la caja.
	 * 
	 * @return el código hash basado en el color y las piezas de la caja.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(color, piezas);
	}

	/**
	 * Compara esta caja con otra para verificar si son iguales.
	 * 
	 * Dos cajas son iguales si tienen el mismo color y contienen las mismas piezas.
	 * 
	 * @param obj el objeto a comparar con esta caja.
	 * @return {@code true} si ambas cajas son iguales, {@code false} en caso
	 *         contrario.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Caja other = (Caja) obj;
		return color == other.color && Objects.equals(piezas, other.piezas);
	}

	/**
	 * Devuelve una representación en forma de texto de la caja, incluyendo su color
	 * y las piezas contenidas.
	 * 
	 * @return una representación textual de la caja.
	 */
	@Override
	public String toString() {
		return "Caja [color=" + color + ", piezas=" + piezas + "]";
	}
}
