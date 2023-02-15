package hilos;

/**
 *
 * @author JAIME EDUARDO DIAZ TOBON
 */
public class Pelota {
    
    int x, y, ancho, alto, vx, vy;
    
    public Pelota(int x, int y, int ancho, int alto, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.vx = vx;
        this.vy = vy;
    }
    
    public void mover(int maxx, int maxy) {
        if (x + ancho >= maxx || x <= 0) vx =-vx;
        if (y + alto >= maxy || y <= 0) vy = -vy;
        x+= vx;
        y+= vy;
    }
}
