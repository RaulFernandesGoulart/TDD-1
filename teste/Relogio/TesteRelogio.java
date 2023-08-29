package Relogio;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class  TesteRelogio{

 @Test
 public void testReiniciarMeiaNoite() {
     Relogio relogio = new Relogio();
     relogio.setHoras(10, 40, 00); // inicio aula Johnatan
     relogio.reiniciarRelogioParaMeiaNoite();
     assertEquals("00:00:00", relogio.ajustarHora(true));
 }
 
}
