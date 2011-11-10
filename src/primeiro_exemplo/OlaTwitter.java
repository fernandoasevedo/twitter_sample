package primeiro_exemplo;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Tweet;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;


public class OlaTwitter {

	public void busca( String chave ) throws TwitterException{
		
		//Conectar ao Twitter
		Twitter twitter;
		TwitterFactory fabrica = new TwitterFactory();
		twitter = fabrica.getInstance();
		
		//Construir o mecanismo de busca
		Query q = new Query();		
		q.setQuery( chave );
				
		//Executar a Busca
		QueryResult resultado;
		resultado = twitter.search( q );
		
		//Imprimir o resultado
		for( Tweet t : resultado.getTweets() ){	
			if ( t.getToUser() == null ){
				System.out.println( t.getFromUser() ); //imprime quem mandou o tweet
			}else{
				
				System.out.println( t.getFromUser() + "->" + t.getToUser() );
			}
			
			System.out.println( t.getProfileImageUrl() );
			System.out.println( t.getText() );  //imprime o texto do tweet
			System.out.println("\n");
		}
		
		twitter.shutdown();
	}
	
	public static void main( String a[]){
		
		OlaTwitter ola = new OlaTwitter();
		try {
			
			ola.busca("#enacomp2011");
			
		} catch (TwitterException e) {			
			//e.printStackTrace();
			System.out.println("ops =/ que feio servidor você não pode fazer isso");
		}
	}
	
}
