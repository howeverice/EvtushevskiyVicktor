package net.service;

import net.model.KPI;

import java.util.List;

public interface KPIService
{
    KPI getById(Long id);

    void save(KPI kpi);

    void delete(Long id);

    List<KPI> getAll();

    void deleteAll();
}
