package Relogio;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
import java.time.Clock;
import java.time.ZoneId;



@SuppressWarnings("unused")
public class Relogio {
 private int horas;
 private int minutos;
 private int segundos;

 public Relogio() {
     this.horas = 0;
     this.minutos = 0;
     this.segundos = 0;
 }

 //Pode ser programado com horas, minutos e segundos.
 public void setHoras(int horas, int minutos, int segundos) {
     this.horas = horas;
     this.minutos = minutos;
     this.segundos = segundos;
 }
 
//Pode ser reiniciado para meia noite a pedido do usuário
 public void reiniciarRelogioParaMeiaNoite() {
	 setHoras(0, 0, 0);
 }
//Pode marcar um intervalo de tempo. O usuário informa quando se inicia e quando  termina a marcação (função cronômetro) e o relógio responde o tempo decorrido.

 public class Cronometro {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Pressione Enter para iniciar o cronômetro...");
	        scanner.nextLine();

	        Instant startTime = Instant.now();

	        System.out.println("Pressione Enter novamente para parar o cronômetro...");
	        scanner.nextLine();

	        Instant endTime = Instant.now();

	        Duration elapsedTime = Duration.between(startTime, endTime);
	        long seconds = elapsedTime.getSeconds();
	        long millis = elapsedTime.toMillisPart();

	        System.out.println("Tempo decorrido: " + seconds + " segundos e " + millis + " milissegundos");

	        scanner.close();
	    }
	}
 
//Pode imprimir a hora no formato 24h ou AM/PM
 public class FormatoVinteEQuatro {
     
     public static void main(String[] args) {
         imprimirHora24h();
     }
     
     public static void imprimirHora24h() {
         Date agora = new Date();
         SimpleDateFormat formato24h = new SimpleDateFormat("HH:mm:ss");
         String hora24h = formato24h.format(agora);
         System.out.println("Hora no formato 24h: " + hora24h);
     }
     
    
 }


 // Não passa o tempo sozinho, mas atualiza corretamente o horário quando recebe indicação de passagem do tempo do Sistema Operacional. 
 public class CustomClockExample {
	    private static Clock customClock = Clock.systemDefaultZone();

	    public static void main(String[] args) {
	        try (Scanner scan = new Scanner(System.in)) {
				while (true) {
				    System.out.println("Pressione Enter para atualizar o relógio...");
				    scan.nextLine();

				    // Atualiza o relógio personalizado
				    Instant newInstant = Instant.now();
				    customClock = Clock.fixed(newInstant, ZoneId.systemDefault());

				    Instant currentTime = Instant.now(customClock);
				    System.out.println("Horário atualizado: " + currentTime);
				}
			}
	    }
	}
}
