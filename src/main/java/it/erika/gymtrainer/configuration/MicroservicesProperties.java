package it.erika.gymtrainer.configuration;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.net.URI;

@Validated // ci permette di inserire le annotation che usiamo nei dto
@ConfigurationProperties(prefix = "microservices")
public record MicroservicesProperties(@Valid @NotNull GymTrack gymTrack) {

    public record GymTrack(@NotNull URI url) {}
}
