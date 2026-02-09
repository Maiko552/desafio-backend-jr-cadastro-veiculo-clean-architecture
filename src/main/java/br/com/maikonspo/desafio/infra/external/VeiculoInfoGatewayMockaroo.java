package br.com.maikonspo.desafio.infra.external;

import br.com.maikonspo.desafio.domain.exception.FalhaApiExternaException;
import br.com.maikonspo.desafio.domain.gateway.VeiculoInfoGateway;
import br.com.maikonspo.desafio.domain.model.valueobject.VeiculoInfo;
import br.com.maikonspo.desafio.infra.external.dto.MockarooVeiculoResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.time.Duration;

@Component
public class VeiculoInfoGatewayMockaroo implements VeiculoInfoGateway {

    private static final String BASE_URL = "https://my.api.mockaroo.com/veiculos";
    private static final String API_KEY = "55ad1cd0";

    private final WebClient webClient;

    public VeiculoInfoGatewayMockaroo(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public VeiculoInfo obterPorPlaca(String placa) {
        if (placa == null || placa.isBlank()) {
            throw new IllegalArgumentException("Placa é obrigatória para consultar a API externa");
        }

        try {
            MockarooVeiculoResponse res = webClient
                    .get()
                    .uri(BASE_URL + "?key={key}&placa={placa}", API_KEY, placa)
                    .retrieve()
                    .bodyToMono(MockarooVeiculoResponse.class)
                    .timeout(Duration.ofSeconds(5))
                    .block();

            if (res == null) {
                throw new IllegalStateException("API externa retornou resposta vazia");
            }

            return new VeiculoInfo(
                    res.marca(),
                    res.modelo(),
                    res.chassi(),
                    Boolean.TRUE.equals(res.licenciado())
            );

        } catch (WebClientResponseException e) {
            throw new IllegalStateException(
                    "Falha ao consultar API externa (HTTP " + e.getStatusCode().value() + ")",
                    e
            );
        } catch (Exception e) {
            throw new FalhaApiExternaException(e);
        }

    }
}
