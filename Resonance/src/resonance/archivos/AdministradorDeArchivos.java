package resonance.archivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import resonance.estructura.RedDeUsuarios;
import resonance.excepciones.ExistException;
import resonance.excepciones.LimitException;
import resonance.usuario.Usuario;

public class AdministradorDeArchivos {

	private static String url = disco()+"/Resonance";
	
	public static void inicializar()
	{
		File file = new File(url);
		if(!file.exists()) {
			file.mkdirs();
		}
	}
	
	public static boolean existUser(String name)
	{
		File file = new File(url+"/Usuarios/"+name+".dat");
        if(file.exists()) {
        	return true;
        }
		
		return false;
	}
	
	public static void serializarUser (Usuario user)
	{
		try {
			
			FileOutputStream fos = new FileOutputStream(disco() +"/Usuarios/"+user.getID()+".dat");
			ObjectOutputStream oos =  new ObjectOutputStream(fos);
			oos.writeObject(user);
			oos.close();
			fos.close();	
		}
		
		
		catch (IOException ioe) 
		{
			ioe.printStackTrace();
		}
		
	}
	
	public static String obtenerIdUser (String fileName) {
		
		return fileName.substring(0, fileName.length()-4);
	}
	
	
	public static RedDeUsuarios deserializarGrafo() {
		
		RedDeUsuarios grafo  = new RedDeUsuarios ();
		File file = new File(url+ "/Usuarios/");
		for (File f : file.listFiles())
		{
			Usuario aux = deserializarUser(obtenerIdUser(f.getName()));
			try {
				grafo.agregar(obtenerIdUser(f.getName()), aux.getPerfil());
			} catch (LimitException | ExistException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return grafo;
	}
	
	
	
	
	public static Usuario deserializarUser(String id)
	{

		
		Usuario user = null;
		
		try
		{
		FileInputStream fis = new FileInputStream(disco() + "Resonance/Usuarios/"+id+".dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		user = (Usuario) ois.readObject();
		ois.close();
		fis.close();
	}
	
	catch (IOException ioe) 
	{
		ioe.printStackTrace();
	}
	
	catch (ClassNotFoundException cnfe)
	{
		cnfe.printStackTrace();
	}
		return user;
	}

	
	public static String disco() {
    	String dp = System.getProperty("user.home");
    	dp = dp.substring(0, 1);
    	dp = dp + ":" + '/';
    	return dp;
    }

	
}
