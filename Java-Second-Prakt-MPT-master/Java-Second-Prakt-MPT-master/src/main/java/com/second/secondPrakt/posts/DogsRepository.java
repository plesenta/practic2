package com.second.secondPrakt.posts;


import com.second.secondPrakt.models.Dogs;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DogsRepository extends CrudRepository<Dogs, Long > {
    public List<Dogs> findByBreed(String title);
    public List<Dogs> findByBreedContains(String title);
}
