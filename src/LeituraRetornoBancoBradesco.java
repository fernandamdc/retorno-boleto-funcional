import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LeituraRetornoBancoBradesco {

    public static List<Boleto> lerArquivo(String nomeArquivo) {
        System.out.println("Lendo Arquivo " + nomeArquivo);
        try (var reader = Files.newBufferedReader(Paths.get(nomeArquivo))) {
            String ln;
            var lista = new ArrayList<Boleto>();
            while ((ln = reader.readLine()) != null) {
                var vetor = ln.split(";");
                var boleto = new Boleto();
                boleto.setId(Integer.parseInt(vetor[0]));
                boleto.setCodBanco(vetor[1]);
                boleto.setAgencia(vetor[2]);
                boleto.setContaBancaria(vetor[3]);
                boleto.setDataVencimento(LocalDate.parse(vetor[4], ProcessarBoletos.FORMATO_DATA));
                boleto.setDataPagamento(LocalDateTime.parse(vetor[5], ProcessarBoletos.FORMATO_DATA_HORA));
                boleto.setCpfCliente(vetor[6]);
                boleto.setValor(Double.parseDouble(vetor[7]));
                boleto.setMulta(Double.parseDouble(vetor[8]));
                boleto.setJuros(Double.parseDouble(vetor[9]));
                lista.add(boleto);
            }
            return lista;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
