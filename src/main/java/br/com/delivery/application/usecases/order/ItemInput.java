package br.com.delivery.application.usecases.order;

import java.util.UUID;

public record ItemInput(UUID id, int quantity) {
}
