package com.example.news.repository;

import com.example.news.dob.UserChoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserChoiceRepository extends CrudRepository<UserChoice, Long> {

    UserChoice findUserChoiceByUserIdAndNewsIdNotNull(int userId);

    UserChoice findUserChoiceByUserIdAndSubIdNotNull(int userId);
}
