package com.mlefevre.samples.data.repository;

import com.mlefevre.samples.data.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {

}
