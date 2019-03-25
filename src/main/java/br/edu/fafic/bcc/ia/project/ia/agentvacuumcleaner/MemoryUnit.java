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
 * 
 * ACTION
 * 0 - limpar
 * 1 - andar
 * 2 - noop
 */
public class MemoryUnit {

    private Perception perception;
    private int action;

    public MemoryUnit(Perception perception, int action) {
        this.perception = perception;
        this.action = action;
    }

    public Perception getPerception() {
        return perception;
    }

    public void setPerception(Perception perception) {
        this.perception = perception;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "MemoryUnit{ " +perception.toString() + ", action=" + action + '}';
    }
    
    
}
