package application;
import application.graphic.MainMenu;

public class App 
{
	public static void main( String[] args ) {
		MainMenu mainMenu = new MainMenu();
		mainMenu.toggleVisible();
	}
}