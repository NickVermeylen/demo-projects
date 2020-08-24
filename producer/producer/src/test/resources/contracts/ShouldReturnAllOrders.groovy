package contracts

import org.springframework.cloud.contract.spec.Contract
import org.springframework.cloud.contract.spec.internal.HttpMethods
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

Contract.make {
    description("should return all orders")
    request {
        url("/orders")
        method(HttpMethods.HttpMethod.GET.methodName)
    }
    response {
        status(HttpStatus.OK.value())
        body([[id: "1F3A", firstName: "Sheldon", lastName: "Cooper"]])
        headers {
            contentType(MediaType.APPLICATION_JSON_VALUE)
        }

    }
}
