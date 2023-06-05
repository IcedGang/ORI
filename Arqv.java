import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Classe para ler os Arquivos
public class Arqv {

    //Lê o arquivo 'desconsideradas.txt'
    public static Set<String> lerPalavrasDesconsideradas(String arquivo) throws IOException {
        Set<String> palavrasDesconsideradas = new HashSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(arquivo));
        String linha;
        
        //Adiciona as palavras do arquivo pra um conjunto
        while ((linha = reader.readLine()) != null) {
            palavrasDesconsideradas.add(linha.trim().toLowerCase());
        }
        reader.close();

        //Retorna o conjunto com as palavras desconsideradas
        return palavrasDesconsideradas;
    }

    //Lê os arquivos 'a.txt', 'b.txt', 'c.txt'
    public static void lerArquivo(String arquivo, Map<String, Map<Integer, Integer>> contadorPalavras, Set<String> palavrasDesconsideradas, int documento) throws IOException {
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
