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

    private ArrayList<MemoryUnit> unitsMemory;
    
    public Memory(){
        this.unitsMemory = new ArrayList<MemoryUnit>();
    }

    public Memory(ArrayList<MemoryUnit> unitsMemory) {
        this.unitsMemory = unitsMemory;
    }

    public ArrayList<MemoryUnit> getMemory() {
        return unitsMemory;
    }

    public void setMemory(ArrayList<MemoryUnit> unitsMemory) {
        this.unitsMemory = unitsMemory;
    }
    
    public boolean isCrescent(int position){
        
        int n = this.unitsMemory.size()-1;
        
        while(this.unitsMemory.get(n).getAction() != 1){
            n--;
        }
        return this.unitsMemory.get(n).getPerception().getIdentifier() < position;
    }
    
    public void updateMemory(Perception p, int action){
//        System.out.println("Salvando..."+p.toString());
        MemoryUnit mu = new MemoryUnit(p, action);
        this.unitsMemory.add(mu);
    }
    
    public void updateIdMemory(){
        
       for(MemoryUnit mu : this.unitsMemory){
           Perception p = mu.getPerception();
           int id = p.getIdentifier() + 1;
           p.setIdentifier(id);
           mu.setPerception(p);
       }
    }
    
    public boolean idIsClean(int id){
        int n = unitsMemory.size()-1;
        
        while(unitsMemory.get(n).getAction() != 2 || n == 0){
            if(unitsMemory.get(n).getAction() == 1 && unitsMemory.get(n).getPerception().equals(new Perception(id, false)))
                return (true && idIsClean(id - 1));
            n--;
        }
        return false;
    }
    
    public boolean idIsCleanDesc(int id){
        int n = unitsMemory.size()-1;
        
        if(noExistNoop()){
            while(n!=0){
                if(unitsMemory.get(n).getAction() == 1 && unitsMemory.get(n).getPerception().equals(new Perception(id, false)))
                    return (true && idIsCleanDesc(id + 1));
                n--;
            } 
        }else{
            while(unitsMemory.get(n).getAction() != 2){
                if(unitsMemory.get(n).getAction() == 1 && unitsMemory.get(n).getPerception().equals(new Perception(id, false)))
                    return (true && idIsCleanDesc(id + 1));
                n--;
            }        
        }
        return false;
    }
    
    public boolean noExistNoop(){
        
        for(MemoryUnit mu: unitsMemory){
            if(mu.getAction() == 2) return false;
        }
        return true;
    }
    
    public void printMemory(){
        System.out.println("Print Memory "+this.unitsMemory.size());
        for(int i = 0; i < this.unitsMemory.size(); i++){            
            System.out.println(this.unitsMemory.get(i).toString());
        }
    }
}
 