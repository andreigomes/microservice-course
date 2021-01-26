package com.devsuperior.hroauth.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String roleName;
}
