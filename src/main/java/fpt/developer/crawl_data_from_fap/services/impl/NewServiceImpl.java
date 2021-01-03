package fpt.developer.crawl_data_from_fap.services.impl;

import fpt.developer.crawl_data_from_fap.entities.New;
import fpt.developer.crawl_data_from_fap.repository.NewRepository;
import fpt.developer.crawl_data_from_fap.services.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewServiceImpl implements NewService {
    @Autowired
    private NewRepository newRepository;

    @Override
    public <S extends New> List<S> saveAll(Iterable<S> iterable) {
        return newRepository.saveAll(iterable);
    }

    @Override
    public List<New> findAll() {
        return newRepository.findAll();
    }

    @Override
    public List<New> findAll(Sort sort) {
        return newRepository.findAll(sort);
    }

    @Override
    public <S extends New> S insert(S s) {
        return newRepository.insert(s);
    }

    @Override
    public <S extends New> List<S> insert(Iterable<S> iterable) {
        return newRepository.insert(iterable);
    }

    @Override
    public <S extends New> List<S> findAll(Example<S> example) {
        return newRepository.findAll(example);
    }

    @Override
    public <S extends New> List<S> findAll(Example<S> example, Sort sort) {
        return newRepository.findAll(example, sort);
    }

    @Override
    public Page<New> findAll(Pageable pageable) {
        return newRepository.findAll(pageable);
    }

    @Override
    public <S extends New> S save(S s) {
        return newRepository.save(s);
    }

    @Override
    public Optional<New> findById(String s) {
        return newRepository.findById(s);
    }

    @Override
    public boolean existsById(String s) {
        return newRepository.existsById(s);
    }

    @Override
    public Iterable<New> findAllById(Iterable<String> iterable) {
        return newRepository.findAllById(iterable);
    }

    @Override
    public long count() {
        return newRepository.count();
    }

    @Override
    public void deleteById(String s) {
        newRepository.deleteById(s);
    }

    @Override
    public void delete(New aNew) {
        newRepository.delete(aNew);
    }

    @Override
    public void deleteAll(Iterable<? extends New> iterable) {
        newRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        newRepository.deleteAll();
    }

    @Override
    public <S extends New> Optional<S> findOne(Example<S> example) {
        return newRepository.findOne(example);
    }

    @Override
    public <S extends New> Page<S> findAll(Example<S> example, Pageable pageable) {
        return newRepository.findAll(example, pageable);
    }

    @Override
    public <S extends New> long count(Example<S> example) {
        return newRepository.count(example);
    }

    @Override
    public <S extends New> boolean exists(Example<S> example) {
        return newRepository.exists(example);
    }
}
