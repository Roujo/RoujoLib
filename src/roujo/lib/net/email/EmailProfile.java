package roujo.lib.net.email;

public enum EmailProfile {
	Gmail("smtp.gmail.com", "jonathan.rouillard@gmail.com", "derp");
	
	public final String smtp_host;
	public final String smtp_user;
	public final String smtp_pass;
	
	private EmailProfile(String smtp_host, String smtp_user, String smtp_pass) {
		this.smtp_host = smtp_host;
		this.smtp_user = smtp_user;
		this.smtp_pass = smtp_pass;
	}
}
