package jp.co.fnj.storage.api.entity.mapper.custom;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
  List<FileAndRelatedFolderInfoEntity> selectFileAndRelatedFolder(
      @Param("folderId") String argFolderId, @Param("keyword") String argKeyword,
      @Param("delFlg") Boolean argDelFLg, @Param("developerId") String argDeveloperId,
      @Param("mansionId") String argMansionId, @Param("userId") String argMyUserId);

}
