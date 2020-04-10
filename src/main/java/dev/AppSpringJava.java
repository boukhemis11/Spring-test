/**
 * 
 */
package dev;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.config.AppConfig;
import dev.ihm.Menu;

/**
 * @author boukh
 *
 */
public class AppSpringJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		  AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		  Menu menu = context.getBean(Menu.class);
		  menu.afficher();

		  context.getBean(Scanner.class).close();

		  context.close();

	}

}
