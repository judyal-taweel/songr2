package com.judy.mahmood.Songr.infrastructure;

import com.judy.mahmood.Songr.domain.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Long> {

}
