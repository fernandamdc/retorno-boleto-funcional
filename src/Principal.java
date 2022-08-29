public class Principal {
    public static void main(String[] args) {
        ProcessarBoletos processador =
                new ProcessarBoletos(LeituraRetornoBancoBrasil::lerArquivo);
        processador.processar("banco-brasil-1.csv");


        processador.setLeituraRetorno(LeituraRetornoBancoBradesco::lerArquivo);
        processador.processar("bradesco-1.csv");
    }
}
