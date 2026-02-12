package br.com.delivery.application.usecases.order;

import java.util.UUID;

public record CreateOrderInput(UUID id, List<ItemInput> items) {
}
