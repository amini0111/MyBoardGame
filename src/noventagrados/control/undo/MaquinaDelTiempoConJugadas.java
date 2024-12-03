package noventagrados.control.undo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import noventagrados.control.Arbitro;
import noventagrados.modelo.Jugada;
import noventagrados.modelo.Tablero;

/**
 * La clase MaquinaDelTiempoConJugadas implementa el mecanismo para deshacer jugadas
 * almacenando un histórico de las jugadas realizadas.
 * Hereda de MecanismoDeDeshacerAbstracto e implementa la interfaz MecanismoDeDeshacer.
 * 
 * @author <a href="mailto:mbx1030@alu.ubu.es">Mohammed Amine Belhadri</a>
 * @version 2.0
 */
public class MaquinaDelTiempoConJugadas extends MecanismoDeDeshacerAbstracto {

	/**
	 * Lista para almacenar el histórico de las jugadas realizadas durante la partida.
	 * Cada elemento de la lista representa una jugada realizada, permitiendo
	 * deshacer acciones previas o rehacer movimientos.
	 */
	private List<Jugada> historicoJugadas;


    /**
     * Constructor de MaquinaDelTiempoConJugadas.
     * 
     * @param fecha La fecha en la que se inicializa la máquina del tiempo.
     */
    public MaquinaDelTiempoConJugadas(Date fecha) {
        super(fecha);
        this.historicoJugadas = new ArrayList<>();
    }

    /**
     * Consulta el árbitro actual aplicando todas las jugadas almacenadas en el histórico.
     * 
     * @return Un clon del árbitro en su estado actual.
     */
    @Override
    public Arbitro consultarArbitroActual() {
        // Crear un nuevo árbitro en su estado inicial
        Tablero tableroInicial = new Tablero(); // Asumimos que hay un constructor vacío de Tablero.
        Arbitro arbitroActual = new Arbitro(tableroInicial);  // Constructor que requiere un tablero como argumento
        arbitroActual.colocarPiezasConfiguracionInicial();

        // Aplicar todas las jugadas almacenadas en el histórico
        for (Jugada jugada : historicoJugadas) {
            if (arbitroActual.esMovimientoLegal(jugada)) {
                arbitroActual.empujar(jugada);
                arbitroActual.cambiarTurno();
            }
        }

        return arbitroActual;
    }

    /**
     * Consulta el número de jugadas que se pueden deshacer.
     * 
     * @return El número de jugadas en el histórico.
     */
    @Override
    public int consultarNumeroJugadasEnHistorico() {
        return historicoJugadas.size();
    }

    /**
     * Deshace la última jugada realizada, eliminándola del histórico.
     */
    @Override
    public void deshacerJugada() {
        if (!historicoJugadas.isEmpty()) {
            historicoJugadas.remove(historicoJugadas.size() - 1);
        }
    }

    /**
     * Realiza una nueva jugada y la agrega al histórico.
     * 
     * @param jugada La jugada realizada.
     */
    @Override
    public void hacerJugada(Jugada jugada) {
        historicoJugadas.add(jugada);
    }

    /**
     * Obtiene la fecha de inicio de la máquina del tiempo.
     * 
     * @return La fecha de inicio.
     */
    @Override
    public Date obtenerFechaInicio() {
        return this.fechaInicio;
    }
}
