import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                    contadorPalavras.putIfAbsent(palavra, new HashMap<>());
                    Map<Integer, Integer> mapaDocumento = contadorPalavras.get(palavra);
                    
                    mapaDocumento.put(documento, mapaDocumento.getOrDefault(documento, 0) + 1);
                }

            }
        }

        reader.close();
    }

}
