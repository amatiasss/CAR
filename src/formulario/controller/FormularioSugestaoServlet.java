package formulario.controller;

/**
 * <b>Sugestao</b><br><br>
 *
 * Servlet que recebe sugestões de usuários
 * 
 * @author Rodrigo Lopes, Hamon Barros, Rômulo Calado
 *
 */
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

import auto_Atendimento.logic.Sugestao;
import facade.CampoVazioInvalidoException;
import facade.Facade;

public class FormularioSugestaoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final String OPERACAO_ENVIAR_FORMULARIO_SUCESSO = "/formularioSucesso.jsp";

	private final String OPERACAO_ENVIAR_FORMULARIO_ERRO = "/mensagem.jsp";

	private final String TITULO_EMAIL = "Sugestão";

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws FileNotFoundException, IOException, ServletException {
		Set<File> attachFiles = new TreeSet<File>();
		String nome = request.getParameter("nome");
		String emailRemetente = request.getParameter("email");
		String ramal = request.getParameter("ramal");
		String sugestaoEnviada = request.getParameter("sugestao");
		String realPathContext = getServletContext().getRealPath("/listaEmails");
		Facade facade = new Facade(realPathContext);
		String hibernateConfig = getServletContext().getRealPath("/"); 
		Sugestao sugestao;
		String operacao = request.getParameter("operacao");
		try {
			if (operacao.equalsIgnoreCase("enviarEmail")) {

				sugestao = new Sugestao(nome, emailRemetente, ramal,
						sugestaoEnviada);
				facade.grava(sugestao.getUsuario(), hibernateConfig);
				facade.grava(sugestao, hibernateConfig);
				facade.enviarEmail(attachFiles, emailRemetente, sugestao
						.getRelatorio(), TITULO_EMAIL, facade.SUGESTAO);
				forward(OPERACAO_ENVIAR_FORMULARIO_SUCESSO, request, response);
			}
		} catch (Exception e) {
			forward(OPERACAO_ENVIAR_FORMULARIO_ERRO + "?text=" + e.getMessage()+ realPathContext+"==>"+getServletContext().getRealPath("/"), request, response);
		}

	}

	private void forward(String path, HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(path);
		dispatcher.forward(req, res);
	}

}
