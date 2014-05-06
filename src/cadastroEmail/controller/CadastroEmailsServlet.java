package cadastroEmail.controller;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import correio.email.logic.ConexaoXML;

import formulario.logic.email.CadastroEmail;
import formulario.logic.email.Responsavel;

public class CadastroEmailsServlet extends HttpServlet implements Cadastro {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final String CADASTRO_XML = "CadastroEmail.xml";

	private final String LISTAR_RESPONSAVEIS_MENSAGEM_LABORATORIO = "Lista de responsáveis por emails de Solicitação de Laboratório.";

	private final String LISTAR_RESPONSAVEIS_MENSAGEM_OUTROS = "Lista de responsáveis por emails de Outras solicitações.";

	private final String LISTAR_RESPONSAVEIS_MENSAGEM_RECLAMACAO = "Lista de responsáveis por emails de Reclamação.";

	private final String LISTAR_RESPONSAVEIS_MENSAGEM_SALA = "Lista de responsáveis por emails de Solicitação de Sala.";

	private final String LISTAR_RESPONSAVEIS_MENSAGEM_SERVICO = "Lista de responsáveis por emails de Serviço.";

	private final String LISTAR_RESPONSAVEIS_MENSAGEM_SUGESTAO = "Lista de responsáveis por emails de Sugestões.";

	private final String LISTAR_RESPONSAVEIS_JSP = "/cadastroEmails/listarResponsaveis.jsp";

	private final String RESPONSAVEL_REMOVIDO_SUCESSO = "Responsável removido com sucesso.";

	private final String CADASTRO_SUCESSO = "Cadastro de email efetuado com sucesso.";

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ConexaoXML conexao = new ConexaoXML();
		String pathCadastro = getServletContext().getRealPath(
				"/listaEmails/" + CADASTRO_XML);

