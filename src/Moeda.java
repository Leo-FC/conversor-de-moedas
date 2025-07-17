public class Moeda {
    private String codigoMoedaBase;
    private String codigoMoedaSolicitada;
    private Double valorMoedaSolicitada;
    private Double valorInformado;
    private Double valorConvertido;

    public Moeda(ExchangeApi exchangeApi, String codSolicitado, Double valorInformado){
        this.codigoMoedaBase = exchangeApi.baseCode();
        this.codigoMoedaSolicitada = codSolicitado;

        this.valorInformado = valorInformado;
        this.valorMoedaSolicitada = exchangeApi.conversionRates().get(codSolicitado);
        this.valorConvertido = getValorMoedaSolicitada() * getValorInformado();
    }

    public String getCodigoMoedaBase() {
        return codigoMoedaBase;
    }

    public void setCodigoMoedaBase(String codigoMoedaBase) {
        this.codigoMoedaBase = codigoMoedaBase;
    }

    public Double getValorMoedaSolicitada() {
        return valorMoedaSolicitada;
    }

    public void setValorMoedaSolicitada(Double valorMoedaSolicitada) {
        this.valorMoedaSolicitada = valorMoedaSolicitada;
    }

    public Double getValorConvertido() {
        return valorConvertido;
    }

    public void setValorConvertido(Double valorConvertido) {
        this.valorConvertido = valorConvertido;
    }

    public Double getValorInformado() {
        return valorInformado;
    }

    public void setValorInformado(Double valorInformado) {
        this.valorInformado = valorInformado;
    }

    @Override
    public String toString(){
        return
                valorInformado + " " + codigoMoedaBase + " esta aproximadamente na cotacao de " + valorConvertido + " " + codigoMoedaSolicitada;
    }
}
