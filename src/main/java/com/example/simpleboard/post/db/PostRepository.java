package com.example.simpleboard.post.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

    /*
    select *
    from post
    where id = ?
    and status = ?
    order by id desc
    limit 1
     */
    public Optional<PostEntity> findByIdAndStatusOrderByIdDesc(Long Id, String Status);

}
