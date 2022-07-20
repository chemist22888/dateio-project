package com.etnetera.hr.repository;

import org.springframework.data.repository.CrudRepository;

import com.etnetera.hr.data.JavaScriptFramework;

import java.util.Date;
import java.util.List;

/**
 * Spring data repository interface used for accessing the data in database.
 * 
 * @author Etnetera
 *
 */
public interface JavaScriptFrameworkRepository extends CrudRepository<JavaScriptFramework, Long> {
    List<JavaScriptFramework> findAllByName(String name);
    List<JavaScriptFramework> findAllByVersion(String version);
    List<JavaScriptFramework> findAllByHypeLevel(Integer hypeLevel);
}
