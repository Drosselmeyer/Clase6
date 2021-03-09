/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.Clases;

/**
 *
 * @author Drosselmeyer
 */
public class Video {
    //Propiedades
    private String nombre;
    private String url;
    private long duracion; //En minutos
    
    public Video(String nombre, String url, long duracion){
        this.nombre = nombre;
        this.url = url;
        this.duracion = duracion;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return this.nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getDuracion() {
        return duracion;
    }

    public void setDuracion(long duracion) {
        this.duracion = duracion;
    }
    
    
    
}
