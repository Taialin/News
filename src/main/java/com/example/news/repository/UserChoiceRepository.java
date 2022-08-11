package com.example.news.repository;

import com.example.news.dob.UserChoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserChoiceRepository extends CrudRepository<UserChoice, Long> {

    List<UserChoice> findUserChoicesByUserIdAndNewsIdNotNull(int userId);

    List<UserChoice> findUserChoicesByUserIdAndSubIdNotNull(int userId);
}
