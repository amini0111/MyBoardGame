package noventagrados.control.undo;

import java.util.Date;
import noventagrados.control.Arbitro;
import noventagrados.modelo.Jugada;

/**
 * Interfaz que define el mecanismo para deshacer jugadas (mecanismo "undo").
 * Permite consultar el estado actual del árbitro, hacer y deshacer jugadas,
 * y consultar la cantidad de jugadas realizadas.
 * 
 * @author <a href="mailto:mbx1030@alu.ubu.es">Mohammed Amine Belhadri</a>
 * @version 2.0
 */
public interface MecanismoDeDeshacer {

    /**
     * Consulta el árbitro actual en el estado actual de la partida.
     * Devuelve un clon en profundidad del árbitro con las piezas en su posición
     * actual y las cajas en su estado correspondiente.
     * 
     * @return un clon del árbitro en el estado actual.
     */
    Arbitro consultarArbitroActual();

    /**
     * Consulta el número de jugadas que se encuentran en el histórico y que pueden
     * ser deshechas en este momento.
     * 
     * @return el número de jugadas en el histórico.
     */
    int consultarNumeroJugadasEnHistorico();

    /**
     * Deshace la última jugada realizada en la partida.
     * Devuelve el estado del juego al estado anterior a la última jugada.
     */
    void deshacerJugada();

    /**
     * Realiza una jugada y la almacena en el histórico para poder deshacerla
     * posteriormente.
     * 
     * @param jugada la jugada realizada que se desea almacenar en el histórico.
     */
    void hacerJugada(Jugada jugada);

    /**
     * Devuelve la fecha de inicio del mecanismo de deshacer.
     * Indica cuándo se inicializó el mecanismo de deshacer.
     * 
     * @return la fecha de inicio del mecanismo de deshacer.
     */
    Date obtenerFechaInicio();
}
