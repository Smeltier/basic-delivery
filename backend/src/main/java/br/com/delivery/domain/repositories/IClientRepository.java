package br.com.delivery.domain.repositories;

import java.util.Optional;

import br.com.delivery.domain.client.Client;
import br.com.delivery.domain.client.ClientId;

public interface IClientRepository {
  Optional<Client> findById(ClientId id);

  void save(Client client);
}
