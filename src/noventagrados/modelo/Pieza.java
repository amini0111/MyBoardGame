package noventagrados.modelo;

import noventagrados.util.TipoPieza;

import java.util.Objects;

import noventagrados.util.Color;

/**
 * Representa una pieza del juego Noventa Grados. Una pieza puede ser de dos
 * tipos (PEON o REINA) y de dos colores (BLANCO o NEGRO). Esta clase es
 * inmutable, ya que los atributos son finales y no pueden cambiarse después de
 * la construcción.
 * 
 * @author <a href="mailto:mbx1030@alu.ubu.es">Mohammed Amine Belhadri</a>
 * @since 1.0
 * @version 2.0
 */
public class Pieza {

	/** Tipo de la pieza (PEON o REINA). */
	private final TipoPieza tipoPieza;

	/** Color de la pieza (BLANCO o NEGRO). */
	private final Color color;

	/**
	 * Constructor que inicializa la pieza con un tipo y un color.
	 * 
	 * @param tipoPieza el tipo de la pieza (PEON o REINA), no puede ser nulo.
	 * @param color     el color de la pieza (BLANCO o NEGRO), no puede ser nulo.
	 *@throws IllegalArgumentException si {@code tipoPieza} o {@code color} son nulos.
	 */
	public Pieza(TipoPieza tipoPieza, Color color) {
	    if (tipoPieza == null || color == null) {
	        throw new IllegalArgumentException("El tipo de pieza y el color no pueden ser nulos.");
	    }
	    this.tipoPieza = tipoPieza;
	    this.color = color;
	}


	/**
	 * Devuelve una representación textual de la pieza, formada por el tipo y el
	 * color. Por ejemplo, "PB" para un peón blanco o "RN" para una reina negra.
	 * 
	 * @return una cadena de texto que representa la pieza.
	 */
	public String aTexto() {
		return String.valueOf(tipoPieza.toChar()) + String.valueOf(color.toChar());
	}

	/**
	 * Devuelve un clon profundo de la pieza actual.
	 * 
	 * @return una nueva instancia de {@code Pieza} con los mismos valores que la
	 *         pieza actual.
	 */
	public Pieza clonar() {
		return new Pieza(this.tipoPieza, this.color);
	}

	/**
	 * Devuelve el color de la pieza.
	 * 
	 * @return el color de la pieza (BLANCO o NEGRO).
	 */
	public Color consultarColor() {
		return this.color;
	}

	/**
	 * Devuelve el tipo de la pieza.
	 * 
	 * @return el tipo de la pieza (PEON o REINA).
	 */
	public TipoPieza consultarTipoPieza() {
		return this.tipoPieza;
	}

	/**
	 * Calcula el valor hash de la pieza basado en su tipo y color.
	 * 
	 * @return el valor hash de la pieza.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(color, tipoPieza);
	}

	/**
	 * Compara esta pieza con otra para verificar si son iguales. Dos piezas son
	 * iguales si tienen el mismo tipo y color.
	 * 
	 * @param obj el objeto a comparar con esta pieza.
	 * @return {@code true} si las piezas son iguales, {@code false} en caso
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
		Pieza other = (Pieza) obj;
		return color == other.color && tipoPieza == other.tipoPieza;
	}

	/**
	 * Devuelve una representación en forma de cadena de texto de la pieza,
	 * incluyendo su tipo y color.
	 * 
	 * @return una cadena de texto que representa la pieza.
	 */
	@Override
	public String toString() {
		return "Pieza [tipoPieza=" + tipoPieza + ", color=" + color + "]";
	}

}
