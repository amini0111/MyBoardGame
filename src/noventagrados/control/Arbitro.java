package noventagrados.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import noventagrados.modelo.Celda;
import noventagrados.modelo.Jugada;
import noventagrados.modelo.Pieza;
import noventagrados.modelo.Tablero;
import noventagrados.util.Color;
import noventagrados.util.Coordenada;
import noventagrados.util.Sentido;
import noventagrados.util.TipoPieza;

/**
 * Clase que representa al árbitro del juego. Se encarga de gestionar el tablero,
 * las jugadas, el turno y el estado de las piezas durante la partida.
 * 
 * @author <a href="mailto:mbx1030@alu.ubu.es">Mohammed Amine Belhadri</a>
 * @since 1.0
 * @version 2.0
 */
public class Arbitro {

	/**
	 * Representa el tablero de juego que contiene las celdas y las piezas.
	 */
	private Tablero tablero;

	/**
	 * Lleva la cuenta del número de jugadas realizadas en la partida.
	 */
	private int numeroJugadas;

	/**
	 * Indica el turno actual, ya sea del jugador con piezas blancas o negras.
	 */
	private Color turnoActual;

	/**
	 * Caja que contiene las piezas blancas que han sido expulsadas del tablero.
	 */
	private Caja cajaPiezasBlancas;

	/**
	 * Caja que contiene las piezas negras que han sido expulsadas del tablero.
	 */
	private Caja cajaPiezasNegras;


    /**
     * Constructor de la clase Arbitro.
     * Inicializa el tablero, las cajas de piezas y el estado del juego.
     * 
     * @param tablero El tablero de juego.
     * @throws IllegalArgumentException Si el tablero es nulo.
     * 
     */
    public Arbitro(Tablero tablero) {
        if (tablero == null) {
            throw new IllegalArgumentException("El tablero no puede ser nulo.");
        }
        this.tablero = tablero;
        this.numeroJugadas = 0;
        this.turnoActual = null;
        this.cajaPiezasBlancas = new Caja(Color.BLANCO);
        this.cajaPiezasNegras = new Caja(Color.NEGRO);
    }

    /**
     * Cambia el turno actual al jugador contrario.
     */
    public void cambiarTurno() {
        turnoActual = (turnoActual == Color.BLANCO) ? Color.NEGRO : Color.BLANCO;
    }

    /**
     * Crea un clon del objeto Arbitro, replicando el estado del tablero,
     * el turno actual y las cajas de piezas.
     * 
     * @return Un nuevo objeto Arbitro idéntico al actual.
     */
    public Arbitro clonar() {
        Arbitro clon = new Arbitro(this.tablero.clonar());
        clon.numeroJugadas = this.numeroJugadas;
        clon.turnoActual = this.turnoActual;
        clon.cajaPiezasBlancas = this.cajaPiezasBlancas.clonar();
        clon.cajaPiezasNegras = this.cajaPiezasNegras.clonar();
        return clon;
    }

    /**
     * Coloca las piezas en el tablero según las coordenadas indicadas y establece el turno inicial.
     * 
     * @param piezas       Lista de piezas a colocar en el tablero.
     * @param coordenadas  Lista de coordenadas donde se colocarán las piezas.
     * @param turnoInicial El color del turno inicial.
     * @throws IllegalArgumentException Si alguna lista o el turno es nulo, o si el número de piezas y coordenadas no coincide.
     * 
     */
    public void colocarPiezas(List<Pieza> piezas, List<Coordenada> coordenadas, Color turnoInicial) {
        if (piezas == null || coordenadas == null || turnoInicial == null) {
            throw new IllegalArgumentException("Ningún argumento puede ser nulo.");
        }

        if (piezas.size() != coordenadas.size()) {
            throw new IllegalArgumentException("El número de piezas y coordenadas debe coincidir.");
        }

        // Colocar las piezas en el tablero
        for (int i = 0; i < piezas.size(); i++) {
            tablero.colocar(piezas.get(i), coordenadas.get(i));
        }

        // Inicializar el turno actual
        this.turnoActual = turnoInicial;
    }

