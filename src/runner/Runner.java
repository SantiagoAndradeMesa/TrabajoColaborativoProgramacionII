package runner;

import javax.swing.JOptionPane;

import model.Methods;

/**
 * Clase encargada en la creacion de un menu y la ejecucion del programa
 * 
 * @author Santiago Andrade
 * @author Karen Hernandez
 * @author Jeimmy Valderrama
 */
public class Runner {
	/**
	 * Metodo encargado de mostrar el menu con los metodos para trabajar los Strings
	 */
	public void menu() {
		String crypt = "";
		String oration = JOptionPane.showInputDialog("Ingrese una oracion");
		Methods method = new Methods(oration);
		boolean keyMenu = true;
		while (keyMenu == true) {
			try {
				if (oration.equals("")) {
					JOptionPane.showMessageDialog(null, "No ha digitado nada, saliendo del sistema");
					System.exit(0);
				} else {
					int opt = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido, elija una" + "opcion:\n"
							+ "1.Convertir en nombre propio\n" + "2.Buscar Cadena de Caracteres\n"
							+ "3.Encriptar cadena\n" + "4.Desencriptar cadena\n" + "5.Llenar Caracteres\n"
							+ "6.Borrar Caracteres\n" + "7.Interseccion\n" + "8.Diferencia\n" + "9.Borrar caracteres\n"
							+ "10.Validar Dirección de correo electronico\n" + "11.Salir"));
					switch (opt) {
					case 1:
						JOptionPane.showMessageDialog(null, method.ownName());
						break;
					case 2:
						String word = JOptionPane.showInputDialog("Ingrese la cadena que desea buscar(del, o, y)");
						JOptionPane.showMessageDialog(null, "cantidad de veces que se repite la cadena '" + word
								+ "' es " + method.searchString(word));
						break;
					case 3:
						String phrase = JOptionPane.showInputDialog("Ingrese la cadena a encriptar");
						crypt = phrase;
						JOptionPane.showMessageDialog(null, Methods.encrypt(crypt));
						break;
					case 4:
						if (crypt.equals("")) {
							JOptionPane.showMessageDialog(null, "No hay cadena para desencriptar");
						} else {
							JOptionPane.showMessageDialog(null, Methods.decrypt(crypt));
						}
						break;
					case 5:
						String character = JOptionPane.showInputDialog("Que caracter desea agregar");
						int quanty = Integer.parseInt(JOptionPane.showInputDialog("Cuantas veces desea agregarlo"));
						int opc = Integer.parseInt(JOptionPane.showInputDialog("1.Hacia la izquierda\n2.Derecha"));
						JOptionPane.showMessageDialog(null, method.charAdded(character, quanty, opc));
						break;
					case 6:
						String charToDelete = JOptionPane.showInputDialog("Ingrese el caracter a borrar");
						JOptionPane.showMessageDialog(null, method.deleteChar(charToDelete));
						break;
					case 7:
						String chain = JOptionPane.showInputDialog("Ingrese cadena a comparar con la original");
						JOptionPane.showMessageDialog(null, method.intersection(chain));
						break;
					case 8:
						String differChain = JOptionPane
								.showInputDialog("Ingrese la cadena para diferenciar con la original");
						JOptionPane.showMessageDialog(null, method.difference(differChain));
						break;
					case 9:
						String text = JOptionPane.showInputDialog("Ingrese cadena para borrar caracteres");
						int sideOpc = Integer.parseInt(JOptionPane
								.showInputDialog("Opc 1 para borrar por izquierda\nOpc 2 para borrar por derecha"));
						JOptionPane.showMessageDialog(null, method.eraseChars(text, sideOpc));
						break;
					case 10:
						String email = JOptionPane.showInputDialog("Ingrese un email");
						JOptionPane.showMessageDialog(null, method.msjEmail(email));
						break;
					case 11:
						JOptionPane.showMessageDialog(null, "Saliendo del sistema");
						keyMenu = false;
						break;
					default:
						JOptionPane.showMessageDialog(null, "Opcion no valida");
						break;
					}
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Ha tenido un error o ha cancelado una opcion, saliendo del sistema");
				System.exit(0);
			}
		}

	}

	/**
	 * Metodo encargado de ejecutar el programa
	 * 
	 * @param args - de tipo String
	 */
	public static void main(String... args) {
		Runner run = new Runner();
		run.menu();
	}

}
