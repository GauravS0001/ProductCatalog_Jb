# ProductCatalog_Jb

# Product Catalog Cache Service (Spring Boot + Redis)

This project demonstrates a production-grade backend optimization using Redis caching with Spring Boot. It simulates a frequently accessed API — like a "Featured Product Catalog" — where caching is used to minimize database load and significantly reduce response time.

This mirrors real-world scenarios such as e-commerce platforms or dashboards, where read-heavy, rarely-changing data is perfect for caching. The project replicates a pattern I’ve implemented in backend systems in production to improve performance and system scalability.

## Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Cache + Redis (Cache-aside strategy)
- Spring Data JPA + H2 (for simulation)
- Python (for benchmarking API performance)

## Features

- GET /api/products/featured  
  Returns featured products from DB (cached in Redis on first request)

- POST /api/products/featured/refresh  
  Manually evicts Redis cache (simulates data update)

- TTL for cache: 5 minutes  
- Uses @Cacheable and @CacheEvict in service layer

## Architecture Overview

Client  
↓  
Controller  
↓  
Service  
↓         ↱  
Redis ←⎯⎯⎯ DB

We use a cache-aside pattern:  
- First request hits DB, result is cached in Redis  
- Subsequent requests return directly from Redis  
- Manual eviction via a refresh endpoint

## Benchmark Results

A Python script was used to benchmark cold (DB hit) vs. warm (Redis hit) performance. The dataset included 200 dummy featured products.

| Scenario              | Avg Response Time |
|-----------------------|-------------------|
| Cold Start (DB hit)   | 36.60 ms          |
| Redis Cache Hit       | 11.10 ms          |
| Performance Gain      | ~69.67%           |

This reflects the kind of optimization I’ve applied in real production systems, where Redis caching reduced API latency and helped scale backend performance under load.

## Author

Gaurav Solanki  
GitHub: https://github.com/GauravS0001