    /**
     * Coloca las piezas en el tablero en la configuración inicial predeterminada.
     * Se añaden reinas y peones de ambos colores en las posiciones específicas del tablero.
     */
    public void colocarPiezasConfiguracionInicial() {
        List<Pieza> piezas = new ArrayList<>();
        List<Coordenada> coordenadas = new ArrayList<>();

        // Reina blanca
        piezas.add(new Pieza(TipoPieza.REINA, Color.BLANCO));
        coordenadas.add(new Coordenada(0, 0));

        // Reina negra
        piezas.add(new Pieza(TipoPieza.REINA, Color.NEGRO));
        coordenadas.add(new Coordenada(6, 6));

        // Peones blancos
        piezas.add(new Pieza(TipoPieza.PEON, Color.BLANCO));
        coordenadas.add(new Coordenada(0, 1));
        piezas.add(new Pieza(TipoPieza.PEON, Color.BLANCO));
        coordenadas.add(new Coordenada(0, 2));
        piezas.add(new Pieza(TipoPieza.PEON, Color.BLANCO));
        coordenadas.add(new Coordenada(0, 3));
        piezas.add(new Pieza(TipoPieza.PEON, Color.BLANCO));
        coordenadas.add(new Coordenada(1, 0));
        piezas.add(new Pieza(TipoPieza.PEON, Color.BLANCO));
        coordenadas.add(new Coordenada(2, 0));
        piezas.add(new Pieza(TipoPieza.PEON, Color.BLANCO));
        coordenadas.add(new Coordenada(3, 0));

        // Peones negros
        piezas.add(new Pieza(TipoPieza.PEON, Color.NEGRO));
        coordenadas.add(new Coordenada(3, 6));
        piezas.add(new Pieza(TipoPieza.PEON, Color.NEGRO));
        coordenadas.add(new Coordenada(4, 6));
        piezas.add(new Pieza(TipoPieza.PEON, Color.NEGRO));
        coordenadas.add(new Coordenada(5, 6));
        piezas.add(new Pieza(TipoPieza.PEON, Color.NEGRO));
        coordenadas.add(new Coordenada(6, 3));
        piezas.add(new Pieza(TipoPieza.PEON, Color.NEGRO));
        coordenadas.add(new Coordenada(6, 4));
        piezas.add(new Pieza(TipoPieza.PEON, Color.NEGRO));
        coordenadas.add(new Coordenada(6, 5));

        // Colocar las piezas en el tablero y asignar el turno inicial
        colocarPiezas(piezas, coordenadas, Color.BLANCO);
    }

    /**
     * Devuelve la caja de piezas correspondiente al color indicado.
     * 
     * @param color El color de la caja de piezas que se desea consultar.
     * @return La caja de piezas correspondiente al color.
     * @throws IllegalArgumentException Si el color de la caja no es válido.
     */
    public Caja consultarCaja(Color color) {
        if (color == Color.BLANCO) {
            return cajaPiezasBlancas;
        } else if (color == Color.NEGRO) {
            return cajaPiezasNegras;
        }
        throw new IllegalArgumentException("Color no válido: " + color);
    }

    /**
     * Devuelve el número de jugadas realizadas en la partida.
     * 
     * @return El número de jugadas realizadas.
     */
    public int consultarNumeroJugada() {
        return numeroJugadas;
    }

    /**
     * Devuelve una copia en profundidad del tablero actual.
     * 
     * @return Un clon del tablero actual.
     */
    public Tablero consultarTablero() {
        return tablero.clonar();
    }

    /**
     * Devuelve el color del turno actual.
     * 
     * @return El color del jugador que tiene el turno actual.
     */
    public Color consultarTurno() {
        return turnoActual;
    }

