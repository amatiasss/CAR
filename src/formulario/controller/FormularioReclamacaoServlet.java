package formulario.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import auto_Atendimento.logic.Reclamacao;
import facade.Facade;

/**
 * Servlet que recebe reclamacoes de usuários
 * @author Rodrigo Lopes, Hamon Barros, Rômulo Calado
 */
public class FormularioReclamacaoServlet extends HttpServlet {
		//Atributos
	private static final long serialVersionUID = 1L;
	private final String OPERACAO_ENVIAR_FORMULARIO_SUCESSO = "/formularioSucesso.jsp";
	private final String OPERACAO_ENVIAR_FORMULARIO_ERRO = "/mensagem.jsp";
	private final String CANCELADO = "Cancelamento: ";
	private final String TITULO_EMAIL = "Reclamação";

	/**
	 * Trata um formulario enviado pelo metodo Post.
	 * 
	 * @param request
	 *            Dados recebido no envio.
	 * @param response
	 *            Acesso ao cliente que envio um formulario.
	 * @throws ServletException
	 *             Lancada se ocorrer alguma problema interno no servlet.
	 * @throws IOException
	 *             Lancada caso ocorra problema no envio da pagina.
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws FileNotFoundException, IOException, ServletException {
		Set<File> attachFiles = new TreeSet<File>();
		
		String nome = request.getParameter("nome");
		String emailRemetente = request.getParameter("email");
		String ramal = request.getParameter("ramal");
		String tipoReclamacao = request.getParameter("tipo");
		if (tipoReclamacao.equalsIgnoreCase("OUTROS")){
			tipoReclamacao = request.getParameter("tipoDeOutro");
			
		}
		String descricao = request.getParameter("descricao");
		String realPathContext = getServletContext().getRealPath("/listaEmails");
		Facade facade = new Facade(realPathContext);
		String hibernateConfig = getServletContext().getRealPath("/"); 
		Reclamacao reclamacao;
		String operacao = request.getParameter("operacao");
		try {
			if (operacao.equalsIgnoreCase("enviarEmail")) {

				reclamacao = new Reclamacao(nome, emailRemetente, ramal,
						tipoReclamacao, descricao);
				facade.grava(reclamacao.getUsuario(), hibernateConfig);
				facade.grava(reclamacao, hibernateConfig);
				facade.enviarEmail(attachFiles, emailRemetente, reclamacao
						.getRelatorio(), TITULO_EMAIL, facade.RECLAMACAO);
				forward(OPERACAO_ENVIAR_FORMULARIO_SUCESSO, request, response);
			}
		} catch (Exception e) {
			forward(OPERACAO_ENVIAR_FORMULARIO_ERRO + "?text=" + e.getMessage()+ realPathContext+"==>"+getServletContext().getRealPath("/"), request, response);
		}

	}

	/**
	 * Redireciona para uma página.
	 * 
	 * @param path
	 *            O path da pagina.
	 * @param req
	 *            A requisição.
	 * @param res
	 *            A resposta.
	 * @throws ServletException
	 *             Lancada se ocorrer alguma problema interno no servlet.
	 * @throws IOException
	 *             Lancada caso ocorra problema no envio da pagina.
	 */
	private void forward(String path, HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(path);
		dispatcher.forward(req, res);
	}

}
