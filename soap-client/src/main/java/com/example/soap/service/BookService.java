package com.example.soap.service;

import com.example.generated.wsdl.GetBookRequest;
import com.example.generated.wsdl.GetBookResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class BookService extends WebServiceGatewaySupport {

    public com.example.generated.wsdl.GetBookResponse getBook(String isbn) {
        com.example.generated.wsdl.GetBookRequest request = new GetBookRequest();
        request.setIsbn(isbn);

        com.example.generated.wsdl.GetBookResponse response = (GetBookResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/books", request,
                        new SoapActionCallback(
                                "http://spring.io/guides/gs-producing-web-service/GetBookRequest"));

        return response;
    }
}
