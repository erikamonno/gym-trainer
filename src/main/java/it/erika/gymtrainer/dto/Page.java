package it.erika.gymtrainer.dto;

import java.util.List;
import lombok.Data;

@Data
public class Page<T> {

    private List<T> content;
    private PageInfo page;
}
