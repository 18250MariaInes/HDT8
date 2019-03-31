/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdt8;

/**
 * pacientes que se guardan en al VH y se compararan de acuerdo a la prioridad de su caso
 * @author maria
 */
public class Paciente implements Comparable<Paciente>{
    private String nombre;
    private String caso;
    private String prioridad;

    /**
     *constructor de los pacientes que se guardan en al VH
     * @param n nombre
     * @param c caso
     * @param p prioridad
     */
    public Paciente (String n,String c,String p ){
        this.nombre=n;
        this.caso=c;
        this.prioridad=p;
    }
/**
 * metodo para comparar la prioridad entre dos paciente
 * @param o otro paciente
 * @return resultado de comparacion
 */
    @Override
    public int compareTo(Paciente o) {
        return prioridad.compareTo(o.prioridad);
    }
    
     public String toString() {
         return "Nombre "+nombre+" de prioridad "+prioridad;
     }
    
    
}
