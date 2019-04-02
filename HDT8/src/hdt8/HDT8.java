/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdt8;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 *
 * @author maria
 */
public class HDT8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        ArrayList<String> list = new ArrayList();
        VectorHeap<Paciente> heaPacientes = new VectorHeap<>();
        
        //Se lee el txt y se guarda cada linea en un array list
        try{
            Stream<String> lines = Files.lines(
                    Paths.get("pacientes.txt"),
                    StandardCharsets.UTF_8
            );
            
            lines.forEach(a -> list.add(a));
        } catch (IOException e){
            System.out.println("Error!");
        }
        
        
        //Guarda cada paciente en el heap
        for (int i = 0; i < list.size(); i++){
            String paci = (list.get(i));
            String[] datosPaci = paci.split(", ");
            Paciente paciente = new Paciente(datosPaci[0],datosPaci[1],datosPaci[2]);
            heaPacientes.add(paciente);
        }
        
        //Imprime el heap ya con los pacientes ordenado segun la prioridad
        System.out.print("\t\tPacientes por atender\n\n");
        int size = heaPacientes.size();
        int contador =1;    
        for (int c = 0;c<size;c++){
            System.out.println("Paciente #"+(c+1)+"    " + heaPacientes.getFirst().toString());
            heaPacientes.remove();
        }
        System.out.print("\n");
        
      
    }
    
}
