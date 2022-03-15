package com.example.service;

import com.example.domain.*;
import com.example.repository.TableRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created on 2022/3/9.
 *
 * @author MariaCarrie
 */
@Service
public class TableService {

    private final static Logger LOG = LoggerFactory.getLogger(TableService.class);

	private final TableRepository tableRepository;
	public TableService(TableRepository tableRepository) {
		this.tableRepository = tableRepository;
	}

    @Transactional(readOnly = true)
    public Collection<Table> findRel() {
        Collection<Table> rel = tableRepository.findRel();
        return rel;
    }

    @Transactional(readOnly = true)
    public Collection<TableSimple> findRelSimple() {
        Collection<TableSimple> rel = tableRepository.findRelSimple();
        return rel;
    }

    @Transactional(readOnly = true)
    public Collection<FiledHeat> filedSqlDetail() {
        Collection<FiledHeat> rel = tableRepository.filedSqlDetail();
        rel.forEach(filedHeat -> {
            System.out.println(">>findSqlDetail>>"+filedHeat.toString());
        });

        return rel;
    }

    @Transactional(readOnly = true)
    public Collection<FiledHeat> filedSqlRank() {
        Collection<FiledHeat> rel = tableRepository.filedSqlRank();
        rel.forEach(filedHeat -> {
            System.out.println(">>findSqlRank>>"+filedHeat.toString());
        });
        return rel;
    }


}
