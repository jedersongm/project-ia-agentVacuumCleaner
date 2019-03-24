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
        this.memory =  new Memory(null);
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
    
    public void init(Environment environment){
        Random r = new Random();
        int cont = 0;
        setPosition(r.nextInt(environment.getSize()));
        
        Painting[] quadros = environment.getPainting();
          
        while(quadros[position-1] != null){
            cont++;
            if(quadros[position].isDirty())
                clear(quadros[position]);
            toLeft();
            for(int i = 0; i <= cont; i++){
                quadros[position+i].setIdentifier(i);           
            }            
        }     
        this.memory.updateIdMemory();
        environment.setPainting(quadros);
        setSizeEnv(sizeEnvironment(environment));
    }
    
    public int sizeEnvironment(Environment environment){
        int cont = 0;
        
        Painting[] quadros = environment.getPainting();
        
        do{
            if(quadros[cont].isDirty()){
                clear(quadros[cont]);
            }
            
            cont++;
        }while(quadros[position+1] != null);
        
        environment.setPainting(quadros);
       
        return cont++;
    }
    
    public void toMove(){        
       
        if(position == 0 || memory.isCrescent(position)){
            toRight();
        } else toLeft();
        
    }
    
    private void toRight() {
       System.out.println("Movendo "+ (this.position-1) + " <== "+ this.position + "\n");
       this.memory.updateMemory(new Perception(position, false), 1);
       this.position++;
    }
    
    private void toLeft() {
        
        System.out.println("Movendo "+ this.position + "==> "+ (this.position+1) + "\n");
        this.memory.updateMemory(new Perception(position, false), 1);
        this.position--;
    }
    
    
    public void clear(Painting painting){
        
        System.out.println("Limpando: "+painting.getIdentifier() + "\n");
        this.memory.updateMemory(new Perception(position, true), 0);
        painting.setDirty(false);
        
    }
    
    public void noop() throws InterruptedException{
        System.out.println("StandBy...\n");
        Thread.sleep(1000);
        
    }

    public void action(Environment environment) throws InterruptedException{
        
        environment.printEnviroment(position);
        
        int n = bestAction(this.position, environment);
          
        switch(n){        
            case 0: clear(environment.getPainting()[this.position]);
                break;
            case 1: toMove();
                break;
            case 2: noop();                
        }
        action(environment);
    }

    private int bestAction(int position, Environment environment) {
        
        if(this.memory.getMemory().get(this.memory.getMemory().size()-1).getAction() == 2){
            return 1;
        }
        if((position == 0 || position == this.sizeEnv-1) && isAllClean()) return 2;
        
        if(environment.getPainting()[position].isDirty()) return 0;
        
        return 1;
    }
    
    private boolean isAllClean( ){        
        if(this.memory.isCrescent(position)){
            return this.memory.idIsCleanDesc(position);
        }else return this.memory.idIsClean(position);        
    }
   
}
