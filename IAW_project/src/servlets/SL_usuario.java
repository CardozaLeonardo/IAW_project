package servlets;

import java.io.IOException;
import datos.Dt_usuario;
import entidades.Tbl_user;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SL_usuario
 */
@WebServlet("/SL_usuario")
public class SL_usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SL_usuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opc = request.getParameter("opc");
		int opcion = 0;
		
		opc = opc==null?"0":opc;
		
		opcion = Integer.parseInt(opc);
		
		Tbl_user tus = new Tbl_user();
		Dt_usuario dtus = new Dt_usuario();
		
		switch(opcion)
		{
		   case 1:
		   { 
			   try {
				   tus.setUsername(request.getParameter("username"));
				   tus.setNombre1(request.getParameter("name1"));
				   tus.setNombre2(request.getParameter("name2"));
				   tus.setApellido1(request.getParameter("apellido1"));
				   tus.setApellido2(request.getParameter("apellido2"));
				   tus.setPwd(request.getParameter("password"));
				   tus.setEmail(request.getParameter("email"));
				   
				   if(dtus.guardarUser(tus))
				   {
					   response.sendRedirect("./pages/seguridad/newUser.jsp?msj=1");
				   }else {
					   response.sendRedirect("./pages/seguridad/newUser.jsp?msj=2");
				   }
			   }
			   catch(Exception e)
			   {
				  e.printStackTrace(); 
			   }
			   
		   }
			   
		   case 2:
		   {
		   
			   break;
		   }
		   
		   
		   default:
		   {
			   response.sendRedirect("tblUsuarios.jsp?msj=ERROR");
		   }
		}
		
	}

}
