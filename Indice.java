import java.io.*;
import java.util.*;

public class Indice {
    public static void main(String[] args) throws IOException{
        // Dicionário indice
        Map<String, Map<Integer, Integer>> contadorPalavras = new HashMap<>();

        // Coloque o caminho relativo da sua maquina para identificar os arquivos
        String arquivoConjunto = "conjunto.txt";
        String arquivoConsulta = "consulta.txt";
        String arquivoDesconsideradas = "desconsideradas.txt";
        String arquivoIndice = "indice.txt";
       
        // Lê as palavras a serem desconsideradas do arquivo "desconsideradas.txt"
        List<String> palavrasDesconsideradas = Arqv.lerArquivos(arquivoDesconsideradas);

        // lê o conjunto de arquivos em "conjunto.txt"
        List<String> arquivos = Arqv.lerArquivos(arquivoConjunto);

        // Remover os caracteres [. , ! ?] do conjunto de arquivos 
        Remove.removeSpecChar(arquivos);

        // lê os arquivos do conjunto arquivos
        Arqv.read(arquivos, contadorPalavras, palavrasDesconsideradas);

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
