package com.example.backend.service;

import com.example.backend.entity.Gongzi;
import com.example.backend.request.GongziRequest;

import java.util.List;

public interface GongziService {

    public void register(GongziRequest gongzi) throws Exception;

    public List<Gongzi> list() throws Exception;

    public Gongzi read(Long gongziNo) throws Exception;

    public void remove(Long gongziNo) throws Exception;

    public void modify(Gongzi gongzi, GongziRequest request) throws Exception;

    public void view(Long gongziNo, Integer view) throws Exception;

}
