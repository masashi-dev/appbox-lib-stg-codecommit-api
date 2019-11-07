package jp.co.fnj.storage.constant;

import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

@Component
public final class Messages {

	public static final ResourceBundle rb = ResourceBundle.getBundle("messages");
	public static final String E00000 = rb.getString("E00000");
	public static final String E01001 = rb.getString("E01001");
	public static final String E02001 = rb.getString("E02001");
	public static final String E03002 = rb.getString("E03002");
	public static final String E04001 = rb.getString("E04001");
	public static final String E05001 = rb.getString("E05001");

	public String E00000() {
		return E00000;
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