import java.util.Map;

public record ExchangeApi(String baseCode, Map<String,Double> conversionRates) {
}