    /**
     * Consulta si hay un ganador en la partida.
     * 
     * @return El color del ganador si hay uno, o null si no hay ganador.
     */
    public Color consultarTurnoGanador() {
        TableroConsultor<Tablero> consultor = new TableroConsultor<>(tablero);

        // Inicializamos el color del ganador como null
        Color ganador = null;

        // Si no hay ninguna reina blanca ni negra en el tablero, no hay ganador
        if (consultor.hayReina(Color.BLANCO) || consultor.hayReina(Color.NEGRO)) {
            // Si la reina blanca no está en el tablero, gana negro
            if (!consultor.hayReina(Color.BLANCO)) {
                ganador = Color.NEGRO;
            }
            // Si la reina negra no está en el tablero, gana blanco
            else if (!consultor.hayReina(Color.NEGRO)) {
                ganador = Color.BLANCO;
            }
            // Si la reina blanca está en el centro, gana blanco
            else if (consultor.estaReinaEnElCentro(Color.BLANCO)) {
                ganador = Color.BLANCO;
            }
            // Si la reina negra está en el centro, gana negro
            else if (consultor.estaReinaEnElCentro(Color.NEGRO)) {
                ganador = Color.NEGRO;
            }
        }

        // Devuelve el ganador o null si no hay ganador
        return ganador;
    }

    /**
     * Realiza el movimiento de empujar una pieza en el tablero según la jugada indicada.
     * 
     * @param jugada La jugada que especifica el movimiento de las piezas.
     */
    public void empujar(Jugada jugada) {

        Coordenada origen = jugada.origen().consultarCoordenada();
        Coordenada destino = jugada.destino().consultarCoordenada();

        if (hayPiezaEntreOrigenYDestino(origen, destino)) {
            // Crear un consultor para realizar cálculos en el tablero
            TableroConsultor<Tablero> consultor = new TableroConsultor<>(tablero);

            // Obtener la pieza en la celda de origen
            Pieza piezaMovida = tablero.obtenerCelda(origen).consultarPieza();

            // Calcular sentido y distancia del movimiento
            Sentido sentido = consultor.calcularSentido(origen, destino);
            int distancia = sentido == Sentido.HORIZONTAL_E || sentido == Sentido.HORIZONTAL_O
                    ? consultor.consultarDistanciaEnHorizontal(origen, destino)
                    : consultor.consultarDistanciaEnVertical(origen, destino);

            // Mover las piezas intermedias
            moverPiezasIntermedias(consultor, origen, destino, sentido, distancia);

            // Mover la pieza principal
            tablero.eliminarPieza(origen);
            tablero.obtenerCelda(destino).colocar(piezaMovida);

        } else {
            // Obtener la pieza en la celda de origen
            Pieza piezaMovida = tablero.obtenerCelda(origen).consultarPieza();

            // Mover la pieza principal directamente de origen a destino
            tablero.eliminarPieza(origen);
            tablero.obtenerCelda(destino).colocar(piezaMovida);
        }

        // Incrementar el número de jugadas
        numeroJugadas++;
    }

    /**
     * Verifica si existe alguna pieza entre las coordenadas de origen y destino en el tablero.
     *
     * @param origen  Coordenada de origen desde la cual inicia el movimiento.
     * @param destino Coordenada de destino hacia la cual se realiza el movimiento.
     * @return true si hay al menos una pieza entre el origen y el destino, false en caso contrario.
     * 
     * Este método determina si hay alguna pieza entre dos puntos dados en el tablero.
     * Utiliza un objeto {@link TableroConsultor} para calcular la dirección del movimiento (horizontal o vertical).
     * Luego, verifica cada celda en la trayectoria entre el origen y el destino para ver si está ocupada.
     */
    private boolean hayPiezaEntreOrigenYDestino(Coordenada origen, Coordenada destino) {
        // Crear un consultor para realizar cálculos en el tablero
        TableroConsultor<Tablero> consultor = new TableroConsultor<>(tablero);

        // Obtener el sentido del movimiento (horizontal o vertical)
        Sentido sentido = consultor.calcularSentido(origen, destino);

        // Inicializar una variable para el resultado
        boolean piezaEncontrada = false;

        // Verificar si el movimiento es horizontal
        if (sentido == Sentido.HORIZONTAL_E || sentido == Sentido.HORIZONTAL_O) {
            int inicio = origen.columna();
            int fin = destino.columna();
            int paso = (inicio < fin) ? 1 : -1;

            for (int columna = inicio + paso; (paso == 1) ? columna <= fin : columna >= fin; columna += paso) {
                Coordenada coordenada = new Coordenada(origen.fila(), columna);
                Celda celda = tablero.consultarCelda(coordenada);

                if (celda != null && !celda.estaVacia()) {
                    piezaEncontrada = true;
                    // Si encontramos una pieza, no es necesario seguir buscando.
                }
            }
        }
        // Verificar si el movimiento es vertical
        else if (sentido == Sentido.VERTICAL_N || sentido == Sentido.VERTICAL_S) {
            int inicio = origen.fila();
            int fin = destino.fila();
            int paso = (inicio < fin) ? 1 : -1;

            for (int fila = inicio + paso; (paso == 1) ? fila <= fin : fila >= fin; fila += paso) {
                Coordenada coordenada = new Coordenada(fila, origen.columna());
                Celda celda = tablero.consultarCelda(coordenada);

                if (celda != null && !celda.estaVacia()) {
                    piezaEncontrada = true;
                    // Si encontramos una pieza, no es necesario seguir buscando.
                }
            }
        }

        // Retornar el resultado final
        return piezaEncontrada;
    }


