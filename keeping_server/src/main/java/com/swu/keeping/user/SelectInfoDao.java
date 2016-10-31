package com.swu.keeping.user;

import java.util.List;

public interface SelectInfoDao {

	public UserDetailVO selectUserDatailInfo(String id);

	public List<UserBloodVO> selectUserBloodInfo(String id);

	public void reset();

}
