package com.fastcampus.loan.controller;

import com.fastcampus.loan.dto.JudgmentDTO.Request;
import com.fastcampus.loan.dto.JudgmentDTO.Response;
import com.fastcampus.loan.dto.ResponseDTO;
import com.fastcampus.loan.service.JudgmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/judgments")
public class JudgmentController extends AbstractController {

    private final JudgmentService judgmentService;

    @PostMapping
    public ResponseDTO<Response> create(@RequestBody Request request) {
        return ok(judgmentService.create(request));
    }
}
