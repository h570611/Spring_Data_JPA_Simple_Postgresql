# Spring_Data_JPA_Simple_Postgresql

## Application.properties
```
spring.datasource.url=jdbc:postgresql://localhost:5432/<database_name>
spring.datasource.username=<username>
spring.datasource.password=<password>
spring.jpa.hibernate.ddl-auto=update
```


poweshell sample: 

$url = "https://res.cloudinary.com/demo/image/upload/v1312461204/sample.jpg"

$url_split = $url -split "/"

$image_name = $url_split[-1]

$out_path = "C:\Users\jonas\Arbeid\" + $image_name


echo $image_name

echo $out_path


wget $url -OutFile $out_path

#wget "https://res.cloudinary.com/demo/image/upload/v1312461204/sample.jpg" -OutFile "C:\Users\jonas\Arbeid\1.jpg"
