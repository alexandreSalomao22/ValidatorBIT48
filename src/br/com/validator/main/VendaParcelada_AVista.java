package br.com.validator.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Formatter;

import javax.swing.JOptionPane;

public class VendaParcelada_AVista {

	public static void main(String[] args) {

		String linha = "";
		String tags = "BitIdentificador = 54, bit01, bit02, bit03, bit40 = fixo 2 posições, bit4A, bit88,bit92,bit93";
		
		String varivavel43, variavel45, variavel46, variavel47, variavel92, variavel93;
		String SinalIdentificador, Sinalbit01, Sinalbit02, Sinalbit03, Sinalbit04, Sinalbit43, Sinalbit45, Sinalbit46, Sinalbit47, Sinalbit48, Sinalbit49, Sinalbit4b, Sinalbit88, Sinalbit92, Sinalbit93;
		String bitIdentificador, bit01, bit02, bit03, bit04 = null, bit43 = null, bit45 = null, bit46 = null, bit47 = null, bit48 = null, bit49 = null, bit4b = null, bit88 = null, bit92 = null, bit93 = null;
		int bit43size, bit45size, bit46size, bit47size, bit92size, bit93size;
		
		String path = JOptionPane
				.showInputDialog("COLOQUE O REPOSITORIO ONDE SE ENCONTRA OS ARQUIVOS\n Ex: C:\\logs");
		String arq = JOptionPane.showInputDialog("DIGITE O NOME DO ARQUIVO A SER SALVO");
		String findText = JOptionPane.showInputDialog("DIGITE OQUE DESEJA PROCURAR");
		
		if(path.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Caminho em Branco, Fechando Aplicação");
			System.exit(0);
			
		} if (arq.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Nome do Arquivo em Branco, Fechando Aplicação");
			System.exit(0);
			
		} if (findText.equalsIgnoreCase("")) {
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
						bit03 = linha.substring(26,32);
						
						if(linha.substring(32, 36).equals("0403")) {
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
						if ( bit02.length() == 18) 
							{
								Sinalbit02 = "\tOK";
							}
							else {
							Sinalbit02 = "\tERRO";
						}
						if (bit03.length() == 6) {
							Sinalbit03 = "\tOK";
						}
							else {
							Sinalbit03 = "\tERRO";
						}
						if (bit04.length() == 4) {
							Sinalbit04 = "\tOK";
						}
							else {
							Sinalbit04 = "\tERRO";
						}
						
						if (bit43.length() <= 34)
						{
							Sinalbit43 = "\tOK";
						}
							else {
							Sinalbit43 = "\tERRO";
						}
						if (bit45.length() <= 52)
						{
							Sinalbit45 = "\tOK";
						}
							else {
							Sinalbit45 = "\tERRO";
						}
						
						if (bit46.length() <= 40)
						{
							Sinalbit46 = "\tOK";
						}
							else {
							Sinalbit46 = "\tERRO";
						}
						
						if (bit47.length() <= 14)
						{
							Sinalbit47 = "\tOK";
						}
							else {
							Sinalbit47 = "\tERRO";
						}
						
						if (bit48.length() == 6 && bit48.equals("480001") || bit48.equals("480002") || bit48.equals("480002") || bit48.equals("480003") || bit48.equals("480004"))
						{
							Sinalbit48 = "\tOK";
						}
							else {
							Sinalbit48 = "\tERRO";
						}
						if (bit49.length() == 18)
						{
							Sinalbit49 = "\tOK";
						}
							else {
							Sinalbit49 = "\tERRO";
						}
						
						if (bit4b.length() == 8)
						{
							Sinalbit4b = "\tOK";
						}
							else {
							Sinalbit4b = "\tERRO";
						}
						
						if (bit88.length() == 38)
						{
							Sinalbit88 = "\tOK";
						}
							else {
							Sinalbit88 = "\tERRO";
						}
						
						if (bit92.length() <= 74)
						{
							Sinalbit92 = "\tOK";
						}
							else {
							Sinalbit92 = "\tERRO";
						}
						
						if (bit93.length() <= 44)
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
						else {
							
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
						if ( bit02.length() == 18) 
							{
								Sinalbit02 = "\tOK";
							}
							else {
							Sinalbit02 = "\tERRO";
						}
						if (bit03.length() == 6) {
							Sinalbit03 = "\tOK";
						}
							else {
							Sinalbit03 = "\tERRO";
						}
						
						if (bit43.length() <= 34)
						{
							Sinalbit43 = "\tOK";
						}
							else {
							Sinalbit43 = "\tERRO";
						}
						if (bit45.length() <= 52)
						{
							Sinalbit45 = "\tOK";
						}
							else {
							Sinalbit45 = "\tERRO";
						}
						
						if (bit46.length() <= 40)
						{
							Sinalbit46 = "\tOK";
						}
							else {
							Sinalbit46 = "\tERRO";
						}
						
						if (bit47.length() <= 14)
						{
							Sinalbit47 = "\tOK";
						}
							else {
							Sinalbit47 = "\tERRO";
						}
						
						if (bit48.length() == 6 && bit48.equals("480001") || bit48.equals("480002") || bit48.equals("480002") || bit48.equals("480003") || bit48.equals("480004"))
						{
							Sinalbit48 = "\tOK";
						}
							else {
							Sinalbit48 = "\tERRO";
						}
						if (bit49.length() == 18)
						{
							Sinalbit49 = "\tOK";
						}
							else {
							Sinalbit49 = "\tERRO";
						}
						
						if (bit4b.length() == 8)
						{
							Sinalbit4b = "\tOK";
						}
							else {
							Sinalbit4b = "\tERRO";
						}
						
						if (bit88.length() == 38)
						{
							Sinalbit88 = "\tOK";
						}
							else {
							Sinalbit88 = "\tERRO";
						}
						
						if (bit92.length() <= 74)
						{
							Sinalbit92 = "\tOK";
						}
							else {
							Sinalbit92 = "\tERRO";
						}
						
						if (bit93.length() <= 44)
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