/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.fafic.bcc.ia.project.ia.agentvacuumcleaner;

import java.util.Random;

/**
 *
 * @author Jéderson Martins
 * @email jedersongmoura@gmail.com
 */
public class Environment {

    private Painting[] paintings;
    private int size;
    
    public Environment(Painting[] painting) {
        this.paintings = painting;
        Random r = new Random();
        this.size = r.nextInt(30)+1;
    }

    public Environment() {
        Random r = new Random();
        this.size = r.nextInt(30)+1;
        this.paintings = new Painting[size];
        for(int i = 0; i < this.size; i++){
            this.paintings[i] = new Painting();
        }
    }

    public Painting[] getPaintings() {
        return this.paintings;
    }

    public void setPaintings(Painting[] painting) {
        this.paintings = painting;
    }

    public int getSize() {
        return this.size;
    }
    
    public void printEnviroment(int position){
        
        for(int i = 0; i < size;i++){
            System.out.print(i == position ? "[ A ]" : "[ "+ this.paintings[i].getIdentifier() +" ]");
        }
        System.out.println("\n");
        for(int i = 0; i < size; i++){
            System.out.print(this.paintings[i].isDirty() ? "[ X ]" : "[ _ ]");
        }
        System.out.println("\n");
    }

    
    
    
    
}
