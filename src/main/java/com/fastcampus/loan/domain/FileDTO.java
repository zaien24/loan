package com.fastcampus.loan.domain;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class FileDTO implements Serializable {

    private String name;

    private String url;



}
