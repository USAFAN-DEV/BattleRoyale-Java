package InterfazDeUsuario.StatePatternUI;

public interface UIStatesTransition extends UIStates{

    public void crearPartida();
    //pantallaDificultadBots -> pantallaTitulo

    public void elegirPersonaje(); 
    //pantallaTitulo -> pantallaSeleccionPersonaje
    //pantallaDatosPersonaje -> pantallaSeleccionPersonaje

    public void verDatosPersonaje();
    //pantallaSeleccionPersonaje -> pantallaDatosPersonaje

    public void elegirCiudad();
    //pantallaDatosPersonaje -> pantallaCiudad

    public void elegirNumeroBots();
    //pantallaCiudad -> pantallaBots

    public void elegirDificultadBots();
    //pantallaBots -> pantallaDificultadBots;
    
}
