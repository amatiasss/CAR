
package formulario.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import facade.CampoVazioInvalidoException;
import facade.Facade;
import formulario.logic.HorarioSemanal;
import formulario.salaAula.logic.FormularioSala;
/**
 * Classe Controller responsavel pelo Formulário Sala de Aula
 * 
 * @author Romulo Calado
 * @author Rodrigo Lopes
 * @author Hamon Barros
 * */
public class FormularioSalaEnvioServlet extends HttpServlet
{

    private static final long serialVersionUID = 1L;
    private final String OPERACAO_ENVIAR_FORMULARIO_SUCESSO = "/formularioSucesso.jsp";
    private final String OPERACAO_ENVIAR_FORMULARIO_ERRO = "/mensagem.jsp";
    private final String TITULO_EMAIL = "Solicitação de Sala de Aula";
    private final String OPERACAO_CANCELADA = ", cancelou a solicitação de sala de aula, podendo ser prejudicado(a) em futuras solicitações.";
//  String exibida em caso de erro
	private final String CANCELADO = "Cancelamento: ";
   
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        Set<File> attachFiles = new TreeSet<File>();
        String contexto = getServletContext().getRealPath("/listaEmails");
        String realPathContext = getServletContext().getRealPath("/");
        String operacao = "";
        String emailUsuario = "";
        String nomeProfessor = "";
        String disciplina = "";
        String periodo = "";
        String curso = "";
        String opcaoPeriodicidade = "";
        String periodicidade = "";
        HorarioSemanal horario1 = new HorarioSemanal();
        HorarioSemanal horario2 = new HorarioSemanal();
        HorarioSemanal horario3 = new HorarioSemanal();
        String totalAlunos = "";
        String ramal = "";
        String salaAtual = "";
        String equipamentosFrequentes = "";
        String equipamentosIndispensaveis = "";
        String linkMaterial = "";
       
        
        
        String equipamentosNaoDisponiveis = "";
    	String equipamentosNaoUtilizados ="";
    	String disciplinaNoturna="";
    	String justificativaNoturna="";
    	String disciplinaSabado="";
    	String turnoSabado="";
    	String justificativaSabado="";
    	String contribuicao="";
        String nomeArquivo = "";
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //maximo de memoria que sera utilizado
        factory.setSizeThreshold(4096);
        // o local para salvar os arquivos temporários de tamanha getSizeThreshold()
        factory.setRepository(new File(realPathContext));//getServletContext().getRealPath("/temp/")));
        ServletFileUpload upload = new ServletFileUpload(factory);
        // Tamanho maximo do arquivo de upload
        upload.setSizeMax(1000000);
        List fileItems;
        File savedFile = null; 
        try
        {
            fileItems = upload.parseRequest(request);
            Iterator itr = fileItems.iterator();
            do
            {
                if(!itr.hasNext())
                    break;
                FileItem fItem = (FileItem)itr.next();
                
                if (!fItem.isFormField()) {
					nomeArquivo = fItem.getName();
					if (!nomeArquivo.equals("")) {
						String extensao = nomeArquivo.substring(nomeArquivo
								.length() - 3, nomeArquivo.length());
						if (!extensao.equalsIgnoreCase("exe")
								&& !extensao.equalsIgnoreCase("bat")) {
							savedFile = new File(getServletContext()
									.getRealPath("/temp/"), nomeArquivo);
							attachFiles.add(savedFile);
							fItem.write(savedFile);
						}
					}
				} else
                {                    
                    if(fItem.getFieldName().equals("operacao"))
                        operacao = fItem.getString();
                    if(fItem.getFieldName().equals("email"))
                        emailUsuario = fItem.getString();
                    if(fItem.getFieldName().equals("nomeDisciplina"))
                        disciplina = fItem.getString();
                    if(fItem.getFieldName().equals("periodo"))
                        periodo = fItem.getString();
                    if(fItem.getFieldName().equals("nomeProfessor"))
                        nomeProfessor = fItem.getString();
                    if(fItem.getFieldName().equals("cursosPertence"))
                        curso = fItem.getString();
                    if(fItem.getFieldName().equals("ramal"))
                        ramal = fItem.getString();
                    if(fItem.getFieldName().equals("numeroAlunos"))
                        totalAlunos = fItem.getString();
                    if(fItem.getFieldName().equals("email"))
                        emailUsuario = fItem.getString();
                    if(fItem.getFieldName().equals("opcaoPeriodicidade"))
                    	opcaoPeriodicidade = fItem.getString();
                    if(fItem.getFieldName().equals("periodicidade"))
                        periodicidade = fItem.getString();
                    if(fItem.getFieldName().equals("dia1"))
                        horario1.setDia(fItem.getString());
                    if(fItem.getFieldName().equals("inicio1"))
                        horario1.setInicio(fItem.getString());
                    if(fItem.getFieldName().equals("fim1"))
                        horario1.setFim(fItem.getString());
                    if(fItem.getFieldName().equals("dia2"))
                        horario2.setDia(fItem.getString());
                    if(fItem.getFieldName().equals("inicio2"))
                        horario2.setInicio(fItem.getString());
                    if(fItem.getFieldName().equals("fim2"))
                        horario2.setFim(fItem.getString());
                    if(fItem.getFieldName().equals("dia3"))
                        horario3.setDia(fItem.getString());
                    if(fItem.getFieldName().equals("inicio3"))
                        horario3.setInicio(fItem.getString());
                    if(fItem.getFieldName().equals("fim3"))
                        horario3.setFim(fItem.getString());
                    if(fItem.getFieldName().equals("salaAtual"))
                        salaAtual = fItem.getString();
                    if(fItem.getFieldName().equals("equipamentosFrequentes"))
                    	equipamentosFrequentes = fItem.getString();
                    if(fItem.getFieldName().equals("equipamentosIndispensaveis"))
                        equipamentosIndispensaveis = fItem.getString();
                    if(fItem.getFieldName().equals("linkMaterial"))
                    	linkMaterial = fItem.getString();
                    if(fItem.getFieldName().equals("equipamentosNaoDisponiveis"))
                    	equipamentosNaoDisponiveis = fItem.getString();
                    if(fItem.getFieldName().equals("equipamentosNaoUtilizados"))
                    	equipamentosNaoUtilizados = fItem.getString();
                    if(fItem.getFieldName().equals("disciplinaNoturna"))
                    	disciplinaNoturna = fItem.getString();
                    if(fItem.getFieldName().equals("justificativaNoturna"))
                    	justificativaNoturna = fItem.getString();
                    if(fItem.getFieldName().equals("disciplinaSabado"))
                    	disciplinaSabado = fItem.getString();
                    if(fItem.getFieldName().equals("turnoSabado"))
                    	turnoSabado = fItem.getString();
                    if(fItem.getFieldName().equals("justificativaSabado"))
                    	justificativaSabado = fItem.getString();
                    if(fItem.getFieldName().equals("contribuicao"))
                    	contribuicao = fItem.getString();
                }
            } while(true);
        }
        catch(Exception e)
        {
            response.getWriter().print("Lançou!!!!");
        }
        Facade facade = new Facade(contexto);
        FormularioSala documento; 
        if(opcaoPeriodicidade.equalsIgnoreCase("OUTRA"))
            opcaoPeriodicidade = periodicidade;
        
