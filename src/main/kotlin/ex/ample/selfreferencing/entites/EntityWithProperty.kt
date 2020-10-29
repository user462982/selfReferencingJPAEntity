package ex.ample.selfreferencing.entites

import ex.ample.selfreferencing.extensions.WithProperty
import javax.persistence.*

@Entity
class EntityWithProperty(
    @ManyToOne
    override val property: Property
) : WithProperty {
    @Id
    @GeneratedValue
    val id: Long? = null
}