import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

// Classe para ler os Arquivos
public class Arqv {

    //Lê os arquivos 'desconsideradas.txt' e 'conjunto.txt'
    public static List<String> lerArquivos(String arquivo) throws IOException {
        List<String> palavrasDesconsideradas = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(arquivo));
        String linha;
        
        //Adiciona as palavras do arquivo pra um conjunto
        while ((linha = reader.readLine()) != null) {
            palavrasDesconsideradas.add(linha.trim().toLowerCase());
        }
        reader.close();

        //Retorna o conjunto com as palavras desconsideradas ou dos arquivos em 'conjunto.txt'
        return palavrasDesconsideradas;
    }

    //Lê cada arquivo do conjunto dos arquivos
    public static void read(List<String> arquivos, Map<String, Map<Integer, Integer>> contadorPalavras, List<String> palavrasDesconsideradas) throws IOException{
        int count = 1;
        for (String str : arquivos) 
            Arqv.lerArquivo(str, contadorPalavras, palavrasDesconsideradas, count++);
    }

    //Lê os arquivos 
    private static void lerArquivo(String arquivo, Map<String, Map<Integer, Integer>> contadorPalavras, List<String> palavrasDesconsideradas, int documento) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(arquivo));
        String linha;
        
        //Coloca as palvras no Dicionário
        while ((linha = reader.readLine()) != null) {
            //Separa as palvras quando houver espaços em branco
            String[] palavras = linha.trim().toLowerCase().split("\\s+");

            //Verifica as palavras desconsideradas
            for (String palavra : palavras) {
                if (!palavrasDesconsideradas.contains(palavra)) {
                    contadorPalavras.putIfAbsent(palavra, new TreeMap<>());
                    Map<Integer, Integer> mapaDocumento = contadorPalavras.get(palavra);
                    
                    mapaDocumento.put(documento, mapaDocumento.getOrDefault(documento, 0) + 1);
                }

            }
        }

        reader.close();
    }

    //Lê o arquivo consulta.txt
    //Faz a leitura do arquivo e retorna a quantidade de linhas que ele tem
    public static int readFile(List<String> str, String fileName) throws IOException{
        Scanner scn = new Scanner(new FileReader(fileName));
        String string;
        int i = 0;

        while(scn.hasNext()){
            string = scn.next();
            str.add(string);
            i++;
        }

        return i; //Retorna o numero de palavras do arquivo
    }

    //Faz a leitura do arquivo e guarda na lista de listas
    public static List<List<String>> readArqv(List<List<String>> Listlist,List<String> list, int count1, int[] count2) throws IOException{
        for(int i = 0; i < count1; i++){
            List<String> s = new ArrayList<String>();
            count2[i] = Arqv.readFile(s, list.get(i)); //Aqui o algoritmo lê um arquivo e salva o numero de palavras dele no vetor count

            Listlist.add(s); //Adicio na lista de listas
        }

        return Listlist;
    }

}
