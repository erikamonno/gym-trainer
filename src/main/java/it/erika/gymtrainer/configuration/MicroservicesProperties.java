package it.erika.gymtrainer.configuration;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.net.URI;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated // ci permette di inserire le annotation che usiamo nei dto
@ConfigurationProperties(prefix = "microservices")
public record MicroservicesProperties(@Valid @NotNull GymTrack gymTrack) {

    public record GymTrack(@NotNull URI url) {}
}
