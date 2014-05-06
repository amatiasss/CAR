package formulario.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.CampoVazioInvalidoException;
import facade.Facade;
import formulario.logic.Formulario;
import formulario.outro.logic.FormularioOutro;
import formulario.servico.logic.FormularioServico;
import formulario.servico.logic.Servico;

public class FormularioServicoServlet extends HttpServlet{
	

    private static final long serialVersionUID = 1L;
    private final String OPERACAO_ENVIAR_FORMULARIO_SUCESSO = "/formularioSucesso.jsp";
    private final String OPERACAO_ENVIAR_FORMULARIO_ERRO = "/mensagem.jsp";
    private final String TITULO_EMAIL = "Solicitação de Serviço";
    private final String CANCELADO = "Cancelamento: ";
	
	//private String tipoSoftware;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException, IOException, ServletException{
    	Set<File> attachFiles = new TreeSet<File>();
    	String nome = "";
    	String emailRemetente = "";
    	String ramal = "";
    	String tipo = "";
    	String tipoDeServico = "";
    	String tipoSoftware = "";
    	StringBuffer link = new StringBuffer("");
    	String nomeSoftware = "";
    	//String tipoServico = "";
    	String realPathContext = getServletContext().getRealPath("/listaEmails");
    	String hibernateConfig = getServletContext().getRealPath("/");
    	nome = request.getParameter("nome");
    	emailRemetente = request.getParameter("email");
    	if(!request.getParameter("ramal").equals(null))
    		ramal = request.getParameter("ramal");
    	tipo = request.getParameter("tipo");
    	Facade facade = new Facade(realPathContext);
    	FormularioServico documento = null;
    	String operacao = request.getParameter("operacao");
    
    	if (tipo.equalsIgnoreCase("INSTALACAO")){
    		tipoSoftware = request.getParameter("tipoSoftware");
    		String localInstalacao = request.getParameter("localInstalacao");
    		if (tipoSoftware.equalsIgnoreCase("SIM")){
    			link.append(request.getParameter("link"));
    		}
    		nomeSoftware = request.getParameter("nomeSoftware");
    		
    		try {
    			if (operacao.equalsIgnoreCase("enviarEmail")){
    				
    				documento = new FormularioServico(nome, emailRemetente, ramal, link, nomeSoftware, localInstalacao);
    				documento.escreveCartaInstalacao();
    				//facade.grava(documento, realPathContext);
    				facade.grava(documento.getInstalacaoDeSoftware().getUsuario(), hibernateConfig);
    				facade.grava(documento.getInstalacaoDeSoftware(), hibernateConfig);
    				facade.enviarEmail(attachFiles, emailRemetente, documento.toString(), TITULO_EMAIL, facade.SERVICO);
    				forward(OPERACAO_ENVIAR_FORMULARIO_SUCESSO, request, response);
    			}else{
    				forward(OPERACAO_ENVIAR_FORMULARIO_ERRO + "?text=" + CANCELADO
						+ "Solicatação+de+serviço+cancelada.", request, response);
    			}
			} catch (CampoVazioInvalidoException e) {
				e.printStackTrace();
			}
    		
    		
    		
    	}else if(tipo.equalsIgnoreCase("CONTA")){
    		tipoDeServico = request.getParameter("tipoServico");
    		String justificativa = request.getParameter("justificativa");
    		FormularioServico documentoConta;
    		String login = request.getParameter("conta");
    		try {
    			if (operacao.equalsIgnoreCase("enviarEmail")){
    				documentoConta = new FormularioServico(nome, emailRemetente, ramal, justificativa, login,tipoDeServico);
    				documentoConta.escreveCartaConta();
    				facade.grava(documentoConta.getServicoConta().getUsuario(), hibernateConfig);
    				facade.grava(documentoConta.getServicoConta(), hibernateConfig);
    				facade.enviarEmail(attachFiles, emailRemetente, documentoConta.toString(), TITULO_EMAIL, facade.SERVICO);
					forward(OPERACAO_ENVIAR_FORMULARIO_SUCESSO, request, response);
					//facade.grava(documentoConta, realPathContext);
    			}else{
    				forward(OPERACAO_ENVIAR_FORMULARIO_ERRO + "?text=" + CANCELADO
    						+ "Solicatação+de+serviço+cancelada.", request, response);
        			}
    		}catch (CampoVazioInvalidoException e) {
					
					e.printStackTrace();
			}
		}else if (tipo.equalsIgnoreCase("MANUTENCAO")){
    		FormularioServico documentoManutencao;
    		StringBuffer descricao = new StringBuffer(); 
    		descricao.append(request.getParameter("descricao"));
    		String tipoManutencao = request.getParameter("tipoManutencao");
    		try {
    			if (operacao.equalsIgnoreCase("enviarEmail")){
    				documentoManutencao = new FormularioServico(nome, emailRemetente, ramal, tipoManutencao, descricao);
    				documentoManutencao.escreveCartaManutencao();
    				facade.grava(documentoManutencao.getManutencao().getUsuario(), hibernateConfig);
    				facade.grava(documentoManutencao.getManutencao(), hibernateConfig);
    				facade.enviarEmail(attachFiles, emailRemetente, documentoManutencao.toString(), TITULO_EMAIL, facade.SERVICO);
					//facade.grava(documentoManutencao, realPathContext);
    				forward(OPERACAO_ENVIAR_FORMULARIO_SUCESSO, request, response);
    			}else{
    				forward(OPERACAO_ENVIAR_FORMULARIO_ERRO + "?text=" + CANCELADO
    						+ "Solicatação+de+serviço+cancelada.", request, response);
        			}
    		}catch (CampoVazioInvalidoException e) {
					
					e.printStackTrace();
			}
    	}
    	
    	
    }
    private void forward(String path, HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException{
    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(path);
    	dispatcher.forward(req, res);
    }

}
