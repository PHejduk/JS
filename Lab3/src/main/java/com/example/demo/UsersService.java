package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class UsersService {

    private List<UsersEntity> users;
    private PageEntity page;
    private int id;

    public UsersService(){
        users = new ArrayList<>();
        this.page = new PageEntity();
        this.id=0;
    }
    public Object getPageData(int pNumber, int pSize){
        this.page.setPageNumber(pNumber);
        this.page.setPageSize(pSize);
        this.page.setUsers(this.users);
        return this.page;
    }
}
