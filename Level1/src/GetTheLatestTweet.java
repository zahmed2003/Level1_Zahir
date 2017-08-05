
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class GetTheLatestTweet implements MouseListener{
	
JFrame tweetWindow = new JFrame();
JPanel panel = new JPanel();
JButton button = new JButton();
JTextField text = new JTextField(20);
String search = "";


	public static void main(String[] args) 
	{
		 new GetTheLatestTweet().createUI();
		
		
	}
	
	public void  createUI()
	{
		tweetWindow.setVisible(true);
		tweetWindow.setTitle("The Amazing Tweet Retriever");
		tweetWindow.setSize(300,50);
		tweetWindow.add(panel);
		tweetWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
		panel.setVisible(true);
		
		panel.add(button);
		button.setText("Search the Twitterverse");
		button.addMouseListener(this);
		
		text.setBounds(19, 200, 50, 100);
		text.setVisible(true);
		text.setEditable(true);
		panel.add(text);
		tweetWindow.pack();
		
		
		
		
	}
	
	
	private List getLatestTweet(String searchingFor) {

		Twitter twitter = new TwitterFactory().getInstance();
		AccessToken accessToken = new AccessToken(
				"2453751158-IVD2VGZsvwZiRKxNe3Gs2lMjg30nvSkV1xSuPFf",
				"vBa5PjKfuMTK1LLBG51nCUI9r5d6Ph5cAHrS73spg6Nvu");
		twitter.setOAuthConsumer("YqeZdD2hYxOKv4QOkmp0i2djN",
				"6XUB1r8KXBvd8Pk9HHW3NgphMxHvHWBLAr5TihnckMU0ttyGST");
		twitter.setOAuthAccessToken(accessToken);

		Query query = new Query(searchingFor);
		try {
			QueryResult result = twitter.search(query);
			return result.getTweets();
		} catch (Exception e) {
			System.err.print(e.getMessage());
			return null;
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		if(buttonPressed == button)
		{
			System.out.println("tweet tweet");
			
			search = text.getText();
			System.out.println(getLatestTweet(search));
			
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
