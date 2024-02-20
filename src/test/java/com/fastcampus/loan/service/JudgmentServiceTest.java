package com.fastcampus.loan.service;

import com.fastcampus.loan.domain.Application;
import com.fastcampus.loan.domain.Judgment;
import com.fastcampus.loan.dto.JudgmentDTO.Request;
import com.fastcampus.loan.dto.JudgmentDTO.Response;
import com.fastcampus.loan.repository.ApplicationRepository;
import com.fastcampus.loan.repository.JudgmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JudgmentServiceTest {

    @InjectMocks
    private JudgmentServiceImpl judgmentService;

    @Mock
    private JudgmentRepository judgmentRepository;

    @Mock
    private ApplicationRepository applicationRepository;

    @Spy
    private ModelMapper modelMapper;

    @Test
    void Should_ReturnResponseOfNewJudgmentEntity_When_RequestNewJudgment() {
        Judgment judgment = Judgment.builder()
                .applicationId(1L)
                .name("Member Kim")
                .approvalAmount(BigDecimal.valueOf(50000000))
                .build();

        Request request = Request.builder()
                .applicationId(1L)
                .name("Member Kim")
                .approvalAmount(BigDecimal.valueOf(50000000))
                .build();

        when(applicationRepository.findById(1L)).thenReturn(Optional.ofNullable(Application.builder().build()));
        when(judgmentRepository.save(ArgumentMatchers.any(Judgment.class))).thenReturn(judgment);

        Response actual = judgmentService.create(request);

        assertThat(actual.getName()).isSameAs(judgment.getName());
        assertThat(actual.getApplicationId()).isSameAs(judgment.getApplicationId());
        assertThat(actual.getApprovalAmount()).isSameAs(judgment.getApprovalAmount());
    }



}
