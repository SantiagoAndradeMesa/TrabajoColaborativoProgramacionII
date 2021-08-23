package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
/**
 * Clase encargada de manipular cadenas de texto
 * @author Santiago Andrade
 * @author Karen Hernandez
 * @author Jeimmy Valderrama
 *
 */
public class Methods {

	/**
	 * Atributo de la clase logica el cual
	 */
	private String ORATION;

	/**
	 * Constructor de la clase
	 * 
	 * @param oration- de tipo cadena de texto
	 */
	public Methods(String oration) {
		this.ORATION = oration;

	}

	/**
	 * Metodo en donde convierte en nombre propio el contenido de la cadena
	 * 
	 * @return out- de tipo cadena de texto
	 */
	public String ownName() {
		String out = "";
		char c = ' ';
		int aux = 0;
		for (int i = 0; i < ORATION.length(); i++) {
			c = ORATION.charAt(i);
			if (i == 0) {
				c = Character.toUpperCase(c);
			}
			if (i >= 1) {
				c = Character.toLowerCase(c);
			}
			if (c == ' ') {
				aux = (i + 1);
			}
			if (aux == i) {
				if (c == 'y' || c == 'o' || c == 'u') {
					c = Character.toLowerCase(c);
				} else {
					c = Character.toUpperCase(c);
				}
			}
			out += c;
		}
		return out;
	}

	/**
	 * Metodo encargado de buscar y contar el numero de veces que existe la cadena
	 * 
	 * @param word-de tipo cadena de texto
	 * @return count- de tipo entero
	 */
	public int searchString(String word) {
		String in = ORATION;
		int count = 0;
		String arreglo[] = in.split(" ");
		for (int i = 0; i < arreglo.length; i++) {
			if (arreglo[i].equals(word)) {
				count += 1;
			}
		}
		return count;
	}

	/**
	 * Metodo estatico encargado de encriptar cadenas
	 * 
	 * @param phrase-de tipo cadena de texto
	 * @return enctrypted - de tipo cadena de texto
	 */
	public static String encrypt(String phrase) {
		char ecyt[] = phrase.toCharArray();
		/** ciclo para encriptar la cadena */
		for (int i = 0; i < ecyt.length; i++) {
//		La letra en esa posicion va a ser igual a 5 letras mas adelante en el abecedario
			ecyt[i] = (char) (ecyt[i] + (char) 5);
		}
		String encrypted = String.valueOf(ecyt);

		return encrypted;
	}

	/**
	 * Metodo estatico encargado de desencriptar la cadena encriptada
	 * 
	 * @param phrase - de tipo cadena de texto
	 * @return decrypt - de tipo cadena de texto
	 */
	public static String decrypt(String phrase) {
		String encrypted = encrypt(phrase);
		char ecyt[] = encrypted.toCharArray();
		/** Ciclo para desencriptar la cadena */
		for (int i = 0; i < ecyt.length; i++) {
			ecyt[i] = (char) (ecyt[i] - (char) 5);
		}
		String decrypt = String.valueOf(ecyt);

		return decrypt;
	}

	/**
	 * Metodo encargado de concatenar o agregar un caracter n veces por izquierda o
	 * derecha
	 * 
	 * @param addLetter-de tipo cadena de texto
	 * @param quanty-de    tipo entero
	 * @param opc-         de tipo entero
	 * @return out- de tipo cadena de texto
	 */
	public String charAdded(String addLetter, int quanty, int opc) {
		String out = "";
		int cant = 0;
		String letterConvert = "";
		char letter = ' ';
		char c = ' ';
		// Scanner sc = new Scanner(System.in);
		for (int i = 0; i < ORATION.length(); i++) {
			c = ORATION.charAt(i);
			out += c;
		}
		letterConvert = addLetter;
		letter = letterConvert.charAt(0);
		// System.out.println("Cual letra desea agregar");
		// letter = sc.next().charAt(0);
		cant = quanty;
		// System.out.println("Cuantas letras desea agregar");
		// cant = sc.nextInt();
		// System.out.println("Agregarlo al inicio = 1 \n Agregarlo al final = 2");
		// opc = sc.nextInt();
		String add = "";
		for (int i = 0; i < cant; i++) {
			add += letter;
		}
		if (opc == 1) {
			out = add + out;
		} else if (opc == 2) {
			out = out + add;
		} else {
			out = "opcion no valida";
		}

		return out;

	}

