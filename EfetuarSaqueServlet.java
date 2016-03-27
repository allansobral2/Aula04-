import javax.servlet.ServletException;   
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.*;

import src.TO.*;
import src.model.*;
import src.DAO.*;
import src.control.*;
import src.*;

@WebServlet("/EfetuarSaque.do")	
public class EfetuarSaqueServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String agencia = request.getParameter("agencia");
		String conta = request.getParameter("conta");
		String valor = request.getParameter("valor");

		EfetuarSaqueTO efetuarSaque = new EfetuarSaqueTO(agencia, conta, valor);
		EfetuarSaqueDAO dao = new EfetuarSaqueDAO ();
		efetuarSaque.setAgencia();
		efetuarSaque.setConta();
		efetuarSaque.setValor();		
		dao.sacar(efetuar);
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Saque Realizado</title></head><body>");
		out.println( "Agencia: "+EfetuarSaqueTO.getAgencia()+"<br>");
		out.println( "Conta: "+EfetuarSaqueTO.getConta()+"<br>");
		out.println( "Valor Sacado: "+EfetuarSaqueTO.getValor()+"<br>");
		out.println("</body></html>");
		}
}
