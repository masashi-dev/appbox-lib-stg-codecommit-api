package jp.co.fnj.storage.api.entity.mapper.custom;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import jp.co.fnj.storage.api.entity.model.custom.FileListEntity;

/**
 * ファイル一覧取得APIマッパー.
 * 
 */
@Mapper
public interface FileGetListMapper {

  /** ファイル一覧取得 */
  List<FileListEntity> selectGetFileList(@Param("folderId") String folderId);
}
