package StatePatternMapa;

public interface MapaStatesTransition extends MapaStates{
    
    public void empezarPartida(); //Transicion a estado jugar
    public void pausarPartida(); //Transicion a estado pausa
    public void empezarCombate(); //Transicion a estado combate
    public void terminarPartida(); //Transicion a estado muerte
    public void ganarPartida(); //Transicion a estado victoria
    public void volverAJugar(); //Transicion a pantallaInicio

}
