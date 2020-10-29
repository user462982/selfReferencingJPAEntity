package ex.ample.selfreferencing.repositories

import ex.ample.selfreferencing.entites.EntityWithProperty
import ex.ample.selfreferencing.entites.Property
import org.springframework.stereotype.Repository

@Repository
interface EntityWithPropertyRepository: PropertyAwareRepositoryFragment<EntityWithProperty>
