package jp.co.fnj.storage.api.model.file;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * ファイル全文検索APIレスポンス.
 *
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class FileFullTextSearchResponse {
  /** (フォルダTBL)フォルダID */
  private String folder_folder_id;

  /** (フォルダTBL)親フォルダID */
  private String folder_parent_folder_id;

  /** (フォルダTBL)フォルダグループ */
  private Integer folder_folder_group;

  /** (フォルダTBL)論理フォルダ名 */
  private String folder_folder_name;

  /** (フォルダTBL)物理フォルダ名 */
  private String folder_s3_folder_name;

  /** (フォルダTBL)デベロッパID */
  private String folder_developer_id;

  /** (フォルダTBL)マンションID */
  private String folder_mansion_id;

  /** (フォルダTBL)フォルダパス */
  private String folder_s3_object_key;

  /** (フォルダTBL)説明文 */
  private String folder_explanatory_text;

  /** (フォルダTBL)追加ユーザID */
  private String folder_insert_user_id;

  /** (フォルダTBL)追加日時 */
  private LocalDateTime folder_insert_date_time;

  /** (フォルダTBL)更新ユーザID */
  private String folder_update_user_id;

  /** (フォルダTBL)更新日時 */
  private LocalDateTime folder_update_date_time;

  /** (ファイルTBL)ファイルID */
  private String file_file_id;

  /** (ファイルTBL)フォルダID */
  private String file_folder_id;

  /** (ファイルTBL)論理ファイル名 */
  private String file_file_name;

  /** (ファイルTBL)物理ファイル名 */
  private String file_s3_file_name;

  /** (ファイルTBL)ファイルパス */
  private String file_s3_objecrt_key;

  /** (ファイルTBL)ファイルサイズ */
  private Long file_file_size;

  /** (ファイルTBL)追加ユーザID */
  private String file_insert_user_id;

  /** (ファイルTBL)追加日時 */
  private LocalDateTime file_insert_date_time;

  /** (ファイルTBL)更新ユーザID */
  private String file_update_user_id;

  /** (ファイルTBL)更新日時 */
  private LocalDateTime file_update_date_time;
}
