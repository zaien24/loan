package com.fastcampus.loan.service;


import com.fastcampus.loan.dto.CounselDTO;

public interface CounselService {

    CounselDTO.Response create(CounselDTO.Request request);
}
