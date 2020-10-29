package ex.ample.selfreferencing.entites

import ex.ample.selfreferencing.extensions.WithProperty
import javax.persistence.*

@Entity
class Property : WithProperty {

    @Id
    @GeneratedValue
    val id: Long? = null

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    override val property: Property? = null
}