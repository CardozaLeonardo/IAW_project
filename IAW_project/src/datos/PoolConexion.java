package datos;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.swing.JOptionPane;

public class PoolConexion 
{
	// El patrï¿½n Singleton exige que los atributos y los mï¿½todos sean declarados en static y privados.
	private static PoolConexion INSTANCE = null;  // Creando una instancia de PoolConexion en NULL
	private static Connection con = null; // Crea un objeto de tipo Connection
	private static DataSource dataSource; // Crea un objeto de tipo DataSource
	private static String db = "HR"; // Variable con el nombre de la BD
	private static String url = "jdbc:postgresql://localhost:5432/"+db; // URL para conectar con la BD
	private static String user = "postgres";
	private static String pass = "Usuario123#.";
	
	private PoolConexion() // Constructor de la clase
    {
		inicializaDataSource(); // Instancia el DataSource (pool)
    }
	
	private synchronized static void createInstance() // Este mï¿½todo asigna a la instancia <<INSTANCE>> la instancia del objeto (Pool)
	{
		if(INSTANCE==null)
		{
			INSTANCE = new PoolConexion();
		}
	}
	
	public static PoolConexion getInstance() // Este mï¿½todo retorna la instancia ï¿½nica del objeto (pool)
	{
		if(INSTANCE == null)
		{
			createInstance();
		}
		return INSTANCE;
	}
	
	

	 public final void inicializaDataSource() // Este método asigna los valores de fabrica para la creacion del origen de datos de conexion
	    {

		 	org.apache.commons.dbcp.BasicDataSource basicDataSource = new org.apache.commons.dbcp.BasicDataSource();
	        basicDataSource.setDriverClassName("org.postgresql.Driver");
	        basicDataSource.setUsername(user);
	        basicDataSource.setPassword(pass);
	        basicDataSource.setUrl(url);
	        basicDataSource.setMaxActive(50);
	        dataSource = basicDataSource;
	    }
	
	 
	 public static boolean EstaConectado()
	    {
	    	boolean resp = false;
	    	try
	    	{
	    		con = PoolConexion.dataSource.getConnection();
	    		if ((con==null) || (con.isClosed()))
	    			resp = false;
	    		else
	    			resp = true;
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    		System.out.println(e.getMessage());
	    	}
	    	
	    	return resp;
	    }

	    public static Connection getConnection() 
	    {	
		   if (EstaConectado()==false) 
			   {
			   		try 
			   		{
						con = PoolConexion.dataSource.getConnection();
					} 
			   		catch (SQLException e) 
			   		{
						// TODO Auto-generated catch block
			   			e.printStackTrace();
			   			System.out.println(e.getMessage());
					}
			   }
		   return con;
	    }
	    
	    
	    public static void main(String[] args) throws SQLException 
		{
			// TODO Auto-generated method stub
			PoolConexion.getInstance();
			Connection con = null;
	        
	        try 
	        {
		    	con = PoolConexion.getConnection();
		    	if(con!=null)
		    	{
		    		JOptionPane.showMessageDialog(null, "Conectado a " + db +" !");
		    		System.out.println("Conectado a "+db+" !!!");
		    	}
		    	else
		    	{
		    		JOptionPane.showMessageDialog(null, "Error al Conectar a "+db+" !!!");
		    		System.out.println("Error al Conectar a "+db+" !!!");
		    	}
	        }
	        finally
	        {
	            try 
	            {
	               con.close();
	               System.out.println("Se desconectï¿½ de "+db+"!!!");
	            } 
	            catch (SQLException ex) 
	            {
	            	ex.printStackTrace();
	                System.out.println(ex.getMessage());
	            }
	        }

		}
	
}
