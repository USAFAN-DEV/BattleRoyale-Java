package InterfazDeUsuario.StatePatternUI;

import InterfazDeUsuario.UI;

public class DificultadBotsConcreteState implements UIStatesTransition{

    private UI ui;

    public DificultadBotsConcreteState(UI ui){

        this.ui = ui;

    }

    @Override
    public void crearPartida() {
        
        this.ui.setEstadoUI(this.ui.getTituloConcreteState());

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'elegirDificultadBots'");
    }

    @Override
    public void process() {
        
        if(this.ui.getSolicitudCambioEstado().equals("Crear partida")){

            this.crearPartida();

        }

    }
    
}
