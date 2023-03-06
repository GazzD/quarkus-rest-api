package loca.cyberia.model

import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Client(
    @Id
    @GeneratedValue
    var id: Long?=0,
    var name: String?="",
    var surname: String?="",
    var age: Int?=null,
    var email: String?="",
    var basicSalary: BigDecimal?=null

)
