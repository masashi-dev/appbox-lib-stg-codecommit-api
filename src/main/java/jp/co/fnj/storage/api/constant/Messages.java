package jp.co.fnj.storage.api.constant;

import java.util.ResourceBundle;
import org.springframework.stereotype.Component;

@Component
public final class Messages {

  public static final ResourceBundle rb = ResourceBundle.getBundle("messages");
  public static final String E00000 = rb.getString("E00000");
  public static final String E00001 = rb.getString("E00001");
  public static final String E00002 = rb.getString("E00002");
  public static final String E00003 = rb.getString("E00003");
  public static final String E00004 = rb.getString("E00004");
  public static final String E00005 = rb.getString("E00005");
  public static final String E00006 = rb.getString("E00006");
  public static final String E00007 = rb.getString("E00007");
  public static final String E01001 = rb.getString("E01001");
  public static final String E02001 = rb.getString("E02001");
  public static final String E03002 = rb.getString("E03002");
  public static final String E04001 = rb.getString("E04001");
  public static final String E05001 = rb.getString("E05001");

  public String E00000() {
    return E00000;
  }

  public String E00001() {
    return E00001;
  }

  public String E00002() {
    return E00002;
  }

  public String E00003() {
    return E00003;
  }

  public String E00004() {
    return E00004;
  }

  public String E00005() {
    return E00005;
  }

  public String E00006() {
    return E00006;
  }

  public String E00007() {
    return E00007;
  }

  public String E01001() {
    return E01001;
  }

  public String E02001() {
    return E02001;
  }

  public String E03002() {
    return E03002;
  }

  public String E04001() {
    return E04001;
  }

  public String E05001() {
    return E05001;
  }
}
