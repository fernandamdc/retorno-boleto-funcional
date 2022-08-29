import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LeituraRetornoBancoBrasil {
    private LeituraRetornoBancoBrasil(){

    }

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
            boleto.setDataVencimento(LocalDate.parse(vetor[2], ProcessarBoletos.FORMATO_DATA ));
            boleto.setDataPagamento(LocalDate.parse(vetor[3], ProcessarBoletos.FORMATO_DATA ).atTime(0,0));
            boleto.setCpfCliente(vetor[4]);
            boleto.setValor(Double.parseDouble(vetor[5]));
            boleto.setMulta(Double.parseDouble(vetor[6]));
            boleto.setJuros(Double.parseDouble(vetor[7]));
            lista.add(boleto);
            }
            return lista;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

