package noventagrados.textui.excepcion;

/**
 * Excepción comprobable que indica que una opción solicitada no está disponible.
 * Esta clase extiende la clase Exception y proporciona los constructores habituales.
 * 
 * @author <a href="mailto:mbx1030@alu.ubu.es">Mohammed Amine Belhadri</a>
 * @version 2.0
 */
public class OpcionNoDisponibleException extends Exception {

    /**
     * Identificador de versión para la serialización.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor sin parámetros para la excepción.
     */
    public OpcionNoDisponibleException() {
        super();
    }

    /**
     * Constructor con un mensaje específico.
     * 
     * @param message El mensaje que describe la causa de la excepción.
     */
    public OpcionNoDisponibleException(String message) {
        super(message);
    }

    /**
     * Constructor con una causa específica.
     * 
     * @param cause La causa de la excepción (otra excepción).
     */
    public OpcionNoDisponibleException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor con un mensaje y una causa específica.
     * 
     * @param message El mensaje que describe la causa de la excepción.
     * @param cause   La causa de la excepción (otra excepción).
     */
    public OpcionNoDisponibleException(String message, Throwable cause) {
        super(message, cause);
    }
}
