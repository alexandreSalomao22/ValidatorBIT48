package br.com.validator.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Formatter;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {

		String linha = "";
		String tags = "BitIdentificador = 54, bit01, bit02, bit03, bit40 = fixo 2 posi��es, bit4A, bit88,bit92,bit93";
		
		String varivavel43, variavel45, variavel46, variavel47, variavel92, variavel93, variavel4A;
		String SinalIdentificador, Sinalbit40, Sinalbit4A ,Sinalbit01, Sinalbit02, Sinalbit03, Sinalbit04, Sinalbit43, Sinalbit45, Sinalbit46, Sinalbit47, Sinalbit48, Sinalbit49, Sinalbit4b, Sinalbit88, Sinalbit92, Sinalbit93;
		String bitIdentificador, bit4A = null, bit40 = null ,bit01, bit02, bit03, bit04 = null, bit43 = null, bit45 = null, bit46 = null, bit47 = null, bit48 = null, bit49 = null, bit4b = null, bit88 = null, bit92 = null, bit93 = null;
		int bit43size, bit45size, bit46size, bit47size, bit92size, bit93size, bit4Asize;
		
		
		String path = JOptionPane
				.showInputDialog("COLOQUE O REPOSITORIO ONDE SE ENCONTRA OS ARQUIVOS\n Ex: C:\\logs");
		String arq = JOptionPane.showInputDialog("DIGITE O NOME DO ARQUIVO A SER SALVO");
		String findText = JOptionPane.showInputDialog("DIGITE OQUE DESEJA PROCURAR");
		
		if(path.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Caminho em Branco, Fechando Aplica��o");
			System.exit(0);
			
		} if (arq.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Nome do Arquivo em Branco, Fechando Aplica��o");
			System.exit(0);
			
		} if (findText.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Palavra a ser Pesquisada em Branco, Fechando Aplica��o");
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
						
						String verificacao = linha.substring(14,16);
						int v = Integer.parseInt(verificacao);
						// VENDA PARCELADA
						if(linha.substring(32, 36).equals("0403")) {
							bitIdentificador = linha.substring(0, 2);
							bit01 = linha.substring(2, 8);
							bit02 = linha.substring(8, 26);
							bit03 = linha.substring(26,32);
							bit04 = linha.substring(32, 36);
							
							varivavel43 = linha.substring(40,42);
							bit43size = Integer.parseInt(varivavel43);
							bit43size = bit43size*2;
							bit43 = linha.substring(36, 36+bit43size+6);
							
							variavel45 = linha.substring(46+bit43size,48+bit43size);
							bit45size = Integer.parseInt(variavel45);
							bit45size = bit45size*2;
							bit45 = linha.substring(42+bit43size, 42+bit43size+bit45size+6);
							
							variavel46 = linha.substring(52+bit43size+bit45size, 54+bit43size+bit45size);
							bit46size = Integer.parseInt(variavel46);
							bit46size = bit46size*2;
							bit46 = linha.substring(48+bit43size+bit45size, 48+bit43size+bit45size+bit46size+6);
							
							variavel47 = linha.substring(58+bit43size+bit45size+bit46size, 60+bit43size+bit45size+bit46size);
							bit47size = Integer.parseInt(variavel47);
							bit47size = bit47size*2;
							bit47 = linha.substring(54+bit43size+bit45size+bit46size, 54+bit43size+bit45size+bit46size+bit47size+6);
							
							bit48 = linha.substring(60+bit43size+bit45size+bit46size+bit47size, 66+bit43size+bit45size+bit46size+bit47size);
							bit49 = linha.substring(66+bit43size+bit45size+bit46size+bit47size, 84+bit43size+bit45size+bit46size+bit47size);
							bit4b = linha.substring(84+bit43size+bit45size+bit46size+bit47size, 92+bit43size+bit45size+bit46size+bit47size);			
							bit88 = linha.substring(92+bit43size+bit45size+bit46size+bit47size, 130+bit43size+bit45size+bit46size+bit47size);
							
							variavel92 = linha.substring(134+bit43size+bit45size+bit46size+bit47size, 136+bit43size+bit45size+bit46size+bit47size);
							bit92size = Integer.parseInt(variavel92);
							bit92size = bit92size*2;
							bit92 = linha.substring(130+bit43size+bit45size+bit46size+bit47size, 136+bit43size+bit45size+bit46size+bit47size+bit92size);
							
							variavel93 = linha.substring(140+bit43size+bit45size+bit46size+bit47size+bit92size, 142+bit43size+bit45size+bit46size+bit47size+bit92size);
							bit93size = Integer.parseInt(variavel93);
							bit93size = bit93size*2;
							bit93 = linha.substring(136+bit43size+bit45size+bit46size+bit47size+bit92size, 142+bit43size+bit45size+bit46size+bit47size+bit92size+bit93size);
							
							if (bitIdentificador.equals("54")) 
							{
								SinalIdentificador = "\tOK";
							}
							else 	{
									SinalIdentificador = "\tERRO";
									}
						if (bit01.equals("010490") || bit01.equals("010491"))
							{	
								Sinalbit01 = "\tOK";
							}
							else {
								Sinalbit01 = "\tERRO";
							}
						if ( bit02.length() == 18 && bit02.substring(0,2).equals("02")) 
							{
								Sinalbit02 = "\tOK";
							}
							else {
							Sinalbit02 = "\tERRO";
						}
						if (bit03.length() == 6 && bit03.substring(0,2).equals("03")) {
							Sinalbit03 = "\tOK";
						}
							else {
							Sinalbit03 = "\tERRO";
						}
						if (bit04.length() == 4 && bit04.substring(0,2).equals("04")) {
							Sinalbit04 = "\tOK";
						}
							else {
							Sinalbit04 = "\tERRO";
						}
						
						if (bit43.length() <= 34 && bit43.substring(0,2).equals("43"))
						{
							Sinalbit43 = "\tOK";
						}
							else {
							Sinalbit43 = "\tERRO";
						}
						if (bit45.length() <= 52 && bit45.substring(0,2).equals("45"))
						{
							Sinalbit45 = "\tOK";
						}
							else {
							Sinalbit45 = "\tERRO";
						}
						
						if (bit46.length() <= 40 && bit46.substring(0,2).equals("46"))
						{
							Sinalbit46 = "\tOK";
						}
							else {
							Sinalbit46 = "\tERRO";
						}
						
						if (bit47.length() <= 14 && bit47.substring(0,2).equals("47"))
						{
							Sinalbit47 = "\tOK";
						}
							else {
							Sinalbit47 = "\tERRO";
						}
						
						if (bit48.length() == 6 && bit48.equals("480001") || bit48.equals("480002") || bit48.equals("480003") || bit48.equals("480004") && bit48.substring(0,2).equals("48"))
						{
							Sinalbit48 = "\tOK";
						}
							else {
							Sinalbit48 = "\tERRO";
						}
						if (bit49.length() == 18 && bit49.substring(0,2).equals("49"))
						{
							Sinalbit49 = "\tOK";
						}
							else {
							Sinalbit49 = "\tERRO";
						}
						
						if (bit4b.length() == 8 && bit4b.substring(0,2).equalsIgnoreCase("4B"))
						{
							Sinalbit4b = "\tOK";
						}
							else {
							Sinalbit4b = "\tERRO";
						}
						
						if (bit88.length() == 38 && bit88.substring(0,2).equals("88"))
						{
							Sinalbit88 = "\tOK";
						}
							else {
							Sinalbit88 = "\tERRO";
						}
						
						if (bit92.length() <= 74 && bit92.substring(0,2).equals("92"))
						{
							Sinalbit92 = "\tOK";
						}
							else {
							Sinalbit92 = "\tERRO";
						}
						
						if (bit93.length() <= 44 && bit93.substring(0,2).equals("93"))
						{
							Sinalbit93 = "\tOK";
						}
							else {
							Sinalbit93 = "\tERRO";
						}
							

						saida.format("--Venda Parcelada--\r\n" + "\r\n" + bitIdentificador  + SinalIdentificador + "\r\n" + bit01 + Sinalbit01 + "\r\n" + bit02 + Sinalbit02 + "\r\n"
								+ bit03 + Sinalbit03 + "\r\n" + bit04 + Sinalbit04 + "\r\n" + bit43 + Sinalbit43 + "\r\n" + bit45 + Sinalbit45 + "\r\n"
								 + bit46 + Sinalbit46 + "\r\n" + bit47 + Sinalbit47 + "\r\n" + bit48 + Sinalbit48 + "\r\n" + bit49 + Sinalbit49 + "\r\n"
								 + bit4b + Sinalbit4b + "\r\n" + bit88 + Sinalbit88 + "\r\n" + bit92 + Sinalbit92 + "\r\n" + bit93 + Sinalbit93 + "\r\n"
								 + "\r\n" + "----------------------------------------------------------------------------" + "\r\n", args);
						}
						
						
						// ESTORNO A VISTA
						else if (linha.substring(2,4).equals("01") && linha.substring(8,10).equals("03") && v != 04 ) {
							bitIdentificador = linha.substring(0, 2);
							bit01 = linha.substring(2, 8);
							bit03 = linha.substring(8, 14);
							
							varivavel43 = linha.substring(18,20);
							bit43size = Integer.parseInt(varivavel43);
							bit43size = bit43size*2;
							bit43 = linha.substring(14, 20+bit43size);
							
							variavel45 = linha.substring(24+bit43size,26+bit43size);
							bit45size = Integer.parseInt(variavel45);
							bit45size = bit45size*2;
							bit45 = linha.substring(20+bit43size, 26+bit43size+bit45size);
							
							variavel46 = linha.substring(30+bit43size+bit45size, 32+bit43size+bit45size);
							bit46size = Integer.parseInt(variavel46);
							bit46size = bit46size*2;
							bit46 = linha.substring(26+bit43size+bit45size, 32+bit43size+bit45size+bit46size);
							
							variavel47 = linha.substring(36+bit43size+bit45size+bit46size, 38+bit43size+bit45size+bit46size);
							bit47size = Integer.parseInt(variavel47);
							bit47size = bit47size*2;
							bit47 = linha.substring(32+bit43size+bit45size+bit46size, 38+bit43size+bit45size+bit46size+bit47size);
							
							bit48 = linha.substring(38+bit43size+bit45size+bit46size+bit47size, 44+bit43size+bit45size+bit46size+bit47size);
							bit49 = linha.substring(44+bit43size+bit45size+bit46size+bit47size, 62+bit43size+bit45size+bit46size+bit47size);
							
							variavel4A = linha.substring(66+bit43size+bit45size+bit46size+bit47size, 68+bit43size+bit45size+bit46size+bit47size);
							bit4Asize = Integer.parseInt(variavel4A);
							bit4Asize = bit4Asize*2;
							bit4A = linha.substring(62+bit43size+bit45size+bit46size+bit47size, 68+bit43size+bit45size+bit46size+bit47size+bit4Asize);
							
							bit88 = linha.substring(68+bit43size+bit45size+bit46size+bit47size+bit4Asize, 106+bit43size+bit45size+bit46size+bit47size+bit4Asize);
							
							variavel92 = linha.substring(110+bit43size+bit45size+bit46size+bit47size+bit4Asize, 112+bit43size+bit45size+bit46size+bit47size+bit4Asize);
							bit92size = Integer.parseInt(variavel92);
							bit92size = bit92size*2;
							bit92 = linha.substring(106+bit43size+bit45size+bit46size+bit47size+bit4Asize, 112+bit43size+bit45size+bit46size+bit47size+bit4Asize+bit92size);
							
							variavel93 = linha.substring(116+bit43size+bit45size+bit46size+bit47size+bit4Asize+bit92size, 118+bit43size+bit45size+bit46size+bit47size+bit4Asize+bit92size);
							bit93size = Integer.parseInt(variavel93);
							bit93size = bit93size*2;
							bit93 = linha.substring(112+bit43size+bit45size+bit46size+bit47size+bit4Asize+bit92size, 118+bit43size+bit45size+bit46size+bit47size+bit4Asize+bit92size+bit93size);
							
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

							if (bit03.length() == 6 && bit03.substring(0,2).equals("03")) {
								Sinalbit03 = "\tOK";
							} else {
								Sinalbit03 = "\tERRO";
							}
							
							if (bit43.length() <= 34 && bit43.substring(0,2).equals("43")) {
								Sinalbit43 = "\tOK";
							} else {
								Sinalbit43 = "\tERRO";
							}
							
							if (bit45.length() <= 52 && bit45.substring(0,2).equals("45")) {
								Sinalbit45 = "\tOK";
							} else {
								Sinalbit45 = "\tERRO";
							}
							
							if (bit46.length() <= 40 && bit46.substring(0,2).equals("46")) {
								Sinalbit46 = "\tOK";
							} else {
								Sinalbit46 = "\tERRO";
							}
							if (bit47.length() <= 14 && bit47.substring(0,2).equals("47")) {
								Sinalbit47 = "\tOK";
							} else {
								Sinalbit47 = "\tERRO";
							}
							if (bit48.length() == 6 && bit48.equals("480001") || bit48.equals("480002") || bit48.equals("480003") || bit48.equals("480004") && bit48.substring(0,2).equals("48"))
							{
								Sinalbit48 = "\tOK";
							}
								else {
								Sinalbit48 = "\tERRO";
							}
							if (bit49.length() == 18 && bit49.substring(0,2).equals("49"))
							{
								Sinalbit49 = "\tOK";
							}
								else {
								Sinalbit49 = "\tERRO";
							}

							if (bit4A.length() <= 56 && bit4A.substring(0,2).equalsIgnoreCase("4A")) {
								Sinalbit4A = "\tOK";
							} else {
								Sinalbit4A = "\tERRO";
							}

							if (bit88.length() == 38 && bit88.substring(0,2).equals("88")) {
								Sinalbit88 = "\tOK";
							} else {
								Sinalbit88 = "\tERRO";
							}

							if (bit92.length() <= 74 && bit92.substring(0,2).equals("92")) {
								Sinalbit92 = "\tOK";
							} else {
								Sinalbit92 = "\tERRO";
							}

							if (bit93.length() <= 44 && bit93.substring(0,2).equals("93")) {
								Sinalbit93 = "\tOK";
							} else {
								Sinalbit93 = "\tERRO";
							}

							saida.format("--Estorno A Vista--\r\n" + "\r\n" + bitIdentificador + SinalIdentificador + "\r\n" + bit01
									+ Sinalbit01 + "\r\n" + bit03 + Sinalbit03 + "\r\n"
									+ bit43 + Sinalbit43  + "\r\n" + bit45 + Sinalbit45 + "\r\n" + bit46 + Sinalbit46 + "\r\n"+ bit47 + Sinalbit47 + "\r\n" 
									+ bit48 + Sinalbit48 + "\r\n"+ bit49 + Sinalbit49 + "\r\n" +  bit4A + Sinalbit4A + "\r\n" + bit88 + Sinalbit88
									+ "\r\n" + bit92 + Sinalbit92 + "\r\n" + bit93 + Sinalbit93 + "\r\n" + "\r\n"
									+ "----------------------------------------------------------------------------"
									+ "\r\n", args);
						}
						
						//ESTORNO PARCELADO
						else if(linha.substring(14,18).equals("0403")) {
							bitIdentificador = linha.substring(0, 2);
							bit01 = linha.substring(2, 8);
							bit03 = linha.substring(8, 14);
							bit04 = linha.substring(14,18);
							
							varivavel43 = linha.substring(22,24);
							bit43size = Integer.parseInt(varivavel43);
							bit43size = bit43size*2;
							bit43 = linha.substring(18, 24+bit43size);
							
							variavel45 = linha.substring(28+bit43size,30+bit43size);
							bit45size = Integer.parseInt(variavel45);
							bit45size = bit45size*2;
							bit45 = linha.substring(24+bit43size, 30+bit43size+bit45size);
							
							variavel46 = linha.substring(34+bit43size+bit45size, 36+bit43size+bit45size);
							bit46size = Integer.parseInt(variavel46);
							bit46size = bit46size*2;
							bit46 = linha.substring(30+bit43size+bit45size, 36+bit43size+bit45size+bit46size);
							
							variavel47 = linha.substring(40+bit43size+bit45size+bit46size, 42+bit43size+bit45size+bit46size);
							bit47size = Integer.parseInt(variavel47);
							bit47size = bit47size*2;
							bit47 = linha.substring(36+bit43size+bit45size+bit46size, 42+bit43size+bit45size+bit46size+bit47size);
							
							bit48 = linha.substring(42+bit43size+bit45size+bit46size+bit47size, 48+bit43size+bit45size+bit46size+bit47size);
							bit49 = linha.substring(48+bit43size+bit45size+bit46size+bit47size, 66+bit43size+bit45size+bit46size+bit47size);
							
							variavel4A = linha.substring(70+bit43size+bit45size+bit46size+bit47size, 72+bit43size+bit45size+bit46size+bit47size);
							bit4Asize = Integer.parseInt(variavel4A);
							bit4Asize = bit4Asize*2;
							bit4A = linha.substring(66+bit43size+bit45size+bit46size+bit47size, 72+bit43size+bit45size+bit46size+bit47size+bit4Asize);
							
							bit88 = linha.substring(72+bit43size+bit45size+bit46size+bit47size+bit4Asize, 110+bit43size+bit45size+bit46size+bit47size+bit4Asize);
							
							variavel92 = linha.substring(114+bit43size+bit45size+bit46size+bit47size+bit4Asize, 116+bit43size+bit45size+bit46size+bit47size+bit4Asize);
							bit92size = Integer.parseInt(variavel92);
							bit92size = bit92size*2;
							bit92 = linha.substring(110+bit43size+bit45size+bit46size+bit47size+bit4Asize, 116+bit43size+bit45size+bit46size+bit47size+bit4Asize+bit92size);
							
							variavel93 = linha.substring(120+bit43size+bit45size+bit46size+bit47size+bit4Asize+bit92size, 122+bit43size+bit45size+bit46size+bit47size+bit4Asize+bit92size);
							bit93size = Integer.parseInt(variavel93);
							bit93size = bit93size*2;
							bit93 = linha.substring(116+bit43size+bit45size+bit46size+bit47size+bit4Asize+bit92size, 122+bit43size+bit45size+bit46size+bit47size+bit4Asize+bit92size+bit93size);
							
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

							if (bit03.length() == 6 && bit03.substring(0,2).equals("03")) {
								Sinalbit03 = "\tOK";
							} else {
								Sinalbit03 = "\tERRO";
							}
							
							if (bit04.length() == 4 && bit04.substring(0,2).equals("04")) {
								Sinalbit04 = "\tOK";
							} else {
								Sinalbit04 = "\tERRO";
							}
							
							if (bit43.length() <= 34 && bit43.substring(0,2).equals("43")) {
								Sinalbit43 = "\tOK";
							} else {
								Sinalbit43 = "\tERRO";
							}
							
							if (bit45.length() <= 52 && bit45.substring(0,2).equals("45")) {
								Sinalbit45 = "\tOK";
							} else {
								Sinalbit45 = "\tERRO";
							}
							
							if (bit46.length() <= 40 && bit46.substring(0,2).equals("46")) {
								Sinalbit46 = "\tOK";
							} else {
								Sinalbit46 = "\tERRO";
							}
							if (bit47.length() <= 14 && bit47.substring(0,2).equals("47")) {
								Sinalbit47 = "\tOK";
							} else {
								Sinalbit47 = "\tERRO";
							}
							if (bit48.length() == 6 && bit48.equals("480001") || bit48.equals("480002") || bit48.equals("480003") || bit48.equals("480004") && bit48.substring(0,2).equals("48") )
							{
								Sinalbit48 = "\tOK";
							}
								else {
								Sinalbit48 = "\tERRO";
							}
							if (bit49.length() == 18 && bit49.substring(0,2).equals("49"))
							{
								Sinalbit49 = "\tOK";
							}
								else {
								Sinalbit49 = "\tERRO";
							}

							if (bit4A.length() <= 56 && bit4A.substring(0,2).equalsIgnoreCase("4A")) {
								Sinalbit4A = "\tOK";
							} else {
								Sinalbit4A = "\tERRO";
							}

							if (bit88.length() == 38 && bit88.substring(0,2).equals("88")) {
								Sinalbit88 = "\tOK";
							} else {
								Sinalbit88 = "\tERRO";
							}

							if (bit92.length() <= 74 && bit92.substring(0,2).equals("92")) {
								Sinalbit92 = "\tOK";
							} else {
								Sinalbit92 = "\tERRO";
							}

							if (bit93.length() <= 44 && bit93.substring(0,2).equals("93")) {
								Sinalbit93 = "\tOK";
							} else {
								Sinalbit93 = "\tERRO";
							}
							
							saida.format("--Estorno Parcelado--\r\n" + "\r\n" + bitIdentificador + SinalIdentificador + "\r\n" + bit01
									+ Sinalbit01 + "\r\n" + bit03 + Sinalbit03 + "\r\n"
									+ bit04 + Sinalbit04 + "\r\n" + bit43 + Sinalbit43  + "\r\n" + bit45 + Sinalbit45 + "\r\n" + bit46 + Sinalbit46 + "\r\n"+ bit47 + Sinalbit47 + "\r\n" 
									+ bit48 + Sinalbit48 + "\r\n"+ bit49 + Sinalbit49 + "\r\n" +  bit4A + Sinalbit4A + "\r\n" + bit88 + Sinalbit88
									+ "\r\n" + bit92 + Sinalbit92 + "\r\n" + bit93 + Sinalbit93 + "\r\n" + "\r\n"
									+ "----------------------------------------------------------------------------"
									+ "\r\n", args);
							
						}
						
						//POOLING
						
						else if (linha.substring(32, 36).equals("4001"))
						{
							bitIdentificador = linha.substring(0, 2);
							bit01 = linha.substring(2, 8);
							bit02 = linha.substring(8, 26);
							bit03 = linha.substring(26,32);
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
							if (bit02.length() == 18 && bit02.substring(0,2).equals("02")) {
								Sinalbit02 = "\tOK";
							} else {
								Sinalbit02 = "\tERRO";
							}
							if (bit03.length() == 6 && bit03.substring(0,2).equals("03")) {
								Sinalbit03 = "\tOK";
							} else {
								Sinalbit03 = "\tERRO";
							}

							if (bit40.length() == 4 && bit40.substring(0,2).equals("40")) {
								Sinalbit40 = "\tOK";
							} else {
								Sinalbit40 = "\tERRO";
							}
							if (bit4A.length() <= 56 && bit4A.substring(0,2).equalsIgnoreCase("4A")) {
								Sinalbit4A = "\tOK";
							} else {
								Sinalbit4A = "\tERRO";
							}

							if (bit88.length() == 38 && bit88.substring(0,2).equals("88")) {
								Sinalbit88 = "\tOK";
							} else {
								Sinalbit88 = "\tERRO";
							}

							if (bit92.length() <= 74 && bit92.substring(0,2).equals("92")) {
								Sinalbit92 = "\tOK";
							} else {
								Sinalbit92 = "\tERRO";
							}

							if (bit93.length() <= 44 && bit93.substring(0,2).equals("93")) {
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
						
						//VENDA A VISTA
						else {
							
							bitIdentificador = linha.substring(0, 2);
							bit01 = linha.substring(2, 8);
							bit02 = linha.substring(8, 26);
							bit03 = linha.substring(26,32);
							varivavel43 = linha.substring(36,38);
							bit43size = Integer.parseInt(varivavel43);
							bit43size = bit43size*2;
							bit43 = linha.substring(32, 32+bit43size+6);
							
							variavel45 = linha.substring(42+bit43size,44+bit43size);
							bit45size = Integer.parseInt(variavel45);
							bit45size = bit45size*2;
							bit45 = linha.substring(38+bit43size, 38+bit43size+bit45size+6);
							
							variavel46 = linha.substring(48+bit43size+bit45size, 50+bit43size+bit45size);
							bit46size = Integer.parseInt(variavel46);
							bit46size = bit46size*2;
							bit46 = linha.substring(44+bit43size+bit45size, 44+bit43size+bit45size+bit46size+6);
							
							variavel47 = linha.substring(54+bit43size+bit45size+bit46size, 56+bit43size+bit45size+bit46size);
							bit47size = Integer.parseInt(variavel47);
							bit47size = bit47size*2;
							bit47 = linha.substring(50+bit43size+bit45size+bit46size, 50+bit43size+bit45size+bit46size+bit47size+6);
							
							bit48 = linha.substring(56+bit43size+bit45size+bit46size+bit47size, 62+bit43size+bit45size+bit46size+bit47size);
							bit49 = linha.substring(62+bit43size+bit45size+bit46size+bit47size, 80+bit43size+bit45size+bit46size+bit47size);
							bit4b = linha.substring(80+bit43size+bit45size+bit46size+bit47size, 88+bit43size+bit45size+bit46size+bit47size);			
							bit88 = linha.substring(88+bit43size+bit45size+bit46size+bit47size, 126+bit43size+bit45size+bit46size+bit47size);
							
							variavel92 = linha.substring(130+bit43size+bit45size+bit46size+bit47size, 132+bit43size+bit45size+bit46size+bit47size);
							bit92size = Integer.parseInt(variavel92);
							bit92size = bit92size*2;
							bit92 = linha.substring(126+bit43size+bit45size+bit46size+bit47size, 132+bit43size+bit45size+bit46size+bit47size+bit92size);
							
							variavel93 = linha.substring(136+bit43size+bit45size+bit46size+bit47size+bit92size, 138+bit43size+bit45size+bit46size+bit47size+bit92size);
							bit93size = Integer.parseInt(variavel93);
							bit93size = bit93size*2;
							bit93 = linha.substring(132+bit43size+bit45size+bit46size+bit47size+bit92size, 138+bit43size+bit45size+bit46size+bit47size+bit92size+bit93size);
							
							if (bitIdentificador.equals("54")) 
							{
								SinalIdentificador = "\tOK";
							}
							else 	{
									SinalIdentificador = "\tERRO";
									}
						if (bit01.equals("010490") || bit01.equals("010491"))
							{	
								Sinalbit01 = "\tOK";
							}
							else {
								Sinalbit01 = "\tERRO";
							}
						if ( bit02.length() == 18 && bit02.substring(0,2).equals("02")) 
							{
								Sinalbit02 = "\tOK";
							}
							else {
							Sinalbit02 = "\tERRO";
						}
						if (bit03.length() == 6 && bit03.substring(0,2).equals("03")) {
							Sinalbit03 = "\tOK";
						}
							else {
							Sinalbit03 = "\tERRO";
						}
						
						if (bit43.length() <= 34 && bit43.substring(0,2).equals("43"))
						{
							Sinalbit43 = "\tOK";
						}
							else {
							Sinalbit43 = "\tERRO";
						}
						if (bit45.length() <= 52 && bit45.substring(0,2).equals("45"))
						{
							Sinalbit45 = "\tOK";
						}
							else {
							Sinalbit45 = "\tERRO";
						}
						
						if (bit46.length() <= 40 && bit46.substring(0,2).equals("46"))
						{
							Sinalbit46 = "\tOK";
						}
							else {
							Sinalbit46 = "\tERRO";
						}
						
						if (bit47.length() <= 14 && bit47.substring(0,2).equals("47"))
						{
							Sinalbit47 = "\tOK";
						}
							else {
							Sinalbit47 = "\tERRO";
						}
						
						if (bit48.length() == 6 && bit48.equals("480001") || bit48.equals("480002") || bit48.equals("480002") || bit48.equals("480003") || bit48.equals("480004") && bit48.substring(0,2).equals("48"))
						{
							Sinalbit48 = "\tOK";
						}
							else {
							Sinalbit48 = "\tERRO";
						}
						if (bit49.length() == 18 && bit49.substring(0,2).equals("49"))
						{
							Sinalbit49 = "\tOK";
						}
							else {
							Sinalbit49 = "\tERRO";
						}
						
						if (bit4b.length() == 8 && bit4b.substring(0,2).equalsIgnoreCase("4B"))
						{
							Sinalbit4b = "\tOK";
						}
							else {
							Sinalbit4b = "\tERRO";
						}
						
						if (bit88.length() == 38 && bit88.substring(0,2).equals("88"))
						{
							Sinalbit88 = "\tOK";
						}
							else {
							Sinalbit88 = "\tERRO";
						}
						
						if (bit92.length() <= 74 && bit92.substring(0,2).equals("92"))
						{
							Sinalbit92 = "\tOK";
						}
							else {
							Sinalbit92 = "\tERRO";
						}
						
						if (bit93.length() <= 44 && bit93.substring(0,2).equals("93"))
						{
							Sinalbit93 = "\tOK";
						}
							else {
							Sinalbit93 = "\tERRO";
						}
							
						saida.format("--Venda A Vista--\r\n" + "\r\n" + bitIdentificador  + SinalIdentificador + "\r\n" + bit01 + Sinalbit01 + "\r\n" + bit02 + Sinalbit02 + "\r\n"
								+ bit03 + Sinalbit03 + "\r\n" +  bit43 + Sinalbit43 + "\r\n" + bit45 + Sinalbit45 + "\r\n"
								 + bit46 + Sinalbit46 + "\r\n" + bit47 + Sinalbit47 + "\r\n" + bit48 + Sinalbit48 + "\r\n" + bit49 + Sinalbit49 + "\r\n"
								 + bit4b + Sinalbit4b + "\r\n" + bit88 + Sinalbit88 + "\r\n" + bit92 + Sinalbit92 + "\r\n" + bit93 + Sinalbit93 + "\r\n"
								 + "\r\n" + "----------------------------------------------------------------------------" + "\r\n", args);
							
						}	
						
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