import java.io.*;
import java.util.*;

public class Indice {
    public static void main(String[] args) throws IOException{
        
        Map<String, Map<Integer, Integer>> contadorPalavras = new HashMap<>();
        // Coloque o caminho relativo da sua maquina para identificar os arquivos
        String nomeArquivoA = "a.txt";
        String nomeArquivoB = "b.txt";
        String nomeArquivoC = "c.txt";
        String arquivoDesconsideradas = "desconsideradas.txt";
        String arquivoIndice = "indice.txt";
       
        // Ler as palavras a serem desconsideradas do arquivo "desconsideradas.txt"
        Set<String> palavrasDesconsideradas = Arqv.lerPalavrasDesconsideradas(arquivoDesconsideradas);

        // Remover os caracteres ',','!', , '?' dos arquivos a.txt, b.txt e c.txt
        Remove.removerCaracteresEspeciais(nomeArquivoA);
        Remove.removerCaracteresEspeciais(nomeArquivoB);
        Remove.removerCaracteresEspeciais(nomeArquivoC);

        // Ler os arquivos a.txt, b.txt e c.txt
        Arqv.lerArquivo(nomeArquivoA, contadorPalavras, palavrasDesconsideradas, 1);
        Arqv.lerArquivo(nomeArquivoB, contadorPalavras, palavrasDesconsideradas, 2);
        Arqv.lerArquivo(nomeArquivoC, contadorPalavras, palavrasDesconsideradas, 3);

        // Escrever as palavras, suas contagens e os documentos no arquivo "indice.txt"
        PrintWriter writer = new PrintWriter(arquivoIndice);
        for (Map.Entry<String, Map<Integer, Integer>> entry : contadorPalavras.entrySet()) {
            String palavra = entry.getKey();
            Map<Integer, Integer> mapaDocumento = entry.getValue();
            StringBuilder sb = new StringBuilder();
            
            // Escreve o arquivo em que a palavra foi encontrada e a quantidade de vezes
            for (Map.Entry<Integer, Integer> documentoEntry : mapaDocumento.entrySet()) {
                Integer documento = documentoEntry.getKey();
                Integer quantidade = documentoEntry.getValue();
                
                sb.append(documento).append(",").append(quantidade).append(" ");
            }

            String registros = sb.toString().trim();
            writer.println(palavra + ": " + registros);
        }

        writer.close();
    }

}
