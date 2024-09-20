package org.example.correctionexercice2rest.service;

import java.util.List;

//interface pour normaliser nos services on viens definir les 5 methodes de base commune a nos 2 services
public interface BaseService<TReceive,TSend> {
    TSend create (TReceive received);
    TSend update (long id,TReceive received);
    boolean delete (long id);
    TSend findById (long id);
    List<TSend> getAll ();
}
