package ru.p4b.dev.rest;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.client.fluent.Executor;
import org.testng.SkipException;
import java.io.IOException;
public class TestBase {


  public boolean isIssueOpen(int issueId) throws IOException {
    String json = getExecutor().execute(org.apache.http.client.fluent.Request
            .Get("http://bugify.stqa.ru/api/issues/" + issueId + ".json")).returnContent().asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonObject parsedObject = parsed.getAsJsonObject();
    String issueStatus = parsedObject.get("issues").getAsJsonArray().get(0).getAsJsonObject().get("state_name").toString();
    if (issueStatus.equals("Resolved")) {
      return true;
    }
      else return false;
    }

  public void skipIfNotFixed(int issueId) throws IOException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }

  protected Executor getExecutor() {
    return Executor.newInstance().auth("288f44776e7bec4bf44fdfeb1e646490", "");
  }
}
