package it.erika.gymtrainer.dto;

import lombok.Data;

@Data
public class PageInfo {

    private Long size;
    private Long number;
    private Long totalElement;
    private Long totalPages;
}
