package org.launchcode.myblog.data;

import org.launchcode.myblog.models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagData extends CrudRepository<Tag, Integer> {
}
