package com.fastcampus.loan.service;


import com.fastcampus.loan.dto.CounselDTO.Response;
import com.fastcampus.loan.dto.CounselDTO.Request;

public interface CounselService {

    Response create(Request request);

    Response get(Long counselId);
}
