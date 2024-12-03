package noventagrados.control.undo;

import java.util.Date;
import noventagrados.control.Arbitro;
import noventagrados.modelo.Jugada;

/**
 * Clase abstracta que proporciona una implementación base del mecanismo de deshacer.
 * Define los atributos y métodos comunes para los descendientes que implementan la interfaz MecanismoDeDeshacer.
 * 
 * @author <a href="mailto:mbx1030@alu.ubu.es">Mohammed Amine Belhadri</a>
 * @version 2.0
 */
public abstract class MecanismoDeDeshacerAbstracto implements MecanismoDeDeshacer {

    /**
     * Fecha de inicio del mecanismo de deshacer.
     */
    protected Date fechaInicio;

    /**
     * Constructor que inicializa el mecanismo de deshacer con la fecha actual.
     * La fecha de inicio es el momento en el cual se inicializa el mecanismo.
     * 
     * @param fecha la fecha de inicio del mecanismo de deshacer.
     */
    public MecanismoDeDeshacerAbstracto(Date fecha) {
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser nula.");
        }
        this.fechaInicio = fecha;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date obtenerFechaInicio() {
        return fechaInicio;
    }

    /**
     * Método abstracto para consultar el árbitro actual, implementado por las clases descendientes.
     * 
     * @return un clon del árbitro en el estado actual.
     */
    @Override
    public abstract Arbitro consultarArbitroActual();

    /**
     * Método abstracto para consultar el número de jugadas en el histórico, implementado por las clases descendientes.
     * 
     * @return el número de jugadas en el histórico.
     */
    @Override
    public abstract int consultarNumeroJugadasEnHistorico();

    /**
     * Método abstracto para deshacer la última jugada, implementado por las clases descendientes.
     */
    @Override
    public abstract void deshacerJugada();

    /**
     * Método abstracto para hacer una jugada y guardarla en el histórico, implementado por las clases descendientes.
     * 
     * @param jugada la jugada realizada que se desea almacenar en el histórico.
     */
    @Override
    public abstract void hacerJugada(Jugada jugada);
}
