package steps

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

String response

When(~/^making a request to (.*)$/) { String service ->
  String url = "http://${service}"
  response = getRequest(url)
}

Then(~/^response for .status is UP$/) { ->
  assert response.contains("\"UP\"")
}
