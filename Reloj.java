/**
 * Clase Reloj con ciclos
 * Alumno: Ramirez Padron Angel Leonardo
 */


public class Reloj {
    private int horas;
    private int minutos;
    private int segundos;
    
    // Constructor
    public Reloj(int horas, int minutos, int segundos) {
        setHora(horas, minutos, segundos);
    }
    
    // Métodos para establecer la hora
    public void setHora(int horas, int minutos, int segundos) {
        if (horas >= 0 && horas < 24) {
            this.horas = horas;
        } else {
            this.horas = 0;
        }
        
        if (minutos >= 0 && minutos < 60) {
            this.minutos = minutos;
        } else {
            this.minutos = 0;
        }
        
        if (segundos >= 0 && segundos < 60) {
            this.segundos = segundos;
        } else {
            this.segundos = 0;
        }
    }
    
    // Incrementar el tiempo en 1 segundo
    public void incrementar() {
        segundos++;
        
        if (segundos >= 60) {
            segundos = 0;
            minutos++;
            
            if (minutos >= 60) {
                minutos = 0;
                horas++;
                
                if (horas >= 24) {
                    horas = 0;
                }
            }
        }
    }
    
    // Formatear la hora como HH:MM:SS
    public String getHoraFormateada() {
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }
    
    // Getters
    public int getHoras() {
        return horas;
    }
    
    public int getMinutos() {
        return minutos;
    }
    
    public int getSegundos() {
        return segundos;
    }
}