# BattleRoyale-Java
Proyecto elaborado por Nicolas Graullera y Eduardo Yánez.

Proyecto final de la asignatura programación orientada a objetos.
El proyecto se ha dividido en el desarrollo de los sistemas esenciales que lo componen. La primera parte que es el desarrollo del mapa lo ha elaborado Nicolas y yo me he encargado del Combate entre los personajes.

Voy a explicar en detalle cómo se ha creado el sistema de combate entre dos jugadores (Los dos archivos .java importantes son InterfazCombate.java y MetodoCombate.java). Primero obte por crear la interfaz. Emepece por algo sencillo, rellenar los bordes, tamaños, botones necesarios, etc. Lo que sería empezar por lo más general y después especificarme en cosas concretas como donde deberían estar situados los botones, sus dimensiones, fondos y más. 

Después de lograr una base y tener un primer ejemplo de como iba a ir quedando, empece a idear cómo tendría que implementar la funcionalidad de los botones, cómo debería actuar los bots, habilidad y pociones. Todas estas funciones serían implementadas en el fichero MetodoCombate.java, en el que recibe dos jugadores y son atributos privados por lo que declaramos los getter y setter necesarios para trabajar con los atributos de los jugadores. Este calcula el ataque que tiene que realizar cada jugador al contrario mediante la función Dmg() dependiendo de las estadísticas que tenga el personaje que se haya declarado en el mapa. La lógica del programa trata que el jugador 1 siempre realiza la acción primera y después el bot "elige una opción" mediante unos random declarados en la función Botmove(). Cuando el user selecciona Ataque el ActionListener lo registra y se ejecuta la funcion Ataque() entonces cada uno realiza sus turnos adecuadamente. 

A continuación tenemos la función Habilidad() en la que el jugador 1 usa la habilidad y despues el bot emplea lo que salga mediante el valor aleatorio; estas habilidades están definidas en cada uno de los personajes que proporciona el programa entonces como un atributo del jugador accedemos a ellos, después de usarlos van a tener un cooldown de 3 turnos tanto el bot como el player. El cooldown del jugador 1 se tiene que calcular en la interfaz de combate porque se tiene que desabilitar el boton el cual tu puedes seleccionar esa habilidad, mientras que la del bot se calcula adecuadamente en su función respectiva

La función de usarPociones(), en esta funcion vas a poder usar una funcion y te va a curar un total de 50 puntos de vida, si la vida supera el max de vida del personaje este se establece como el max de la vida del personaje, cada vez que se emplea una el n de pociones se reduce 1 hasta que el contador llegue a 0 que mostrará por pantalla que no queda ninguna.

Hay que resaltar que todos los acontecimientos del combate los muestro en consola por cada interacción que se realiza con los distintos botones que proporciona el programa. También se ha incluido un sleep de 3 segundos para dar una sensación real de combate y que se necesita tiempo para que el personaje realiza las opciones.

Destaco que se tuvo que crear una condición especial para uno de los personajes ya que su habilidad es bastante particular por lo que aparacerá tanto en los dos ficheros para que se cumpla las condiciones del personaje.

Por último, se ha añadido música para dar una ambientación buena al combate y se han declarado los atributos que consideramos necesarios para que las interacciones entre el mapa y la interfaz de combate función correctamente, no generen problemas y sea fluido para el usuario que está disfrutando con el juego.
