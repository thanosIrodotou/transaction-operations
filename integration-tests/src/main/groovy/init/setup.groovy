package init

import groovy.json.JsonSlurper
import groovy.util.logging.Slf4j
import okhttp3.*

this.metaClass.mixin(cucumber.api.groovy.Hooks)

@Slf4j
class IntegrationTestWorld {

  static final OkHttpClient CLIENT = new OkHttpClient()
  static final MediaType JSON = MediaType.parse("application/json")
  def jsonSlurper = new JsonSlurper()

  static String getRequest(String url) {
    OkHttpClient client = new OkHttpClient()
    Request request = buildPartialRequest(url)
            .build()
    Response response = client.newCall(request).execute()

    assert response.successful
    return response.body().string()
  }

  static String putRequest(String url, String json) {
    RequestBody body = RequestBody.create(JSON, json)
    Request request = buildPartialRequest(url).put(body).build()
    Response response = CLIENT.newCall(request).execute()

    return response.body().string()
  }

  static String postRequest(String url, String json) {
    RequestBody body = RequestBody.create(JSON, json)
    Request request = buildPartialRequest(url).post(body).build()
    Response response = CLIENT.newCall(request).execute()

    return response.body().string()
  }

  static String deleteRequest(String url) {
    OkHttpClient client = new OkHttpClient()
    Request request = buildPartialRequest(url)
            .delete()
            .build()
    Response response = client.newCall(request).execute()

    return response.body().string()
  }

  private static Request.Builder buildPartialRequest(String url) {
    return new Request.Builder()
            .url(url)
            .addHeader("Content-Type", "application/json")
  }

  def convertJson(input) {
    jsonSlurper.parseText(input)
  }
}

def world = new IntegrationTestWorld()

World {
  return world
}
