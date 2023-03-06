package loca.cyberia.service

import loca.cyberia.model.Client
import loca.cyberia.repository.ClientRepository
import java.util.Optional
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.transaction.Transactional

@ApplicationScoped
@Transactional
class ClientService {

    @Inject
    lateinit var clientRepository: ClientRepository;

    fun store(client: Client) {
        clientRepository.persist(client);
    }

    fun findAll():List<Client> {
        return clientRepository.listAll();
    }

    fun findById(id: Long): Optional<Client> {
        return clientRepository.findByIdOptional(id);
    }

    fun findByName(name: String): Client? {
        return clientRepository.findByName(name);
    }

    fun delete(id: Long) {
        clientRepository.deleteById(id);
    }

    fun update(client: Client) {
        clientRepository.update(
            "" +
                "name = '${client.name}', " +
                "surname = '${client.surname}', " +
                "age = ${client.age}, " +
                "email = '${client.email}', " +
                "basicSalary = ${client.basicSalary} " +
                "where id = ${client.id}"

        )
    }
}