/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.fafic.bcc.ia.project.ia.agentvacuumcleaner;

import java.util.ArrayList;

/**
 *
 * @author Jéderson Martins
 * @email jedersongmoura@gmail.com
 */
public class Memory {

    private ArrayList<MemoryUnit> memory;

    public Memory(ArrayList<MemoryUnit> memory) {
        this.memory = memory;
    }

    public ArrayList<MemoryUnit> getMemory() {
        return memory;
    }

    public void setMemory(ArrayList<MemoryUnit> memory) {
        this.memory = memory;
    }
    
    public boolean isCrescent(int position){
        
        int n = this.memory.size();
        
        while(this.memory.get(n).getAction() != 1){
            n--;
        }
        return this.memory.get(n).getPerception().getIdentifier() < position;
    }
    
    public void updateMemory(Perception p, int action){
        this.memory.add(new MemoryUnit(p, action));
    }
    
    public void updateIdMemory(){
        
       for(MemoryUnit mu : this.memory){
           Perception p = mu.getPerception();
           int id = p.getIdentifier() + 1;
           p.setIdentifier(id);
           mu.setPerception(p);
       }
    }
}
 