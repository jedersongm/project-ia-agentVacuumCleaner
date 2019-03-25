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
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Environment env = new Environment();
        
        Agent agent = new Agent();
        
        agent.init(env);
        //agent.setSizeEnv(agent.sizeEnvironment(env));
        //agent.getMemory().printMemory();
       agent.action(env);
    }
    

}
