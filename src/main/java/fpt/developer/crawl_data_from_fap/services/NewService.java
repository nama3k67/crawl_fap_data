package fpt.developer.crawl_data_from_fap.services;

import fpt.developer.crawl_data_from_fap.entities.New;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface NewService {
    <S extends New> List<S> saveAll(Iterable<S> iterable);

    List<New> findAll();

    List<New> findAll(Sort sort);

    <S extends New> S insert(S s);

    <S extends New> List<S> insert(Iterable<S> iterable);

    <S extends New> List<S> findAll(Example<S> example);

    <S extends New> List<S> findAll(Example<S> example, Sort sort);

    Page<New> findAll(Pageable pageable);

    <S extends New> S save(S s);

    Optional<New> findById(String s);

    boolean existsById(String s);

    Iterable<New> findAllById(Iterable<String> iterable);

    long count();

    void deleteById(String s);

    void delete(New aNew);

    void deleteAll(Iterable<? extends New> iterable);

    void deleteAll();

    <S extends New> Optional<S> findOne(Example<S> example);

    <S extends New> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends New> long count(Example<S> example);

    <S extends New> boolean exists(Example<S> example);
}
