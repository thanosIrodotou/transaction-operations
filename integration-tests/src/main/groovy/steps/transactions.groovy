package steps

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

final String serviceUrl = "http://transaction-processor:8080/transactions"
String response

Given(~/^a request to transaction-processor$/) { ->
  response = getUrl(serviceUrl)
}

Given(~/^a create request with data:$/) { String transactionJson ->
  response = postUrl(serviceUrl, transactionJson)
}

Given(~/^a delete by id request for id (.*)$/) { String id ->
  response = deleteUrl(serviceUrl + "/" + id)
}

Given(~/^a deleteAll request$/) { ->
  response = deleteUrl(serviceUrl)
}

Then(~/^response contains transaction with id (.*)$/) { String expectedId ->
  assert convertJson(response).id == expectedId
}

Then(~/^response contains json$/) { String expectedJson ->
  assert response == expectedJson
}

Then(~/^request to list transactions returns (.*) transaction$/) { int expected ->
  listResponse = getUrl(serviceUrl)
  assert convertJson(listResponse).data.size() == expected
}
