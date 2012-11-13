package roujo.lib.net.email;

public enum EmailProfile {
	Gmail("smtp.gmail.com", "jonathan.rouillard@gmail.com");
	
	public final String smtp_host;
	public final String smtp_user;
	
	private EmailProfile(String smtp_host, String smtp_user) {
		this.smtp_host = smtp_host;
		this.smtp_user = smtp_user;
	}
}