	/**
	 * Metodo encargado de borrar caracteres, donde retornara la cadena sin los
	 * caracteres
	 * 
	 * @param charToDelete - de tipo cadena de texto
	 * @return out- de tipo cadena de texto
	 */
	public String deleteChar(String charToDelete) {
		String out = "";
		String deleteChar = charToDelete;
		char c = ' ';
		// char delete = ' ';
		for (int i = 0; i < ORATION.length(); i++) {
			c = ORATION.charAt(i);
			try {
				if (c == deleteChar.charAt(0)) {
					c = ORATION.charAt(i + 1);
					i++;
				}
				out += c;
			} catch (Exception e) {

			}

		}
		return out;
	}

	/**
	 * Metodo encargado de retornar la interseccion entre dos cadenas
	 * 
	 * @param chain- de tipo cadena de texto
	 * @return intersect- de tipo cadena de texto
	 */
	public String intersection(String chain) {
		String intersect = "";
		for (int i = 0; i < chain.length(); i++) {
			String got = Character.toString(chain.charAt(i));
			if (ORATION.contains(got)) {
				if (!intersect.contains(got)) {
					intersect += got;
				}
			}
		}
		return intersect;
	}

	/**
	 * Metodo encargado de retornra la diferencia de caracteres que tiene la cadena
	 * original con la de entrada
	 * 
	 * @param differChain -de tipo texto
	 * @return differ - de tipo cadena de texto
	 */
	public String difference(String differChain) {
		String differ = "";
		for (int i = 0; i < ORATION.length(); i++) {
			String getIt = Character.toString(ORATION.charAt(i));
			if (!differChain.contains(getIt)) {
				differ += getIt;
			}
		}
		return differ;
	}

	/**
	 * Metodo encargado de borrar caracteres ya sea por derecha o izquierda
	 * 
	 * @param text-de tipo cadena de texto
	 * @param sideOpc- de tipo entero
	 * @return endText- de tipo String
	 */
	public String eraseChars(String text, int sideOpc) {
		String endText = ORATION;
		if (sideOpc == 1) {
			for (int i = 0; i < ORATION.length(); i++) {
				if (frequency(ORATION.substring(i, i + 1), text)) {
					endText = ORATION.substring(i + 1, ORATION.length());
				} else {
					return endText;
				}

			}
			return endText;
		} else if (sideOpc == 2) {
			for (int i = ORATION.length(); i >= 0; i--) {
				if (frequency(ORATION.substring(i - 1, i), text)) {
					endText = ORATION.substring(0, i - 1);
				} else {
					return endText;
				}

			}
			return endText;
		} else {
			return "Opcion no valida";
		}
	}

	/**
	 * Metodo encargado de buscar y determinar la frecuencia en la que se repiten
	 * caracteres entre la cadena y retornar un booleano para asi poder determinar
	 * los caracteres a borrar por izquierda o derecha
	 * 
	 * @param character-de tipo String
	 * @param string-de    tipo cadena de texto
	 * @return true or false-de tipo booleano
	 */
	public boolean frequency(String character, String string) {
		int counter = 0;
		for (int i = 0; i < string.length(); i++) {
			if (string.substring(i, i + 1).equalsIgnoreCase(character)) {
				counter++;
			}
		}
		if (counter == 0)
			return false;
		else
			return true;
	}

	/**
	 * Metodo encargado de evaluar y retornar un mensaje si un email es valido o no
	 * 
	 * @param email - de tipo cadena de texto
	 * @return validation - de tipo String
	 */
	public String msjEmail(String email) {
		if (validEmail(email) == true) {
			return email + " es un email valido";
		} else {
			return email + " no es un email valido";
		}
	}

	/**
	 * Metodo de tipo boolean encargado de validar si un email es valido o no
	 * 
	 * @param email- de tipo cadena de texto
	 * @return match - de la clase Matcher
	 */
	public boolean validEmail(String email) {
		Pattern pattern = Pattern
				.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher matcher = pattern.matcher(email);
		return matcher.find();
	}
}
