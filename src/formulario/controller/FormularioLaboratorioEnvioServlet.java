package formulario.controller;

/**
 * FormularioLaboratorioServlet trata a conexao com o formulario solicitacao de laboratorio.
 * 
 * @author Romulo Calado
 * @author Rodrigo Lopes
 * @author Hamon Barros
 * */

import java.io.File;
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
import formulario.laboratorio.logic.FormularioLaboratorio;

public class FormularioLaboratorioEnvioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Pagina retornada em caso de envio bem sucedido
	private final String OPERACAO_ENVIAR_FORMULARIO_SUCESSO = "/formularioSucesso.jsp";

	// Mensage enviada caso o usuário envio um formulário cancelado
	private final String OPERACAO_CANCELADA = ", cancelou a solicitação de laboratório, podendo ser prejudicado(a) em futuras solicitações.";

	// Pagina retornada em caso de problema no envio
	private final String OPERACAO_ENVIAR_FORMULARIO_ERRO = "/mensagem.jsp";

	// String exibida em caso de erro
	private final String ERRO = "Erro: ";

	// String exibida em caso de erro
	private final String CANCELADO = "Cancelamento: ";
	
	private final String TITULO_EMAIL = "Solicitação de Laboratório";

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
			throws ServletException, IOException {
		Set<File> attachFiles = new TreeSet<File>();
		
		String realPathContext = getServletContext().getRealPath("/");

		// Path do arquivo contendo os emails
		String contexto = getServletContext().getRealPath("/listaEmails");
		String operacao = request.getParameter("operacao");
		String emailUsuario = request.getParameter("email");
		String nomeMinistrante = request.getParameter("nomeMinistrante");
		// Gera a mensagem do email
		FormularioLaboratorio fl = new FormularioLaboratorio(request);
		fl.ExtrairDados(request.getParameterNames());
		String documento = fl.getRelatorio();

		Facade facade = new Facade(contexto);
		try {
			if (operacao.equals("enviarEmail")) {
				
                facade.grava(fl.getMinistrante(), realPathContext);
                facade.grava(fl.getCurso(), realPathContext);
                facade.grava(fl.getHorario1(), realPathContext);
                facade.grava(fl.getHorario2(), realPathContext);
                facade.grava(fl.getHorario3(), realPathContext);
                facade.grava(fl, realPathContext);
                facade.enviarEmail(attachFiles, emailUsuario, documento, TITULO_EMAIL, facade.LABORATORIO);
				forward(OPERACAO_ENVIAR_FORMULARIO_SUCESSO, request, response);
			} else {
				if (emailUsuario != null) {
					facade.enviarEmail(attachFiles, emailUsuario, nomeMinistrante+ ", cujo e-mail é "+ emailUsuario+ OPERACAO_CANCELADA, TITULO_EMAIL, facade.LABORATORIO);
					forward(OPERACAO_ENVIAR_FORMULARIO_ERRO + "?text=" + CANCELADO
							+ "Solicatação+cancelada.", request, response);
				}
			}
		} catch (CampoVazioInvalidoException e) {
			forward(OPERACAO_ENVIAR_FORMULARIO_ERRO + "?text=" + ERRO
					+ "+Formulario+contém+erro.", request, response);
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
	void forward(String path, HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(path);
		dispatcher.forward(req, res);
	}

}
