package br.com.validator.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Formatter;

import javax.swing.JOptionPane;

public class Pooling {

	public static void main(String[] args) {

		String linha = "";
		String tags = "TAG’s do BIT 48: 01, 02, 03, 43, 45, 46, 47, 48, 49, 4B, 88, 92, 93";

		String variavel92, variavel93, variavel4A;
		String SinalIdentificador, Sinalbit01, Sinalbit02, Sinalbit03, Sinalbit40, Sinalbit88, Sinalbit92, Sinalbit93,
				Sinalbit4A;
		String bitIdentificador, bit01, bit02, bit03, bit40 = null, bit4A = null, bit88 = null, bit92 = null,
				bit93 = null;
		int bit4Asize, bit92size, bit93size;

		String path = JOptionPane.showInputDialog("COLOQUE O REPOSITORIO ONDE SE ENCONTRA OS ARQUIVOS\n Ex: C:\\logs");
		String arq = JOptionPane.showInputDialog("DIGITE O NOME DO ARQUIVO A SER SALVO");
		String findText = JOptionPane.showInputDialog("DIGITE OQUE DESEJA PROCURAR");

		if (path.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Caminho em Branco, Fechando Aplicação");
			System.exit(0);

		}
		if (arq.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Nome do Arquivo em Branco, Fechando Aplicação");
			System.exit(0);

		}
		if (findText.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Palavra a ser Pesquisada em Branco, Fechando Aplicação");
			System.exit(0);
		}

		try {
			File diretorio = new File("C:\\log_salvo");
			diretorio.mkdir();

			Formatter saida = new Formatter("C:\\log_salvo\\" + arq + ".txt");
			File dirAudios = new File(path);
			File[] arquivos = null;
			arquivos = dirAudios.listFiles();
			for (File arquivo : arquivos) {

				FileReader reader = new FileReader(arquivo.getPath());
				BufferedReader leitor = new BufferedReader(reader);
				while (true) {
					linha = leitor.readLine();
					if (linha == null)
						break;
					if (linha.contains(findText)) {

						bitIdentificador = linha.substring(0, 2);
						bit01 = linha.substring(2, 8);
						bit02 = linha.substring(8, 26);
						bit03 = linha.substring(26, 32);
						bit40 = linha.substring(32, 36);

						variavel4A = linha.substring(40, 42);
						bit4Asize = Integer.parseInt(variavel4A);
						bit4Asize = bit4Asize * 2;
						bit4A = linha.substring(36, 42 + bit4Asize);

						bit88 = linha.substring(42 + bit4Asize, 80 + bit4Asize);

						variavel92 = linha.substring(84 + bit4Asize, 86 + bit4Asize);
						bit92size = Integer.parseInt(variavel92);
						bit92size = bit92size * 2;
						bit92 = linha.substring(80 + bit4Asize, 86 + bit4Asize + bit92size);

						variavel93 = linha.substring(90 + bit4Asize + bit92size, 92 + bit4Asize + bit92size);
						bit93size = Integer.parseInt(variavel93);
						bit93size = bit93size * 2;
						bit93 = linha.substring(86 + bit4Asize + bit92size, 92 + bit4Asize + bit92size + bit93size);

						if (bitIdentificador.equals("54")) {
							SinalIdentificador = "\tOK";
						} else {
							SinalIdentificador = "\tERRO";
						}
						if (bit01.equals("010490") || bit01.equals("010491")) {
							Sinalbit01 = "\tOK";
						} else {
							Sinalbit01 = "\tERRO";
						}
						if (bit02.length() == 18) {
							Sinalbit02 = "\tOK";
						} else {
							Sinalbit02 = "\tERRO";
						}
						if (bit03.length() == 6) {
							Sinalbit03 = "\tOK";
						} else {
							Sinalbit03 = "\tERRO";
						}

						if (bit40.length() == 4) {
							Sinalbit40 = "\tOK";
						} else {
							Sinalbit40 = "\tERRO";
						}
						if (bit4A.length() <= 56) {
							Sinalbit4A = "\tOK";
						} else {
							Sinalbit4A = "\tERRO";
						}

						if (bit88.length() == 38) {
							Sinalbit88 = "\tOK";
						} else {
							Sinalbit88 = "\tERRO";
						}

						if (bit92.length() <= 74) {
							Sinalbit92 = "\tOK";
						} else {
							Sinalbit92 = "\tERRO";
						}

						if (bit93.length() <= 44) {
							Sinalbit93 = "\tOK";
						} else {
							Sinalbit93 = "\tERRO";
						}

						saida.format("--Pooling--\r\n" + "\r\n" + bitIdentificador + SinalIdentificador + "\r\n" + bit01
								+ Sinalbit01 + "\r\n" + bit02 + Sinalbit02 + "\r\n" + bit03 + Sinalbit03 + "\r\n"
								+ bit40 + Sinalbit40 + "\r\n" + bit4A + Sinalbit4A + "\r\n" + bit88 + Sinalbit88
								+ "\r\n" + bit92 + Sinalbit92 + "\r\n" + bit93 + Sinalbit93 + "\r\n" + "\r\n"
								+ "----------------------------------------------------------------------------"
								+ "\r\n", args);
					}

				}

			}

			saida.close();
			JOptionPane.showMessageDialog(null, "ARQUIVO: " + arq + " SALVO EM: C:\\log_salvo");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(linha);
		}
	}

}