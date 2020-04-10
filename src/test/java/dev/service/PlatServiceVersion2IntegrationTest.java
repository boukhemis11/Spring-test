/**
 * 
 */
package dev.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.config.AppConfig;
import dev.dao.IPlatDao;
import dev.entite.Plat;

/**
 * @author boukh
 *
 */
@SpringJUnitConfig(classes = AppConfig.class) //@SpringJUnitConfig = @ExtendWith + @ContextConfiguration
@ActiveProfiles({ "memoire", "platServiceVersion2" })
public class PlatServiceVersion2IntegrationTest {
	 
	@Autowired
	private IPlatService platServiceVersion2;
	@Autowired
	private IPlatDao daoMemoire;
	
	@Test
    void ajouterPlat() {
		platServiceVersion2.ajouterPlat("couscous", 1200);
        assertThat(daoMemoire.listerPlats()).containsExactly(new Plat ("couscous", 1200) );
    }
}
