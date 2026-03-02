package pe.com.intralot.loto.layer.model.bean;

import java.util.List;

public class Jugada {
    private String id;
    private List<Integer> bolillas;
    private int totalJugada;
    private boolean check;
    
    // Métodos getters y setters para acceder a los atributos privados
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public List<Integer> getBolillas() {
        return bolillas;
    }
    
    public void setBolillas(List<Integer> bolillas) {
        this.bolillas = bolillas;
    }
    
    public int getTotalJugada() {
        return totalJugada;
    }
    
    public void setTotalJugada(int totalJugada) {
        this.totalJugada = totalJugada;
    }
    
    public boolean isCheck() {
        return check;
    }
    
    public void setCheck(boolean check) {
        this.check = check;
    }
    
    @Override
    public String toString() {
      return "Jugada { id: " + id + ", bolillas: " + bolillas + ", totalJugada: " + totalJugada + ", check: " + check + " }";
    }
    
}
