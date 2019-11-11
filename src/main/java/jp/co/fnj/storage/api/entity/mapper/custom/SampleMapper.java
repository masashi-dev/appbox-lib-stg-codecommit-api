package jp.co.fnj.storage.api.entity.mapper.custom;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * サンプルマッパー.（表結合を伴う検索系や、集計などの場合にAPI独自に作成する）
 * 
 */
@Mapper
public interface SampleMapper {

  /** 一覧取得 */
  // TODO 戻り値は適当
  Object selectHoge(@Param("folderId") String folderId);


  /** 集計 */
  Integer sumHoge(@Param("folderId") String folderId);

}
