package com.learesong.email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailEntity {

    private String name;
    private String email;
    private String subject;
    private String message;

}
