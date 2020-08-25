# soap-wsdl
Simple SOAP demo

SOAP server written in Java with Spring Boot and Spring WS and Spring Web libs.

Building and running server side

```
mvn clean install
java -jar ./target/soap-0.0.1-SNAPSHOT.jar 
```

Consuming SOAP service from command line

Create SOAP request message (request.xml)

``` XML
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
				  xmlns:gs="http://spring.io/guides/gs-producing-web-service">
   <soapenv:Header/>
   <soapenv:Body>
      <gs:getBookRequest>
         <gs:isbn>987</gs:isbn>
      </gs:getBookRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

Calling service from command line:

```
curl --header "content-type: text/xml" -d @request.xml http://localhost:8080/ws 
```

Prettifing xml output

```
curl --header "content-type: text/xml" -d @request.xml http://localhost:8080/ws | xmllint --format -
```

