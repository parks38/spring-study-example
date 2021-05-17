package com.example.valid_anno;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ContentDto {
    private int id;
    /**
     * notNull : 널이면 입력된 메세지가 사용
     * notEmpty :공백이면 안된다
     * Size : 조건이 충족되지않으면 메세지가 출력
     */

    @NotNull(message = "writer is null ")
    @NotEmpty(message = "writer is empty ")
    @Size(min = 3, max = 10, message = "writer min 3, max 10.")
    private String writer;

    @NotNull(message = "content is null")
    @NotEmpty(message = "content is empty")
    private String content;
}
