package application;

public enum UserGreetings {
	HELLO("sparkle lover"),
    HALLO("gem seeker"),
    HOLA("shine on"),
    BONJOUR("bling king/queen"),
    BUNA("sparkle enthusiast"),
    CIAO(" treasure hunter"),
    AHOI("diamond dazzler"),
    ALOHA("jewelry junkie"),
    ARIGATO("gem geniuss");

	private final String userHello;

	UserGreetings(String userHello) {
		this.userHello=userHello;
	}

	public String getUserHello() {
		return userHello;
	} 
}
