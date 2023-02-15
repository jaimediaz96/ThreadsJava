package hilos;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author JAIME EDUARDO DIAZ TOBON
 */
public class Hilos extends JFrame {

    PanelSuperior jpSuperior;
    ArrayList<Thread> threads = new ArrayList<>();

    public Hilos() {
        setTitle("EJEMPLO HILOS");
        setSize(400, 400);
        setLocationRelativeTo(null);
        jpSuperior = new PanelSuperior();
        add(jpSuperior, BorderLayout.CENTER);
        JPanel jpInferior = new JPanel();
        JButton jbDale = new JButton("DALE");
        jbDale.addActionListener((e) -> {
            juego();
        });
        jpInferior.add(jbDale);
        JButton jbSalir = new JButton("SALIR");
        jbSalir.addActionListener((e) -> {
            System.exit(0);
        });
        jpInferior.add(jbSalir);
        JButton jbDetener = new JButton("DETENER");
        jbDetener.addActionListener((e) -> {
            detener();
        });
        jpInferior.add(jbDetener);
        add(jpInferior, BorderLayout.SOUTH);
    }

    private void juego() {
        Pelota pelota = new Pelota(20, 20, 20, 20, 5, 5);
        jpSuperior.add(pelota);
        Runnable r = new PelotaHilos(pelota, jpSuperior);
        Thread t = new Thread(r);
        threads.add(t);
        t.start();
    }

    private void detener() {
        // t.stop(); Obsoleto
        if (!threads.isEmpty())  {
            Thread threadToStop = threads.get(threads.size() - 1);
            threadToStop.interrupt();
            threads.remove(threadToStop);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Hilos marco = new Hilos();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}
