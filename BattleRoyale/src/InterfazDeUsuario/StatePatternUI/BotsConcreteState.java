package InterfazDeUsuario.StatePatternUI;

import InterfazDeUsuario.UI;

public class BotsConcreteState implements UIStatesTransition{

    private UI ui;

    public BotsConcreteState(UI ui){

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
        
        this.ui.setEstadoUI(this.ui.getDificultadBotsConcreteState());

    }

    
    @Override
    public void process() {
        
        if(this.ui.getSolicitudCambioEstado().equals("Elegir dificultad bots")){

            this.elegirDificultadBots();

        }

    }
    
}
