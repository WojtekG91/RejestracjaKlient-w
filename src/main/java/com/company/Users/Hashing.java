package com.company.Users;


import org.apache.commons.codec.digest.DigestUtils;

public class Hashing {

    public String HashingPassword(String password) {

        String md5HexPassword = DigestUtils.md5Hex(password).toUpperCase();

        return md5HexPassword;
    }
}
