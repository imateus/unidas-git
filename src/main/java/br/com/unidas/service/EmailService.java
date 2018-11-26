package br.com.unidas.service;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

import br.com.unidas.entity.Reserva;
import br.com.unidas.entity.Usuario;

public class EmailService {
	
	public boolean enviarEmail(Usuario usuario) {

		try {
            Email email = new SimpleEmail();
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("mateusxd20@gmail.com", "mateus10"));
            email.setSSLOnConnect(true);

            email.setFrom("mateusxd20@gmail.com", "Unidas"); // remetente
            email.setSubject("Recuperação de senha"); // assunto do e-mail
            email.setMsg("Olá "+usuario.getNome()+"\n Sua senha é: " + usuario.getSenha()); //conteudo do e-mail
            email.addTo(usuario.getEmail(), usuario.getNome()); //destinatário
            email.setSSL(true);
            email.send();
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
	public boolean enviarEmailReserva(Reserva reserva) {

		try {
            Email email = new SimpleEmail();
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("mateusxd20@gmail.com", "mateus10"));
            email.setSSLOnConnect(true);

            email.setFrom("mateusxd20@gmail.com", "Unidas"); // remetente
            email.setSubject("Confirmação de Reserva - Unidas"); // assunto do e-mail
            email.setMsg("Olá "+reserva.getUsuario().getNome()+"\n Reserva de número: " + reserva.getId() + " efetuada com sucesso!"); //conteudo do e-mail
            email.addTo(reserva.getUsuario().getEmail(), reserva.getUsuario().getNome()); //destinatário
            email.setSSL(true);
            email.send();
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}

}
