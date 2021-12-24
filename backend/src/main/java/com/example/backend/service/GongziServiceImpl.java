package com.example.backend.service;

import com.example.backend.entity.Gongzi;
import com.example.backend.repository.GongziRepository;
import com.example.backend.request.GongziRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Lazy
@Slf4j
public class GongziServiceImpl implements GongziService{
    @Autowired
    private GongziRepository repository;

    @Override
    public void register(GongziRequest request) throws Exception {

        Gongzi gongziEntity = new Gongzi(request.getTitle(), request.getWriter(), request.getDescription());

        repository.save(gongziEntity);
    }

    @Override
    public List<Gongzi> list() throws Exception {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "gongziNo"));
    }

    @Override
    public Gongzi read(Long gongziNo) throws Exception {

        Gongzi gongzi = repository.findByGongziNo(gongziNo).orElse(null);

        return gongzi;
    }

    @Override
    public void remove(Long gongziNo) throws Exception {

        repository.deleteById(gongziNo);
    }

    @Override
    public void modify(Gongzi gongzi, GongziRequest request) throws Exception {
        gongzi.updateGongzi(request);
        repository.save(gongzi);
    }

    @Override
    public void view(Long gongziNo, Integer view) throws Exception {
        Gongzi gongzi = repository.findByGongziNo(gongziNo).orElse(null);

        gongzi.setView(view);

        repository.save(gongzi);
    }
}
