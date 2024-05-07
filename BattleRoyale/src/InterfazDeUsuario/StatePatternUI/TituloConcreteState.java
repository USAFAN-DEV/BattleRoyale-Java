package InterfazDeUsuario.StatePatternUI;

import InterfazDeUsuario.UI;

public class TituloConcreteState implements UIStatesTransition{

    private UI ui;

    public TituloConcreteState(UI ui){

        this.ui = ui;

    }

    @Override
    public void crearPartida() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearPartida'");
    }

    @Override
    public void elegirPersonaje() {

        this.ui.setEstadoUI(this.ui.getSeleccionPersonajeConcreteState());

    }

    @Override
    public void verDatosPersonaje() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verDatosPersonaje'");
    }

    @Override
    public void elegirCiudad() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'elegirCiudad'");
    }

    @Override
    public void elegirNumeroBots() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'elegirNumeroBots'");
    }

    @Override
    public void elegirDificultadBots() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'elegirDificultadBots'");
    }

    @Override
    public void process() {
        
        if(this.ui.getSolicitudCambioEstado().equals("Seleccion personaje")){

            this.elegirPersonaje();

        }

    }
    
}