    /**
     * Mueve las piezas intermedias entre las coordenadas de origen y destino siguiendo la trayectoria indicada.
     * Este método se utiliza cuando se necesita mover piezas que están en el camino del movimiento principal.
     *
     * @param consultor     Instancia de {@link TableroConsultor} para realizar cálculos sobre el tablero.
     * @param origen        Coordenada de origen del movimiento.
     * @param destino       Coordenada de destino del movimiento.
     * @param sentido       Sentido en el que se está realizando el movimiento (horizontal o vertical).
     * @param distancia     Distancia que se debe mover cada pieza en la trayectoria.
     * 
     * Este método obtiene las coordenadas intermedias a lo largo de la trayectoria entre las coordenadas de origen y destino,
     * y mueve las piezas una por una en dirección al sentido especificado. Cada pieza se mueve a una nueva coordenada calculada.
     * Si la nueva coordenada está fuera del tablero, la pieza se considera expulsada y se maneja apropiadamente.
     */
    private void moverPiezasIntermedias(TableroConsultor<Tablero> consultor, Coordenada origen, Coordenada destino,
                                        Sentido sentido, int distancia) {
        // Obtener las coordenadas intermedias a lo largo de la trayectoria entre origen y destino
        List<Coordenada> coordenadasIntermedias = obtenerPiezasEnTrayectoria(origen, destino);

        // Recorre las coordenadas de la trayectoria de atrás hacia adelante (última pieza primero)
        for (int i = coordenadasIntermedias.size() - 1; i >= 0; i--) {
            Coordenada intermedia = coordenadasIntermedias.get(i);
            Celda celdaIntermedia = tablero.obtenerCelda(intermedia);

            // Solo procesamos si la celda no está vacía
            if (!celdaIntermedia.estaVacia()) {
                Pieza pieza = celdaIntermedia.consultarPieza();

                // Calcular la nueva coordenada para la pieza
                Coordenada nuevaCoordenada = calcularNuevaCoordenada(intermedia, sentido, distancia);

                // Eliminar la pieza de la celda actual
                celdaIntermedia.eliminarPieza();

                // Verificar si la nueva coordenada está fuera del tablero
                if (!tablero.estaEnTablero(nuevaCoordenada)) {
                    manejarPiezaExpulsada(pieza); // Manejar la pieza expulsada
                } else {
                    // Colocar la pieza en la nueva celda
                    tablero.obtenerCelda(nuevaCoordenada).colocar(pieza);
                }
            }
        }
    }


    /**
     * Maneja la pieza expulsada del tablero, colocándola en la caja correspondiente según su color.
     * Este método se invoca cuando una pieza es expulsada del tablero y debe ser almacenada adecuadamente.
     *
     * @param pieza La pieza que ha sido expulsada del tablero.
     *
     * Este método determina el color de la pieza y la coloca en la caja de piezas correspondiente.
     * Si la pieza es de color blanco, se añade a la caja de piezas blancas.
     * Si la pieza es de color negro, se añade a la caja de piezas negras.
     */
    private void manejarPiezaExpulsada(Pieza pieza) {

        if (pieza.consultarColor() == Color.BLANCO) {
            cajaPiezasBlancas.añadir(pieza);
        } else if (pieza.consultarColor() == Color.NEGRO) {
            cajaPiezasNegras.añadir(pieza);
        }
    }


