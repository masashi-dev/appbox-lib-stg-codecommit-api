package jp.co.fnj.storage.api.entity.mapper.custom;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SortOrderResistMapper {

  /**
   * 表示順の最大値取得
   *
   */
  Integer selectSortOrderMax(String argParentFolderId);
}
