package application;
import application.graphic.MainMenu;

public class App 
{
	public static MainMenu mainMenu;
	public static void main( String[] args ) {
		mainMenu = new MainMenu();
		mainMenu.toggleVisible();
	}
}