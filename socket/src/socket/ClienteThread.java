/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kennedy
 */

/* A thread serve para não bloquear o fluxo principal de informações
 *já que poderá haver mais de um cliente acessando ao servidor*/

public class ClienteThread extends Thread {
    
    private Socket socket;
    
    public ClienteThread(Socket socket){
        this.socket = socket;
    }
    
    //Execução em paralelo junto com o cliente
    @Override
    public void run(){
        InputStreamReader inputReader = null;
        try {
            inputReader = new InputStreamReader(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(ClienteThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader reader = new BufferedReader(inputReader);
        
        String r;
        try {
            while((r = reader.readLine())!=null){
                System.out.println("Cliente: " + r);
                
            }
        } catch (IOException ex) {
            Logger.getLogger(ClienteThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

