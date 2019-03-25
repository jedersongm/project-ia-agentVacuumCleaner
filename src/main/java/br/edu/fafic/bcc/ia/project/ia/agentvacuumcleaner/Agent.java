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
public class Agent {

    private int position, sizeEnv;
    private Memory memory;
    

    public Agent() {
            
        this.position = 0;
        this.sizeEnv = 0;
        this.memory =  new Memory();
    }

    

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    
    public int getSizeEnv(){
        return sizeEnv;
    }
    
    public void setSizeEnv(int sizeEnv){
        this.sizeEnv = sizeEnv;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }
    
    
    
    public void init(Environment environment){
        Random r = new Random();
        int cont = 0;
        setPosition(r.nextInt(environment.getSize()));
        environment.printEnviroment(position);
        Painting[] quadros = environment.getPaintings();
          
        while(position != 0){
            cont++;
            if(quadros[position].isDirty()){
                clear(quadros[position]);
            }                
            toLeft(environment);
            for(int i = 0; i <= cont; i++){
                quadros[position+i].setIdentifier(i);           
            }
            this.memory.updateIdMemory();
        }     
        
        environment.setPaintings(quadros);        
        environment.printEnviroment(position);
        int tam = sizeEnvironment(environment);        
        this.setSizeEnv(tam);
        memory.printMemory();
    }
    
    public int sizeEnvironment(Environment environment){
        int cont = 0;
        this.memory.printMemory();
        environment.printEnviroment(position);
        Painting[] quadros = environment.getPaintings();
                
        while(cont < environment.getSize()){
            quadros[cont].setIdentifier(cont);
            if(quadros[cont].isDirty()){
                clear(quadros[cont]);
            }
            if(cont != environment.getSize()-1)
                toRight(environment);
            cont++;
        }
        
        environment.setPaintings(quadros);
        environment.printEnviroment(position);
       
        return cont++;
    }
    
    public void toMove(Environment environment){        
       
        if(position == 0)
            toRight(environment);
        if(position == getSizeEnv()-1)
            toLeft(environment);
        if(memory.isCrescent(position))
            toRight(environment);        
        if(memory.isCrescent(position) == false)
             toLeft(environment);
        
    }
    
    private void toRight(Environment environment) {
       System.out.println("Movendo "+ (this.position) + " ==> "+ (this.position+1) + "\n");
       this.memory.updateMemory(new Perception(environment.getPaintings()[position].getIdentifier(), false), 1);
       this.position++;
    }
    
    private void toLeft(Environment environment) {
        
        System.out.println("Movendo "+ (this.position-1) + " <== "+ (this.position) + "\n");
        this.memory.updateMemory(new Perception(environment.getPaintings()[position].getIdentifier(), false), 1);
        
        this.position--;
    }
    
    
    public void clear(Painting painting){
        
        System.out.println("Limpando: "+painting.getIdentifier() + "\n");
        this.memory.updateMemory(new Perception(painting.getIdentifier(), true), 0);
        painting.setDirty(false);
        
    }
    
    public void noop(Environment environment) throws InterruptedException{
        System.out.println("StandBy...\n");
        this.memory.updateMemory(new Perception(environment.getPaintings()[position].getIdentifier(), false), 2);
        Thread.sleep(1000);
        
    }

    public void action(Environment environment) throws InterruptedException{
        
        environment.printEnviroment(position);
        System.out.println("Actioon");
        int n = bestAction(this.position, environment);
          
        switch(n){        
            case 0: clear(environment.getPaintings()[this.position]);
                break;
            case 1: toMove(environment);
                break;
            case 2: noop(environment);                
        }
        action(environment);
    }

    private int bestAction(int position, Environment environment) {
        memory.printMemory();
         if(this.memory.getMemory().get(this.memory.getMemory().size()-1).getAction() == 2){
            return 1;
        }       
        
        if((position == 0 || position == sizeEnv-1)) return 2;      
                       
        if(environment.getPaintings()[position].isDirty()) return 0;
        
        return 1;
    }
    
    private boolean isAllClean( ){        
        if(this.memory.isCrescent(position)){
            return this.memory.idIsCleanDesc(position);
        }else return this.memory.idIsClean(position);        
    }
   
}
