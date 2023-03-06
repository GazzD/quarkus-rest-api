package loca.cyberia.repository

import io.quarkus.hibernate.orm.panache.PanacheRepository
import loca.cyberia.model.Client
import java.util.Optional
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class ClientRepository : PanacheRepository<Client> {
    fun findByName(name: String): Client? = find("name", name).firstResult<Client>()
}