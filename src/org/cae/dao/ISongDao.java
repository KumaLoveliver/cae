package org.cae.dao;

import java.util.List;
import java.util.Map;

import org.cae.common.Condition;
import org.cae.common.DaoResult;
import org.cae.entity.Song;

public interface ISongDao extends IBaseDao{

	Map<String,Object> getSongForHomepageDao();
	
	List<Song> getAllSongDao(Condition condition, Song song);
	
	Integer getSongCountDao(Condition condition, Song song);
	
	Song getSongDao(Song song);
	
	DaoResult saveSongDao(Song song);
	
	DaoResult deleteSongDao(Song song);
}
