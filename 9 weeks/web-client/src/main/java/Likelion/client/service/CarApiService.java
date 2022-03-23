package Likelion.client.service;

import Likelion.client.model.CarDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CarApiService {
    private static final Logger logger = LoggerFactory.getLogger(CarApiService.class);
    private final WebClient randomDataClient;

    public CarApiService(WebClient randomDataClient) {
        this.randomDataClient = randomDataClient;
    }

    public CarDto buyNewCar() {
        CarDto result = this.randomDataClient
                .get()
                .uri("/api/vehicle/random_vehicle")
                .retrieve()
                .onStatus(HttpStatus::is5xxServerError, clientResponse ->
                        Mono.empty())
                .bodyToMono(CarDto.class)
                .block();

        return result;
    }
}
