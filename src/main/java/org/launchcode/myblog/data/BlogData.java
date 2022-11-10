package org.launchcode.myblog.data;

import org.launchcode.myblog.models.Blog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public interface BlogData extends CrudRepository<Blog, Integer> {


}
