package Combate.StrategyPattern;

public interface JugadorAccionStrategy extends AccionStrategy {
    public void ataque();
    public void usarHabilidad();
    public void usarPociones();
}
