package ex.ample.selfreferencing.repositories

import ex.ample.selfreferencing.entites.Property
import ex.ample.selfreferencing.extensions.WithProperty
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface PropertyAwareRepositoryFragment<T> : JpaRepository<T, Long> where T : WithProperty {

    fun findAllByProperty(property: Property): List<T>

    @Query("SELECT e as entity FROM #{#entityName} e where e.property = :property")
    fun findAllManually(property: Property): List<T>

    @Query("SELECT e as entity FROM #{#entityName} e where :property = null or e.property = :property")
    fun findAllManuallyNullable(property: Property?): List<T>

    @Query("SELECT e as entity FROM #{#entityName} e where coalesce( null, :properties ) = null or e.property in :properties")
    fun findAllManuallyNullable (properties: List<Property>?): List<T>
}
