package InterfazDeUsuario.StatePatternUI;

import InterfazDeUsuario.UI;

public class SeleccionPersonajeConcreteState implements UIStatesTransition{

    private UI ui;

    public SeleccionPersonajeConcreteState(UI ui){

        this.ui = ui;

    }

    @Override
    public void crearPartida() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearPartida'");
    }

    @Override
    public void elegirPersonaje() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'elegirPersonaje'");
    }

    @Override
    public void verDatosPersonaje() {
        
        this.ui.setEstadoUI(this.ui.getDatosPersonajeConcreteState());

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
        
        if(this.ui.getSolicitudCambioEstado().equals("Datos personaje")){

            this.verDatosPersonaje();

        }

    }
    
}
