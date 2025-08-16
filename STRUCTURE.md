idp-platform/
├── idp-core/ # Main IdP application
├── idp-admin/ # Admin console service
├── idp-federation/ # Federation service for external IdPs
├── idp-commons/ # Shared libraries and utilities
├── idp-config/ # Configuration server
├── idp-gateway/ # API Gateway
└── docker-compose.yml # Local development setup

idp-core/
├── src/main/java/com/company/idp/
│ ├── IdpApplication.java # Main Spring Boot application
│ ├── config/ # Configuration classes
│ │ ├── SecurityConfig.java
│ │ ├── JwtConfig.java
│ │ ├── SamlConfig.java
│ │ ├── DatabaseConfig.java
│ │ ├── CacheConfig.java
│ │ └── WebConfig.java
│ ├── controller/ # REST Controllers
│ │ ├── AuthController.java
│ │ ├── TokenController.java
│ │ ├── UserController.java
│ │ ├── SamlController.java
│ │ ├── OidcController.java
│ │ └── WellKnownController.java
│ ├── service/ # Business logic
│ │ ├── AuthenticationService.java
│ │ ├── AuthorizationService.java
│ │ ├── TokenService.java
│ │ ├── UserService.java
│ │ ├── SamlService.java
│ │ ├── OidcService.java
│ │ ├── MfaService.java
│ │ ├── AuditService.java
│ │ └── NotificationService.java
│ ├── repository/ # Data access layer
│ │ ├── UserRepository.java
│ │ ├── ClientRepository.java
│ │ ├── TokenRepository.java
│ │ ├── AuditRepository.java
│ │ └── SessionRepository.java
│ ├── entity/ # JPA Entities
│ │ ├── User.java
│ │ ├── Role.java
│ │ ├── Permission.java
│ │ ├── Client.java
│ │ ├── Token.java
│ │ ├── Session.java
│ │ └── AuditLog.java
│ ├── dto/ # Data Transfer Objects
│ │ ├── request/
│ │ │ ├── LoginRequest.java
│ │ │ ├── TokenRequest.java
│ │ │ ├── UserCreateRequest.java
│ │ │ └── MfaVerifyRequest.java
│ │ └── response/
│ │ ├── LoginResponse.java
│ │ ├── TokenResponse.java
│ │ ├── UserInfoResponse.java
│ │ └── ErrorResponse.java
│ ├── security/ # Security components
│ │ ├── CustomUserDetailsService.java
│ │ ├── JwtAuthenticationFilter.java
│ │ ├── JwtTokenProvider.java
│ │ ├── SamlAuthenticationProvider.java
│ │ ├── OidcAuthenticationProvider.java
│ │ └── CustomAuthenticationEntryPoint.java
│ ├── exception/ # Exception handling
│ │ ├── GlobalExceptionHandler.java
│ │ ├── AuthenticationException.java
│ │ ├── AuthorizationException.java
│ │ └── TokenException.java
│ ├── util/ # Utility classes
│ │ ├── CryptoUtils.java
│ │ ├── ValidationUtils.java
│ │ ├── DateUtils.java
│ │ └── StringUtils.java
│ └── validator/ # Custom validators
│ ├── PasswordValidator.java
│ ├── EmailValidator.java
│ └── TokenValidator.java
├── src/main/resources/
│ ├── application.yml # Main configuration
│ ├── application-dev.yml
│ ├── application-prod.yml
│ ├── db/migration/ # Flyway migrations
│ │ ├── V1__Initial_schema.sql
│ │ ├── V2__Add_clients_table.sql
│ │ └── V3__Add_audit_table.sql
│ ├── templates/ # Thymeleaf templates
│ │ ├── login.html
│ │ ├── consent.html
│ │ ├── error.html
│ │ └── mfa.html
│ ├── static/ # Static resources
│ │ ├── css/
│ │ ├── js/
│ │ └── images/
│ └── certificates/ # SSL/SAML certificates
└── src/test/java/ # Test classes
├── integration/
├── unit/
└── e2e/

idp-admin/
├── src/main/java/com/company/idp/admin/
│ ├── AdminApplication.java
│ ├── controller/
│ │ ├── UserManagementController.java
│ │ ├── ClientManagementController.java
│ │ ├── RoleManagementController.java
│ │ ├── AuditController.java
│ │ └── SystemController.java
│ ├── service/
│ │ ├── UserManagementService.java
│ │ ├── ClientManagementService.java
│ │ ├── RoleManagementService.java
│ │ └── ReportingService.java
│ └── config/
│ ├── AdminSecurityConfig.java
│ └── WebMvcConfig.java
└── src/main/resources/
├── templates/admin/ # Admin UI templates
└── static/admin/ # Admin static resources

idp-federation/
├── src/main/java/com/company/idp/federation/
│ ├── FederationApplication.java
│ ├── controller/
│ │ ├── SamlFederationController.java
│ │ ├── OidcFederationController.java
│ │ └── LdapController.java
│ ├── service/
│ │ ├── ExternalIdpService.java
│ │ ├── AttributeMappingService.java
│ │ ├── UserProvisioningService.java
│ │ └── SyncService.java
│ ├── provider/
│ │ ├── GoogleProvider.java
│ │ ├── MicrosoftProvider.java
│ │ ├── GenericSamlProvider.java
│ │ └── LdapProvider.java
│ └── mapper/
│ ├── AttributeMapper.java
│ ├── UserMapper.java
│ └── RoleMapper.java

idp-commons/
├── src/main/java/com/company/idp/commons/
│ ├── constants/
│ │ ├── SecurityConstants.java
│ │ ├── ErrorCodes.java
│ │ └── ClaimTypes.java
│ ├── model/
│ │ ├── BaseEntity.java
│ │ ├── ApiResponse.java
│ │ └── UserPrincipal.java
│ ├── exception/
│ │ ├── BaseException.java
│ │ ├── ServiceException.java
│ │ └── ValidationException.java
│ ├── util/
│ │ ├── JsonUtils.java
│ │ ├── HttpUtils.java
│ │ └── LoggingUtils.java
│ └── annotation/
│ ├── Auditable.java
│ ├── RateLimited.java
│ └── Secured.java

config/
├── application-common.yml # Shared configuration
├── logback-spring.xml # Logging configuration
├── ehcache.xml # Cache configuration
├── keystore/ # Certificates and keys
│ ├── idp-signing.jks
│ ├── idp-encryption.jks
│ └── saml-metadata.xml
└── docker/
├── Dockerfile.idp-core
├── Dockerfile.idp-admin
└── docker-compose.yml

