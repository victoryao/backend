package com.yaohoo.be.dao.mapper.write;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.yaohoo.be.dao.entity.ActivityDO;

public interface ActivityMapper {
	
	@Insert("insert into activity_subject(`subject`,`created`,`updated`) values(#{subject},#{created},#{created})")
	@SelectKey(statement = "SELECT LAST_INSERT_ID() as aId", keyProperty = "aId", before = false, resultType = Integer.class)
	public void addActivitySubject(ActivityDO activityDO);
	
	@Insert("insert into activity_content(`a_id`,`content`) values(#{aId},#{content})")
	public void addActivityContent(ActivityDO activityDO);

	@Delete("delete from activity_subject where id = #{id}")
	public void delActivitySubject(int id);
	
	@Delete("delete from activity_content where a_id = #{aId}")
	public void delActivityContent(int aId);
	
	@Update("update activity_subject set subject = #{subject} where id = #{id}")
	public Object updateActivitySubject(int id, String subject);
	
	@Update("update activity_content set content = #{content} where a_id = #{aId}")
	public Object updateActivityContent(int aId,String content);

	@Update("update activity_subject set type = 1 where id = #{aId}")
	public void upActivity(int aId);

	@Update("update activity_subject set type = 0 where id = #{aId}")
	public void downActivity(int aId);

	@Update("update activity_subject set status = 0 where id = #{aId}")
	public void onlineActivity(int aId);
	
	@Update("update activity_subject set status = 1 where id = #{aId}")
	public void offlineActivity(int aId);


}
