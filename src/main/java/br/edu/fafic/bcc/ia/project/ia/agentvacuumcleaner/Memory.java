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
    
    
}
