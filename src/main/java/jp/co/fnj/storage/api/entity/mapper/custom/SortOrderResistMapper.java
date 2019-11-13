package jp.co.fnj.storage.api.entity.mapper.custom;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SortOrderResistMapper {

  /**
   * 表示順の最大値取得
   *
   */
  Integer selectSortOrderMax(@Param("parentFolderId") String argParentFolderId);
}
