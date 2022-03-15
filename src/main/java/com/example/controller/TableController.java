package com.example.controller;


import com.example.domain.*;
import com.example.repository.*;
import com.example.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 */
@RestController
@RequestMapping("/table")
public class TableController {

	private final TableService tableService;

	public TableController(TableService tableService) {
		this.tableService = tableService;
	}
    @Autowired
    TableRepository tableRepository;

	@Autowired
    TableAllRepository tableAllRepository;

    @GetMapping("/all")
    public Iterable<Table> findAll() {
        return tableRepository.findAll();
    }

        @GetMapping("/findRel")
    public Collection<Table> findRel() {
        return tableRepository.findRel();
    }

    @GetMapping("/findRelSimple")
    public Collection<TableSimple> findRelSimple() {
        return tableRepository.findRelSimple();
    }

    @GetMapping("/filedSqlDetail")
    public Collection<FiledHeat> filedSqlDetail() {
        return tableService.filedSqlDetail();
    }

    @GetMapping("/filedSqlRank")
    public Collection<FiledHeat> filedSqlRank() {
        return tableService.filedSqlRank();
    }

    @GetMapping("/filedAll")
    public Collection<FiledHeatAll> filedAll() {
        return tableAllRepository.fieldAll();
    }

    @GetMapping("/filedAllByName")
    public Collection<FiledHeatAll> filedAllByName(@RequestParam String fullTableName) {
        return tableAllRepository.fieldAllByName(fullTableName);
    }

    @PostMapping("/filedAllByObject")
    public Collection<FiledHeatAll> filedAllByObject(@RequestBody TableParam tableParam) {
        return tableAllRepository.fieldAllByObject(tableParam);
    }

    @GetMapping("/findTest1")
    public Collection<FiledHeatQueryDTO> findColumn(@RequestParam String fullTableName) {
        return tableRepository.findRelationDetail(fullTableName);
    }

    @GetMapping("/filedAllByCql")
    public Collection<FiledHeatAll> filedAllByCql() {
        String cql="match p = shortestpath((:COLUMN{fullField:\"ydj.0618_dept11.col2\"})-[rel:generate*..]-()) return p";
        return tableAllRepository.findByCql(cql);
    }
}
