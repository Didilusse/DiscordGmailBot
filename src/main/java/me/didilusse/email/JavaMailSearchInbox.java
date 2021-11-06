package me.didilusse.email;



import me.didilusse.discord.*;
import java.util.Arrays;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeUtility;
import javax.mail.search.FlagTerm;

import org.apache.commons.io.IOUtils;

public class JavaMailSearchInbox {
	
		public static int Unread = 0;
		 
		 
//		 public static String email = "didilusse@gmail.com";
//		 public static String password = "pellpommozblnbpj";
		 public static int check(String email, String password) throws Exception{
			 Session session = Session.getDefaultInstance(new Properties( ));
			    Store store = session.getStore("imaps");
			    store.connect("imap.googlemail.com", 993, email, password);
			    Folder inbox = store.getFolder( "INBOX" );
			    inbox.open( Folder.READ_ONLY );
			    

			    // Fetch unseen messages from inbox folder
			    Message[] messages = inbox.search(
			        new FlagTerm(new Flags(Flags.Flag.SEEN), false));
			    Unread =  messages.length;
			    if(messages.length >= 1) {
			    	System.out.println("You have " + messages.length + " unread email");
			    
			    }

			    // Sort messages from recent to oldest
			    Arrays.sort( messages, ( m1, m2 ) -> {
			      try {
			        return m2.getSentDate().compareTo( m1.getSentDate() );
			      } catch ( MessagingException e ) {
			        throw new RuntimeException( e );
			      }
			    } );

			    
			    return messages.length;
		 }
		 
		 /*for ( Message message : messages ) {
	    	
	    	
	    	String body = IOUtils.toString(
	                 MimeUtility.decode(message.getInputStream(), "quoted-printable"),
	                 "UTF-8"
	              );
	    	
	      System.out.println("sendDate: " + message.getSentDate() + " subject: " + message.getSubject());
	      
	      
	    }*/
}
