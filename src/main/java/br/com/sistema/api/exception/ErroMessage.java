package br.com.sistema.api.exception;

public class ErroMessage {

	private String msgUsuario;
	private String msgDesenvolvedor;
	
	public ErroMessage(String msgUsuario, String msgDesenvolvedor) {
		this.msgUsuario = msgUsuario;
		this.msgDesenvolvedor = msgDesenvolvedor;
	}
	
	public String getMsgUsuario() {
		return msgUsuario;
	}
	public void setMsgUsuario(String msgUsuario) {
		this.msgUsuario = msgUsuario;
	}
	public String getMsgDesenvolvedor() {
		return msgDesenvolvedor;
	}
	public void setMsgDesenvolvedor(String msgDesenvolvedor) {
		this.msgDesenvolvedor = msgDesenvolvedor;
	}

}
