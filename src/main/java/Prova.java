
import it.bracco23.debugwindow.ErrorFrame;
import it.bracco23.jfunctions.Function;
import it.bracco23.jfunctions.Utility;
import java.io.*;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Emiddio
 */
public class Prova {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
       final ErrorFrame err=ErrorFrame.getErrorFrame(true);
        //err.setDefaultCloseOperation(ErrorFrame.EXIT_ON_CLOSE);
        
            new Thread(new Runnable(){

            @Override
            public void run() {
               throw new RuntimeException("Eccezione 1");
            }
                
            }, "Thread1").start();
            System.out.println("parte thread 1");
             new Thread(new Runnable(){

            @Override
            public void run() {
               err.setText("Thread2");
               throw new RuntimeException("Thread2");
            }
                
            }, "Thread2").start();
             
            System.out.println("parte thread 2");
            Thread.sleep(1500);
            System.out.println("Sto per chiudermi");
    }
}