		String operacao = request.getParameter("operacao");
		CadastroEmail cadastroEmail = (CadastroEmail) conexao
				.read(pathCadastro);
		if (cadastroEmail == null) {
			cadastroEmail = new CadastroEmail();
		}
		if (operacao.equals("cadastrar")) {
			String nomeResponsavel = request.getParameter("nome");

			String emailCadastrar = request.getParameter("email");
			String setorCadastrar = request.getParameter("setorResponsavel");

			if (setorCadastrar.equalsIgnoreCase("laboratorio")) {
				cadastroEmail.addCadastroLaboratorio(nomeResponsavel,
						emailCadastrar);

			} else if (setorCadastrar.equalsIgnoreCase("outro")) {
				cadastroEmail.addCadastroOutro(nomeResponsavel, emailCadastrar);
			} else if (setorCadastrar.equalsIgnoreCase("reclamacao")) {
				cadastroEmail.addCadastroReclamacao(nomeResponsavel,
						emailCadastrar);
			} else if (setorCadastrar.equalsIgnoreCase("sala")) {
				cadastroEmail.addCadastroSala(nomeResponsavel, emailCadastrar);
			} else if (setorCadastrar.equalsIgnoreCase("servico")) {
				cadastroEmail.addCadastroServico(nomeResponsavel,
						emailCadastrar);
			} else {
				cadastroEmail.addCadastroSugestao(nomeResponsavel,
						emailCadastrar);
			}
			conexao.write(cadastroEmail, pathCadastro);
			request.setAttribute("mensagem", CADASTRO_SUCESSO);
			forward(MENSAGEM_JSP, request, response);
			// Prepara e lista todos os clientes numa pagina jsp

		} else if (operacao.equals("listar")) {
			String setor = request.getParameter("setorResponsavel");

			if (setor.equalsIgnoreCase("laboratorio")) {
				Responsavel resp = new Responsavel(cadastroEmail
						.getLaboratorio());
				Iterator it = resp.getResponsaveis().iterator();
				request.setAttribute("responsaveis", it);
				request.setAttribute("setorResponsavel", setor);
				request.setAttribute("mensagem",
						LISTAR_RESPONSAVEIS_MENSAGEM_LABORATORIO);
				forward(LISTAR_RESPONSAVEIS_JSP, request, response);
			} else if (setor.equalsIgnoreCase("outro")) {
				Responsavel resp = new Responsavel(cadastroEmail.getOutro());
				Iterator it = resp.getResponsaveis().iterator();
				request.setAttribute("responsaveis", it);
				request.setAttribute("setorResponsavel", setor);
				request.setAttribute("mensagem",
						LISTAR_RESPONSAVEIS_MENSAGEM_OUTROS);
				forward(LISTAR_RESPONSAVEIS_JSP, request, response);
			} else if (setor.equalsIgnoreCase("reclamacao")) {
				Responsavel resp = new Responsavel(cadastroEmail
						.getReclamacao());
				Iterator it = resp.getResponsaveis().iterator();
				request.setAttribute("responsaveis", it);
				request.setAttribute("setorResponsavel", setor);
				request.setAttribute("mensagem",
						LISTAR_RESPONSAVEIS_MENSAGEM_RECLAMACAO);
				forward(LISTAR_RESPONSAVEIS_JSP, request, response);
			} else if (setor.equalsIgnoreCase("sala")) {
				Responsavel resp = new Responsavel(cadastroEmail.getSala());
				Iterator it = resp.getResponsaveis().iterator();
				request.setAttribute("responsaveis", it);
				request.setAttribute("setorResponsavel", setor);
				request.setAttribute("mensagem",
						LISTAR_RESPONSAVEIS_MENSAGEM_SALA);
				forward(LISTAR_RESPONSAVEIS_JSP, request, response);
			} else if (setor.equalsIgnoreCase("servico")) {
				Responsavel resp = new Responsavel(cadastroEmail.getServico());
				Iterator it = resp.getResponsaveis().iterator();
				request.setAttribute("responsaveis", it);
				request.setAttribute("setorResponsavel", setor);
				request.setAttribute("mensagem",
						LISTAR_RESPONSAVEIS_MENSAGEM_SERVICO);
				forward(LISTAR_RESPONSAVEIS_JSP, request, response);
			} else {
				Responsavel resp = new Responsavel(cadastroEmail.getSugestao());
				Iterator it = resp.getResponsaveis().iterator();
				request.setAttribute("responsaveis", it);
				request.setAttribute("setorResponsavel", setor);
				request.setAttribute("mensagem",
						LISTAR_RESPONSAVEIS_MENSAGEM_SUGESTAO);
				forward(LISTAR_RESPONSAVEIS_JSP, request, response);
			}

		} else if (operacao.equalsIgnoreCase("removerResponsavel")) {
			Responsavel resp;
			String setor = request.getParameter("setorResponsavel");
			String nomeRemover = request.getParameter("nome");
			if (setor.equalsIgnoreCase("laboratorio")) {
				cadastroEmail.removeCadastroLaboratorio(nomeRemover);
				resp = new Responsavel(cadastroEmail.getLaboratorio());
				request.setAttribute("mensagem", LISTAR_RESPONSAVEIS_MENSAGEM_LABORATORIO);
			} else if (setor.equalsIgnoreCase("outro")) {
				cadastroEmail.removeCadastroOutro(nomeRemover);

				resp = new Responsavel(cadastroEmail.getOutro());
				request.setAttribute("mensagem", LISTAR_RESPONSAVEIS_MENSAGEM_OUTROS);

			} else if (setor.equalsIgnoreCase("reclamacao")) {
				cadastroEmail.removeCadastroReclamacao(nomeRemover);

				resp = new Responsavel(cadastroEmail.getReclamacao());
				request.setAttribute("mensagem", LISTAR_RESPONSAVEIS_MENSAGEM_RECLAMACAO);
			} else if (setor.equalsIgnoreCase("sala")) {
				cadastroEmail.removeCadastroSala(nomeRemover);

				resp = new Responsavel(cadastroEmail.getSala());
				request.setAttribute("mensagem", LISTAR_RESPONSAVEIS_MENSAGEM_SALA);
			} else if (setor.equalsIgnoreCase("servico")) {
				cadastroEmail.removeCadastroServico(nomeRemover);

				resp = new Responsavel(cadastroEmail.getServico());
				request.setAttribute("mensagem", LISTAR_RESPONSAVEIS_MENSAGEM_SERVICO);
			} else {
				cadastroEmail.removeCadastroSugestao(nomeRemover);

				resp = new Responsavel(cadastroEmail.getSugestao());
				request.setAttribute("mensagem", LISTAR_RESPONSAVEIS_MENSAGEM_SUGESTAO);
			}
			Iterator it = resp.getResponsaveis().iterator();
			request.setAttribute("responsaveis", it);
			request.setAttribute("setorResponsavel", setor);
			forward(LISTAR_RESPONSAVEIS_JSP, request, response);
			conexao.write(cadastroEmail, pathCadastro);
			/*
			 * request.setAttribute("mensagem", RESPONSAVEL_REMOVIDO_SUCESSO);
			 * forward(MENSAGEM_JSP, request, response);
			 */
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
	 * @throws IOException
	 */
	void forward(String path, HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(path);
		dispatcher.forward(req, res);
	}

}
