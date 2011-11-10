package primeiro_exemplo;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

public class Perfil {

	public void imprimePerfil( String username ) throws TwitterException{
		
		//acessar o twitter
		Twitter twitter = new TwitterFactory().getInstance();
		
		//buscar o usuário
		User user;
		user = twitter.showUser( username );
		
		//imprimir coisas do usuário
		System.out.println( user.getScreenName() );
		System.out.println( user.getName() );
		System.out.println( user.getDescription() );
		System.out.println( user.getProfileImageURL() );
		
		String nome = user.getScreenName();
		String descricao = user.getDescription();
		URL url = user.getProfileImageURL();
		ImageIcon icon = new ImageIcon( url );
		String id = "" + user.getId();
		JOptionPane.showMessageDialog( null, nome +"\n" + descricao, id , 0, icon );
		//fechar a conexão		
		twitter.shutdown();
	}
	
	public static void main( String a[] ){
		
		Perfil p = new Perfil();
		try {
			p.imprimePerfil( "enacompufg");
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}
}
