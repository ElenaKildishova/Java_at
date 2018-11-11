package ru.p4b.dev.github;

import com.jcabi.github.Github;
import com.jcabi.github.RtGithub;
import org.testng.annotations.Test;

public class GithubTests {

  @Test
  public void testCommits() {
    Github github = new RtGithub(".. your OAuth token ..");
  }
}
