package helpers;

public class ValidationsHelper {

    // -------- Atributos --------
    static String nomeProduto;
    static float valorUnitario;
    static int quantidade;
    static String tamanho;
    static String cor;
    static float valorFrete;
    static String ct;
    static String nomeCt;

    // -------- Getters e Setters --------

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public float getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(float valorFrete) {
        this.valorFrete = valorFrete;
    }

    public String getCt() {
        return ct;
    }

    public void setCt(String ct) {
        ValidationsHelper.ct = ct;
    }

    public String getNomeCt() {
        return nomeCt;
    }

    public void setNomeCt(String nomeCt) {
        ValidationsHelper.nomeCt = nomeCt;
    }

    // -------- Métodos --------

    public float calcularTotalDoProduto(float valorUnitario, int quantidade){
        return (valorUnitario * quantidade);
    }
    public float calcularTotalDaCompra() { return (calcularTotalDoProduto(valorUnitario,quantidade) + valorFrete); }


}
