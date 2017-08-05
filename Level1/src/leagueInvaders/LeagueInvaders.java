package leagueInvaders;
import javax.swing.JFrame;

public class LeagueInvaders {

	static JFrame frame = new JFrame();
	final int width = 500;
	final int height = 800;
	
	public static void main(String[] args)
	{
		LeagueInvaders lInvaders = new LeagueInvaders(frame);

	}
	
	public LeagueInvaders(JFrame frame)
	{
		LeagueInvaders.frame = frame;
		setup();
	}
	
	public void setup()
	{
		frame.setSize(width, height);
		frame.setVisible(true);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		 
	}

}
