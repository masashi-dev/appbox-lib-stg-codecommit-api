package jp.co.fnj.storage.api.entity.mapper.custom;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import jp.co.fnj.storage.api.entity.model.custom.BookmarkGetEntity;

/**
 * お気に入り取得マッパー.
 *
 */
@Mapper
public interface BookmarkGetMapper {
  /**
   * 条件に該当するファイルの情報および、そのファイルが格納されているフォルダの情報を取得する.
   *
   * @param argMyUserId
   * @return ファイルとフォルダ（1:1）のリスト
   */
  List<BookmarkGetEntity> selectBookmark(@Param("user_id") String argMyUserId);

}
