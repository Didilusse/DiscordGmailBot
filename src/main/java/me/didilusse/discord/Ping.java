package me.didilusse.discord;



import me.didilusse.email.*;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class Ping extends ListenerAdapter {
	
	
	
	@Override
	public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
		
		String[] message = e.getMessage().getContentRaw().split(" ");
		
		if(message.length == 1 && message[0].equalsIgnoreCase("!email")){
			try {
				
				int emails = JavaMailSearchInbox.check();
				
				System.out.println("Called Check");
				if(emails >= 1) {
					 e.getChannel().sendMessage("You have " + JavaMailSearchInbox.Unread + " unread email!").queue();
				}
				else {
					e.getChannel().sendMessage("You have no unread email!").queue();
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
		
		/*else if(message[0].equalsIgnoreCase("!calculate") && message[1].equalsIgnoreCase("add")){
            int num1 = Integer.parseInt(message[2]);
            int num2 = Integer.parseInt(message[3]);
            e.getChannel().sendMessage("The Result is: " + (num1 + num2)).queue();
        }else if(message[0].equalsIgnoreCase("!calculate") && message[1].equalsIgnoreCase("sub")){
            int num1 = Integer.parseInt(message[2]);
            int num2 = Integer.parseInt(message[3]);
            e.getChannel().sendMessage("The Result is: " + (num1 - num2)).queue();
        }*/
		
	}
	
}
