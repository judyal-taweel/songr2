package com.judy.mahmood.Songr.infrastructure;

import com.judy.mahmood.Songr.domain.Songs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Songs,Long>{
//    public List<Songs> findbyAlbumID(String album_id );
}
