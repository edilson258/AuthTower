package com.edilson258.authtower.core.service;

public interface JWTService {
    String generateAccessToken(String subject, Long duration);
    String generateRefreshToken(String subject, Long duration);
}
