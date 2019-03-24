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

    private Painting[] painting;
    private int size;
    
    public Environment(Painting[] painting) {
        this.painting = painting;
        Random r = new Random();
        this.size = r.nextInt(30)+1;
    }

    public Environment() {
        Random r = new Random();
        this.size = r.nextInt(100)+1;
        this.painting = new Painting[this.size];
        for(int i = 0; i < this.size; i++){
            this.painting[i].setDirty();            
        }
    }

    public Painting[] getPainting() {
        return this.painting;
    }

    public void setPainting(Painting[] painting) {
        this.painting = painting;
    }

    public int getSize() {
        return this.size;
    }
    
    public void printEnviroment(int position){
        
        for(int i = 0; i < size;i++){
            System.out.print(i == position ? "[ O ]" : "[ "+ this.painting[i].getIdentifier() +" ]");
        }
        System.out.println("\n");
        for(int i = 0; i < size;i++){
            System.out.print(this.painting[i].isDirty() ? "[ X ]" : "[ _ ]");
        }
    }

    
    
    
    
}