    /**
     * Obtiene una lista de las coordenadas de las piezas que se encuentran en la trayectoria entre dos coordenadas específicas.
     * Este método permite identificar las piezas que están situadas entre el punto de origen y el punto de destino,
     * teniendo en cuenta el sentido del movimiento (horizontal, vertical).
     *
     * @param origen  Coordenada de origen desde donde comienza la trayectoria.
     * @param destino Coordenada de destino hasta donde se extiende la trayectoria.
     * @return Una lista de las coordenadas de las piezas encontradas en la trayectoria entre origen y destino.
     *         La lista estará vacía si no hay piezas en el camino.
     *
     * El método utiliza un objeto {@link TableroConsultor} para calcular la dirección del movimiento
     * entre el origen y el destino, y luego obtiene todas las coordenadas de las piezas que se encuentran en esa trayectoria.
     */
    private List<Coordenada> obtenerPiezasEnTrayectoria(Coordenada origen, Coordenada destino) {
        // Lista para almacenar las coordenadas de las piezas encontradas en la trayectoria
        List<Coordenada> coordenadasEncontradas = new ArrayList<>();

        // Crear un consultor para realizar cálculos en el tablero
        TableroConsultor<Tablero> consultor = new TableroConsultor<>(tablero);

        // Obtener el sentido del movimiento
        Sentido sentido = consultor.calcularSentido(origen, destino);

        // Obtener las coordenadas de las piezas en la trayectoria según el sentido
        coordenadasEncontradas = obtenerPiezasEnTrayectoria(origen, sentido);

        return coordenadasEncontradas;
    }


    /**
     * Obtiene una lista de las coordenadas de las piezas que se encuentran en la trayectoria a partir de una coordenada de origen,
     * siguiendo una dirección determinada. La trayectoria se recorre en función del sentido del movimiento (horizontal o vertical)
     * y se limita por la cantidad de celdas vacías que se pueden atravesar.
     *
     * @param origen  Coordenada de origen desde donde comienza la trayectoria.
     * @param sentido Sentido del movimiento (puede ser horizontal o vertical).
     * @return Una lista con las coordenadas de las piezas encontradas a lo largo de la trayectoria desde el origen en la dirección indicada.
     *         La lista estará vacía si no se encuentran piezas en la trayectoria.
     *
     * El método verifica si la trayectoria es horizontal o vertical, y luego recorre las celdas desde la coordenada de origen
     * hasta el límite de la columna o fila, dependiendo de la dirección. Durante el recorrido, se almacenan las coordenadas
     * de las celdas que contienen piezas. Además, el método utiliza una variable para controlar el número de celdas vacías
     * permitidas antes de detener la búsqueda.
     */
    private List<Coordenada> obtenerPiezasEnTrayectoria(Coordenada origen, Sentido sentido) {
        // Lista para almacenar las coordenadas de las piezas encontradas en la trayectoria
        List<Coordenada> coordenadasEncontradas = new ArrayList<>();

        // Crear un consultor para realizar cálculos en el tablero
        TableroConsultor<Tablero> consultor = new TableroConsultor<>(tablero);

        // Variable para controlar el número de celdas vacías
        int celdasPermitidas = 0;

        // Verificar si el movimiento es horizontal
        if (sentido == Sentido.HORIZONTAL_E || sentido == Sentido.HORIZONTAL_O) {
            int inicio = origen.columna();
            int paso = (sentido == Sentido.HORIZONTAL_E) ? 1 : -1;

            // Número de piezas del mismo color en la columna perpendicular
            int piezasEnPerpendicular = consultor.consultarNumeroPiezasEnVertical(origen);

            // Determinar el fin de la trayectoria
            int fin = (sentido == Sentido.HORIZONTAL_E) ? tablero.consultarNumeroColumnas() - 1 : 0;

            // Recorre las celdas en la fila hasta encontrar el número de piezas permitido
            for (int columna = inicio + paso; (paso == 1) ? columna <= fin : columna >= fin; columna += paso) {
                Coordenada nuevaCoordenada = new Coordenada(origen.fila(), columna);
                Celda celda = tablero.consultarCelda(nuevaCoordenada);

                if (celda != null && !celda.estaVacia()) {
                    // Añadir la coordenada de la celda con pieza a la lista
                    coordenadasEncontradas.add(nuevaCoordenada);
                } else {
                    // Si se encuentra una celda vacía, incrementamos el contador
                    celdasPermitidas++;
                }

                // Si hemos recorrido tantas celdas vacías como piezas en perpendicular, terminamos
                if (celdasPermitidas == piezasEnPerpendicular) {
                    return coordenadasEncontradas;
                }
            }
        } else if (sentido == Sentido.VERTICAL_N || sentido == Sentido.VERTICAL_S) {
            int inicio = origen.fila();
            int paso = (sentido == Sentido.VERTICAL_S) ? 1 : -1;

            // Número de piezas del mismo color en la fila perpendicular
            int piezasEnPerpendicular = consultor.consultarNumeroPiezasEnHorizontal(origen);

            // Determinar el fin de la trayectoria
            int fin = (sentido == Sentido.VERTICAL_S) ? tablero.consultarNumeroFilas() - 1 : 0;

            // Recorre las celdas en la columna hasta encontrar el número de piezas permitido
            for (int fila = inicio + paso; (paso == 1) ? fila <= fin : fila >= fin; fila += paso) {
                Coordenada nuevaCoordenada = new Coordenada(fila, origen.columna());
                Celda celda = tablero.consultarCelda(nuevaCoordenada);

                if (celda != null && !celda.estaVacia()) {
                    // Añadir la coordenada de la celda con pieza a la lista
                    coordenadasEncontradas.add(nuevaCoordenada);
                } else {
                    // Si se encuentra una celda vacía, incrementamos el contador
                    celdasPermitidas++;
                }

                // Si hemos recorrido tantas celdas vacías como piezas en perpendicular, terminamos
                if (celdasPermitidas == piezasEnPerpendicular) {
                    return coordenadasEncontradas;
                }
            }
        }

        // Llamada a otro método para verificar piezas en la perpendicular
        Color colorPiezaMovida = tablero.consultarCelda(origen).consultarPieza().consultarColor();
        obtenerPiezasEnPerpendicular(origen, sentido, consultor, colorPiezaMovida);

        return coordenadasEncontradas;
    }



