package jp.co.fnj.storage.api.model.file;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * ファイル/フォルダ削除APIリクエスト.
 *
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class FileDeleteRequest {

  /** ファイルID */
  @NotNull
  @Valid
  private List<FileDeleteTarget> targets;
}
