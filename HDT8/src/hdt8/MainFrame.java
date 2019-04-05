/*
 * Maria Ines Vasquez Figuera 18250  -   Paula Camila Gonzalez Ortega 18398
 * Estructura de Datos - Seccion 10
 * Este main utiliza un PriorityQueue de Pacientes para leer un txt y ordenar
 * los pacientes de acuerdo a la prioridad de su caso (orden alfabetico)
 */
//package hdt8;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.PriorityQueue;

/**
 *
 * @author Educho
 */
public class MainFrame {
    public static void main(String[] args) {
        
        System.out.println("Este Main es usando PriorityQueues para organizar los pacientes de un hospital \n");
         // Objetos a utilizar
        Scanner scan = new Scanner(System.in);
        ArrayList<String> list = new ArrayList();
        PriorityQueue<Paciente> queuePacientes = new PriorityQueue<>() ;
        
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
            queuePacientes.add(paciente);
        }
        
  
        //Imprime el heap ya con los pacientes ordenados segun la prioridad
        System.out.print("\t\tPacientes por atender\n\n");
        int size = queuePacientes.size();
        int contador =1;    
        for (int c = 0;c<size;c++){
            //System.out.println("Paciente #"+(c+1)+"    " + heaPacientes.getFirst().toString());
            System.out.print(queuePacientes.poll()+"\n");
        }
        System.out.print("\n");
       
    
    }
    
}
