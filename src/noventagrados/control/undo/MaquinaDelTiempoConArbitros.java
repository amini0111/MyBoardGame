package noventagrados.control.undo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import noventagrados.control.Arbitro;
import noventagrados.modelo.Jugada;
import noventagrados.modelo.Tablero;

/**
 * Clase que implementa el mecanismo de deshacer basado en almacenar clones de los árbitros
 * en cada jugada realizada. Se extiende de MecanismoDeDeshacerAbstracto.
 * 
 * @author <a href="mailto:mbx1030@alu.ubu.es">Mohammed Amine Belhadri</a>
 * @version 2.0
 */
public class MaquinaDelTiempoConArbitros extends MecanismoDeDeshacerAbstracto {

    /**
     * Histórico de clones del árbitro que representa el estado del juego en cada jugada.
     */
    private List<Arbitro> historicoArbitros;

    /**
     * Constructor que inicializa el mecanismo de deshacer basado en clones de árbitros
     * con una fecha de inicio y un tablero inicial.
     * 
     * @param fecha La fecha de inicio del mecanismo de deshacer.
     */
    public MaquinaDelTiempoConArbitros(Date fecha) {
        super(fecha);
        this.historicoArbitros = new ArrayList<>();

        // Inicializamos con el árbitro en el estado inicial con un tablero por defecto
        Tablero tableroInicial = new Tablero();
        Arbitro arbitroInicial = new Arbitro(tableroInicial);
        arbitroInicial.colocarPiezasConfiguracionInicial();
        historicoArbitros.add(arbitroInicial);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Arbitro consultarArbitroActual() {
        // Devolver el último clon del árbitro almacenado en la lista.
        if (!historicoArbitros.isEmpty()) {
            return historicoArbitros.get(historicoArbitros.size() - 1).clonar();
        } else {
            throw new IllegalStateException("No hay ningún árbitro almacenado en el histórico.");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int consultarNumeroJugadasEnHistorico() {
        // El número de jugadas es el tamaño del histórico menos el árbitro inicial.
        return historicoArbitros.size() - 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deshacerJugada() {
        // Deshacer la última jugada, eliminando el último clon del árbitro si hay más de un estado en el histórico.
        if (historicoArbitros.size() > 1) {
            historicoArbitros.remove(historicoArbitros.size() - 1);
        }
        // Si no hay más jugadas para deshacer, simplemente no hacer nada.
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void hacerJugada(Jugada jugada) {
        // Obtener el último árbitro del histórico y clonar su estado.
        Arbitro arbitroActual = historicoArbitros.get(historicoArbitros.size() - 1).clonar();

        // Aplicar la jugada si es válida.
        if (arbitroActual.esMovimientoLegal(jugada)) {
            arbitroActual.empujar(jugada);
            arbitroActual.cambiarTurno();
            historicoArbitros.add(arbitroActual);
        } else {
            throw new IllegalArgumentException("La jugada no es válida.");
        }
    }
}
