rem Generando la documentacion completa del proyecto NoventaGrados, incluyendo metodos y atributos privados.

rem Utilizamos el flag '-d' para especificar el directorio de salida 'doc', '-sourcepath' para indicar la ubicacion del codigo fuente,

rem '-subpackages' para incluir todos los subpaquetes del paquete principal 'noventagrados', y '-private' para incluir los elementos privados.

javadoc -d doc -sourcepath src -subpackages noventagrados -private

echo Documentacion generada exitosamente en el directorio 'doc'.

pause
