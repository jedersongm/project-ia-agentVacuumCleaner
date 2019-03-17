/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.bcc.ia.project.ia.agentvacuumcleaner;

import java.util.Random;

/**
 *
 * @author jeder
 */
public class Painting {
    
    private boolean dirty;
    private int identifier;

    public Painting(boolean dirty) {
        this.dirty = dirty;
        this.identifier = 0;
    }

    public Painting() {
        this.setDirty();
        this.identifier = 0;
    }

    public boolean isDirty() {
        return dirty;
    }

    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }
    
    public void setDirty(){
        Random r = new Random();
        this.dirty = r.nextBoolean();
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        String state = (this.isDirty() ? "Dirty" : "Clean");
        return "Painting{" + "ID=" + identifier + ", State=" + state + '}';
    }
    
    
    
    
    
}
