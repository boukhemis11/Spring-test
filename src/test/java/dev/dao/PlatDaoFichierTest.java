/**
 * 
 */
package dev.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.entite.Plat;

/**
 * @author boukh
 *
 */

@SpringJUnitConfig(classes = PlatDaoFichier.class)
@TestPropertySource("classpath:test.properties") 
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ActiveProfiles({ "fichier" })

public class PlatDaoFichierTest {
	@Autowired
	private PlatDaoFichier platDaoFichier;
	
	@Test
    void ajouterPlat() {
		platDaoFichier.ajouterPlat("couscous", 1200);
        assertThat(platDaoFichier.listerPlats()).contains(new Plat("couscous", 1200));
    }
}
