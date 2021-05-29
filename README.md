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
### Relasi di sisi category, ONE TO MANY.
Masalahnya, akan me-load semua category, jika ada 100 category maka semuanya akan di-load.

### Relasinya bisa di sisi product, jadi MANY TO ONE.
Keuntungannya, jika category akan di load berdasarkan product.

### Bagaimana, jika kita ingin mencari product dengan category tertentu?
Itu bisa dilakukan pada manipulasi di bagian repository

### Relasi Supler
- 1 Supler bisa menyuplai lebih dari 1 product
- Sehingga hubungan supler ke product adalah MANY TO MANY

Kasus lain, Mahasiswa dan Mata Kuliah
- mahasiswa bisa mengambil lebih dari 1 mata kuliah
- 1 mata kuliah bisa diikuti lebih dari 1 mahasiswa

## Swagger
test apakah configurasinya sudah berjalan
```
localhost:8182/api/v2/api-docs
```

### Swagger UI
swagger UI akan digenerate di web dan langsung bisa kita akses
```
http://localhost:8182/api/swagger-ui/
```
> Note: Jangan lupa, berikan karakter `/` diakhirnya