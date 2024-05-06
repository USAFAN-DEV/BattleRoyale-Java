package Combate.StatePatternVida;

public interface LifeStateTransition extends LifeState{
    public void morir();
    public void revivir();
}
