package dad.models;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EmailData {
  private StringProperty host_name;
  private StringProperty port;
  private BooleanProperty ssl;
  private StringProperty user;
  private StringProperty password;
  private StringProperty from;
  private StringProperty to;
  private StringProperty subject;
  private StringProperty message;

  public EmailData() {
      host_name = new SimpleStringProperty();
      port = new SimpleStringProperty();
      ssl = new SimpleBooleanProperty();
      user = new SimpleStringProperty();
      password = new SimpleStringProperty();
      from = new SimpleStringProperty();
      to = new SimpleStringProperty();
      subject = new SimpleStringProperty();
      message = new SimpleStringProperty();
  }

  public String getHost_name() {
    return host_name.get();
  }

  public StringProperty host_nameProperty() {
    return host_name;
  }

  public String getPort() {
    return port.get();
  }

  public StringProperty portProperty() {
    return port;
  }

  public boolean isSsl() {
    return ssl.get();
  }

  public BooleanProperty sslProperty() {
    return ssl;
  }

  public String getUser() {
    return user.get();
  }

  public StringProperty userProperty() {
    return user;
  }

  public String getPassword() {
    return password.get();
  }

  public StringProperty passwordProperty() {
    return password;
  }

  public String getFrom() {
    return from.get();
  }

  public void setFrom(String from) {
    this.from.set(from);
  }

  public String getTo() {
    return to.get();
  }

  public StringProperty toProperty() {
    return to;
  }

  public String getSubject() {
    return subject.get();
  }

  public StringProperty subjectProperty() {
    return subject;
  }

  public String getMessage() {
    return message.get();
  }

  public StringProperty messageProperty() {
    return message;
  }
}
