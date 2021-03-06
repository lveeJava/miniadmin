package cn.scene.dao;

import cn.scene.model.Scene;
import org.apache.ibatis.annotations.Param;

import javax.annotation.security.PermitAll;
import java.util.List;

public interface SceneMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Scene record);

    int insertSelective(Scene record);

    Scene selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Scene record);

    int updateByPrimaryKey(Scene record);

    //查询精选模板总数
    int selectCount();

    //查询精选模板
    List<Scene> selectDelicate();

    //查询最新推荐
    List<Scene> selectNews();

    //个人相册热销模板
    List<Scene> selectPhotoByHitCount();

    //个人相册总数
    int selectPhotoCount();

    //分类查询,积分兑换
    List<Scene> selectCharge(Integer types);

    //分类查询,免费
    List<Scene> selectFree(Integer types);

    //个人中心查询我的模板
    List<Scene> selectByFromScene(@Param("userId") Integer userId, @Param("fromId") Integer FromId);

    //场景上架
    int updateByIsIssue(@Param("id") Integer id,@Param("jifen") Integer jifen);

    //场景标题
    Scene selectByApartInfo(Integer id);

    //场景删除
    int updateIsDel(Integer id);

    //我的共享
    List<Scene> selectByUserId(Integer userId);

    //插入数据初始化
    int getNewsId(Scene scene);

    //根据id更新场景共享状态
    int updateIsIssue(Integer id);

    //更新场景背景音乐
    int updateMusicById(@Param("id") Integer id, @Param("music")String music, @Param("mTitle")String mTitle);

    //场景搜索
    List<Scene> selectInfoByTitle(String content);

    //根据id更新封面图
    int updateCoverById(@Param("id")Integer id,@Param("cover")String cover);

    //根据code查询场景
    Scene selectInfoByCode(String code);

    //增加场景阅读量
    int updateHitCountById(Integer id);

    //根据id查询场景
    Scene sceneInfoById(Integer id);

    //增加原场景的兑换人数
    int updateCountsById(Integer id);

    //生成场景兑换
    int getExchangeSceneId(Scene scene);

    //查询共享总数
    int selectCountsByIssue(int userId);
}