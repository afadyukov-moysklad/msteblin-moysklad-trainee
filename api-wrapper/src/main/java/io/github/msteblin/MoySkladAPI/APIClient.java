package io.github.msteblin.MoySkladAPI;

import io.github.msteblin.MoySkladAPI.types.Product;
import io.github.msteblin.MoySkladAPI.types.Rows;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.util.List;

public class APIClient {
    public static final String MS_API_URL = "https://api.moysklad.ru/api/remap/1.2";
    private final RestClient restClient;

    public APIClient() {
        this.restClient = RestClient.builder().baseUrl(MS_API_URL).build();
    }

    public List<Product> getProducts(String token) {
        Rows<Product> rows = restClient.get().uri("/entity/product")
                .headers(h -> h.setBasicAuth(token))
                .retrieve()
                .body(new ParameterizedTypeReference<Rows<Product>>() {});
        assert rows != null;
        return rows.rows();
    }
}
