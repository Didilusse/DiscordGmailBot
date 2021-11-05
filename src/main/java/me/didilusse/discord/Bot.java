package me.didilusse.discord;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;



public class Bot {

	
	private Bot() throws LoginException {
		
		JDABuilder.createDefault("ENTER BOT TOKEN HERE")
        .addEventListeners(new Listener())
        .setActivity(Activity.watching("Didilusse"))
        .addEventListeners(new Ping())
		.build();
		
    }
	
	public static void main(String[] args) throws LoginException {
        new Bot();
        
    }

	
	
	
	
    
}
