import java.awt.Graphics;
import java.awt.Image;


public class Shell extends GameObject{
	double degree;
	
	public Shell(Image img){
		this.img = img;
		x = 200;
		y = 200;
		width = 5;
		height = 5;
		speed = 5;
		degree = Math.random()*Math.PI*2;
		

	
	}
	
	public void draw(Graphics g){
		
		g.fillOval((int)x,(int) y, width, height);
		g.drawImage(img, (int)x, (int)y, null);
		
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);
		
		if(x < 0 || x > 480){
			degree = Math.PI-degree;
		}
		if(y < 30||y > 480){
			degree = -degree;
		}
		
	}
} 
