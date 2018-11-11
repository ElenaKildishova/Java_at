package ru.p4b.dev.mantis.model;

public class Issue {

  private int id;
  private String summary;
  private String description;
  private Project project;
  private int status;
  private int resolution;

  public int getResolution() {
    return resolution;
  }

  public Issue withResolution(int resolution) {
    this.resolution = resolution;
    return this;
  }

  public int getStatus() {
    return status;
  }

  public Issue withStatus(int status) {
    this.status = status;
    return this;
  }

  public int getId() {
    return id;
  }

  public Issue withId(int id) {
    this.id = id;
    return this;
  }

  public String getSummary() {
    return summary;
  }

  public Issue withSummary(String summary) {
    this.summary = summary;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public Issue withDescription(String description) {
    this.description = description;
    return this;
  }

  public Project getProject() {
    return project;
  }

  public Issue withProject(Project project) {
    this.project = project;
    return this;
  }
}