    /**
     * Método auxiliar que consulta cuántas piezas del mismo color que la pieza movida están en la dirección perpendicular.
     * Este método se utiliza para contar las piezas que se encuentran en la columna o fila perpendicular al movimiento
     * realizado, verificando si son del mismo color que la pieza que se movió originalmente.
     *
     * @param origen            La coordenada de origen desde la cual se realiza la consulta de las piezas en la perpendicular.
     * @param sentido           El sentido del movimiento que se realizó (horizontal o vertical).
     * @param consultor         Un objeto de tipo {@link TableroConsultor} utilizado para realizar cálculos en el tablero.
     * @param colorPiezaMovida  El color de la pieza movida, para verificar cuántas piezas del mismo color se encuentran en la perpendicular.
     * @return El número de piezas del mismo color que se encuentran en la dirección perpendicular a la coordenada de origen.
     *         El valor retornado incluye todas las piezas que se encuentran a lo largo de la dirección perpendicular.
     *
     * El método primero determina si el movimiento fue horizontal o vertical y luego recorre las celdas en la perpendicular 
     * (ya sea columna o fila) a partir de la coordenada de origen. Si encuentra una pieza, se verifica su color y, si es del mismo 
     * color que la pieza original, se incrementa el contador de piezas en la perpendicular.
     */
    private int obtenerPiezasEnPerpendicular(Coordenada origen, Sentido sentido, TableroConsultor<Tablero> consultor, Color colorPiezaMovida) {
        int piezasEnPerpendicular = 0;

        // Si el movimiento es horizontal, verificamos las piezas en la misma columna
        if (sentido == Sentido.HORIZONTAL_E || sentido == Sentido.HORIZONTAL_O) {
            piezasEnPerpendicular = consultor.consultarNumeroPiezasEnVertical(origen);

            for (int fila = 0; fila < tablero.consultarNumeroFilas(); fila++) {
                Coordenada coordenada = new Coordenada(fila, origen.columna());
                Celda celda = tablero.consultarCelda(coordenada);
                if (celda != null && !celda.estaVacia()) {
                    Pieza pieza = celda.consultarPieza();
                    // Verificamos que la pieza sea del mismo color que la pieza movida
                    if (pieza.consultarColor() == colorPiezaMovida) {
                        piezasEnPerpendicular++;
                    }
                }
            }
        }

        // Si el movimiento es vertical, verificamos las piezas en la misma fila
        if (sentido == Sentido.VERTICAL_N || sentido == Sentido.VERTICAL_S) {
            piezasEnPerpendicular = consultor.consultarNumeroPiezasEnHorizontal(origen);

            for (int columna = 0; columna < tablero.consultarNumeroColumnas(); columna++) {
                Coordenada coordenada = new Coordenada(origen.fila(), columna);
                Celda celda = tablero.consultarCelda(coordenada);
                if (celda != null && !celda.estaVacia()) {
                    Pieza pieza = celda.consultarPieza();
                    // Verificamos que la pieza sea del mismo color que la pieza movida
                    if (pieza.consultarColor() == colorPiezaMovida) {
                        piezasEnPerpendicular++;
                    }
                }
            }
        }

        return piezasEnPerpendicular;
    }


