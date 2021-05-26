## Test Welcome
```
http://localhost:8080/api/v1/welcome
```
Hasil
```
Selamat Datang
```

## Test API
Saya menggunakan IntelliJ IDEA Ultimate untuk menjalankan file di folder `api`.
examples. `getProduct.rest`.

## Penerapan Relationship
- 1 category bisa dimiliki banyak product
- 1 product hanya punya 1 category
### Relasi di sisi category, One to Many.
Masalahnya, akan me-load semua category, jika ada 100 category maka semuanya akan di-load.

### Relasinya bisa di sisi product, jadi Many to One.
Keuntungannya, jika category akan di load berdasarkan product.

### Bagaimana, jika kita ingin mencari product dengan category tertentu?
Itu bisa dilakukan pada manipulasi di bagian repository