package com.nstr.data.collection.repository;

import com.nstr.data.collection.model.pojo.ResourceComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceCommentRepository extends JpaRepository<ResourceComment,Long> {

}
