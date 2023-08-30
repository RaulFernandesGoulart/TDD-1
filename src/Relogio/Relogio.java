package Relogio;


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

 public void marcarIntervalo(int horaInicio, int minutoInicio, int segundoInicio,
                            int horaFim, int minutoFim, int segundoFim) {
     int segundosInicio = horaInicio * 3600 + minutoInicio * 60 + segundoInicio;
     int segundosFim = horaFim * 3600 + minutoFim * 60 + segundoFim;

     int segundosDecorridos = segundosFim - segundosInicio;
     int horasDecorridas = segundosDecorridos / 3600;
     segundosDecorridos %= 3600;
     int minutosDecorridos = segundosDecorridos / 60;
     segundosDecorridos %= 60;

     System.out.printf("Tempo decorrido: %02d:%02d:%02d%n",
             horasDecorridas, minutosDecorridos, segundosDecorridos);
 }
//Pode imprimir a hora no formato 24h ou AM/PM
 public String ajustarHora(boolean formato24h) {
     if (formato24h) {
         return String.format("%02d:%02d:%02d", horas, minutos, segundos);
     } else {
         String periodo = (horas >= 12) ? "PM" : "AM";
         int hora12h = (horas > 12) ? horas - 12 : (horas == 0) ? 12 : horas;
         return String.format("%02d:%02d:%02d %s", hora12h, minutos, segundos, periodo);
     }
 }

 // Não passa o tempo sozinho, mas atualiza corretamente o horário quando recebe indicação de passagem do tempo do Sistema Operacional. 
 public void passarTempo(int segundosPassados) {
     int segundosAtuais = horas * 3600 + minutos * 60 + segundos;
     segundosAtuais += segundosPassados;

     horas = segundosAtuais / 3600;
     segundosAtuais %= 3600;
     minutos = segundosAtuais / 60;
     segundosAtuais %= 60;
     segundos = segundosAtuais;
 }
}
