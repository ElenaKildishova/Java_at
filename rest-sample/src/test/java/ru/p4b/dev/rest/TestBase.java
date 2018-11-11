package ru.p4b.dev.rest;
import org.testng.SkipException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class TestBase {


  public boolean isIssueOpen(int issueId) {

      return true;
    }

  public void skipIfNotFixed(int issueId) throws MalformedURLException, RemoteException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }
}
