import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;


public class Plan extends GameObject {
	
    int speed = 5;
	boolean left,right,up,down;
	
	public Plan(Image img,double x,double y){
		this.img = img;
		this.x = (int)x;
		this.y = (int)y;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
		
	}
	
	public void drawSelf(Graphics g){
		g.drawImage(img, (int)x, (int)y, null);
		
	}
	
	public void addDirection(KeyEvent e){
		switch(e.getKeyCode()){
		case 65:
			left = true;
			break;
		case 87:
			up = true;
			break;
		case 68:
			right = true;
			break;
		case 83:
			down = true;
			break;
		}
	}
	
	public void minusDirection(KeyEvent e){
		switch(e.getKeyCode()){
		case 65:
			left = false;
			break;
		case 87:
			up = false;
			break;
		case 68:
			right = false;
			break;
		case 83:
			down = false;
			break;
		}
	}
	
}
