package jp.co.fnj.storage.api.entity.mapper.custom;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import jp.co.fnj.storage.api.entity.model.custom.FileUpdateDisplayOrderEntity;

/**
 * 表示順更新APIマッパー.
 * 
 */
@Mapper
public interface FileUpdateDisplayOrderMapper {

  /** 表示順更新 */
  List<FileUpdateDisplayOrderEntity> updateDisplayOrder(@Param("folderId") String folderId);

}
