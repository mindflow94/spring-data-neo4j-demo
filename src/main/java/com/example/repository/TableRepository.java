package com.example.repository;

import com.example.domain.*;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created on 2022/3/9.
 *
 * @author MariaCarrie
 */
@Repository
public interface TableRepository extends Neo4jRepository<Table, Long> {

    @Query(value = "MATCH p=()-[r:flow]->() RETURN p LIMIT 5")
    Collection<Table> findRel();

    @Query(value = "MATCH (n:Table) RETURN n.fullTable as fullTable,n.id as id LIMIT 5")
    Collection<TableSimple> findRelSimple();

    // match p =((n:COLUMN{fullField:'ydj.0618_dept11.col1'})-[rel:generate]->(m)) where m.temporary=false return m.fullField as fullField,rel.createTime as createTime,rel.edgeType as edgeType,rel.expression as expression,rel.start as start,rel.end as end,rel.endTemporary as endTemporary,rel.startTemporary as startTemporary
    @Query(value = "match p =((n:COLUMN{fullField:'ydj.0618_dept11.col1'})-[rel:generate]->(m)) where m.temporary=false return m.fullField as fullField,rel.createTime as createTime,rel.edgeType as edgeType,rel.expression as expression,rel.start as start,rel.end as end,rel.endTemporary as endTemporary,rel.startTemporary as startTemporary")
    Collection<FiledHeat> filedSqlDetail();

    // match p =((n:COLUMN{fullTable:'ydj.0618_dept11'})-[rel:generate]->(m)) where m.temporary=false return n.fullField as fullField,rel.createTime as createTime,rel.edgeType as edgeType,rel.expression as expression,rel.start as start,rel.end as end,rel.endTemporary as endTemporary,rel.startTemporary as startTemporary
    @Query(value = "match p =((n:COLUMN{fullTable:'ydj.0618_dept11'})-[rel:generate]->(m)) where m.temporary=false return n.fullField as fullField,rel.createTime as createTime,rel.edgeType as edgeType,rel.expression as expression,rel.start as start,rel.end as end,rel.endTemporary as endTemporary,rel.startTemporary as startTemporary")
    Collection<FiledHeat> filedSqlRank();

    @Query(value = "match p =((n:COLUMN{fullField:{fullFieldName}})-[rel:generate]->(m)) where m.temporary=false return m.fullField as fullField,rel.createTime as createTime,rel.edgeType as edgeType,rel.expression as expression,rel.start as start,rel.end as end,rel.endTemporary as endTemporary,rel.startTemporary as startTemporary")
    Collection<FiledHeatQueryDTO> findRelationDetail(@Param("fullFieldName") String fullFieldName);

    @Query(value = "match p =((n:COLUMN{fullTable:{fullTableName}})-[rel:generate]->(m)) where m.temporary=false return n.fullField as fullField,rel.createTime as createTime,rel.edgeType as edgeType,rel.expression as expression,rel.start as start,rel.end as end,rel.endTemporary as endTemporary,rel.startTemporary as startTemporary")
    Collection<FiledHeatQueryDTO> findRelationRank(@Param("fullTableName") String fullTableName);

    @Query(value = "MATCH (n:COLUMN) RETURN n LIMIT 25")
    Collection<FiledHeatColumn> findRelColumn();
}