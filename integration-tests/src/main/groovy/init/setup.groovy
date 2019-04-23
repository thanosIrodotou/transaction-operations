package init

import groovy.json.JsonSlurper
import groovy.util.logging.Slf4j
import okhttp3.*

this.metaClass.mixin(cucumber.api.groovy.Hooks)

@Slf4j
class IntegrationTestWorld {

  def jsonSlurper = new JsonSlurper()

  static String postUrl(String url, String json) {
    final MediaType JSON = MediaType.parse("application/json")

    OkHttpClient client = new OkHttpClient()

    RequestBody body = RequestBody.create(JSON, json)
    Request request = new Request.Builder()
            .url(url)
            .post(body)
            .build()
    Response response = client.newCall(request).execute()
    return response.body().string()
  }

  static String getUrl(String url) {
    OkHttpClient client = new OkHttpClient()

    Request request = new Request.Builder()
            .url(url)
            .addHeader("Content-Type", "application/json")
            .build()

    Response response = client.newCall(request).execute()

    assert response.successful

    return response.body().string()
  }

  static String deleteUrl(String url) {
    OkHttpClient client = new OkHttpClient()

    Request request = new Request.Builder()
            .url(url)
            .delete()
            .addHeader("Content-Type", "application/json")
            .build()

    Response response = client.newCall(request).execute()

    return response.body().string()
  }


  def convertJson(input) {
    jsonSlurper.parseText(input)
  }

}

def world = new IntegrationTestWorld()

World {
  return world
}