        try
            {
        	if(operacao.equalsIgnoreCase("enviarEmail")){
            	documento = new FormularioSala(nomeProfessor, disciplina, periodo, curso, opcaoPeriodicidade,horario1, horario2, horario3, totalAlunos, emailUsuario, ramal, salaAtual, equipamentosFrequentes, equipamentosIndispensaveis, linkMaterial, equipamentosNaoDisponiveis, equipamentosNaoUtilizados, disciplinaNoturna, justificativaNoturna, disciplinaSabado, turnoSabado, justificativaSabado, contribuicao, savedFile);
                documento.escreveCarta();
                facade.enviarEmail(attachFiles, emailUsuario, documento.toString(), TITULO_EMAIL, facade.SALA);
                facade.grava(documento.getProfessor(), realPathContext);
                facade.grava(documento.getDisciplina(), realPathContext);
                facade.grava(documento.getHorario1(), realPathContext);
                facade.grava(documento.getHorario2(), realPathContext);
                facade.grava(documento.getHorario3(), realPathContext);
                facade.grava(documento, realPathContext);
                forward(OPERACAO_ENVIAR_FORMULARIO_SUCESSO, request, response);
            }else{
            	if ((emailUsuario != null) && (nomeProfessor != null)) {
					facade.enviarEmail(new TreeSet<File>(), emailUsuario, "O(A) professor(a) "+ nomeProfessor+ ", cujo e-mail é "+ emailUsuario+ OPERACAO_CANCELADA, TITULO_EMAIL, facade.SALA);
					forward(OPERACAO_ENVIAR_FORMULARIO_ERRO + "?text=" + CANCELADO
							+ "Solicatação+cancelada.", request, response);
				}
            }}catch(CampoVazioInvalidoException e)
            {
                forward(OPERACAO_ENVIAR_FORMULARIO_ERRO, request, response);
            }
    }
   
    void forward(String path, HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException
    {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(path);
        dispatcher.forward(req, res);
    }

}