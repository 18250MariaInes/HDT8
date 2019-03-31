/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdt8;

import java.util.Vector;

/**
 *clase VectoHeap donde se almacenan los paciente de acuerdo a su prioridad
 * extiende comparable e implementa PriorityQueue
 * extraido de canvas y el libro de texto
 * @author maria
 * @param <E>
 */
public class VectorHeap <E extends Comparable<E>> implements PriorityQueue<E> {

    /**
     *vector donde se guardaran los pacientes
     */
    protected Vector<E> data; // the data, kept in heap order
    
    /**
     *constructor default
     */
    public VectorHeap()// post: constructs a new priority queue
    {
        data = new Vector<E>();
    }

    /**
     *agrega otro vectorheap a uno ya existente
     * @param v
     */
    public VectorHeap(Vector<E> v){
        int i;
        data = new Vector<E>(v.size()); 
        for (i = 0; i < v.size(); i++){
            add(v.get(i));
        }
    }

    /**
     *agrega paciente al vectpr
     * @param value agregadp
     */
    public void add(E value){
        data.add(value);
        percolateUp(data.size()-1);
    }

    /**
     *mueve un nodo a su nueva y correcta posicion
     * @param leaf
     */
    protected void percolateUp(int leaf){
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 &&(value.compareTo(data.get(parent)) < 0)){
            data.set(leaf,data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf,value);
    }

    /**
     *retorna el padre de un determinado nodo
     * @param i numero de nodo
     * @return padre
     */
    protected static int parent(int i){
        return (i-1)/2;
    }

    /**
     *retorna la izquierda de un determinado nodo
     * @param i numero de nodo
     * @return izquierda
     */
    protected static int left(int i){
        return 2*i+1;
    }

    /**
     *retorna la derecha de un determinado nodo
     * @param i numero de nodo
     * @return derechya
     */
    protected static int right(int i){
        return (2*i+1) + 1;
    }

    /**
     *mueve un nodo a su nueva y correcta posicion pero moviendo la raiz
     * @param root
     */
    protected void pushDownRoot(int root)
	// pre: 0 <= root < size
	// post: moves node at index root down
	// to appropriate position in subtree
	{
		int heapSize = data.size();
		E value = data.get(root);
		while (root < heapSize) {
			int childpos = left(root);
			if (childpos < heapSize)
			{
				if ((right(root) < heapSize) &&
				((data.get(childpos+1)).compareTo
				(data.get(childpos)) < 0))
				{
					childpos++;
				}
			// Assert: childpos indexes smaller of two children
			if ((data.get(childpos)).compareTo
				(value) < 0)
			{
				data.set(root,data.get(childpos));
				root = childpos; // keep moving down
			} else { // found right location
				data.set(root,value);
				return;
			}
			} else { // at a leaf! insert and halt
				data.set(root,value);
				return;
			}
		}
	}

    /**
     *
     * @return primer valor del vector
     */
    public E getFirst(){
        return data.firstElement();
    }

    /**
     *remueve un paciente del vector
     * @return
     */
    public E remove(){
        E minVal = getFirst();
        data.set(0,data.get(data.size()-1));
        data.setSize(data.size()-1);
        if (data.size() > 1) pushDownRoot(0);
        return minVal;
    }

    /**
     * determina si esta vacio el Vector
     * @return tru or false
     */
    @Override
    public boolean isEmpty() {
         
        boolean empty = false;
        if (data.isEmpty()) { 
             empty = true;
        }
        
        return empty;
    }

    /**
     *determina el tammaño del vector
     * @return tamaño
     */
    @Override
    public int size() {
        return data.size(); 
    }

    /**
     *vacia el vector de paciente
     */
    @Override
    public void clear() {
        data.clear();
    }
}
