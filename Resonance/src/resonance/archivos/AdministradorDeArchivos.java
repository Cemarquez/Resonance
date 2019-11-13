package resonance.archivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import resonance.estructura.RedDeUsuarios;

public class AdministradorDeArchivos {

	private static String url = disco() + "/Resonance";

	public static void inicializar() {
		File file = new File(url + "/Usuarios");
		if (!file.exists()) {
			file.mkdirs();
		}

		File file1 = new File(url + "/Datos");
		if (!file1.exists()) {
			file1.mkdirs();
		}
	}

	/**
	 * Método para serializar el objeto que entra como párametro del mismo.
	 * 
	 * @param pPasajero Objeto a serializar.
	 */
	public static void serializarGrafo(RedDeUsuarios red) {
		try {

			FileOutputStream fos = new FileOutputStream(disco() + "Resonance/Datos/Data.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(red);
			oos.close();
			fos.close();
		}

		catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

	public static void crearCarpetaUsuario(String name) {
		File file = new File(url + "/Usuarios/" + name);
		if (!file.exists()) {
			file.mkdirs();
		}
	}

	public static boolean existUser(String name) {
		File file = new File(url + "/Usuarios/" + name + "/" + name + ".dat");
		if (file.exists()) {
			return true;
		}

		return false;
	}

	public static boolean existData() {
		File file = new File(disco() + "Resonance/Datos/Data.dat");
		if (file.exists()) {
			return true;
		}

		return false;
	}

	public static String obtenerIdUser(String fileName) {

		return fileName.substring(0, fileName.length() - 4);
	}

	public static RedDeUsuarios deserializarGrafo() {

		RedDeUsuarios grafo = null;

		try {
			FileInputStream fis = new FileInputStream(disco() + "Resonance/Datos/Data.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			grafo = (RedDeUsuarios) ois.readObject();
			ois.close();
			fis.close();
		}

		catch (IOException ioe) {
			ioe.printStackTrace();
		}

		catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		return grafo;
	}

	public static void cambiarFotoPerfil(File file, String username) {
		File fileDestino = new File(url + "/Usuarios/" + username + "/FotoPerfil.png");
		try {
			Files.copy(Paths.get(file.getAbsolutePath()), Paths.get(fileDestino.getAbsolutePath()),
					StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String getFormatoFoto(File file) {
		String name = file.getName();
		return name.substring(name.length() - 3, name.length());
	}

	public static File getFotoPerfil(String user) {
		File foto = null;

		File carpetaUsuario = new File(url + "/Usuarios/" + user);

		for (File v : carpetaUsuario.listFiles()) {
			if (v.getName().contains("FotoPerfil")) {
				return v;
			}
		}

		return foto;
	}

	public static RedDeUsuarios deserializarUser(String id) {

		RedDeUsuarios user = null;

		try {
			FileInputStream fis = new FileInputStream(disco() + "Resonance/Usuarios/" + id + "/" + id + ".dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			user = (RedDeUsuarios) ois.readObject();
			ois.close();
			fis.close();
		}

		catch (IOException ioe) {
			ioe.printStackTrace();
		}

		catch (ClassNotFoundException cnfe) {
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
