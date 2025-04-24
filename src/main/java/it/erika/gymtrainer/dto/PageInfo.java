package it.erika.gymtrainer.dto;

import lombok.Data;

@Data
public class PageInfo {

    private Long size;
    private Long number;
    private Long totalElements;
    private Long totalPages;
}
