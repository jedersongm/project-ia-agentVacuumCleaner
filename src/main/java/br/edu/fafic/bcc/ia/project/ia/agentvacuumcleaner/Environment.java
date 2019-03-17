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
    private final int size;
    
    public Environment(Painting[] painting) {
        this.painting = painting;
        Random r = new Random();
        this.size = r.nextInt(100)+1;
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
        return painting;
    }

    public void setPainting(Painting[] painting) {
        this.painting = painting;
    }

    
    
    
    
}
