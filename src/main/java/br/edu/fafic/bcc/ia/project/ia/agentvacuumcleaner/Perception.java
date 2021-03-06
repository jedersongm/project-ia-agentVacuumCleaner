/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.fafic.bcc.ia.project.ia.agentvacuumcleaner;

/**
 *
 * @author Jéderson Martins
 * @email jedersongmoura@gmail.com
 */
public class Perception {

    private int identifier;
    private boolean dirty;

    public Perception(int identifier, boolean dirty) {
        this.identifier = identifier;
        this.dirty = dirty;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public boolean isDirty() {
        return dirty;
    }

    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Perception other = (Perception) obj;
        if (this.identifier != other.identifier) {
            return false;
        }
        if (this.dirty != other.dirty) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String st = (isDirty() ? "Sujo":"Limpo");
        return "[" + identifier + ","+st+"]";
    }
    
    
    
}
