





import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;








public class text extends Frame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image planImage = GameUtil.getImage("img/plan.jpg");
	Image ball = GameUtil.getImage("img/ball.png");
	Image bg = GameUtil.getImage("img/bg.png");
	boolean life = true;
	
	Plan plane = new Plan(planImage,250,250);
	Shell[] shells = new Shell[50];
	
	public void paint(Graphics g){
	g.drawImage(bg, 0, 0, null);
	for(int i=0;i<20;i++){
		shells[i].draw(g);
		boolean dis = shells[i].getRect().intersects(plane.getRect());
		if(dis){
			life =false;
		}
	}
	if(life){
	plane.drawSelf(g);
	if(plane.right){
		plane.x+=plane.speed;
	}
	if(plane.up){
		plane.y-=plane.speed;
	}
	if(plane.down){
		plane.y+=plane.speed;
	}
	if(plane.left){
		plane.x-=plane.speed;
	}
	}
	
	
	}
	
	class PaintTherad extends Thread{
		public void run(){
			while(true){
				repaint();
				try { 
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	//���̼�������¼�
	class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			//System.out.println("����"+e.getKeyCode());
			plane.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			//sSystem.out.println("̧��"+e.getKeyCode());
			plane.minusDirection(e);
		}
		
		
	}
	
	
	public void lauchFrame(){
	
		this.setTitle("������ϰ��Ʒ");
		this.setVisible(true);
		this.setSize(500, 500);
		this.setLocation(700,300);
		
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);	 
		}
		});
		new PaintTherad().start();//�������ڵ��߳�
		addKeyListener(new KeyMonitor());//���Ӽ��̼���
		
		for(int i=0 ;i<50;i++){
			shells [i] =new Shell(ball);
			
		}
	}
	
	public static void main(String[] args) {
		text fir = new text();
		fir.lauchFrame();
		
		
	}
	//˫���弼������׽��ǰ���ݱ���ΪͼƬ���»��ƣ�
	private Image offimage = null;
	public void update(Graphics g){
		if(offimage==null){
			offimage = this.createImage(500,500);
		}
		Graphics gOff = offimage.getGraphics();
		paint(gOff);
		g.drawImage(offimage, 0, 0, null);
		
	}

}
