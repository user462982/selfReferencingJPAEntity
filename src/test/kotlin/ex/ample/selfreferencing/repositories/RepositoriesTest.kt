package ex.ample.selfreferencing.repositories

import ex.ample.selfreferencing.entites.*
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest


@DataJpaTest
internal class RepositoriesTest {

    @Autowired
    lateinit var entityWithPropertyRepository: EntityWithPropertyRepository

    @Autowired
    lateinit var propertyRepository: PropertyRepository

    var property : Property = Property()

    @BeforeEach
    fun setUp() {
        property = propertyRepository.save(property)
        entityWithPropertyRepository.save(EntityWithProperty(property))
    }

    @Test
    fun `Query methods that work`() {
        val w1 = entityWithPropertyRepository.findAllManually(property)
        val w2 = entityWithPropertyRepository.findAllByProperty(property)
        val w3 = entityWithPropertyRepository.findAllManuallyNullable(property)
        val w4 = entityWithPropertyRepository.findAllManuallyNullable(listOf(property))
        val w5 = propertyRepository.findAllManually(property)
        val w6 = propertyRepository.findAllByProperty(property)
    }

    @Test
    fun `Query methods that fail`() {
        val f1 = propertyRepository.findAllManuallyNullable(property)
        val f2 = propertyRepository.findAllManuallyNullable(listOf(property))
    }
}