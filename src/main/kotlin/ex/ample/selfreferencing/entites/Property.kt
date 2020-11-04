package ex.ample.selfreferencing.entites

import ex.ample.selfreferencing.extensions.WithProperty
import javax.persistence.*

@Entity
class Property : WithProperty {

    @Id
    @GeneratedValue
    val id: Long? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable=false, updatable =false)
    override val property: Property? = null
}