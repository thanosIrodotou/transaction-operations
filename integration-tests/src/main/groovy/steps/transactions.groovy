package steps

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

final String serviceUrl = "http://transaction-processor:8080/transactions"
String response

Given(~/^a request to transaction-processor$/) { ->
  response = getRequest(serviceUrl)
}

Given(~/^a create request with data:$/) { String transactionJson ->
  response = postRequest(serviceUrl, transactionJson)
}

When(~/^updating a request with data:$/) { String transactionJson ->
  def transactionId = convertJson(transactionJson).id.toString()
  response = putRequest(serviceUrl + "/" + transactionId, transactionJson)
}

Given(~/^a delete by id request for id (.*)$/) { String id ->
  response = deleteRequest(serviceUrl + "/" + id)
}

Given(~/^a deleteAll request$/) { ->
  response = deleteRequest(serviceUrl)
}

Then(~/^response contains transaction with id (.*)$/) { String expectedId ->
  assert convertJson(response).id == expectedId
}

Then(~/^response contains json$/) { String expectedJson ->
  assert response == expectedJson
}

Then(~/^request to list transactions returns (.*) transaction$/) { int expected ->
  listResponse = getRequest(serviceUrl)
  assert convertJson(listResponse).data.size() == expected
}

Then(~/^request to list transactions returns transaction with organisationId: (.*)$/) { String expectedId ->
  listResponse = getRequest(serviceUrl)
  assert convertJson(listResponse).data[0].organisationId == expectedId
}
