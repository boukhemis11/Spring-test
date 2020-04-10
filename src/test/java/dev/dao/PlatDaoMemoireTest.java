package dev.dao;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.entite.Plat;
class PlatDaoMemoireTest {
  private PlatDaoMemoire platDaoMemoire;
  
  @BeforeEach
  void setUp() {
  this.platDaoMemoire = new PlatDaoMemoire();
  }

  @Test
  void listerPlatsVideALInitialisation() {
	  assertThat(platDaoMemoire.listerPlats().isEmpty());
  }

  @Test
  void ajouterPlatCasPassants() {
	  platDaoMemoire.ajouterPlat("couscous", 1200);
	  platDaoMemoire.ajouterPlat("tadjin", 1500);
	assertThat(platDaoMemoire.listerPlats()).containsOnly(new Plat("couscous", 1200),new Plat("tadjin", 1500));
  }
  
@Test
  void ajouterPlatCasPassantsv2() {
	  platDaoMemoire.ajouterPlat("couscous", 1200);
	assertThat(platDaoMemoire.listerPlats()).containsOnlyOnce(new Plat("couscous", 1200));
  }
}