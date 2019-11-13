package jp.co.fnj.storage.api.entity.mapper.custom;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import jp.co.fnj.storage.api.entity.model.custom.FileAndRelatedFolderInfoEntity;

/**
 * ファイル検索APIマッパー.
 *
 */
@Mapper
public interface FileSearchMapper {

  /**
   * 引数をもとにファイルの情報および、そのファイルが格納されているフォルダの情報を取得する.
   *
   * @param argFolderId
   * @param argKeyword
   * @param argDelFLg
   * @param argDeveloperId
   * @param argMansionId
   * @param argMyUserId
   * @return ファイルとフォルダ（1:1）のリスト
   */
  List<FileAndRelatedFolderInfoEntity> selectFileAndRelatedFolder(String argFolderId,
      String argKeyword, Boolean argDelFLg, String argDeveloperId, String argMansionId,
      String argMyUserId);

}
