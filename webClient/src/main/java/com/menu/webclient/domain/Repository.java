package com.menu.webclient.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter @Setter
public class Repository {
    private String name;
    private String full_name;
    private String url;
    private String commits_url;
    private String pushed_at;
}
