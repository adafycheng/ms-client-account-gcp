package dev.adafycheng.microservices.client.account.mvc

import dev.adafycheng.microservices.client.account.model.CustomerAccount
import dev.adafycheng.microservices.client.account.repository.CustomerAccountRepository
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import spock.lang.Specification

import static org.mockito.ArgumentMatchers.anyString
import static org.mockito.Mockito.when

class CustomerAccountControllerSpec extends Specification {

    // Positive test data
    private static final String LAST_NAME ="Cheng"

    // Response JSON
    private static final CustomerAccount ACCOUNT_CHENG = CustomerAccount.builder().lastName("Cheng").build()
    private static final List<CustomerAccount> RESULT_FOUND = new ArrayList(Arrays.asList(ACCOUNT_CHENG))
    private static final List<CustomerAccount> RESULT_EMPTY = new ArrayList()

    @InjectMocks
    CustomerAccountController customerAccountController

    @Mock
    CustomerAccountRepository customerAccountRepository

    def setup() {
        MockitoAnnotations.openMocks(this)
    }

    def "Controller responds with mocked message for any feature name and user ID"() {

        given: "service is mocked with input Feature Flag Name and User ID"
        when(customerAccountRepository.findByLastName(anyString())).thenReturn(RESULT_EMPTY)
        when(customerAccountRepository.findByLastName(LAST_NAME)).thenReturn(RESULT_FOUND)

        when: "controller is called"
        def output = customerAccountController.findByLastName(lastName)

        then: "response status is OK"
        output.iterator().size() == expectBody.iterator().size()

        where:
        lastName          || expectBody
        LAST_NAME         || RESULT_FOUND
        "Chen"            || RESULT_EMPTY
    }

}
