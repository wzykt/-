package com.wzy.security.uaa.model;

import lombok.Data;

/**
 * @author wzy
 * @version 1.0
 **/
@Data
public class PermissionDto {

    private String id;
    private String code;
    private String description;
    private String url;
}
