package InterfazDeUsuario.StatePatternUI;

public interface UIStatesTransition extends UIStates{

    public void crearPartida();
    //DificultadBots ->Titulo

    public void elegirPersonaje(); 
    //Titulo -> SeleccionPersonaje
    //DatosPersonaje -> SeleccionPersonaje

    public void verDatosPersonaje();
    //SeleccionPersonaje ->DatosPersonaje

    public void elegirCiudad();
    //DatosPersonaje -> ElegirCiudad

    public void elegirNumeroBots();
    //ElegirCiudad -> Bots

    public void elegirDificultadBots();
    //Bots -> DificultadBots;
    
}