    /**
     * Calcula la nueva coordenada de una pieza a partir de la coordenada actual, el sentido del movimiento y la distancia a recorrer.
     * Este método se utiliza para determinar la nueva posición de una pieza que se desplaza sobre el tablero en la dirección especificada.
     *
     * @param actual   La coordenada actual de la pieza antes de realizar el movimiento.
     * @param sentido  El sentido del movimiento que la pieza realizará (horizontal, vertical, etc.).
     * @param distancia La distancia a recorrer en la dirección del movimiento.
     * @return La nueva coordenada a la que se moverá la pieza, calculada en función de la coordenada de origen, 
     *         el sentido del movimiento y la distancia especificada.
     *
     * El método utiliza el sentido del movimiento para determinar cuánto desplazarse en términos de filas y columnas.
     * Luego calcula una nueva instancia de {@link Coordenada} que representa la nueva ubicación de la pieza.
     */
    private Coordenada calcularNuevaCoordenada(Coordenada actual, Sentido sentido, int distancia) {
        Coordenada nuevaCoordenada = new Coordenada(
                actual.fila() + (sentido.consultarDesplazamientoEnFilas() * distancia),
                actual.columna() + (sentido.consultarDesplazamientoEnColumnas() * distancia));

        return nuevaCoordenada;
    }


    /**
     * Verifica si el movimiento especificado en la jugada es legal de acuerdo con las reglas del juego.
     *
     * Este método valida si el movimiento propuesto se realiza dentro del tablero, corresponde al turno del jugador actual,
     * y respeta las restricciones de movimiento en dirección horizontal o vertical.
     * Se asegura también que la distancia del movimiento sea igual al número de piezas presentes en la dirección perpendicular.
     *
     * @param jugada La jugada a verificar, que contiene las coordenadas de origen y destino.
     * @return {@code true} si el movimiento es legal, {@code false} en caso contrario.
     * 
     * El método analiza las coordenadas de la jugada, comprueba que la partida no ha finalizado, que el origen y destino están
     * dentro del tablero, que la celda de origen contiene una pieza válida, y que el movimiento corresponde al turno actual.
     */
    public boolean esMovimientoLegal(Jugada jugada) {
        // Obtener coordenadas de origen y destino
        Coordenada origen = jugada.origen().consultarCoordenada();
        Coordenada destino = jugada.destino().consultarCoordenada();

        // Inicializar resultado como falso por defecto
        boolean esLegal = false;

        // Verificar condiciones iniciales
        if (!estaFinalizadaPartida() && tablero.estaEnTablero(origen) && tablero.estaEnTablero(destino)) {

            Celda celdaOrigen = tablero.consultarCelda(origen);

            // Verificar que la celda origen contiene una pieza válida
            if (celdaOrigen != null && !celdaOrigen.estaVacia()) {
                Pieza piezaOrigen = celdaOrigen.consultarPieza();

                // Verificar turno y movimiento horizontal/vertical
                boolean esMovimientoHorizontal = origen.fila() == destino.fila();
                boolean esMovimientoVertical = origen.columna() == destino.columna();

                if (piezaOrigen.consultarColor() == turnoActual && (esMovimientoHorizontal || esMovimientoVertical)) {

                    // Calcular piezas en la dirección perpendicular y distancia
                    TableroConsultor<Tablero> consultor = new TableroConsultor<>(tablero);
                    int numeroPiezasEnPerpendicular = esMovimientoHorizontal
                            ? consultor.consultarNumeroPiezasEnVertical(origen)
                            : consultor.consultarNumeroPiezasEnHorizontal(origen);
                    int distanciaMovimiento = esMovimientoHorizontal ? Math.abs(destino.columna() - origen.columna())
                            : Math.abs(destino.fila() - origen.fila());

                    // Validar si la distancia coincide con el número de piezas
                    esLegal = distanciaMovimiento == numeroPiezasEnPerpendicular;
                }
            }
        }

        return esLegal;
    }


