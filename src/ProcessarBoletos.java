import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Function;

public class ProcessarBoletos {
    public static final DateTimeFormatter FORMATO_DATA
            = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DateTimeFormatter FORMATO_DATA_HORA
            = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private Function<String, List <Boleto>> leituraRetorno;
    private Function<String, List<Boleto>> lerArquivo;
    public ProcessarBoletos(Function<String, List <Boleto>> leituraRetorno) {

        this.leituraRetorno = leituraRetorno;
    }

    public void processar (String nomeArquivo){
        var lista = leituraRetorno.apply(nomeArquivo);
        for (Boleto boleto : lista) {
            System.out.println(boleto);
        }
    }

    public void setLeituraRetorno(Function<String, List <Boleto>> leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }
}
