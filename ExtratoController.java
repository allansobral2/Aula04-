

import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.TO.ExtratoTO;
import src.model.Extrato;

/**
 * Servlet implementation class ExtratoControle
6
 */
@WebServlet("/Extrato.do")
public class ExtratoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String agencia = request.getParameter("agencia");
		String conta = request.getParameter("conta");
		String periodoDe = request.getParameter("periodoDe");
		String periodoAte = request.getParameter("periodoAte");
		Extrato extrato = new Extrato(agencia, conta, periodoDe, periodoAte);
		extrato.extrato();
		ExtratoTO to = new ExtratoTO();
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Extrato</title></head><body>");
		out.println( "agencia: "+extrato.getAgencia()+"<br>");
		out.println( "conta: "+extrato.getConta()+"<br>");
		out.println( "periodoDe: "+extrato.getPeriodoDe()+"<br>");
		out.println( "periodoAte: "+extrato.getPeriodoAte()+"<br>");
		out.println( "dataHora: "+to.getDataHora()+"<br>");
		out.println( "descrição: "+to.getDescricao()+"<br>");
		out.println( "valor: "+to.getValor()+"<br>");
		out.println("</body></html>");
	}
}