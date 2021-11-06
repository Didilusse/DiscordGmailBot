package me.didilusse.discord;

import java.util.List;

import javax.security.auth.login.LoginException;

import me.didilusse.generalutils.FileUtils;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;



public class Bot {
	
	private Bot(String email, String password, String token) throws LoginException {
		JDABuilder.createDefault(token)
        .addEventListeners(new Listener())
        .setActivity(Activity.watching("Didilusse do dummy things haha"))
        .addEventListeners(new Ping(email, password))
		.build();
    }
	
	public static void main(String[] args) throws Exception {
		String token = null, email = null, password = null;
		try {
			List<String> data = FileUtils.loadFromFile(" ", "data.txt");
			for (String line : data) {
				if (line.startsWith("token: ")) token = line.substring(7);
				if (line.startsWith("email: ")) email = line.substring(7);
				if (line.startsWith("password: ")) password = line.substring(10);
			}
			if (token == null || email == null || password == null) {
				System.out.println("Missing data");
				return;
			}
	 		new Bot(email, password, token);
		} catch (Exception e) {
			System.out.println("Couldn't load data.txt");
			e.printStackTrace();
		}
    }
}
