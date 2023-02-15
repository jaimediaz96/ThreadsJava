package hilos;

import java.awt.Component;

/**
 *
 * @author JAIME EDUARDO DIAZ TOBON
 */
public class PelotaHilos implements Runnable {
    
    Pelota pelota;
    Component panel;
    
    public PelotaHilos(Pelota pelota, Component panel) {
        this.pelota = pelota;
        this.panel = panel;
    }

    @Override
    public void run() {
        System.out.println("Estado del hilo al comenzar: " + Thread.currentThread().isInterrupted());
        // for (int i = 0; i < 3000; i++) {
        // while (!Thread.interrupted()) {
        while (!Thread.currentThread().isInterrupted()) {
            pelota.mover(panel.getWidth(), panel.getHeight());
            panel.paint(panel.getGraphics());
            try {
                Thread.sleep(4); // Bloquea los hilos, un hilo bloqueado no se puede interrumpir
            } catch (InterruptedException ex) {
                //System.out.println("ERROR" + ex);
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Estado del hilo al terminar: " + Thread.currentThread().isInterrupted());
    }
}
