package net.service;

import net.model.Support;

import java.util.List;

public interface SupportService {

    Support getById(Long id);

    void save(Support support);

    void delete(Long id);

    List<Support> getAll();

    void deleteAll();
}
