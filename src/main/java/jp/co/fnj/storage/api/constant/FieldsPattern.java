package jp.co.fnj.storage.api.constant;

public final class FieldsPattern {

    /** ファイルID */
    public static final String FILE_ID = "S03A\\d{10}$";

    /** デベロッパID */
    public static final String DEVELOPER_ID = "^03A\\d{11}$";

    /** アプリ区分（お知らせ） */
    public static final String APL_KBN_INFO = "^info$";

    /** アプリ区分（アプリ(PF) / アプリ(PF以外) / おまとめ / お知らせ） */
    public static final String APL_KBN_APPBOX_APPBOXEXCEPT_KANRI_INFO =
            "^appbox$|^appbox_except$|^kanri$|^info$";

    /** 処理区分 */
    public static final String PROCESSING_KBN = "0|1";

    /**
     * コンストラクタ
     */
    private FieldsPattern() {
        // NOP
    }

}
