package InterfazDeUsuario.StatePatternUI;

import InterfazDeUsuario.UI;

public class ElegirCiudadConcreteState implements UIStatesTransition{

    private UI ui;

    public ElegirCiudadConcreteState(UI ui){

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
        
        this.ui.setEstadoUI(this.ui.getBotsConcreteState());

    }

    @Override
    public void elegirDificultadBots() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'elegirDificultadBots'");
    }

    
    @Override
    public void process() {
        
        if(this.ui.getSolicitudCambioEstado().equals("Elegir bots")){

            this.elegirNumeroBots();

        }

    }

}
