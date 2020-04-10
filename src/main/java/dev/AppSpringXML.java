/**
 * 
 */
package dev;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dev.ihm.Menu;

/**
 * @author boukh
 *
 */
public class AppSpringXML {
	public static void main(String[] args) {
		  ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext
		("application-config-memoire.xml");
		// récupération du bean Menu
		  Menu menu = context.getBean(Menu.class);
		  menu.afficher();
		  // fermeture du Scanner
		  context.getBean(Scanner.class).close();
		  context.close();
	}
}
