package app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import entities.Eleicao;


public class Program {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		String path = "C:\\temp\\in.txt";
		
		Map<String, Integer> cotacao = new LinkedHashMap<String, Integer>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String obj =  br.readLine();
			while(obj != null) {
				String[] eleito = obj.split(",");
				String candidato = eleito[0];
				Integer voto = Integer.parseInt(eleito[1]);
				
				if(cotacao.containsKey(candidato)) {
					int soma = cotacao.get(candidato);
					cotacao.put(candidato, soma + voto);
				
				}else {
					cotacao.put(candidato, voto);
				}
				
				obj = br.readLine();
			}
			
			
			for(String el : cotacao.keySet()) {
				System.out.println(el + ": " + cotacao.get(el));
			}
			
			
		}
		catch(IOException e) {
			System.out.println("Error " + e.getMessage());
		}
	}

}
