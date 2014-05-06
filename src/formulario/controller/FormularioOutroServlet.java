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
import formulario.outro.logic.FormularioOutro;
import formulario.servico.logic.Servico;

public class FormularioOutroServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    private final String OPERACAO_ENVIAR_FORMULARIO_SUCESSO = "/formularioSucesso.jsp";
    private final String OPERACAO_ENVIAR_FORMULARIO_ERRO = "/mensagem.jsp";
    private final String TITULO_EMAIL = "Outras solicitações";
    private final String CANCELADO = "Cancelamento: ";
	
	//private String tipoSoftware;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException, IOException, ServletException{
    	Set<File> attachFiles = new TreeSet<File>();
    	String nome = "";
    	String emailRemetente = "";
    	String ramal = "";
    	String comentario = "";
    	String realPathContext = getServletContext().getRealPath("/listaEmails");
    	String hibernateConfig = getServletContext().getRealPath("/");
    	String operacao = request.getParameter("operacao");
    	
    	Facade facade = new Facade(realPathContext);
    	nome = request.getParameter("nome");
    	emailRemetente = request.getParameter("email");
    	if(!request.getParameter("ramal").equals(null))
    		ramal = request.getParameter("ramal");
    	comentario = request.getParameter("comentario");
    	FormularioOutro documentoOutro = null;
    	try {
			if (operacao.equalsIgnoreCase("enviarEmail")){
				
				documentoOutro = new FormularioOutro(nome, emailRemetente, ramal, comentario, "Instalação de Software");
				documentoOutro.escreveCartaOutro();
				facade.grava(documentoOutro.getOutro().getUsuario(), hibernateConfig);
				facade.grava(documentoOutro.getOutro(), hibernateConfig);
				facade.enviarEmail(attachFiles, emailRemetente, documentoOutro.toString(), TITULO_EMAIL, facade.OUTRO);
				forward(OPERACAO_ENVIAR_FORMULARIO_SUCESSO, request, response);
			}else{
				forward(OPERACAO_ENVIAR_FORMULARIO_ERRO + "?text=" + CANCELADO
					+ "Solicatação+de+serviço+cancelada.", request, response);
			}
		} catch (CampoVazioInvalidoException e) {
			e.printStackTrace();
		}
    }
    private void forward(String path, HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException{
    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(path);
    	dispatcher.forward(req, res);
    }
}
