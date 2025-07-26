
# Myjson

مای‌جیسون یک کتابخانه ساده و قابل توسعه برای مدیریت داده های جیسون برای زبان برنامه‌نویسی جاوا هست

---

### ویژگی‌ها

- پارسر کاملاً داخلی و بدون وابستگی خارجی  
- پشتیبانی از فایل کش برای ذخیره و بازیابی اطلاعات  
- طراحی ساده و با انتزاع بالا  
- قابل توسعه و با وابستگی‌های حداقلی  

---

### نصب و استفاده

1. پروژه را کلون کنید:

git clone https://github.com/Freakoon/Java-Myjson.git

2. فایل JAR ساخته شده را در پوشه کتابخانه‌های پروژه خود کپی کنید.

---

### مستندات

این کتابخانه در حال حاضر در مرحله **بتا** است و برای استفاده در پروژه‌های تولیدی توصیه نمی‌شود.  
نمونه استفاده:

```java
import com.freakon.myjson.*;
public class Main {
 public static void main(String[] args) {
     String[] key = {"A","B"};
     Object[] value = {1,2};
     String fileName = "Test";
     int index = 5;
     Json json = new Json(key,value,fileName,index);
     //return hashmp
     json.show()
     //add,rem,get
     json.add(key,value); 
     .....
 }
}
```


---

مشارکت

برای سوالات یا مشارکت، با ایمیل زیر تماس بگیرید:
freakooon@gmail.com

