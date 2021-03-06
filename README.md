Bookstore RESTful API practice
==========

此專案實作了簡單的CRUD四支API，如下

Requirements
----------
* Java 17
* Spring boot
* JPA
* H2 Database(in memory)

Spec
----------

**一、物件說明**

  * BookVO

| 欄位 | 型別 |中文名稱 | 必填(V) |
|---------|---------|---------|---------|
| oid      | String |索引值  | V |
| bookName      | String |書名  | V |
| author      | String |作者  | V |
| translator      | String |議者  | |
| ISBN      | String |國際標準書號 | V |
| PUBLISHER      | String |出版商  | V |
| PUBLISHDATE      | String |出版日期  | V |
| price      | int |定價  | V |

* RequestWapper

| 欄位 | 型別 |中文名稱 | 必填(V) |
|---------|---------|---------|---------|
| model     | T |可裝任何傳入物件  | V |

* ReponseHeader

| 欄位 | 型別 |中文名稱 |
|---------|---------|---------|
| errorCode    | String |結果代碼  |
| errorDesc    | String |結果訊息  |

* ReponseWapper

| 欄位 | 型別 |中文名稱 |
|---------|---------|---------|
| header    | ReponseHeader |回覆的表頭  |
| model    | T |回覆物件  |

**二、API說明**
  
  * createBook(新增書籍資料)

```
POST /barney/createBook
```
| 標題行 | 值 |
|---------|---------|
| 資料類型   | JSON  |
| 傳入值     | BookVO |
| 傳出值      | null  |

  * searchAllBook(查詢所有書籍資料)

```
POST /barney/searchAllBook
```
| 標題行 | 值 |
|---------|---------|
| 資料類型   | JSON  |
| 傳入值     | null |
| 傳出值      | List< BookVO> |

  * updateBook(更新書籍資料)

```
POST /barney/updateBook
```
| 標題行 | 值 |
|---------|---------|
| 資料類型   | JSON  |
| 傳入值     | BookVO |
| 傳出值      | null |

  * deleteBook(刪除書籍資料)

```
POST /barney/deleteBook
```
| 標題行 | 值 |
|---------|---------|
| 資料類型   | JSON  |
| 傳入值     | String(oid) |
| 傳出值      | null |
