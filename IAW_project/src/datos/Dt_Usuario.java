package datos;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidades.Tbl_user;


public class Dt_Usuario {
	PoolConexion pc = PoolConexion.getInstance();
	Connection c = PoolConexion.getConnection();
	private ResultSet rsUsuario;
	
	public ArrayList<Tbl_user> listUser(){
		ArrayList<Tbl_user> listarUsuario = new ArrayList<Tbl_user>();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("SELECT * FROM tbl_user WHERE estado <> 3",
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE,
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			
			rsUsuario = ps.executeQuery();
			
			while(rsUsuario.next())
			{
				Tbl_user tus = new Tbl_user();
				tus.setId_user(rsUsuario.getInt("id_user"));
				tus.setUsername(rsUsuario.getString("username"));
				tus.setPwd(rsUsuario.getString("password"));
				tus.setNombre1(rsUsuario.getString("nombre1"));
				tus.setNombre2(rsUsuario.getString("nombre2"));
				tus.setApellido1(rsUsuario.getString("apellido1"));
				tus.setApellido2(rsUsuario.getString("apellido2"));
				tus.setPwd_tmp(rsUsuario.getString("pwd_tmp"));
				tus.setEmail(rsUsuario.getString("email"));
				tus.setEstado(rsUsuario.getInt("estado"));
				String hostname = InetAddress.getLocalHost().getHostName();
				
				
				listarUsuario.add(tus);
			}
		}
		catch(Exception e){
			System.out.println("DATOS: ERROR en listUser()" + e.getMessage());
			e.printStackTrace();
		}
		
		return listarUsuario;
	}
	
}
