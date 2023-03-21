/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author kennedy
 */
public class Cliente {
    
    public static void main(String[] args) throws IOException {
        // Passando o host e a porta para conexão
        Socket socket = new Socket("localhost", 4000);
        Scanner scanner = new Scanner(System.in);
        
        // Saída de informações pelo teclado
        ClienteThread clienteThread = new ClienteThread(socket);
        clienteThread.start();
        PrintStream saida = new PrintStream(socket.getOutputStream());
        String keyboard = scanner.nextLine();
        saida.println(keyboard);
    }
}
