package hilos;

import java.awt.Graphics;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.swing.JPanel;

/**
 *
 * @author JAIME EDUARDO DIAZ TOBON
 */
class PanelSuperior extends JPanel {
    
    // CopyOnWriteArrayList es una coleccion o una estructura de datos que permita la modificación concurrente
    CopyOnWriteArrayList<Pelota> pelotas = new CopyOnWriteArrayList<>();
    
    public void add(Pelota p) {
        pelotas.add(p);
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        pelotas.forEach((pelota) -> {
            g.fillOval(pelota.x, pelota.y, pelota.ancho, pelota.alto);
        });
    }
}
