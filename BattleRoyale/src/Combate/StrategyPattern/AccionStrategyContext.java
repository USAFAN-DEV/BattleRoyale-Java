package Combate.StrategyPattern;

public class AccionStrategyContext{
    private AccionStrategy strategy;
    public AccionStrategyContext(AccionStrategy strategy){
        this.strategy=strategy;
    }
    public void setStrategy(AccionStrategy strategy){
        this.strategy=strategy;
    }
    public AccionStrategy getStrategy(){
        return this.strategy;
    }
    public void accion(int opcion){
        strategy.accion(opcion);//delegacion
    }
 
}