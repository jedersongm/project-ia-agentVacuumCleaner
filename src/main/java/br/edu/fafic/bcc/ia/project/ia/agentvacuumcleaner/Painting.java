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

    public Painting(boolean dirty) {
        this.dirty = dirty;
    }

    public Painting() {
        this.setDirty();
    }

    public boolean isirty() {
        return dirty;
    }

    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }
    
    public void setDirty(){
        Random r = new Random();
        this.dirty = r.nextBoolean();
    }
    
    
}