    /**
     * Verifica si la partida ha finalizado, ya sea porque hay un ganador o porque no quedan reinas en el tablero, lo cual resulta en empate.
     *
     * @return {@code true} si la partida ha finalizado (hay un ganador o es empate), {@code false} en caso contrario.
     * 
     * El método comprueba si hay un ganador consultando el turno del ganador. Si no hay reinas de ningún color en el tablero,
     * también considera que la partida ha finalizado en empate.
     */
    public boolean estaFinalizadaPartida() {
        // Consultar el ganador actual
        Color ganador = consultarTurnoGanador();

        // Verificar si hay un ganador o si la partida ha terminado en empate
        TableroConsultor<Tablero> consultor = new TableroConsultor<>(tablero);

        // Si el resultado no es null (hay un ganador) o si no hay reinas de ningún color (empate)
        boolean partidaFinalizada = (ganador != null) || (!consultor.hayReina(Color.BLANCO) && !consultor.hayReina(Color.NEGRO));

        return partidaFinalizada; // La partida ha finalizado si hay un ganador o empate
    }


    /**
     * Calcula el valor hash del objeto {@code Arbitro}, tomando en cuenta las propiedades clave.
     *
     * @return El valor hash calculado del objeto {@code Arbitro}.
     * 
     * Este método se utiliza para permitir el almacenamiento del objeto en estructuras que dependen de valores hash,
     * como {@link java.util.HashSet} y {@link java.util.HashMap}.
     */
    @Override
    public int hashCode() {
        return Objects.hash(cajaPiezasBlancas, cajaPiezasNegras, numeroJugadas, tablero, turnoActual);
    }


    /**
     * Compara el objeto actual con otro objeto para determinar si son iguales.
     *
     * @param obj El objeto a comparar con el objeto actual.
     * @return {@code true} si ambos objetos son iguales, {@code false} en caso contrario.
     * 
     * El método compara todas las propiedades del objeto {@code Arbitro} para determinar si tienen los mismos valores.
     * Esto asegura que dos instancias de {@code Arbitro} son iguales si tienen los mismos valores en las propiedades claves.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Arbitro other = (Arbitro) obj;
        return Objects.equals(cajaPiezasBlancas, other.cajaPiezasBlancas)
                && Objects.equals(cajaPiezasNegras, other.cajaPiezasNegras) && numeroJugadas == other.numeroJugadas
                && Objects.equals(tablero, other.tablero) && turnoActual == other.turnoActual;
    }


    /**
     * Genera una representación en forma de cadena del objeto {@code Arbitro}, que incluye todos sus atributos.
     *
     * @return Una cadena que representa el objeto {@code Arbitro}, mostrando el tablero, número de jugadas,
     * el turno actual, y las cajas de piezas blancas y negras.
     * 
     * Este método es útil para depuración y para proporcionar una vista legible del estado actual del objeto {@code Arbitro}.
     */
    @Override
    public String toString() {
        return "Arbitro [tablero=" + tablero + ", numeroJugadas=" + numeroJugadas + ", turnoActual=" + turnoActual
                + ", cajaPiezasBlancas=" + cajaPiezasBlancas + ", cajaPiezasNegras=" + cajaPiezasNegras + "]";
    }


}
