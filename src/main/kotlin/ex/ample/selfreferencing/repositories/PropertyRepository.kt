package ex.ample.selfreferencing.repositories

import ex.ample.selfreferencing.entites.Property
import org.springframework.stereotype.Repository

@Repository
interface PropertyRepository: PropertyAwareRepositoryFragment<Property> {

}
