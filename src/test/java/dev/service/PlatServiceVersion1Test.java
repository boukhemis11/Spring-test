/**
 * 
 */
package dev.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.dao.IPlatDao;
import dev.exception.PlatException;

import org.mockito.Mockito;
/**
 * @author boukh
 *
 */
public class PlatServiceVersion1Test {
	 private IPlatDao dao;
	 private PlatServiceVersion1 service1;
	 
		@BeforeEach
		public void setUp() {
			dao = Mockito.mock(IPlatDao.class);
			service1 = new PlatServiceVersion1(dao);
		}
		
		@Test
		void testAjouterPlatNomInvalide() {
			assertThatThrownBy(() -> {
				service1.ajouterPlat("B", 1200);
	        })
			.isInstanceOf(PlatException.class)
			.hasMessage("un plat doit avoir un nom de plus de 3 caractères");
		}
		
		@Test
	    void testAjouterPlatPrixInvalide() {

	        assertThatThrownBy(() -> {
	        	service1.ajouterPlat("kebab", 3);
	        })
	        .isInstanceOf(PlatException.class)
			.hasMessage("le prix d'un plat doit être supérieur à 5 €");
	    }
		
	    @Test
	    void testAjouterPlat() {

	    	service1.ajouterPlat("couscous", 1400);
	        
	        verify(dao).ajouterPlat("couscous", 1400);
	    }
}
